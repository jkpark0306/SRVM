<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	window.onload = function() {

		var object = $
		{
			SrvData
		}
		;

		for ( var key in object) {
			alert(key + '=>' + object[key]);
		}

	}
</script>
<script src="/srvm/resources/jquery-3.1.1.min.js"></script>
<link
	href="/srvm/resources/bootstrap/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">

<!-- MetisMenu CSS -->
<link
	href="/srvm/resources/bootstrap/vendor/metisMenu/metisMenu.min.css"
	rel="stylesheet">

<!-- DataTables CSS -->
<link
	href="/srvm/resources/bootstrap/vendor/datatables-plugins/dataTables.bootstrap.css"
	rel="stylesheet">

<!-- DataTables Responsive CSS -->
<link
	href="/srvm/resources/bootstrap/vendor/datatables-responsive/dataTables.responsive.css"
	rel="stylesheet">

<!-- Custom CSS -->
<link href="/srvm/resources/bootstrap/dist/css/sb-admin-2.css"
	rel="stylesheet">

<!-- Custom Fonts -->
<link
	href="/srvm/resources/bootstrap/vendor/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">
</head>
<body>
	<div class="col-lg-4">
		<div class="panel panel-primary" style="width: 1500px;">
			<div class="panel-heading">서비스상세조회</div>
			<div class="panel-body">

				<table id="TB1"
					class="SrvTable table table-striped table-bordered table-hover">
					<tbody>
						<tr>
							<th>서비스코드</th>
							<td>SrvCode</td>
							<th>담당자</th>
							<td>EmpName</td>
							<th>Warranty</th>
							<td>Warranty</td>
						</tr>
						<tr>
							<th>고객사</th>
							<td>CusName</td>
							<th>입고일자</th>
							<td>Indate</td>
							<th>유지보수</th>
							<td>Maintenance</td>
						</tr>
						<tr>
							<th>고객사담당자</th>
							<td>CusEmpName</td>
							<th>출고일자</th>
							<td>OutDate</td>
							<th>외부지원여부</th>
							<td>PartRepFlag</td>
						</tr>
						<tr>
							<th>P/N</th>
							<td>pn</td>
							<th>서비스분류</th>
							<td>ServiceKind</td>
							<th>수주금액</th>
							<td>obt</td>
						</tr>
						<tr>
							<th>S/N</th>
							<td>sn</td>
							<th>진행상황</th>
							<td>Process</td>
							<th>발주금액</th>
							<td>Ord</td>
						</tr>
						<tr>
							<th colspan="3">증상</th>
							<th colspan="3">조치</th>
						</tr>
						<tr height = "100">
							<td colspan="3" />
							<td colspan="3" />
						</tr>
						<tr>
							<th colspan="3">증상</th>
							<th colspan="3">조치</th>
						</tr>
						<tr height = "100">
							<td colspan="3" />
							<td colspan="3" />
						</tr>
						<tr>
							<th colspan="3">증상</th>
							<th colspan="3">조치</th>
						</tr>
						<tr height = "100">
							<td colspan="3" />
							<td colspan="3" />
						</tr>
					</tbody>
				</table>
			</div>


		</div>
		<div class="panel-footer">Panel Footer</div>
	</div>

</body>
</html>
