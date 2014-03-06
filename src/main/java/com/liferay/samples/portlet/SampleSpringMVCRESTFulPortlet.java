package com.liferay.samples.portlet;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;
import org.springframework.web.portlet.bind.annotation.ResourceMapping;

@Controller
@RequestMapping("VIEW")
public class SampleSpringMVCRESTFulPortlet {

@RequestMapping
public String initRESTFulApp(){
	return "defaultView";
}
	
	
@RenderMapping(params="render=requestRESTFulData")
public String requestRESTFulData()
{
	return "RESTFulData";
}

@RenderMapping(params="render=requestFormDashboard")
public String requestFormDashboard()
{
	return "FormDashboard";
}
}

