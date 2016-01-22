<%@page import="java.util.Date"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>商户流水管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			//$("#searchForm").attr("action","${ctx}/trade/vShanghuTrade/gzlist");
		});
		function page(n,s){
			$("#searchForm").attr("action","${ctx}/trade/vShanghuTrade/gzlist");
			$("#pageNo").val(n);
			$("#pageSize").val(s);
			$("#searchForm").submit();
        	return false;
        }
		
		
		$(document).ready(function() {
			 $("#btnExport").click(function(){
				top.$.jBox.confirm("确认要导出交易明细数据吗？","系统提示",function(v,h,f){
					if(v=="ok"){
						var beginDate=document.getElementById("beginCreateTime").value;
						var endDate=document.getElementById("endCreateTime").value;
						var dealType=document.getElementById("dealType").value;
						var realName=document.getElementById("realName").value;
						var userMobile=document.getElementById("userMobile").value;
						var extOrderNo=document.getElementById("extOrderNo").value;
						$("#searchForm").attr("action","${ctx}/trade/vShanghuTrade/exportDeail?shanghu=01&beginCreateTime="+beginDate+"&endCreateTime="+endDate+"&dealType="+dealType+"&realName="+realName+"&userMobile="+userMobile+"&extOrderNo="+extOrderNo+"");
						$("#searchForm").submit();
						$("#searchForm").attr("action","${ctx}/trade/vShanghuTrade/gzlist");
					}
				},{buttonsFocus:1});
				top.$('.jbox-body .jbox-icon').css('top','55px');
			}); 
			
		});
		


	</script>
</head>

<body>
	<ul class="nav nav-tabs">
		<li class="active"><a href="${ctx}/trade/vShanghuTrade/gzlist">交易明细查询</a></li>
<%-- 		<shiro:hasPermission name="trade:vShanghuTrade:edit"><li><a href="${ctx}/trade/vShanghuTrade/form">商户流水添加</a></li></shiro:hasPermission>
 --%>	</ul>
	<form:form id="searchForm" modelAttribute="vShanghuTrade" action="${ctx}/trade/vShanghuTrade/gzlist" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
		  
			<li><label>账户类型：</label>
				<form:select path="dealType" class="input-medium">
					<form:option value="100" label="请选择"/>
					<form:options items="${fns:getDictList('account_type')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
			</li>
			
		<%-- 	<li><label>商品：</label>
				<form:select path="shanghu" class="input-medium">
					<form:option value="100" label="请选择"/>
					<form:options items="${fns:getDictList('product_type')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
			</li> --%>
			
			<li><label>姓名：</label>
				<form:input path="realName" id="realName" htmlEscape="false" maxlength="100" class="input-medium"/>
			</li>
			<li><label>手机号码：</label>
				<form:input path="userMobile" id="userMobile" htmlEscape="false" maxlength="30" class="input-medium"/>
			</li>
			<li><label>订单编号：</label>
				<form:input path="extOrderNo" id="extOrderNo" htmlEscape="false" maxlength="30" class="input-medium"/>
			</li>
			
			 <li><label>时间：</label>
				<input name="beginCreateTime" id="beginCreateTime" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate"
					value="<fmt:formatDate value="${vShanghuTrade.beginCreateTime}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/> - 
				<input name="endCreateTime" id="endCreateTime" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate"
					value="<fmt:formatDate value="${vShanghuTrade.endCreateTime}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
			</li>
			
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/>
			<input id="btnExport" class="btn btn-primary" type="button" value="导出"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
			    <th>姓名</th>
			    <th>手机号码</th>
				<th>商户</th>
				<th>账户类型</th>
				<th>订单编号</th>
				<th>交易金额</th>
				<th>支付通道  </th>
				<th>交易类型</th>
				<th>创建日期</th>
				
				<%-- <shiro:hasPermission name="trade:vShanghuTrade:edit"><th>操作</th></shiro:hasPermission> --%>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="vShanghuTrade">
			<tr>
				
				
				<td>
					${vShanghuTrade.realName}
				</td>
				<td>
					${vShanghuTrade.userMobile}
				</td>
				
				<td>
					<%--  ${vShanghuTrade.shanghu}--%>
					 <c:if test="${vShanghuTrade.shanghu=='00'}">充卡</c:if> 
					 <c:if test="${vShanghuTrade.shanghu=='01'}">单程票</c:if> 
					
				</td>
				<td>
					<%-- ${vShanghuTrade.dealType} --%>
					<c:if test="${vShanghuTrade.dealType=='1'}">交易</c:if> 
					 <c:if test="${vShanghuTrade.dealType=='2'}">退款</c:if> 
					 <c:if test="${vShanghuTrade.dealType=='3'}">出票</c:if> 
				</td>
				<td>
					${vShanghuTrade.extOrderNo}
				</td>
				<td>
					${vShanghuTrade.cashAmount}
				</td>
				<td>
					<%--  ${vShanghuTrade.payWay} --%> 
					<c:if test="${vShanghuTrade.payWay=='1037'}">盘缠支付</c:if> 
					<c:if test="${vShanghuTrade.payWay=='0'}">支付宝支付</c:if> 
					<c:if test="${vShanghuTrade.payWay=='1'}">中移动支付</c:if> 
					<c:if test="${vShanghuTrade.payWay=='2'}">支付宝扫码</c:if> 
					<c:if test="${vShanghuTrade.payWay=='3'}">微信支付</c:if> 
					<c:if test="${vShanghuTrade.payWay=='4'}">微信扫码</c:if> 
				</td>
				<td>
					<%-- ${vShanghuTrade.scoreType} --%>
					<c:if test="${vShanghuTrade.scoreType=='0'}">APP</c:if> 
					 <c:if test="${vShanghuTrade.scoreType=='1'}">扫码</c:if> 
				</td>
				<td>
					<fmt:formatDate value="${vShanghuTrade.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				
				<%-- <shiro:hasPermission name="trade:vShanghuTrade:edit"><td>
    				<a href="${ctx}/trade/vShanghuTrade/form?id=${vShanghuTrade.id}">修改</a>
					<a href="${ctx}/trade/vShanghuTrade/delete?id=${vShanghuTrade.id}" onclick="return confirmx('确认要删除该商户流水吗？', this.href)">删除</a>
				</td></shiro:hasPermission> --%>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>