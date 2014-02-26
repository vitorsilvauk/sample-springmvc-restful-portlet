package com.liferay.samples.services.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link HelloSampleService}.
 *
 * @author Liferay
 * @see HelloSampleService
 * @generated
 */
public class HelloSampleServiceWrapper implements HelloSampleService,
    ServiceWrapper<HelloSampleService> {
    private HelloSampleService _helloSampleService;

    public HelloSampleServiceWrapper(HelloSampleService helloSampleService) {
        _helloSampleService = helloSampleService;
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _helloSampleService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _helloSampleService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _helloSampleService.invokeMethod(name, parameterTypes, arguments);
    }

    @Override
    public java.util.List<com.liferay.samples.services.model.HelloSample> getAllHelloSamples()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _helloSampleService.getAllHelloSamples();
    }

    @Override
    public com.liferay.samples.services.model.HelloSample getHelloSample(
        java.lang.Long id)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _helloSampleService.getHelloSample(id);
    }

    @Override
    public com.liferay.samples.services.model.HelloSample addHelloSample(
        com.liferay.samples.services.model.HelloSample helloSample)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _helloSampleService.addHelloSample(helloSample);
    }

    @Override
    public com.liferay.samples.services.model.HelloSample updateHelloSample(
        com.liferay.samples.services.model.HelloSample helloSample)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _helloSampleService.updateHelloSample(helloSample);
    }

    @Override
    public com.liferay.samples.services.model.HelloSample updateExistentHelloSample(
        com.liferay.samples.services.model.HelloSample helloSample)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _helloSampleService.updateExistentHelloSample(helloSample);
    }

    @Override
    public com.liferay.samples.services.model.HelloSample deleteHelloSample(
        java.lang.Long id)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _helloSampleService.deleteHelloSample(id);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public HelloSampleService getWrappedHelloSampleService() {
        return _helloSampleService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedHelloSampleService(
        HelloSampleService helloSampleService) {
        _helloSampleService = helloSampleService;
    }

    @Override
    public HelloSampleService getWrappedService() {
        return _helloSampleService;
    }

    @Override
    public void setWrappedService(HelloSampleService helloSampleService) {
        _helloSampleService = helloSampleService;
    }
}
