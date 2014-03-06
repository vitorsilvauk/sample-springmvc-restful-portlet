<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="portlet" uri="http://java.sun.com/portlet_2_0" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<portlet:defineObjects/>
<liferay-theme:defineObjects/>
<c:set var="ctxPath">
	<%= renderRequest.getContextPath() %>
</c:set>
<c:set var="portletNamespace">
	<%=renderResponse.getNamespace() %>
</c:set>

<c:set var="sessionId">
    <%=request.getSession().getId() %>
</c:set>
