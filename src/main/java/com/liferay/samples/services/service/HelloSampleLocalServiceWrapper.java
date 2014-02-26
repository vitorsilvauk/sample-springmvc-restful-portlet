package com.liferay.samples.services.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link HelloSampleLocalService}.
 *
 * @author Liferay
 * @see HelloSampleLocalService
 * @generated
 */
public class HelloSampleLocalServiceWrapper implements HelloSampleLocalService,
    ServiceWrapper<HelloSampleLocalService> {
    private HelloSampleLocalService _helloSampleLocalService;

    public HelloSampleLocalServiceWrapper(
        HelloSampleLocalService helloSampleLocalService) {
        _helloSampleLocalService = helloSampleLocalService;
    }

    /**
    * Adds the hello sample to the database. Also notifies the appropriate model listeners.
    *
    * @param helloSample the hello sample
    * @return the hello sample that was added
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.liferay.samples.services.model.HelloSample addHelloSample(
        com.liferay.samples.services.model.HelloSample helloSample)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _helloSampleLocalService.addHelloSample(helloSample);
    }

    /**
    * Creates a new hello sample with the primary key. Does not add the hello sample to the database.
    *
    * @param sampleId the primary key for the new hello sample
    * @return the new hello sample
    */
    @Override
    public com.liferay.samples.services.model.HelloSample createHelloSample(
        long sampleId) {
        return _helloSampleLocalService.createHelloSample(sampleId);
    }

    /**
    * Deletes the hello sample with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param sampleId the primary key of the hello sample
    * @return the hello sample that was removed
    * @throws PortalException if a hello sample with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.liferay.samples.services.model.HelloSample deleteHelloSample(
        long sampleId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _helloSampleLocalService.deleteHelloSample(sampleId);
    }

    /**
    * Deletes the hello sample from the database. Also notifies the appropriate model listeners.
    *
    * @param helloSample the hello sample
    * @return the hello sample that was removed
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.liferay.samples.services.model.HelloSample deleteHelloSample(
        com.liferay.samples.services.model.HelloSample helloSample)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _helloSampleLocalService.deleteHelloSample(helloSample);
    }

    @Override
    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return _helloSampleLocalService.dynamicQuery();
    }

    /**
    * Performs a dynamic query on the database and returns the matching rows.
    *
    * @param dynamicQuery the dynamic query
    * @return the matching rows
    * @throws SystemException if a system exception occurred
    */
    @Override
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _helloSampleLocalService.dynamicQuery(dynamicQuery);
    }

    /**
    * Performs a dynamic query on the database and returns a range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.samples.services.model.impl.HelloSampleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param dynamicQuery the dynamic query
    * @param start the lower bound of the range of model instances
    * @param end the upper bound of the range of model instances (not inclusive)
    * @return the range of matching rows
    * @throws SystemException if a system exception occurred
    */
    @Override
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException {
        return _helloSampleLocalService.dynamicQuery(dynamicQuery, start, end);
    }

    /**
    * Performs a dynamic query on the database and returns an ordered range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.samples.services.model.impl.HelloSampleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param dynamicQuery the dynamic query
    * @param start the lower bound of the range of model instances
    * @param end the upper bound of the range of model instances (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching rows
    * @throws SystemException if a system exception occurred
    */
    @Override
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _helloSampleLocalService.dynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    @Override
    public long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _helloSampleLocalService.dynamicQueryCount(dynamicQuery);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @param projection the projection to apply to the query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    @Override
    public long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
        com.liferay.portal.kernel.dao.orm.Projection projection)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _helloSampleLocalService.dynamicQueryCount(dynamicQuery,
            projection);
    }

    @Override
    public com.liferay.samples.services.model.HelloSample fetchHelloSample(
        long sampleId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _helloSampleLocalService.fetchHelloSample(sampleId);
    }

    /**
    * Returns the hello sample with the primary key.
    *
    * @param sampleId the primary key of the hello sample
    * @return the hello sample
    * @throws PortalException if a hello sample with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.liferay.samples.services.model.HelloSample getHelloSample(
        long sampleId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _helloSampleLocalService.getHelloSample(sampleId);
    }

    @Override
    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _helloSampleLocalService.getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns a range of all the hello samples.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.samples.services.model.impl.HelloSampleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of hello samples
    * @param end the upper bound of the range of hello samples (not inclusive)
    * @return the range of hello samples
    * @throws SystemException if a system exception occurred
    */
    @Override
    public java.util.List<com.liferay.samples.services.model.HelloSample> getHelloSamples(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _helloSampleLocalService.getHelloSamples(start, end);
    }

    /**
    * Returns the number of hello samples.
    *
    * @return the number of hello samples
    * @throws SystemException if a system exception occurred
    */
    @Override
    public int getHelloSamplesCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _helloSampleLocalService.getHelloSamplesCount();
    }

    /**
    * Updates the hello sample in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param helloSample the hello sample
    * @return the hello sample that was updated
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.liferay.samples.services.model.HelloSample updateHelloSample(
        com.liferay.samples.services.model.HelloSample helloSample)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _helloSampleLocalService.updateHelloSample(helloSample);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _helloSampleLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _helloSampleLocalService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _helloSampleLocalService.invokeMethod(name, parameterTypes,
            arguments);
    }

    @Override
    public com.liferay.samples.services.model.HelloSample updateExistentHelloSample(
        com.liferay.samples.services.model.HelloSample helloSample)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _helloSampleLocalService.updateExistentHelloSample(helloSample);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public HelloSampleLocalService getWrappedHelloSampleLocalService() {
        return _helloSampleLocalService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedHelloSampleLocalService(
        HelloSampleLocalService helloSampleLocalService) {
        _helloSampleLocalService = helloSampleLocalService;
    }

    @Override
    public HelloSampleLocalService getWrappedService() {
        return _helloSampleLocalService;
    }

    @Override
    public void setWrappedService(
        HelloSampleLocalService helloSampleLocalService) {
        _helloSampleLocalService = helloSampleLocalService;
    }
}
