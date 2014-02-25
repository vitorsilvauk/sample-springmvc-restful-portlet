package com.liferay.samples.services.service.persistence;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

import com.liferay.samples.services.model.HelloSample;
import com.liferay.samples.services.service.HelloSampleLocalServiceUtil;

/**
 * @author Liferay
 * @generated
 */
public abstract class HelloSampleActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public HelloSampleActionableDynamicQuery() throws SystemException {
        setBaseLocalService(HelloSampleLocalServiceUtil.getService());
        setClass(HelloSample.class);

        setClassLoader(com.liferay.samples.services.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("sampleId");
    }
}
