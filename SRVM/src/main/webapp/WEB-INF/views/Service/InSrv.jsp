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
						alert('${test}');
						obj = JSON.parse('${test}');

						try {
							for (key in obj) {
								var options = obj[key];
								//$("#" + key.toString()).append(
									//	$('<option> </option>'));
								for (var i = 0; i < options.length; i++) {
									if (key.toString() != 'cusempnames') {
										$("#" + key.toString()).append(
												$('<option>' + options[i].Name
														+ '</option>'));
									}
								}

							}
							$("#indate").valueAsDate = new Date();
							$("#outdate").valueAsDate = new Date();
							} catch (Exception) {
							alert(Exception);
						}

						$("#cusnames")
								.change(
										function() {
											var selectitem = $("#cusnames")
													.val();
											$("#cusempnames").empty();
											for (var i = 0; i < obj.cusnames.length; i++) {
												if (obj.cusempnames[i].CusName == selectitem) {
													$("#cusempnames")
															.append(
																	$('<option>'
																			+ obj.cusempnames[i].Name
																			+ "</option>"));
												} else {
												}
											}
										});
						
						$("#confirm").click(function(){
							try{
								
								alert('test');
							
							var param = {};
							
							var indate = new Date($("#indate").val()).format('yyMMdd');
							
							var sccode;
							
							if($("#SrvClass").val()=="수리"){
								sccode = '01';
							}else{
								sccode = '02';
							}
							
							
							var SrvCode = indate+sccode+'000';
							
							var CusName = ${"#cusnames"}.val();
							
							var CusCode;
							
							for(var i = 0;i<obj.cusnames.length;i++){
								if(obj.cusnames[i].Name == CusName){
									CusCode = obj.cusnames[i].CusCode;
								}
							}
							
							var EmpName = ${"#empnames"}.val();
							
							var 
							
							
							
							
							param.SrvCode = SrvCode;
							param.CusCode = 
							
							alert(SrvCode);
							
							}catch(Exception){
								alert(Exception);
							}
							
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
			<div class="panel-heading">입고등록</div>
			<div class="panel-body">

				<table id="TB1" class="SrvTable table table-striped table-bordered table-hover">
					<tbody>
						<tr>
							<th>담당자</th>
							<td id='EmpName'><select id="empnames" /></td>
							<th>Warranty</th>
							<td id='WrtFlag'>
								<select id="WRTFlag">
									<option>Y</option>
									<option>N</option>
								</select>
							</td>
						</tr>
						<tr>
							<th>고객사</th>
							<td><select id="cusnames" /></td>>
							<th>입고일자</th>
							<td id='Indate'>
								<input type="date" id = "indate">
							</td>
							<th>유지보수</th>

							<td id='Maintenance'><select id="MntFlag">
									<option>Y</option>
									<option>N</option>
							</select></td>
						</tr>
						<tr>
							<th>고객사담당자</th>
							<td><select id="cusempnames" /></td>
							</td>
							<th>외부지원여부</th>
							<td id='PartSrvFlag'><select id="PsFlag">
									<option>Y</option>
									<option>N</option>
							</select></td>
						</tr>
						<tr>
							<th>P/N</th>
							<td><select id="equnames" /></td>
							<th>서비스분류</th>
							<td id='ServiceClass'>
								<select id="SrvClass">
									<option>수리</option>
									<option>세팅</option>
								</select></td>
						</tr>
						<tr>
							<th>S/N</th>
							<td id='SerialNumber'>
								<input type="text">
							</td>
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
				<table id="TB2" class="SrvTable table table-striped table-bordered table-hover">
					<tbody>
						<tr>
							<th>순번</th>
							<th>증상</th>
							<th>조치</th>
							<th>원인</th>
						</tr>
					</tbody>
				</table>
				<input type="button" id="confirm" value="확인">
			</div>


		</div>
	</div>

</body>
</html>
