<!--%@ page session="false" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%-->
<!DOCTYPE=html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html>
<head>
<title>SRVM</title>


<style>
</style>
<script src="/resources/js/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="/resources/js/DateFormat.js"></script>
<script>
	var obj = {};
	$(document)
			.ready(
					function() {
						obj = JSON.parse('${insrvparam}');

						try {
							for (key in obj) {
								var options = obj[key];
								for (var i = 0; i < options.length; i++) {
									if (key.toString() != 'cusempnames') {
										if(options[i].Name != undefined || options[i].Name != null){
										$("#" + key.toString()).append(
												$('<option>' + options[i].Name
														+ '</option>'));
										}
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

						$("#confirm")
								.click(
										function() {
											try {

												var param = {};
												var SrvDTO = {};
												var UniEquDTO = {};

												var indate = new Date($(
														"#indate").val())
														.format('yyMMdd');

												var sccode;

												if ($("#SrvClass").val() == "수리") {
													sccode = '01';
												} else {
													sccode = '02';
												}

												var SrvCode = indate + sccode
														+ '000';

												var CusName = $("#cusnames")
														.val();

												var CusCode;

												for (var i = 0; i < obj.cusnames.length; i++) {
													if (obj.cusnames[i].Name == CusName) {
														CusCode = obj.cusnames[i].CusCode;
													}
												}

												var EmpName = $("#empnames")
														.val();

												var EmpCode;

												for (var i = 0; i < obj.empnames.length; i++) {
													if (obj.empnames[i].Name == EmpName) {
														EmpCode = obj.empnames[i].EmpCode;
													}
												}

												var CusEmpName = $(
														"#cusempnames").val();

												var CusEmpCode;

												for (var i = 0; i < obj.cusempnames.length; i++) {
													if (obj.cusempnames[i].Name == CusEmpName) {
														CusEmpCode = obj.cusempnames[i].CusEmpCode;
													}
												}

												//var UniEquCode 

												alert('cuscode = ' + CusCode);

												SrvDTO.SrvCode = SrvCode;
												SrvDTO.CusCode = CusCode;
												SrvDTO.CusEmpCode = CusEmpCode;
												SrvDTO.ProcessCode = '100';
												SrvDTO.RelExtDate = new Date($(
														"#relextdate").val())
														.format('yyyy-MM-dd');

												UniEquDTO.SerialNumber = $(
														"#SerialNumber").val();
												UniEquDTO.ProductNumber = $(
														"#equnames").val();

												param.srvdto = SrvDTO;
												param.uniequdto = UniEquDTO;
												//param.

												alert(JSON.stringify(param));

												$
														.ajax({
															url : "/ajax/InSrv",
															data : JSON
																	.stringify(param),
															dataType : "text",
															type : "POST",
															contentType : "application/json; charset=UTF-8",
															sucess : function(
																	responseData) {
																alert(responseData);
															}
														});

											} catch (Exception) {
												alert(Exception);
											}

										});

					}

			);
</script>

<!-- Bootstrap Core CSS -->
<link
	href="/resources/bootstrap/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">

<!-- MetisMenu CSS -->
<link
	href="/resources/bootstrap/vendor/metisMenu/metisMenu.min.css"
	rel="stylesheet">

<!-- DataTables CSS -->
<link
	href="/resources/bootstrap/vendor/datatables-plugins/dataTables.bootstrap.css"
	rel="stylesheet">

<!-- DataTables Responsive CSS -->
<link
	href="/resources/bootstrap/vendor/datatables-responsive/dataTables.responsive.css"
	rel="stylesheet">

<!-- Custom CSS -->
<link href="/resources/bootstrap/dist/css/sb-admin-2.css"
	rel="stylesheet">

<!-- Custom Fonts -->
<link
	href="/resources/bootstrap/vendor/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">
</head>
<body>
	<div id="wrapper">
		<p>
			<jsp:include page="../common/CommonPage.jsp" flush="false" />
		</p>
	</div>
	<div id="page-wrapper">

		<table id="TB1"
			class="SrvTable table table-striped table-bordered table-hover">
			<tbody>
				<tr>
					<th>담당자</th>
					<td id='EmpName'><select id="empnames">
							<option value="" selected disabled hidden>선택</option>
					</select></td>
					<th>Warranty</th>
					<td id='WrtFlag'><select id="WRTFlag">
							<option value="" selected disabled hidden>선택</option>
							<option>Y</option>
							<option>N</option>
					</select></td>
					<th>고객사</th>
					<td><select id="cusnames">
							<option value="" selected disabled hidden>선택</option>
					</select></td>
				</tr>
				<tr>

					<th>입고일자</th>
					<td id='Indate'><input type="date" id="indate"></td>
					<th>출고예상일자</th>
					<td id='RelExtdate'><input type="date" id="relextdate">
					</td>
										<th>고객사담당자</th>
					<td><select id="cusempnames"><option value=""
								selected disabled hidden>선택</option></select></td>

				</tr>
				<tr>
					<th>유지보수</th>

					<td id='Maintenance'><select id="MntFlag">
							<option>Y</option>
							<option>N</option>
					</select></td>

					<th>P/N</th>
					<td><select id="equnames">
							<option value="" selected disabled hidden>선택</option>
					</select></td>
					<th>S/N</th>
					<td><input type="text" id="SerialNumber"></td>
				</tr>
				<tr>

					<th>서비스분류</th>
					<td id='ServiceClass'><select id="SrvClass">
							<option value="" selected disabled hidden>선택</option>
							<option>수리</option>
							<option>세팅</option>
					</select></td>
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
		</table>
		<input type="button" id="confirm" value="확인">
	</div>
</body>
</html>
