<!--%@ page session="false" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%-->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html>
<head>
<title>SRVM</title>


<style>
</style>
<script src="/srvm/resources/jquery-3.1.1.min.js"></script>
<script>
	$(document).ready(function() {


		$("#SrvTable tr").on("click", function() {
			
			var Param = {};
			alert('test');
			var tr = $(this);
			var td = tr.children();
			$("#SrvTable th").each(function(i){
				Param[$("#SrvTable th").eq(i).text()] = td.eq(i).text();
				
			});
			var JsonParam = JSON.stringify(Param);
			var Uri = "/srvm/Popup/SrvDetailPopup?SrvData="+JsonParam;
			
			window.open(encodeURI(Uri), "newWindow","resizable=no,width=1530px, height=800px, scrollbar=no");
	


		});
				
		

	});

</script>

<!-- Bootstrap Core CSS -->
<link href="/srvm/resources/bootstrap/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

<!-- MetisMenu CSS -->
<link href="/srvm/resources/bootstrap/vendor/metisMenu/metisMenu.min.css" rel="stylesheet">

<!-- DataTables CSS -->
<link href="/srvm/resources/bootstrap/vendor/datatables-plugins/dataTables.bootstrap.css"
	rel="stylesheet"
>

<!-- DataTables Responsive CSS -->
<link href="/srvm/resources/bootstrap/vendor/datatables-responsive/dataTables.responsive.css"
	rel="stylesheet"
>

<!-- Custom CSS -->
<link href="/srvm/resources/bootstrap/dist/css/sb-admin-2.css" rel="stylesheet">

<!-- Custom Fonts -->
<link href="/srvm/resources/bootstrap/vendor/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css"
>
</head>
<body>
	<div id="wrapper">
		<p>
			<jsp:include page="common/CommonPage.jsp" flush="false" />
		</p>
	</div>
	<div id="page-wrapper">
		<p>
		<table class="table table-striped table-bordered table-hover" id="SrvTable">
			<thead id="thead">
				<tr>
					<th style="display: none">ServiceCode</th>
					<th style="display: none">UniEquCode</th>
					<th>입고일자</th>
					<th>담당자</th>
					<th>고객사</th>
					<th>고객사 담당자</th>
					<th>P/N</th>
					<th>S/N</th>
					<th>진행상황</th>
				</tr>

			</thead>
			<tbody id="tbody">
				<c:forEach var="map" items="${SRVLIST}" varStatus="status">
					<tr>
						<td style="display: none">${map.SrvCode}</td>
						<td style="display: none">${map.UniEquCode}</td>
						<td>${map.InDate}</td>
						<td>${map.EmpName}</td>
						<td>${map.CusName}</td>
						<td>${map.CusEmpName}</td>
						<td>${map.ProductNumber}</td>
						<td>${map.SerialNumber}</td>
						<td>${map.Process}</td>

					</tr>

				</c:forEach>


			</tbody>


		</table>
	</div>
	<form id="PopupForm" name="Form" method="post" action="popup url" target="popup_window">
		<input name="param1" value="1" /> <input name="param2" value="2" /> <input name="param3"
			value="3"
		/> <input name="param4" value="4" /> <input name="param5" value="5" />
	</form>
	<!--  input type="button" value="사원등록" id="RegBtn" /-->
	<button onclick="location='RegEmpID.jsp'">사원등록</button>
	<button onclick="location='Test'">테스트</button>
	<input type="button" id="testbtn"/>

</body>
</html>
