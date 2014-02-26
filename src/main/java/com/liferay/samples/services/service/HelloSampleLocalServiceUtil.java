package com.liferay.samples.services.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for HelloSample. This utility wraps
 * {@link com.liferay.samples.services.service.impl.HelloSampleLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Liferay
 * @see HelloSampleLocalService
 * @see com.liferay.samples.services.service.base.HelloSampleLocalServiceBaseImpl
 * @see com.liferay.samples.services.service.impl.HelloSampleLocalServiceImpl
 * @generated
 */
public class HelloSampleLocalServiceUtil {
    private static HelloSampleLocalService _service;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Add custom service methods to {@link com.liferay.samples.services.service.impl.HelloSampleLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
     */

    /**
    * Adds the hello sample to the database. Also notifies the appropriate model listeners.
    *
    * @param helloSample the hello sample
    * @return the hello sample that was added
    * @throws SystemException if a system exception occurred
    */
    public static com.liferay.samples.services.model.HelloSample addHelloSample(
        com.liferay.samples.services.model.HelloSample helloSample)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().addHelloSample(helloSample);
    }

    /**
    * Creates a new hello sample with the primary key. Does not add the hello sample to the database.
    *
    * @param sampleId the primary key for the new hello sample
    * @return the new hello sample
    */
    public static com.liferay.samples.services.model.HelloSample createHelloSample(
        long sampleId) {
        return getService().createHelloSample(sampleId);
    }

    /**
    * Deletes the hello sample with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param sampleId the primary key of the hello sample
    * @return the hello sample that was removed
    * @throws PortalException if a hello sample with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.liferay.samples.services.model.HelloSample deleteHelloSample(
        long sampleId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteHelloSample(sampleId);
    }

    /**
    * Deletes the hello sample from the database. Also notifies the appropriate model listeners.
    *
    * @param helloSample the hello sample
    * @return the hello sample that was removed
    * @throws SystemException if a system exception occurred
    */
    public static com.liferay.samples.services.model.HelloSample deleteHelloSample(
        com.liferay.samples.services.model.HelloSample helloSample)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteHelloSample(helloSample);
    }

    public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return getService().dynamicQuery();
    }

    /**
    * Performs a dynamic query on the database and returns the matching rows.
    *
    * @param dynamicQuery the dynamic query
    * @return the matching rows
    * @throws SystemException if a system exception occurred
    */
    @SuppressWarnings("rawtypes")
    public static java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQuery(dynamicQuery);
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
    @SuppressWarnings("rawtypes")
    public static java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQuery(dynamicQuery, start, end);
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
    @SuppressWarnings("rawtypes")
    public static java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService()
                   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    public static long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQueryCount(dynamicQuery);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @param projection the projection to apply to the query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    public static long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
        com.liferay.portal.kernel.dao.orm.Projection projection)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQueryCount(dynamicQuery, projection);
    }

    public static com.liferay.samples.services.model.HelloSample fetchHelloSample(
        long sampleId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().fetchHelloSample(sampleId);
    }

    /**
    * Returns the hello sample with the primary key.
    *
    * @param sampleId the primary key of the hello sample
    * @return the hello sample
    * @throws PortalException if a hello sample with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.liferay.samples.services.model.HelloSample getHelloSample(
        long sampleId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getHelloSample(sampleId);
    }

    public static com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getPersistedModel(primaryKeyObj);
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
    public static java.util.List<com.liferay.samples.services.model.HelloSample> getHelloSamples(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getHelloSamples(start, end);
    }

    /**
    * Returns the number of hello samples.
    *
    * @return the number of hello samples
    * @throws SystemException if a system exception occurred
    */
    public static int getHelloSamplesCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getHelloSamplesCount();
    }

    /**
    * Updates the hello sample in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param helloSample the hello sample
    * @return the hello sample that was updated
    * @throws SystemException if a system exception occurred
    */
    public static com.liferay.samples.services.model.HelloSample updateHelloSample(
        com.liferay.samples.services.model.HelloSample helloSample)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().updateHelloSample(helloSample);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    public static java.lang.String getBeanIdentifier() {
        return getService().getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    public static void setBeanIdentifier(java.lang.String beanIdentifier) {
        getService().setBeanIdentifier(beanIdentifier);
    }

    public static java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return getService().invokeMethod(name, parameterTypes, arguments);
    }

    public static com.liferay.samples.services.model.HelloSample updateExistentHelloSample(
        com.liferay.samples.services.model.HelloSample helloSample)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().updateExistentHelloSample(helloSample);
    }

    public static void clearService() {
        _service = null;
    }

    public static HelloSampleLocalService getService() {
        if (_service == null) {
            InvokableLocalService invokableLocalService = (InvokableLocalService) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    HelloSampleLocalService.class.getName());

            if (invokableLocalService instanceof HelloSampleLocalService) {
                _service = (HelloSampleLocalService) invokableLocalService;
            } else {
                _service = new HelloSampleLocalServiceClp(invokableLocalService);
            }

            ReferenceRegistry.registerReference(HelloSampleLocalServiceUtil.class,
                "_service");
        }

        return _service;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setService(HelloSampleLocalService service) {
    }
}
