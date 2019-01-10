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
<script src="/srvm/resources/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="/srvm/resources/js/DateFormat.js"></script>
<script>
	window.onload = function() {

	}
	var obj = {};
	$(document).ready(
			function() {

				obj = JSON.parse('${InEquParam}');

				$("#EquCode").val('000000000');


				for (var i = 0; i < obj.cusdtos.length; i++) {
					$("#CusList").append(
							$('<option>' + obj.cusdtos[i].Name + '</option>'));
				}

				function GetEquCode() {

					var mancomp;
					var equcat;
					var pncode;
					var idx;
					var EquCode;

					if ($("#mancomp").val() == "삼미정보시스템") {

					}
				}
				
				function getNewEquCode(){
					
					
					$.ajax({
						
					});
				}

				$("#ProductNumber").change(
						function() {

							var ProductNumber = $("#ProductNumber").val();

							$.ajax({
								url : "/srvm/ajax/GetEquDTObyPN",
								data : ProductNumber,
								dataType : "text",
								type : "POST",
								success : function(responseData) {
									alert(responseData);
									if (responseData == null || responseData == '' || responseData == 'null') {
										alert('else');
										alert(ProductNumber.length);
										if(ProductNumber.length >= 4){
											
										
										$("#EquCode").val($("#EquCode").val().substr(0,3)+ProductNumber.substr(0,4) +$("#EquCode").val().substr(7,2));
										}else{
											var 
											$("#EquCode").val($("#EquCode").val().substr(0,3)+ProductNumber.substr(0,ProductNumber.length)+$("#EquCode").val().substr(7,2));
											
										}
									} else {
										var EquDTO = JSON.parse(responseData);
										alert('이미 등록된 장비입니다. (장비코드 : '
												+ EquDTO.EquCode + ')');

									}
								},
								error : function(request, status, error) {
									alert("code = " + request.status
											+ " message = "
											+ request.responseText
											+ " error = " + error); // 실패 시 처리
								}
							});
						});

				$("#mancomp").change(
						function() {
							if ($("#mancomp").val() == "삼미정보시스템") {
								if ($("#EquCode").val() == null
										|| $("#EquCode").val() == "") {

									$("#EquCode").val("100SSSS000");
								} else {
									$("#EquCode").val(
											"1"
													+ $("#EquCode").val()
															.substr(1, 8));
								}
							} else {
								if ($("#EquCode").val() == null
										|| $("#EquCode").val() == "") {

									$("#EquCode").val("200SSSS000");
								} else {
									$("#EquCode").val(
											"2"
													+ $("#EquCode").val()
															.substr(1, 8));
								}

							}
						});

				$("#EquCat").change(
						function() {

							var EquCat = $("#EquCat").val();

							$.ajax({
								url : "/srvm/ajax/GetEquCatCode",
								data : EquCat,
								dataType : "text",
								type : "POST",
								success : function(responseData) {
									var newEquCode = $("#EquCode").val()
											.substr(0, 1)
											+ responseData
											+ $("#EquCode").val().substr(3, 6);

									$("#EquCode").val(newEquCode);

									alert(responseData);
								}

							});
						});
				$("#confirm").click(function() {

					var EquDTO = {};

					alert('test');

					EquDTO.EquCode = '';
					alert($("#serialnumber").val());
					try {
						EquDTO.ProductNumber = $("#ProductNumber").val();
						EquDTO.ManComp = $("#mancomp").val();
						EquDTO.EquCode = $("#EquCode").val();

					} catch (Exception) {
						alert(Exception);
					}

					$.ajax({
						url : "/srvm/ajax/InEqu",
						data : JSON.stringify(EquDTO),
						dataType : "text",
						type : "POST",

						contentType : "application/json; charset=UTF-8",
						sucess : function(responseData) {
							alert(responseData);
						}

					});

					/*
					
					alert(JSON.parse(UniEquDTO));
					
					
					$.ajax({
						url : "/srvm/ajax/InEqu",
						data : JSON.stringify(UniEquDTO),
						dataType : "text",
						type : "POST",
						
						contentType : "application/json; charset=UTF-8",
						sucess : function(responseData){
							alert(responseData);
						}
					});
					
					 */

					alert(JSON.stringify(UniEquDTO));

					alert('test');
				});

			}

	);
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
			<div class="panel-heading">장비등록</div>
			<div class="panel-body">

				<table id="TB1"
					class="SrvTable table table-striped table-bordered table-hover">
					<tbody>
						<tr>
							<th>제조사</th>
							<td id='ManComp'><input type="text" id='mancomp' /></td>
						</tr>
						<tr>
							<th>ProductNumber</th>
							<td id='PN'><input type="text" id="ProductNumber" /></td>
							<th>EquCode(4)</th>
							<td><input type="text" id='EquCode' /></td>
						</tr>


						<tr>
							<th>제조일자</th>
							<td id='MakeDate'><input type="date" id="makedate" /> <input
								type="checkbox" id="mdcheck" value="제조일자 모름" /></td>
							<th>장비종류</th>
							<td id="tdCat"><select id="EquCat">
									<option>PPC</option>
									<option>SCANNER</option>
									<option>PRINTER</option>
									<option>PDA</option>
							</select></td>
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
