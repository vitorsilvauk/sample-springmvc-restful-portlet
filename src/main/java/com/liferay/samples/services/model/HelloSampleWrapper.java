package com.liferay.samples.services.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link HelloSample}.
 * </p>
 *
 * @author Liferay
 * @see HelloSample
 * @generated
 */
public class HelloSampleWrapper implements HelloSample,
    ModelWrapper<HelloSample> {
    private HelloSample _helloSample;

    public HelloSampleWrapper(HelloSample helloSample) {
        _helloSample = helloSample;
    }

    @Override
    public Class<?> getModelClass() {
        return HelloSample.class;
    }

    @Override
    public String getModelClassName() {
        return HelloSample.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("sampleId", getSampleId());
        attributes.put("sampleName", getSampleName());
        attributes.put("sampleAddress", getSampleAddress());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long sampleId = (Long) attributes.get("sampleId");

        if (sampleId != null) {
            setSampleId(sampleId);
        }

        String sampleName = (String) attributes.get("sampleName");

        if (sampleName != null) {
            setSampleName(sampleName);
        }

        String sampleAddress = (String) attributes.get("sampleAddress");

        if (sampleAddress != null) {
            setSampleAddress(sampleAddress);
        }
    }

    /**
    * Returns the primary key of this hello sample.
    *
    * @return the primary key of this hello sample
    */
    @Override
    public long getPrimaryKey() {
        return _helloSample.getPrimaryKey();
    }

    /**
    * Sets the primary key of this hello sample.
    *
    * @param primaryKey the primary key of this hello sample
    */
    @Override
    public void setPrimaryKey(long primaryKey) {
        _helloSample.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the sample ID of this hello sample.
    *
    * @return the sample ID of this hello sample
    */
    @Override
    public long getSampleId() {
        return _helloSample.getSampleId();
    }

    /**
    * Sets the sample ID of this hello sample.
    *
    * @param sampleId the sample ID of this hello sample
    */
    @Override
    public void setSampleId(long sampleId) {
        _helloSample.setSampleId(sampleId);
    }

    /**
    * Returns the sample name of this hello sample.
    *
    * @return the sample name of this hello sample
    */
    @Override
    public java.lang.String getSampleName() {
        return _helloSample.getSampleName();
    }

    /**
    * Sets the sample name of this hello sample.
    *
    * @param sampleName the sample name of this hello sample
    */
    @Override
    public void setSampleName(java.lang.String sampleName) {
        _helloSample.setSampleName(sampleName);
    }

    /**
    * Returns the sample address of this hello sample.
    *
    * @return the sample address of this hello sample
    */
    @Override
    public java.lang.String getSampleAddress() {
        return _helloSample.getSampleAddress();
    }

    /**
    * Sets the sample address of this hello sample.
    *
    * @param sampleAddress the sample address of this hello sample
    */
    @Override
    public void setSampleAddress(java.lang.String sampleAddress) {
        _helloSample.setSampleAddress(sampleAddress);
    }

    @Override
    public boolean isNew() {
        return _helloSample.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _helloSample.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _helloSample.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _helloSample.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _helloSample.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _helloSample.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _helloSample.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _helloSample.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _helloSample.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _helloSample.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _helloSample.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new HelloSampleWrapper((HelloSample) _helloSample.clone());
    }

    @Override
    public int compareTo(
        com.liferay.samples.services.model.HelloSample helloSample) {
        return _helloSample.compareTo(helloSample);
    }

    @Override
    public int hashCode() {
        return _helloSample.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<com.liferay.samples.services.model.HelloSample> toCacheModel() {
        return _helloSample.toCacheModel();
    }

    @Override
    public com.liferay.samples.services.model.HelloSample toEscapedModel() {
        return new HelloSampleWrapper(_helloSample.toEscapedModel());
    }

    @Override
    public com.liferay.samples.services.model.HelloSample toUnescapedModel() {
        return new HelloSampleWrapper(_helloSample.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _helloSample.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _helloSample.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _helloSample.persist();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof HelloSampleWrapper)) {
            return false;
        }

        HelloSampleWrapper helloSampleWrapper = (HelloSampleWrapper) obj;

        if (Validator.equals(_helloSample, helloSampleWrapper._helloSample)) {
            return true;
        }

        return false;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public HelloSample getWrappedHelloSample() {
        return _helloSample;
    }

    @Override
    public HelloSample getWrappedModel() {
        return _helloSample;
    }

    @Override
    public void resetOriginalValues() {
        _helloSample.resetOriginalValues();
    }
}
