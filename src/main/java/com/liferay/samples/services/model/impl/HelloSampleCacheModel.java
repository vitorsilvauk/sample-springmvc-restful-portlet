package com.liferay.samples.services.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.liferay.samples.services.model.HelloSample;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing HelloSample in entity cache.
 *
 * @author Liferay
 * @see HelloSample
 * @generated
 */
public class HelloSampleCacheModel implements CacheModel<HelloSample>,
    Externalizable {
    public long sampleId;
    public String sampleName;
    public String sampleAddress;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(7);

        sb.append("{sampleId=");
        sb.append(sampleId);
        sb.append(", sampleName=");
        sb.append(sampleName);
        sb.append(", sampleAddress=");
        sb.append(sampleAddress);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public HelloSample toEntityModel() {
        HelloSampleImpl helloSampleImpl = new HelloSampleImpl();

        helloSampleImpl.setSampleId(sampleId);

        if (sampleName == null) {
            helloSampleImpl.setSampleName(StringPool.BLANK);
        } else {
            helloSampleImpl.setSampleName(sampleName);
        }

        if (sampleAddress == null) {
            helloSampleImpl.setSampleAddress(StringPool.BLANK);
        } else {
            helloSampleImpl.setSampleAddress(sampleAddress);
        }

        helloSampleImpl.resetOriginalValues();

        return helloSampleImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        sampleId = objectInput.readLong();
        sampleName = objectInput.readUTF();
        sampleAddress = objectInput.readUTF();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        objectOutput.writeLong(sampleId);

        if (sampleName == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(sampleName);
        }

        if (sampleAddress == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(sampleAddress);
        }
    }
}
