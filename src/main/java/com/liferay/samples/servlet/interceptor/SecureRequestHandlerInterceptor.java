package com.liferay.samples.servlet.interceptor;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.HttpHeaders;
import com.liferay.portal.kernel.servlet.ProtectedServletRequest;
import com.liferay.portal.kernel.util.CookieKeys;
import com.liferay.portal.kernel.util.Digester;
import com.liferay.portal.kernel.util.DigesterUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.Http;
import com.liferay.portal.kernel.util.HttpUtil;
import com.liferay.portal.kernel.util.KeyValuePair;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Company;
import com.liferay.portal.model.User;
import com.liferay.portal.security.auth.CompanyThreadLocal;
import com.liferay.portal.security.auth.PrincipalThreadLocal;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portal.security.permission.PermissionCheckerFactoryUtil;
import com.liferay.portal.security.permission.PermissionThreadLocal;
import com.liferay.portal.service.CompanyLocalServiceUtil;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.util.Portal;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.Encryptor;
import com.liferay.util.EncryptorException;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class SecureRequestHandlerInterceptor extends HandlerInterceptorAdapter{

	public final static List<String> METHODS_TO_CHECK = Collections.unmodifiableList(Arrays.asList("POST", "PUT", "DELETE"));
	
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		if(METHODS_TO_CHECK.contains(request.getMethod().toUpperCase())){
		if (_log.isDebugEnabled()) {
			if (_httpsRequired) {
				_log.debug("https is required");
			}
			else {
				_log.debug("https is not required");
			}
		}

		if (_httpsRequired && !request.isSecure()) {
			if (_log.isDebugEnabled()) {
				String completeURL = HttpUtil.getCompleteURL(request);

				_log.debug("Securing " + completeURL);
			}

			StringBundler redirectURL = new StringBundler(5);

			redirectURL.append(Http.HTTPS_WITH_SLASH);
			redirectURL.append(request.getServerName());
			redirectURL.append(request.getServletPath());

			String queryString = request.getQueryString();

			if (Validator.isNotNull(queryString)) {
				redirectURL.append(StringPool.QUESTION);
				redirectURL.append(request.getQueryString());
			}

			if (_log.isDebugEnabled()) {
				_log.debug("Redirect to " + redirectURL);
			}

			response.sendRedirect(redirectURL.toString());
			return false;
		}
		else {
			if (_log.isDebugEnabled()) {
				String completeURL = HttpUtil.getCompleteURL(request);

				_log.debug("Not securing " + completeURL);
			}
			
			User user = PortalUtil.getUser(request);

			if(user==null){
				user = getUserFromCookies(request);
			}
			
			if ((user != null) && !user.isDefaultUser()) {
				request = setCredentials(
					request, request.getSession(), user.getUserId(), null);
				return true;
			}
			else {
				if (_digestAuthEnabled) {
					return digestAuth(request, response)!=null?true:false;
					
				}
				else if (_basicAuthEnabled) {
					return basicAuth(request, response)!=null?true:false;
				}
				
				return false;
			}

		}
		}
		return true;
	}
	
	
	private User getUserFromCookies(HttpServletRequest request) {
		// Getting the cookies from the servlet request
				Cookie[] cookies = request.getCookies();
				String userId = null;
				String uuid = CookieKeys.getCookie(request, CookieKeys.USER_UUID);
				String companyId = CookieKeys.getCookie(request, CookieKeys.COMPANY_ID);
				
				if (uuid != null && companyId != null) {
					try {
						Company company = CompanyLocalServiceUtil.getCompany(Long.parseLong(companyId));
						String _userid = Encryptor.decrypt(company.getKeyObj(), uuid);
						userId = _userid.substring(0,_userid.indexOf(StringPool.PERIOD));
						
						return UserLocalServiceUtil.getUser(Long.parseLong(userId));
						
					} catch (NumberFormatException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (PortalException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (SystemException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (EncryptorException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				return null;
				
	}

	public String hexStringToStringByAscii(String hexString) {
		byte[] bytes = new byte[hexString.length()/2];
		for (int i = 0; i < hexString.length() / 2; i++) {
			String oneHexa = hexString.substring(i * 2, i * 2 + 2);
			bytes[i] = Byte.parseByte(oneHexa, 16);
		}
		try {
			return new String(bytes, "ASCII");
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException(e);
		}
	}
	protected HttpServletRequest basicAuth(
			HttpServletRequest request, HttpServletResponse response)
		throws Exception {

		HttpSession session = request.getSession();

		session.setAttribute("BASIC_AUTH_ENABLED", Boolean.TRUE);

		long userId = GetterUtil.getLong(
			(String)session.getAttribute(_AUTHENTICATED_USER));

		if (userId > 0) {
			request = new ProtectedServletRequest(
				request, String.valueOf(userId), HttpServletRequest.BASIC_AUTH);

			initThreadLocals(request);
		}
		else {
			try {
				userId = PortalUtil.getBasicAuthUserId(request);
				if(userId > 0){
					initThreadLocals(userId);
				}
			}
			catch (Exception e) {
				_log.error(e, e);
			}

			if (userId > 0) {
				request = setCredentials(
					request, session, userId, HttpServletRequest.BASIC_AUTH);
			}
			else {
				response.setHeader(HttpHeaders.WWW_AUTHENTICATE, _BASIC_REALM);
				response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);

				return null;
			}
		}

		return request;
	}

	
	protected HttpServletRequest setCredentials(
			HttpServletRequest request, HttpSession session, long userId,
			String authType)
		throws Exception {

		User user = UserLocalServiceUtil.getUser(userId);

		String userIdString = String.valueOf(userId);

		request = new ProtectedServletRequest(request, userIdString, authType);

		session.setAttribute(WebKeys.USER, user);
		session.setAttribute(_AUTHENTICATED_USER, userIdString);

		initThreadLocals(request);

		return request;
	}


	
	private String generateNonce(long companyId, String remoteAddress) {

			String companyKey = null;

			try {
				Company company = CompanyLocalServiceUtil.getCompanyById(companyId);

				companyKey = company.getKey();
			}
			catch (Exception e) {
				throw new RuntimeException("Invalid companyId " + companyId, e);
			}

			long timestamp = System.currentTimeMillis();

			String nonce = DigesterUtil.digestHex(
				Digester.MD5, remoteAddress, String.valueOf(timestamp), companyKey);

			return nonce;
	}


	protected void initThreadLocals(HttpServletRequest request)
			throws Exception {

			HttpSession session = request.getSession();

			User user = (User)session.getAttribute(WebKeys.USER);

			CompanyThreadLocal.setCompanyId(user.getCompanyId());

			PrincipalThreadLocal.setName(user.getUserId());
			PrincipalThreadLocal.setPassword(PortalUtil.getUserPassword(request));

			if (!_usePermissionChecker) {
				return;
			}
			
			PermissionChecker permissionChecker =
				PermissionCheckerFactoryUtil.create(user);

			PermissionThreadLocal.setPermissionChecker(permissionChecker);
		}

	
	protected void initThreadLocals(long userId)
			throws Exception {

			
			User user = UserLocalServiceUtil.getUser(userId);

			CompanyThreadLocal.setCompanyId(user.getCompanyId());

			PrincipalThreadLocal.setName(user.getUserId());

			if (!_usePermissionChecker) {
				return;
			}
			
			PermissionChecker permissionChecker =
				PermissionCheckerFactoryUtil.create(user);

			PermissionThreadLocal.setPermissionChecker(permissionChecker);
		}
	
	protected HttpServletRequest digestAuth(
			HttpServletRequest request, HttpServletResponse response)
		throws Exception {

		HttpSession session = request.getSession();

		long userId = GetterUtil.getLong(
			(String)session.getAttribute(_AUTHENTICATED_USER));

		if (userId > 0) {
			request = new ProtectedServletRequest(
				request, String.valueOf(userId),
				HttpServletRequest.DIGEST_AUTH);

			initThreadLocals(request);
		}
		else {
			try {
				userId = PortalUtil.getDigestAuthUserId(request);
			}
			catch (Exception e) {
				_log.error(e, e);
			}

			if (userId > 0) {
				request = setCredentials(
					request, session, userId, HttpServletRequest.DIGEST_AUTH);
			}
			else {

				// Must generate a new nonce for each 401 (RFC2617, 3.2.1)

				long companyId = CompanyLocalServiceUtil.getCompanies(0, 1).get(0).getCompanyId();

				String remoteAddress = request.getRemoteAddr();

				String nonce = generateNonce(companyId, remoteAddress);

				StringBundler sb = new StringBundler(4);

				sb.append(_DIGEST_REALM);
				sb.append(", nonce=\"");
				sb.append(nonce);
				sb.append("\"");

				response.setHeader(HttpHeaders.WWW_AUTHENTICATE, sb.toString());
				response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);

				return null;
			}
		}

		return request;
	}
	    
        	
	
		public void setBasicAuthEnabled(boolean basicAuthEnabled) {
		this._basicAuthEnabled = basicAuthEnabled;
	}


	public void setDigestAuthEnabled(boolean digestAuthEnabled) {
		this._digestAuthEnabled = digestAuthEnabled;
	}


	public void setHttpsRequired(boolean httpsRequired) {
		this._httpsRequired = httpsRequired;
	}


	public void setUsePermissionChecker(boolean usePermissionChecker) {
		this._usePermissionChecker = usePermissionChecker;
	}





		private static final String _AUTHENTICATED_USER =
			SecureRequestHandlerInterceptor.class + "_AUTHENTICATED_USER";

		private static final String _BASIC_REALM =
			"Basic realm=\"" + Portal.PORTAL_REALM + "\"";

		private static final String _DIGEST_REALM =
			"Digest realm=\"" + Portal.PORTAL_REALM + "\"";

		private static Log _log = LogFactoryUtil.getLog(SecureRequestHandlerInterceptor.class);

		private boolean _basicAuthEnabled=true;
		private boolean _digestAuthEnabled;
		private boolean _httpsRequired;
		private boolean _usePermissionChecker=true;
	
	
}
