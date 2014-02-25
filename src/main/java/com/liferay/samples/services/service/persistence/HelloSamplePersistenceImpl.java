package com.liferay.samples.services.service.persistence;

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.liferay.samples.services.NoSuchHelloSampleException;
import com.liferay.samples.services.model.HelloSample;
import com.liferay.samples.services.model.impl.HelloSampleImpl;
import com.liferay.samples.services.model.impl.HelloSampleModelImpl;
import com.liferay.samples.services.service.persistence.HelloSamplePersistence;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the hello sample service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Liferay
 * @see HelloSamplePersistence
 * @see HelloSampleUtil
 * @generated
 */
public class HelloSamplePersistenceImpl extends BasePersistenceImpl<HelloSample>
    implements HelloSamplePersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link HelloSampleUtil} to access the hello sample persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = HelloSampleImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(HelloSampleModelImpl.ENTITY_CACHE_ENABLED,
            HelloSampleModelImpl.FINDER_CACHE_ENABLED, HelloSampleImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(HelloSampleModelImpl.ENTITY_CACHE_ENABLED,
            HelloSampleModelImpl.FINDER_CACHE_ENABLED, HelloSampleImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(HelloSampleModelImpl.ENTITY_CACHE_ENABLED,
            HelloSampleModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    private static final String _SQL_SELECT_HELLOSAMPLE = "SELECT helloSample FROM HelloSample helloSample";
    private static final String _SQL_COUNT_HELLOSAMPLE = "SELECT COUNT(helloSample) FROM HelloSample helloSample";
    private static final String _ORDER_BY_ENTITY_ALIAS = "helloSample.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No HelloSample exists with the primary key ";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(HelloSamplePersistenceImpl.class);
    private static HelloSample _nullHelloSample = new HelloSampleImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<HelloSample> toCacheModel() {
                return _nullHelloSampleCacheModel;
            }
        };

    private static CacheModel<HelloSample> _nullHelloSampleCacheModel = new CacheModel<HelloSample>() {
            @Override
            public HelloSample toEntityModel() {
                return _nullHelloSample;
            }
        };

    public HelloSamplePersistenceImpl() {
        setModelClass(HelloSample.class);
    }

    /**
     * Caches the hello sample in the entity cache if it is enabled.
     *
     * @param helloSample the hello sample
     */
    @Override
    public void cacheResult(HelloSample helloSample) {
        EntityCacheUtil.putResult(HelloSampleModelImpl.ENTITY_CACHE_ENABLED,
            HelloSampleImpl.class, helloSample.getPrimaryKey(), helloSample);

        helloSample.resetOriginalValues();
    }

    /**
     * Caches the hello samples in the entity cache if it is enabled.
     *
     * @param helloSamples the hello samples
     */
    @Override
    public void cacheResult(List<HelloSample> helloSamples) {
        for (HelloSample helloSample : helloSamples) {
            if (EntityCacheUtil.getResult(
                        HelloSampleModelImpl.ENTITY_CACHE_ENABLED,
                        HelloSampleImpl.class, helloSample.getPrimaryKey()) == null) {
                cacheResult(helloSample);
            } else {
                helloSample.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all hello samples.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(HelloSampleImpl.class.getName());
        }

        EntityCacheUtil.clearCache(HelloSampleImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the hello sample.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(HelloSample helloSample) {
        EntityCacheUtil.removeResult(HelloSampleModelImpl.ENTITY_CACHE_ENABLED,
            HelloSampleImpl.class, helloSample.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    @Override
    public void clearCache(List<HelloSample> helloSamples) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (HelloSample helloSample : helloSamples) {
            EntityCacheUtil.removeResult(HelloSampleModelImpl.ENTITY_CACHE_ENABLED,
                HelloSampleImpl.class, helloSample.getPrimaryKey());
        }
    }

    /**
     * Creates a new hello sample with the primary key. Does not add the hello sample to the database.
     *
     * @param sampleId the primary key for the new hello sample
     * @return the new hello sample
     */
    @Override
    public HelloSample create(long sampleId) {
        HelloSample helloSample = new HelloSampleImpl();

        helloSample.setNew(true);
        helloSample.setPrimaryKey(sampleId);

        return helloSample;
    }

    /**
     * Removes the hello sample with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param sampleId the primary key of the hello sample
     * @return the hello sample that was removed
     * @throws com.liferay.samples.services.NoSuchHelloSampleException if a hello sample with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public HelloSample remove(long sampleId)
        throws NoSuchHelloSampleException, SystemException {
        return remove((Serializable) sampleId);
    }

    /**
     * Removes the hello sample with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the hello sample
     * @return the hello sample that was removed
     * @throws com.liferay.samples.services.NoSuchHelloSampleException if a hello sample with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public HelloSample remove(Serializable primaryKey)
        throws NoSuchHelloSampleException, SystemException {
        Session session = null;

        try {
            session = openSession();

            HelloSample helloSample = (HelloSample) session.get(HelloSampleImpl.class,
                    primaryKey);

            if (helloSample == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchHelloSampleException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(helloSample);
        } catch (NoSuchHelloSampleException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected HelloSample removeImpl(HelloSample helloSample)
        throws SystemException {
        helloSample = toUnwrappedModel(helloSample);

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(helloSample)) {
                helloSample = (HelloSample) session.get(HelloSampleImpl.class,
                        helloSample.getPrimaryKeyObj());
            }

            if (helloSample != null) {
                session.delete(helloSample);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (helloSample != null) {
            clearCache(helloSample);
        }

        return helloSample;
    }

    @Override
    public HelloSample updateImpl(
        com.liferay.samples.services.model.HelloSample helloSample)
        throws SystemException {
        helloSample = toUnwrappedModel(helloSample);

        boolean isNew = helloSample.isNew();

        Session session = null;

        try {
            session = openSession();

            if (helloSample.isNew()) {
                session.save(helloSample);

                helloSample.setNew(false);
            } else {
                session.merge(helloSample);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }

        EntityCacheUtil.putResult(HelloSampleModelImpl.ENTITY_CACHE_ENABLED,
            HelloSampleImpl.class, helloSample.getPrimaryKey(), helloSample);

        return helloSample;
    }

    protected HelloSample toUnwrappedModel(HelloSample helloSample) {
        if (helloSample instanceof HelloSampleImpl) {
            return helloSample;
        }

        HelloSampleImpl helloSampleImpl = new HelloSampleImpl();

        helloSampleImpl.setNew(helloSample.isNew());
        helloSampleImpl.setPrimaryKey(helloSample.getPrimaryKey());

        helloSampleImpl.setSampleId(helloSample.getSampleId());
        helloSampleImpl.setSampleName(helloSample.getSampleName());
        helloSampleImpl.setSampleAddress(helloSample.getSampleAddress());

        return helloSampleImpl;
    }

    /**
     * Returns the hello sample with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the hello sample
     * @return the hello sample
     * @throws com.liferay.samples.services.NoSuchHelloSampleException if a hello sample with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public HelloSample findByPrimaryKey(Serializable primaryKey)
        throws NoSuchHelloSampleException, SystemException {
        HelloSample helloSample = fetchByPrimaryKey(primaryKey);

        if (helloSample == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchHelloSampleException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return helloSample;
    }

    /**
     * Returns the hello sample with the primary key or throws a {@link com.liferay.samples.services.NoSuchHelloSampleException} if it could not be found.
     *
     * @param sampleId the primary key of the hello sample
     * @return the hello sample
     * @throws com.liferay.samples.services.NoSuchHelloSampleException if a hello sample with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public HelloSample findByPrimaryKey(long sampleId)
        throws NoSuchHelloSampleException, SystemException {
        return findByPrimaryKey((Serializable) sampleId);
    }

    /**
     * Returns the hello sample with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the hello sample
     * @return the hello sample, or <code>null</code> if a hello sample with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public HelloSample fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        HelloSample helloSample = (HelloSample) EntityCacheUtil.getResult(HelloSampleModelImpl.ENTITY_CACHE_ENABLED,
                HelloSampleImpl.class, primaryKey);

        if (helloSample == _nullHelloSample) {
            return null;
        }

        if (helloSample == null) {
            Session session = null;

            try {
                session = openSession();

                helloSample = (HelloSample) session.get(HelloSampleImpl.class,
                        primaryKey);

                if (helloSample != null) {
                    cacheResult(helloSample);
                } else {
                    EntityCacheUtil.putResult(HelloSampleModelImpl.ENTITY_CACHE_ENABLED,
                        HelloSampleImpl.class, primaryKey, _nullHelloSample);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(HelloSampleModelImpl.ENTITY_CACHE_ENABLED,
                    HelloSampleImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return helloSample;
    }

    /**
     * Returns the hello sample with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param sampleId the primary key of the hello sample
     * @return the hello sample, or <code>null</code> if a hello sample with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public HelloSample fetchByPrimaryKey(long sampleId)
        throws SystemException {
        return fetchByPrimaryKey((Serializable) sampleId);
    }

    /**
     * Returns all the hello samples.
     *
     * @return the hello samples
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<HelloSample> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
    public List<HelloSample> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
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
    @Override
    public List<HelloSample> findAll(int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
            finderArgs = FINDER_ARGS_EMPTY;
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
            finderArgs = new Object[] { start, end, orderByComparator };
        }

        List<HelloSample> list = (List<HelloSample>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_HELLOSAMPLE);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_HELLOSAMPLE;

                if (pagination) {
                    sql = sql.concat(HelloSampleModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<HelloSample>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<HelloSample>(list);
                } else {
                    list = (List<HelloSample>) QueryUtil.list(q, getDialect(),
                            start, end);
                }

                cacheResult(list);

                FinderCacheUtil.putResult(finderPath, finderArgs, list);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return list;
    }

    /**
     * Removes all the hello samples from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (HelloSample helloSample : findAll()) {
            remove(helloSample);
        }
    }

    /**
     * Returns the number of hello samples.
     *
     * @return the number of hello samples
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countAll() throws SystemException {
        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
                FINDER_ARGS_EMPTY, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(_SQL_COUNT_HELLOSAMPLE);

                count = (Long) q.uniqueResult();

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
                    FINDER_ARGS_EMPTY, count);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_ALL,
                    FINDER_ARGS_EMPTY);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Initializes the hello sample persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.com.liferay.samples.services.model.HelloSample")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<HelloSample>> listenersList = new ArrayList<ModelListener<HelloSample>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<HelloSample>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(HelloSampleImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}
