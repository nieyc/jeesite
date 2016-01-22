<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>预售票账务汇总月报表</title>
<link href="${ctxStatic}/account/css/css.css" rel="stylesheet" />
<script type="text/javascript" src="${ctxStatic}/account/js/jquery-1.8.2.min.js"></script> 
<script type="text/javascript">
$(document).ready(function(){
						   
	/* 滑动/展开 */
	
	$("ul.expmenu_new li > div.header").click(function(){
												   
		var arrow = $(this).find("span.arrow");
	
		if(arrow.hasClass("up")){
			arrow.removeClass("up");
			arrow.addClass("down");
		}else if(arrow.hasClass("down")){
			arrow.removeClass("down");
			arrow.addClass("up");
		}
	
		$(this).parent().find("div.menu").slideToggle();
		
	});
	
});
</script>

	 <meta name="decorator" content="default"/>   
	<script type="text/javascript">
		$(document).ready(function() {
			
		});
		
		
	/* 	$(document).ready(function() {
			$("#btnExport").click(function(){
				top.$.jBox.confirm("确认要导出预售票账务汇总数据吗？","系统提示",function(v,h,f){
					if(v=="ok"){
						$("#searchForm").attr("action","${ctx}/account/tAccountSingleAmount/exportMonth?ShanghuCode=4401");
						$("#searchForm").submit();
					}
				},{buttonsFocus:1});
				top.$('.jbox-body .jbox-icon').css('top','55px');
			});
			
		}); */
		
		
		function uploadAll(){
			top.$.jBox.confirm("确认要导出预售票账务汇总数据吗？","系统提示",function(v,h,f){
				if(v=="ok"){
					$("#searchForm").attr("action","${ctx}/account/tAccountSingleAmount/exportMonth?ShanghuCode=4401");
					$("#searchForm").submit();
					$("#searchForm").attr("action","${ctx}/account/tAccountSingleAmount/getGzMonth");
				}
			},{buttonsFocus:1});
			top.$('.jbox-body .jbox-icon').css('top','55px');
		}
		
		function upload(day){
			top.$.jBox.confirm("确认要下载'"+day+"'账单吗？","系统提示",function(v,h,f){
				if(v=="ok"){
					$("#searchForm").attr("action","${ctx}/account/tAccountSingleAmount/exportDay?day="+day+"&ShanghuCode=4401");
					$("#searchForm").submit();
					$("#searchForm").attr("action","${ctx}/account/tAccountSingleAmount/getGzMonth");
				}
			},{buttonsFocus:1});
			top.$('.jbox-body .jbox-icon').css('top','55px');
		}
		
		function page(n,s){
			$("#pageNo").val(n);
			$("#pageSize").val(s);
			$("#searchForm").submit();
        	return false;
        }
	</script>
</head>

<body>
<div class="center">
<div id="con">





<div id="tagContent">
<div class="tagContent selectTag" id="tagContent0">



<ul class="nav nav-tabs">
		<li class="active"><a href="${ctx}/account/tAccountSingleAmount/getGzMonth">预售票账务汇总月报表</a></li>
	</ul>
	<form:form id="searchForm" modelAttribute="tAccountSingleAmount" action="${ctx}/account/tAccountSingleAmount/getGzMonth" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>日期：</label>
				<input name="tradeDate" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate"
					value="<fmt:formatDate value="${tAccountSingleAmount.tradeDate}" pattern="yyyy-MM-dd"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd',isShowClear:false});"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/>
			<input id="btnExport" class="btn btn-primary" type="button" onclick="uploadAll()" value="导出"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	
<table width="100%" border="1" cellspacing="0" cellpadding="0" bordercolor="#cccccc">
  <tr>
    <td width="282">交易月份</td>
    <td width="178">收入（元）</td>
    <td width="178">支出（元）</td>
    <td width="178">余额（元）</td>
    <td width="178">操作</td>
  </tr>
</table>
<ul class="expmenu_new">
<c:forEach items="${page.list}" var="tAccountSingleAmount">		
<li>
	<div class="header">
		<span class="label"><fmt:formatDate value="${tAccountSingleAmount.tradeDate}" pattern="yyyy-MM"/> </span>
              <span class="label2">+${tAccountSingleAmount.inAmount}<em>${tAccountSingleAmount.inDealAmount}笔</em></span>
              <span class="label3">-${tAccountSingleAmount.outAmount}<em>${tAccountSingleAmount.outDealAmount}笔</em></span>
              <span class="label4"><p>期初 <em>${tAccountSingleAmount.beginingAmount}</em></p>
              <p>期末<em>${tAccountSingleAmount.endingAmount}</em></p></span>
              <span class="label5"><a href="#" onclick="upload('<fmt:formatDate value="${tAccountSingleAmount.tradeDate}" pattern="yyyy-MM-dd"/>')">下载月账单</a></span>
		<span class="arrow down"></span>
	</div>
	<div class="menu">
	<table class="table" width="640" border="1" cellspacing="0" cellpadding="0" bordercolor="#cccccc">
	  <tr>
	    <td colspan="4" class="td1">单程票（已出票）</td>
	    <td rowspan="2" class="td2">出票-${tAccountSingleAmount.ticketsAmount} <em>${tAccountSingleAmount.ticketsDealAmount}笔</em></td>
	  </tr>
	  <tr>
	    <td>支付宝 ${tAccountSingleAmount.alipayAmount}   <em>${tAccountSingleAmount.alipayDealAmount}笔</em></td>
	    <td>微信 ${tAccountSingleAmount.wechatAmount}    <em> ${tAccountSingleAmount.wechatDealAmount}笔</em></td>
	    <td>盘缠${tAccountSingleAmount.panchanAmount}    <em>${tAccountSingleAmount.panchanDealAmount}笔</em></td>
	    <td>中移动${tAccountSingleAmount.cmccAmount} <em> ${tAccountSingleAmount.cmccDealAmount}笔</em></td>
	  </tr>
	  <tr>
	    <td colspan="4" class="td1">地铁充值</td>
	    <td rowspan="2" class="td2">退款 ${tAccountSingleAmount.refundAmount}    <em>${tAccountSingleAmount.refundDealAmount} 笔</em></td>
	  </tr>
	  <tr>
	    <td>支付宝    <em></em></td>
	    <td>微信    <em> </em></td>
	    <td>盘缠    <em> </em></td>
	    <td>中移动  <em> </em></td>
	  </tr>
	</table>
	</div>
</li>
</c:forEach>
		
		
		
		
		
      
     
	</ul>


</div>








</div>

  <SCRIPT type=text/javascript>
function selectTag(showContent,selfObj){
	// 操作标签
	var tag = document.getElementById("tags").getElementsByTagName("li");
	var taglength = tag.length;
	for(i=0; i<taglength; i++){
		tag[i].className = "";
	}
	selfObj.parentNode.className = "selectTag";
	// 操作内容
	for(i=0; j=document.getElementById("tagContent"+i); i++){
		j.style.display = "none";
	}
	document.getElementById(showContent).style.display = "block";
	
	
}
</SCRIPT>



</div>


<div class="pagination">${page}</div>
</body>

</html>
