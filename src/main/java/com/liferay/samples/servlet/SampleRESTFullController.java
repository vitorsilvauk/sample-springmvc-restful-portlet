package com.liferay.samples.servlet;

import com.liferay.portal.kernel.dao.orm.ORMException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.samples.services.NoSuchHelloSampleException;
import com.liferay.samples.services.model.HelloSample;
import com.liferay.samples.services.model.impl.HelloSampleImpl;
import com.liferay.samples.services.service.HelloSampleServiceUtil;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class SampleRESTFullController {

	
@RequestMapping(value = "/helloSample", method=RequestMethod.GET)
@ResponseStatus(HttpStatus.OK)
public @ResponseBody List<HelloSample> helloSample() throws SystemException {
	try {
		return HelloSampleServiceUtil.getAllHelloSamples();
	} catch (SystemException e) {
		throw e;
	}
}
	
@RequestMapping(value = "/helloSample/sampleId/{sampleId}", method=RequestMethod.GET)
public @ResponseBody HelloSample helloSample(@PathVariable("sampleId") Long sampleId, HttpServletRequest request) throws NoSuchHelloSampleException, SystemException {
	try {
		return HelloSampleServiceUtil.getHelloSample(sampleId);
	} catch (PortalException e) {
		throw (NoSuchHelloSampleException) e;
	} catch (SystemException e) {
		throw e;
	}
}

@RequestMapping(value = "/helloSample", method=RequestMethod.POST)
@ResponseStatus(HttpStatus.CREATED)
public @ResponseBody HelloSample createSample(@RequestBody HelloSampleImpl helloSample) throws NoSuchHelloSampleException, SystemException {
	try {
		HelloSample createdObject = HelloSampleServiceUtil.addHelloSample(helloSample);
		return createdObject;
	}  catch (SystemException e) {
		throw e;
	}
}

@RequestMapping(value = "/helloSample/sampleId/{sampleId}",method = RequestMethod.PUT)
@ResponseStatus(HttpStatus.NO_CONTENT)
void update(@PathVariable("sampleId") long sampleId,@RequestBody HelloSampleImpl helloSample) throws SystemException, PortalException {
	try {
		helloSample.setSampleId(sampleId);
		HelloSampleServiceUtil.updateExistentHelloSample(helloSample);
	} catch (SystemException e) {
		throw e;
	}
}


@RequestMapping(value = "/helloSample/sampleId/{sampleId}",method = RequestMethod.DELETE)
@ResponseStatus(HttpStatus.NO_CONTENT)
void delete(@PathVariable("sampleId") long sampleId) throws SystemException, NoSuchHelloSampleException {
	try {
		HelloSampleServiceUtil.deleteHelloSample(sampleId);
	} catch (SystemException e) {
		throw e;
	} catch (PortalException e) {
		throw (NoSuchHelloSampleException) e;
	}
}

//exception handling

@ResponseStatus(HttpStatus.CONFLICT)  
@ExceptionHandler(SystemException.class)
public void handleConflict(SystemException se) {
    if(se.getCause() instanceof ORMException){
    	throw (ORMException) se.getCause();
    }
}

@ResponseStatus(HttpStatus.BAD_REQUEST) 
@ExceptionHandler(ORMException.class)
public void handleBadRequest(SystemException se) {
    
}

}
