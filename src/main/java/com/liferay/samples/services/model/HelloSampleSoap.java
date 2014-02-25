package com.liferay.samples.services.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.liferay.samples.services.service.http.HelloSampleServiceSoap}.
 *
 * @author Liferay
 * @see com.liferay.samples.services.service.http.HelloSampleServiceSoap
 * @generated
 */
public class HelloSampleSoap implements Serializable {
    private long _sampleId;
    private String _sampleName;
    private String _sampleAddress;

    public HelloSampleSoap() {
    }

    public static HelloSampleSoap toSoapModel(HelloSample model) {
        HelloSampleSoap soapModel = new HelloSampleSoap();

        soapModel.setSampleId(model.getSampleId());
        soapModel.setSampleName(model.getSampleName());
        soapModel.setSampleAddress(model.getSampleAddress());

        return soapModel;
    }

    public static HelloSampleSoap[] toSoapModels(HelloSample[] models) {
        HelloSampleSoap[] soapModels = new HelloSampleSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static HelloSampleSoap[][] toSoapModels(HelloSample[][] models) {
        HelloSampleSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new HelloSampleSoap[models.length][models[0].length];
        } else {
            soapModels = new HelloSampleSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static HelloSampleSoap[] toSoapModels(List<HelloSample> models) {
        List<HelloSampleSoap> soapModels = new ArrayList<HelloSampleSoap>(models.size());

        for (HelloSample model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new HelloSampleSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _sampleId;
    }

    public void setPrimaryKey(long pk) {
        setSampleId(pk);
    }

    public long getSampleId() {
        return _sampleId;
    }

    public void setSampleId(long sampleId) {
        _sampleId = sampleId;
    }

    public String getSampleName() {
        return _sampleName;
    }

    public void setSampleName(String sampleName) {
        _sampleName = sampleName;
    }

    public String getSampleAddress() {
        return _sampleAddress;
    }

    public void setSampleAddress(String sampleAddress) {
        _sampleAddress = sampleAddress;
    }
}
