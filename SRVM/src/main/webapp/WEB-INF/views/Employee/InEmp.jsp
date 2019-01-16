<!--%@ page session="false" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%-->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>사원등록</title>
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

<script>
$(document).ready(function(){
	alert('${inempparam}');
	
	var obj = JSON.parse('${inempparam}');
	
	
});


</script>
</head>
<body>
	<div id="wrapper">
		<p>
			<jsp:include page="../common/CommonPage.jsp" flsuh="false" />
		</p>
	</div>
	<div id="page-wrapper">
		<table id="TB">
			<thead id="thead">

			</thead>
			<tbody id="tbody">
				<tr>
					<th>사번</th>
					<td><input type="text" id='EmpCode' /></td>
				</tr>
				<tr>
					<th>이름</th>
					<td><input type="text" id="Name" /></td>
					<th>부서</th>
					<td><select id="Dep1">
					</select> <select id="Dep2">
					</select> <select id="Dep3">
					</select></td>

				</tr>


				<tr>
					<th>성별</th>
					<td><select id="gender">
							<option>남</option>
							<option>녀</option>
					</select></td>
					<th>직급</th>
					<td><select id="Rank">
							<option>부장</option>
							<option>차장</option>
							<option>과장</option>
							<option>대리</option>
							<option>사원</option>
					</select></td>
				</tr>

				<tr>
					<th>ID</th>
					<td><input type="text" id="ID" /></td>
					<th>Password</th>
					<td><input type="text" id="password" /></td>
				</tr>


			</tbody>

		</table>


	</div>

</body>
</html>