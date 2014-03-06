<%@include file="init.jsp" %>


<portlet:renderURL var="requestFormDashboardUrl" >
	<portlet:param name="render" value="requestFormDashboard"></portlet:param>
</portlet:renderURL>
<portlet:renderURL var="requestRESTFulDataUrl" >
	<portlet:param name="render" value="requestRESTFulData"></portlet:param>
</portlet:renderURL>

Select the Restful data example or a Sample Dashboard

<aui:button-row>

	<aui:button value="RESTFul Data" onClick="${requestRESTFulDataUrl}"/>
	<aui:button value="Sample Form Dashboard" onClick="${requestFormDashboardUrl}"/>
	
</aui:button-row>

