package com.liferay.samples.services.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.liferay.samples.services.service.ClpSerializer;
import com.liferay.samples.services.service.HelloSampleLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;


public class HelloSampleClp extends BaseModelImpl<HelloSample>
    implements HelloSample {
    private long _sampleId;
    private String _sampleName;
    private String _sampleAddress;
    private BaseModel<?> _helloSampleRemoteModel;

    public HelloSampleClp() {
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
    public long getPrimaryKey() {
        return _sampleId;
    }

    @Override
    public void setPrimaryKey(long primaryKey) {
        setSampleId(primaryKey);
    }

    @Override
    public Serializable getPrimaryKeyObj() {
        return _sampleId;
    }

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
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

    @Override
    public long getSampleId() {
        return _sampleId;
    }

    @Override
    public void setSampleId(long sampleId) {
        _sampleId = sampleId;

        if (_helloSampleRemoteModel != null) {
            try {
                Class<?> clazz = _helloSampleRemoteModel.getClass();

                Method method = clazz.getMethod("setSampleId", long.class);

                method.invoke(_helloSampleRemoteModel, sampleId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getSampleName() {
        return _sampleName;
    }

    @Override
    public void setSampleName(String sampleName) {
        _sampleName = sampleName;

        if (_helloSampleRemoteModel != null) {
            try {
                Class<?> clazz = _helloSampleRemoteModel.getClass();

                Method method = clazz.getMethod("setSampleName", String.class);

                method.invoke(_helloSampleRemoteModel, sampleName);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getSampleAddress() {
        return _sampleAddress;
    }

    @Override
    public void setSampleAddress(String sampleAddress) {
        _sampleAddress = sampleAddress;

        if (_helloSampleRemoteModel != null) {
            try {
                Class<?> clazz = _helloSampleRemoteModel.getClass();

                Method method = clazz.getMethod("setSampleAddress", String.class);

                method.invoke(_helloSampleRemoteModel, sampleAddress);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        try {
            String methodName = "setExpandoBridgeAttributes";

            Class<?>[] parameterTypes = new Class<?>[] {
                    com.liferay.portlet.expando.model.ExpandoBridge.class
                };

            Object[] parameterValues = new Object[] { expandoBridge };

            invokeOnRemoteModel(methodName, parameterTypes, parameterValues);
        } catch (Exception e) {
            throw new UnsupportedOperationException(e);
        }
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        try {
            String methodName = "setExpandoBridgeAttributes";

            Class<?>[] parameterTypes = new Class<?>[] {
                    com.liferay.portal.model.BaseModel.class
                };

            Object[] parameterValues = new Object[] { baseModel };

            invokeOnRemoteModel(methodName, parameterTypes, parameterValues);
        } catch (Exception e) {
            throw new UnsupportedOperationException(e);
        }
    }

    public BaseModel<?> getHelloSampleRemoteModel() {
        return _helloSampleRemoteModel;
    }

    public void setHelloSampleRemoteModel(BaseModel<?> helloSampleRemoteModel) {
        _helloSampleRemoteModel = helloSampleRemoteModel;
    }

    public Object invokeOnRemoteModel(String methodName,
        Class<?>[] parameterTypes, Object[] parameterValues)
        throws Exception {
        Object[] remoteParameterValues = new Object[parameterValues.length];

        for (int i = 0; i < parameterValues.length; i++) {
            if (parameterValues[i] != null) {
                remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
            }
        }

        Class<?> remoteModelClass = _helloSampleRemoteModel.getClass();

        ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

        Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

        for (int i = 0; i < parameterTypes.length; i++) {
            if (parameterTypes[i].isPrimitive()) {
                remoteParameterTypes[i] = parameterTypes[i];
            } else {
                String parameterTypeName = parameterTypes[i].getName();

                remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
            }
        }

        Method method = remoteModelClass.getMethod(methodName,
                remoteParameterTypes);

        Object returnValue = method.invoke(_helloSampleRemoteModel,
                remoteParameterValues);

        if (returnValue != null) {
            returnValue = ClpSerializer.translateOutput(returnValue);
        }

        return returnValue;
    }

    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            HelloSampleLocalServiceUtil.addHelloSample(this);
        } else {
            HelloSampleLocalServiceUtil.updateHelloSample(this);
        }
    }

    @Override
    public HelloSample toEscapedModel() {
        return (HelloSample) ProxyUtil.newProxyInstance(HelloSample.class.getClassLoader(),
            new Class[] { HelloSample.class }, new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        HelloSampleClp clone = new HelloSampleClp();

        clone.setSampleId(getSampleId());
        clone.setSampleName(getSampleName());
        clone.setSampleAddress(getSampleAddress());

        return clone;
    }

    @Override
    public int compareTo(HelloSample helloSample) {
        long primaryKey = helloSample.getPrimaryKey();

        if (getPrimaryKey() < primaryKey) {
            return -1;
        } else if (getPrimaryKey() > primaryKey) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof HelloSampleClp)) {
            return false;
        }

        HelloSampleClp helloSample = (HelloSampleClp) obj;

        long primaryKey = helloSample.getPrimaryKey();

        if (getPrimaryKey() == primaryKey) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return (int) getPrimaryKey();
    }

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(7);

        sb.append("{sampleId=");
        sb.append(getSampleId());
        sb.append(", sampleName=");
        sb.append(getSampleName());
        sb.append(", sampleAddress=");
        sb.append(getSampleAddress());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(13);

        sb.append("<model><model-name>");
        sb.append("com.liferay.samples.services.model.HelloSample");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>sampleId</column-name><column-value><![CDATA[");
        sb.append(getSampleId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>sampleName</column-name><column-value><![CDATA[");
        sb.append(getSampleName());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>sampleAddress</column-name><column-value><![CDATA[");
        sb.append(getSampleAddress());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
