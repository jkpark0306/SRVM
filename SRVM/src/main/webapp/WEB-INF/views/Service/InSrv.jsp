<!--%@ page session="false" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%-->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html>
<head>
<title>SRVM</title>


<style>
</style>
<script src="/srvm/resources/jquery-3.1.1.min.js"></script>
<script>
window.onload = function() {
	try{
		var object = ${param};
		
		var obj = {};
		
		var testjson = '{"empdtos":[{"EmpCode":"1111111"},{"EmpCode":"1112222","Name":"오범석"},{"EmpCode":"1509011","Name":"박지규"}],"cusdtos":[{"CusCode":"181001","Name":"아이아 1공장"},{"CusCode":"181002","Name":"나이키코리아"},{"CusCode":"181003","Name":"아이아 2공장"},{"CusCode":"181004","Name":"삼기오토모티브"},{"CusCode":"181005","Name":"SK실트론"}],"cusempdtos":[{"CusEmpCode":"18100101","Name":"류지황"},{"CusEmpCode":"18100201","Name":"송정호"},{"CusEmpCode":"18100401","Name":"박우리"},{"CusEmpCode":"18100501","Name":"김동현"}],"equdtos":[{"ProductNumber":"SS15"},{"ProductNumber":"DOTH300"}]}';
		
		obj = JSON.parse(object);
		
		
		
		alert('test');
		
		alert('typeof obj = '+typeof(obj));
		
		alert('typeof object = '+typeof(object));

		alert(JSON.stringify(object));
		
		alert(obj.toString());

		alert(JSON.stringify(obj));
		
		}catch(Exception){
			alert(Exception);
		}
}
$(document).ready(function() {



});
</script>

<!-- Bootstrap Core CSS -->
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
			<div class="panel-heading">입고등록</div>
			<div class="panel-body">

				<table id="TB1"
					class="SrvTable table table-striped table-bordered table-hover">
					<tbody>
						<tr>
							<th>서비스코드</th>
							<td id='SrvCode' />
							<th>담당자</th>
							<td id='EmpName'>
								<select name="job">
									<option value="">${param}</option>
									<option value="학생">학생</option>
									<option value="회사원">회사원</option>
									<option value="기타">기타</option>
								</select>
							</td>
							<th>Warranty</th>
							<td id='WrtFlag' />
						</tr>
						<tr>
							<th>고객사</th>
							<td id='CusName' />
							<th>입고일자</th>
							<td id='Indate' />
							<th>유지보수</th>
							<td id='Maintenance' />
						</tr>
						<tr>
							<th>고객사담당자</th>
							<td id='CusEmpName' />
							<th>출고일자</th>
							<td id='OutDate' />
							<th>외부지원여부</th>
							<td id='PartSrvFlag' />
						</tr>
						<tr>
							<th>P/N</th>
							<td id='ProductNumber' />
							<th>서비스분류</th>
							<td id='ServiceClass' />
							<th>수주금액</th>
							<td id='ObtAmount' />
						</tr>
						<tr>
							<th>S/N</th>
							<td id='SerialNumber' />
							<th>진행상황</th>
							<td id='Process' />
							<th>발주금액</th>
							<td id='OrdAmount' />
						</tr>
						<!--tr>
							<th colspan="3">증상</th>
							<th colspan="3">조치</th>
						</tr>
						<tr height="100">
							<td colspan="3" id='Symptom1' />
							<td colspan="3" id='Action1'/>
						</tr>
						<tr>
							<th colspan="3">증상</th>
							<th colspan="3">조치</th>
						</tr>
						<tr height="100">
							<td colspan="3"  id='Symptom2'/>
							<td colspan="3" id='Action2'/>
						</tr>
						<tr>
							<th colspan="3">증상</th>
							<th colspan="3">조치</th>
						</tr>
						<tr height="100">
							<td colspan="3"  id='Symptom3'/>
							<td colspan="3" id='Action3'/>
						</tr-->
					</tbody>
				</table>
				<table id="TB2"
					class="SrvTable table table-striped table-bordered table-hover">
					<tbody>
						<tr>
							<th>순번</th>
							<th>증상</th>
							<th>조치</th>
							<th>원인</th>
						</tr>
					</tbody>
				</table>
			</div>


		</div>
	</div>

</body>
</html>
