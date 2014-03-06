<%@include file="init.jsp" %>


<div id="${portletNamespace}myDIV"></div>

<script src="${ctxPath}/js/RESTFulData.js" type="text/javascript">
</script>

<c:set var="hasAddPermission">
<%=permissionChecker.hasPermission(
		scopeGroupId, "com.liferay.sample.services.model",
		scopeGroupId, "ADD_HELLOSAMPLE") %>
</c:set>
<c:set var="hasDeletePermission">
<%=permissionChecker.hasPermission(
		scopeGroupId, "com.liferay.sample.services.model",
		scopeGroupId, "DELETE_HELLOSAMPLE") %>
</c:set>

<c:set var="hasUpdatePermission">
<%=permissionChecker.hasPermission(
		scopeGroupId, "com.liferay.sample.services.model",
		scopeGroupId, "UPDATE_HELLOSAMPLE") %>
</c:set>

<script type="text/javascript">
var config = {
	'divId': '${portletNamespace}myDIV',
	'ctxPath': '${ctxPath}',
	'hasAddPermission': '${hasAddPermission}',
	'hasDeletePermission':'${hasDeletePermission}',
	'hasUpdatePermission':'${hasUpdatePermission}'
};
Ext.onReady(function(){
	renderRESTFulData(config);
 });
</script>