<%@include file="init.jsp" %>

<div id="${portletNamespace}myDIV"></div>

<script src="${ctxPath}/js/FormDashboard.js" type="text/javascript">

</script>
<script type="text/javascript">
Ext.onReady(function(){
    renderDashboard('${portletNamespace}myDIV');
});
</script>