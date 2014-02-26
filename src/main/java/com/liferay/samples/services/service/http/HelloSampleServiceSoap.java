package com.liferay.samples.services.service.http;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import com.liferay.samples.services.service.HelloSampleServiceUtil;

import java.rmi.RemoteException;

/**
 * Provides the SOAP utility for the
 * {@link com.liferay.samples.services.service.HelloSampleServiceUtil} service utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it is difficult for SOAP to
 * support certain types.
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a {@link java.util.List}, that
 * is translated to an array of {@link com.liferay.samples.services.model.HelloSampleSoap}.
 * If the method in the service utility returns a
 * {@link com.liferay.samples.services.model.HelloSample}, that is translated to a
 * {@link com.liferay.samples.services.model.HelloSampleSoap}. Methods that SOAP cannot
 * safely wire are skipped.
 * </p>
 *
 * <p>
 * The benefits of using the SOAP utility is that it is cross platform
 * compatible. SOAP allows different languages like Java, .NET, C++, PHP, and
 * even Perl, to call the generated services. One drawback of SOAP is that it is
 * slow because it needs to serialize all calls into a text format (XML).
 * </p>
 *
 * <p>
 * You can see a list of services at http://localhost:8080/api/axis. Set the
 * property <b>axis.servlet.hosts.allowed</b> in portal.properties to configure
 * security.
 * </p>
 *
 * <p>
 * The SOAP utility is only generated for remote services.
 * </p>
 *
 * @author Liferay
 * @see HelloSampleServiceHttp
 * @see com.liferay.samples.services.model.HelloSampleSoap
 * @see com.liferay.samples.services.service.HelloSampleServiceUtil
 * @generated
 */
public class HelloSampleServiceSoap {
    private static Log _log = LogFactoryUtil.getLog(HelloSampleServiceSoap.class);

    public static com.liferay.samples.services.model.HelloSampleSoap[] getAllHelloSamples()
        throws RemoteException {
        try {
            java.util.List<com.liferay.samples.services.model.HelloSample> returnValue =
                HelloSampleServiceUtil.getAllHelloSamples();

            return com.liferay.samples.services.model.HelloSampleSoap.toSoapModels(returnValue);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    public static com.liferay.samples.services.model.HelloSampleSoap getHelloSample(
        java.lang.Long id) throws RemoteException {
        try {
            com.liferay.samples.services.model.HelloSample returnValue = HelloSampleServiceUtil.getHelloSample(id);

            return com.liferay.samples.services.model.HelloSampleSoap.toSoapModel(returnValue);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    public static com.liferay.samples.services.model.HelloSampleSoap addHelloSample(
        com.liferay.samples.services.model.HelloSampleSoap helloSample)
        throws RemoteException {
        try {
            com.liferay.samples.services.model.HelloSample returnValue = HelloSampleServiceUtil.addHelloSample(com.liferay.samples.services.model.impl.HelloSampleModelImpl.toModel(
                        helloSample));

            return com.liferay.samples.services.model.HelloSampleSoap.toSoapModel(returnValue);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    public static com.liferay.samples.services.model.HelloSampleSoap updateHelloSample(
        com.liferay.samples.services.model.HelloSampleSoap helloSample)
        throws RemoteException {
        try {
            com.liferay.samples.services.model.HelloSample returnValue = HelloSampleServiceUtil.updateHelloSample(com.liferay.samples.services.model.impl.HelloSampleModelImpl.toModel(
                        helloSample));

            return com.liferay.samples.services.model.HelloSampleSoap.toSoapModel(returnValue);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    public static com.liferay.samples.services.model.HelloSampleSoap updateExistentHelloSample(
        com.liferay.samples.services.model.HelloSampleSoap helloSample)
        throws RemoteException {
        try {
            com.liferay.samples.services.model.HelloSample returnValue = HelloSampleServiceUtil.updateExistentHelloSample(com.liferay.samples.services.model.impl.HelloSampleModelImpl.toModel(
                        helloSample));

            return com.liferay.samples.services.model.HelloSampleSoap.toSoapModel(returnValue);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    public static com.liferay.samples.services.model.HelloSampleSoap deleteHelloSample(
        java.lang.Long id) throws RemoteException {
        try {
            com.liferay.samples.services.model.HelloSample returnValue = HelloSampleServiceUtil.deleteHelloSample(id);

            return com.liferay.samples.services.model.HelloSampleSoap.toSoapModel(returnValue);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }
}
