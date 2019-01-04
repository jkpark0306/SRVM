<!--%@ page session="false" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%-->
<!DOCTYPE=html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html>
<head>
<title>SRVM</title>


<style>
</style>
<script src="/srvm/resources/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="/srvm/resources/js/DateFormat.js"></script>
<script>
	window.onload = function() {

	}
	var obj = {};
	$(document)
			.ready(
					function() {
						
						alert('test');
						
						alert('${InEquParam}');
						
						obj = JSON.parse('${InEquParam}');
						
						alert(obj.equdtos[0].Name);
						
						for(var i=0;i<obj.equdtos.length;i++){
							$("#PNLIST").append($('<option>'+obj.equdtos[i].Name+'</option>'));
						}
						
						for(var i=0;i<obj.cusdtos.length;i++){
							$("#CusList").append($('<option>'+obj.cusdtos[i].Name+'</option>'));
						}
						

						$("#confirm").click(function(){
							
							var UniEquDTO = {};
							
							
							
							
							
							
							
							UniEquDTO.UniEquCode = '';
							
							
							
							
							
							alert('test');
						});
						
					}

			);
	
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
	<div class="col-lg-4">
		<div class="panel panel-primary" style="width: 1500px;">
			<div class="panel-heading">장비등록</div>
			<div class="panel-body">

				<table id="TB1" class="SrvTable table table-striped table-bordered table-hover">
					<tbody>
						<tr>
							<th>ProductNumber</th>
							<td id='ProductNumber'><select id="PNLIST" /></td>
							<th>SerialNumber</th>
							<td id='SerialNumber'>
								<input type="text" id="serialnumber"/>	
							</td>
							<th>고객사</th>
							<td id='Customer'><select id="CusList"/></td>
						</tr>
						<tr>
							<th>제조일자</th>
							<td id='MakeDate'>
								<input type="date" id = "makedate"/>
							</td>
						</tr>
						<tr>
						</tr>
						<tr>
						</tr>
						<tr>
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
				<input type="button" id="confirm" value="확인">
			</div>


		</div>
	</div>

</body>
</html>
