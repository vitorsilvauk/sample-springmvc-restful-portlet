package com.liferay.samples.services.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.liferay.samples.services.model.HelloSample;

import java.util.List;

/**
 * The persistence utility for the hello sample service. This utility wraps {@link HelloSamplePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Liferay
 * @see HelloSamplePersistence
 * @see HelloSamplePersistenceImpl
 * @generated
 */
public class HelloSampleUtil {
    private static HelloSamplePersistence _persistence;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
     */
    public static void clearCache() {
        getPersistence().clearCache();
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
     */
    public static void clearCache(HelloSample helloSample) {
        getPersistence().clearCache(helloSample);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
     */
    public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return getPersistence().countWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
     */
    public static List<HelloSample> findWithDynamicQuery(
        DynamicQuery dynamicQuery) throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<HelloSample> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<HelloSample> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
     */
    public static HelloSample update(HelloSample helloSample)
        throws SystemException {
        return getPersistence().update(helloSample);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
     */
    public static HelloSample update(HelloSample helloSample,
        ServiceContext serviceContext) throws SystemException {
        return getPersistence().update(helloSample, serviceContext);
    }

    /**
    * Caches the hello sample in the entity cache if it is enabled.
    *
    * @param helloSample the hello sample
    */
    public static void cacheResult(
        com.liferay.samples.services.model.HelloSample helloSample) {
        getPersistence().cacheResult(helloSample);
    }

    /**
    * Caches the hello samples in the entity cache if it is enabled.
    *
    * @param helloSamples the hello samples
    */
    public static void cacheResult(
        java.util.List<com.liferay.samples.services.model.HelloSample> helloSamples) {
        getPersistence().cacheResult(helloSamples);
    }

    /**
    * Creates a new hello sample with the primary key. Does not add the hello sample to the database.
    *
    * @param sampleId the primary key for the new hello sample
    * @return the new hello sample
    */
    public static com.liferay.samples.services.model.HelloSample create(
        long sampleId) {
        return getPersistence().create(sampleId);
    }

    /**
    * Removes the hello sample with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param sampleId the primary key of the hello sample
    * @return the hello sample that was removed
    * @throws com.liferay.samples.services.NoSuchHelloSampleException if a hello sample with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.liferay.samples.services.model.HelloSample remove(
        long sampleId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.liferay.samples.services.NoSuchHelloSampleException {
        return getPersistence().remove(sampleId);
    }

    public static com.liferay.samples.services.model.HelloSample updateImpl(
        com.liferay.samples.services.model.HelloSample helloSample)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(helloSample);
    }

    /**
    * Returns the hello sample with the primary key or throws a {@link com.liferay.samples.services.NoSuchHelloSampleException} if it could not be found.
    *
    * @param sampleId the primary key of the hello sample
    * @return the hello sample
    * @throws com.liferay.samples.services.NoSuchHelloSampleException if a hello sample with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.liferay.samples.services.model.HelloSample findByPrimaryKey(
        long sampleId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.liferay.samples.services.NoSuchHelloSampleException {
        return getPersistence().findByPrimaryKey(sampleId);
    }

    /**
    * Returns the hello sample with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param sampleId the primary key of the hello sample
    * @return the hello sample, or <code>null</code> if a hello sample with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.liferay.samples.services.model.HelloSample fetchByPrimaryKey(
        long sampleId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(sampleId);
    }

    /**
    * Returns all the hello samples.
    *
    * @return the hello samples
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.liferay.samples.services.model.HelloSample> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
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
    public static java.util.List<com.liferay.samples.services.model.HelloSample> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
    }

    /**
    * Returns an ordered range of all the hello samples.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.samples.services.model.impl.HelloSampleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of hello samples
    * @param end the upper bound of the range of hello samples (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of hello samples
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.liferay.samples.services.model.HelloSample> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the hello samples from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of hello samples.
    *
    * @return the number of hello samples
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static HelloSamplePersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (HelloSamplePersistence) PortletBeanLocatorUtil.locate(com.liferay.samples.services.service.ClpSerializer.getServletContextName(),
                    HelloSamplePersistence.class.getName());

            ReferenceRegistry.registerReference(HelloSampleUtil.class,
                "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setPersistence(HelloSamplePersistence persistence) {
    }
}
