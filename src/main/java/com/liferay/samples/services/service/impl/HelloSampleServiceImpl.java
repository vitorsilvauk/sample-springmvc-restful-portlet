package com.liferay.samples.services.service.impl;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.samples.services.model.HelloSample;
import com.liferay.samples.services.service.base.HelloSampleServiceBaseImpl;

import java.util.List;

/**
 * The implementation of the hello sample remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.samples.services.service.HelloSampleService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Liferay
 * @see com.liferay.samples.services.service.base.HelloSampleServiceBaseImpl
 * @see com.liferay.samples.services.service.HelloSampleServiceUtil
 */
public class HelloSampleServiceImpl extends HelloSampleServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.liferay.samples.services.service.HelloSampleServiceUtil} to access the hello sample remote service.
     */
	
	public List<HelloSample> getAllHelloSamples() throws SystemException{
		return helloSampleLocalService.getHelloSamples(-1, -1);
	}
	
	public HelloSample getHelloSample(Long id) throws SystemException, PortalException{
		return helloSampleLocalService.getHelloSample(id);
	}
	
	public HelloSample addHelloSample(HelloSample helloSample) throws SystemException{
		return helloSampleLocalService.addHelloSample(helloSample);
	}
	
	public HelloSample updateHelloSample(HelloSample helloSample) throws SystemException{
		return helloSampleLocalService.updateHelloSample(helloSample);
	}
	
	public HelloSample updateExistentHelloSample(HelloSample helloSample) throws SystemException, PortalException{
		return helloSampleLocalService.updateExistentHelloSample(helloSample);
	}
	
	public HelloSample deleteHelloSample(Long id) throws PortalException, SystemException{
		return helloSampleLocalService.deleteHelloSample(id);
	}
	
}
