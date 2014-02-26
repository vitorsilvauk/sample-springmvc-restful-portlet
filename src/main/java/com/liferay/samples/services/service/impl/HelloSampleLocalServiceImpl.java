package com.liferay.samples.services.service.impl;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.samples.services.NoSuchHelloSampleException;
import com.liferay.samples.services.model.HelloSample;
import com.liferay.samples.services.service.base.HelloSampleLocalServiceBaseImpl;

/**
 * The implementation of the hello sample local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.samples.services.service.HelloSampleLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Liferay
 * @see com.liferay.samples.services.service.base.HelloSampleLocalServiceBaseImpl
 * @see com.liferay.samples.services.service.HelloSampleLocalServiceUtil
 */
public class HelloSampleLocalServiceImpl extends HelloSampleLocalServiceBaseImpl {
	/*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.liferay.samples.services.service.HelloSampleLocalServiceUtil} to access the hello sample local service.
     */
	
	@Override
	public HelloSample addHelloSample(HelloSample helloSample)
			throws SystemException {
		
		Long helloSampleId = counterLocalService.increment();
		helloSample.setSampleId(helloSampleId);
		
		return super.addHelloSample(helloSample);
	}

	public HelloSample updateExistentHelloSample(HelloSample helloSample)
			throws SystemException, PortalException {
		if(helloSamplePersistence.fetchByPrimaryKey(helloSample.getSampleId())==null){
			throw new NoSuchHelloSampleException();
		}else{
			return super.updateHelloSample(helloSample);
		}
	}
	
    
	
	
}
