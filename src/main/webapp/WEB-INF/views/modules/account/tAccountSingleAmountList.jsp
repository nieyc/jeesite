<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>预售票账务汇总管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			
		});
		function page(n,s){
			$("#pageNo").val(n);
			$("#pageSize").val(s);
			$("#searchForm").submit();
        	return false;
        }
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li class="active"><a href="${ctx}/account/tAccountSingleAmount/">预售票账务汇总列表</a></li>
	</ul>
	<form:form id="searchForm" modelAttribute="tAccountSingleAmount" action="${ctx}/account/tAccountSingleAmount/getDay" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<%-- <sys:tableSort id="orderBy" name="orderBy" value="trade_date desc" callback="page();"/> --%>
		<ul class="ul-form">
			<li><label>交易日：</label>
				<input name="tradeDate" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate"
					value="<fmt:formatDate value="${tAccountSingleAmount.tradeDate}" pattern="yyyy-MM-dd"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd',isShowClear:false});"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>交易日</th>
				<th>进账总额</th>
				<th>进账总笔数</th>
				<th>支出总额</th>
				<th>支出总笔数</th>
				<th>期初总额</th>
				<th>期末总额</th>
				<th>支付宝总额</th>
				<th>支付宝总笔数</th>
				<th>微信总额</th>
				<th>微信总笔数</th>
				<th>盘缠总额</th>
				<th>盘缠总笔数</th>
				<th>中移动总额</th>
				<th>中移动总笔数</th>
				<th>出票总额</th>
				<th>出票总笔数</th>
				<th>退款总额</th>
				<th>退款总笔数</th>
				<!--<th>创建时间</th>
				 <th>账务类型</th>
				<th>商户编码</th>
				<th>商户名称</th> -->
			<%-- 	<shiro:hasPermission name="account:tAccountSingleAmount:edit"><th>操作</th></shiro:hasPermission> --%>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="tAccountSingleAmount">
			<tr>
				<td>
					<fmt:formatDate value="${tAccountSingleAmount.tradeDate}" pattern="yyyy-MM-dd"/>
				</td>
				<td>
					${tAccountSingleAmount.inAmount}
				</td>
				<td>
					${tAccountSingleAmount.inDealAmount}
				</td>
				<td>
					${tAccountSingleAmount.outAmount}
				</td>
				<td>
					${tAccountSingleAmount.outDealAmount}
				</td>
				<td>
					${tAccountSingleAmount.beginingAmount}
				</td>
				<td>
					${tAccountSingleAmount.endingAmount}
				</td>
				<td>
					${tAccountSingleAmount.alipayAmount}
				</td>
				<td>
					${tAccountSingleAmount.alipayDealAmount}
				</td>
				<td>
					${tAccountSingleAmount.wechatAmount}
				</td>
				<td>
					${tAccountSingleAmount.wechatDealAmount}
				</td>
				<td>
					${tAccountSingleAmount.panchanAmount}
				</td>
				<td>
					${tAccountSingleAmount.panchanDealAmount}
				</td>
				<td>
					${tAccountSingleAmount.cmccAmount}
				</td>
				<td>
					${tAccountSingleAmount.cmccDealAmount}
				</td>
				<td>
					${tAccountSingleAmount.ticketsAmount}
				</td>
				<td>
					${tAccountSingleAmount.ticketsDealAmount}
				</td>
				<td>
					${tAccountSingleAmount.refundAmount}
				</td>
				<td>
					${tAccountSingleAmount.refundDealAmount}
				</td>
				<%--<td>
					<fmt:formatDate value="${tAccountSingleAmount.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				 <td>
					${tAccountSingleAmount.amountType}
				</td>
				<td>
					${tAccountSingleAmount.shanghuCode}
				</td>
				<td>
					${tAccountSingleAmount.shanghuName}
				</td>
				<shiro:hasPermission name="account:tAccountSingleAmount:edit"><td>
    				<a href="${ctx}/account/tAccountSingleAmount/form?id=${tAccountSingleAmount.id}">修改</a>
					<a href="${ctx}/account/tAccountSingleAmount/delete?id=${tAccountSingleAmount.id}" onclick="return confirmx('确认要删除该预售票账务汇总吗？', this.href)">删除</a>
				</td></shiro:hasPermission> --%>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>