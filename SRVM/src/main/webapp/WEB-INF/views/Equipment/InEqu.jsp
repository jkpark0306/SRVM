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

<link rel="stylesheet" href="http://code.jquery.com/ui/1.8.18/themes/base/jquery-ui.css" type="text/css" />  


<script src="http://code.jquery.com/ui/1.8.18/jquery-ui.min.js"></script>  
<script src="/resources/js/cookie.js"></script>
<script>

	$(document).ready(function() {
				var obj = {};

				obj = JSON.parse('${InEquParam}');

				$("#EquCode").val('001000001');
				
				function GetNewEquCode(EquCode){
					
					$.ajax({
						url : "/ajax/GetNewEquCode",
						data : EquCode,
						dataType : "text",
						type : "POST",
						success : function(responseData){
							
							
							return responseData;
						}
						
					});
					
					
					
				}
				
				
				$("#EquCode").change(function(){
					
					if($("#EquCode").val().length < 9){
						while($("#EquCode").val().length<9){
							$("#EquCode").val($("#EquCode").val()+'0');
						}
					}else if($("#EquCode").val().length > 9){
						while($("#EquCode").val().length>9){
							$("#EquCode").val($("#EquCode").val().substr(0,$("#EquCode").val().length-2));
						}
					}
					
				});
				$("#ProductNumber").change(
						function() {

							var ProductNumber = $("#ProductNumber").val();
							
							var EquCode;
							
							$.ajax({
								url : "/ajax/GetEquDTObyPN",
								data : ProductNumber,
								dataType : "text",
								type : "POST",
								success : function(responseData) {
									try{
									if (responseData == null || responseData == '' || responseData == 'null') {
										
										$("#confirm").attr("disabled",false);
										if(ProductNumber.length >= 4){
																					
										EquCode = $("#EquCode").val().substr(0,3)+ProductNumber.substr(0,4) +$("#EquCode").val().substr(7,2);
										}else{
											var appstr = "";
											for(i = 0;i<4-ProductNumber.length;i++){
												appstr = appstr + "0";
											}
											EquCode = $("#EquCode").val().substr(0,3)+ProductNumber.substr(0,ProductNumber.length)+appstr+$("#EquCode").val().substr(7,2);
											
										}
									} else {
										var EquDTO = JSON.parse(responseData);
										EquCode = EquDTO.EquCode;
										alert('이미 등록된 장비입니다. (장비코드 : '
												+ EquDTO.EquCode + ')');
										$("#EquCode").val(EquDTO.EquCode);
										$("#confirm").attr("disabled", true);
										return;
										}
									
									

									if(EquCode.substr(0,7) != '0000000'){
										
										var newEquCode = GetNewEquCode(EquCode);
										
										if(newEquCode != null && newEquCode != ''){
											$("#EquCode").val( GetNewEquCode(EquCode));
											
										}else{
											$("#EquCode").val(EquCode);
										}
										
									}
									}catch(Exception){
										alert(Exception);
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
							var EquCode = "";
							if ($("#mancomp").val() == "삼미정보시스템") {
								if ($("#EquCode").val() == null
										|| $("#EquCode").val() == "") {

									EquCode = "100000000";
								} else {
									EquCode = "1"+$("#EquCode").val().substr(1,8);
								}
							} else {
								if ($("#EquCode").val() == null
										|| $("#EquCode").val() == "") {

									EquCode = "200SSSS000";
								} else {
									
									EquCode = "2"
										+ $("#EquCode").val()
										.substr(1, 8);
								}

							}
							
							
							if(EquCode.substr(0,7) != '0000000'){
								
								var newEquCode = GetNewEquCode(EquCode);
								
								if(newEquCode != null && newEquCode != ''){
									$("#EquCode").val( GetNewEquCode(EquCode));
									
								}else{
									$("#EquCode").val(EquCode);
								}
								
							}
							
							
						});

					
				$("#EquCat").change(function() {

							var EquCat = $("#EquCat").val();
							

							$.ajax({
								url : "/ajax/GetEquCatCode",
								data : EquCat,
								dataType : "text",
								type : "POST",
								success : function(responseData) {
									var EquCode = $("#EquCode").val()
											.substr(0, 1)
											+ responseData
											+ $("#EquCode").val().substr(3, 6);

									
									if(EquCode.substr(0,7) != '0000000'){
										
										var newEquCode = GetNewEquCode(EquCode);
										
										if(newEquCode != null && newEquCode != ''){
											$("#EquCode").val( GetNewEquCode(EquCode));
											
										}else{
											$("#EquCode").val(EquCode);
										}
										
									}
								}

							});
							
 
						});

				$("#mdcheck").change(function(){
					if($('input:checkbox[id="mdcheck"]').is(':checked')==true){
						$("#makedate").attr("disabled", true);
					}
				});
				
				$("#confirm").click(function() {
					try{
					var EquDTO = {};


					EquDTO.EquCode = '';
					
					var productnumber = $("#ProductNumber").val();
					var mancomp = $("#mancomp").val();
					
					if(productnumber == null || productnumber == ""){
						alert('제품번호를 입력하세요');
					}
					if(mancomp == null || mancomp == ""){
						alert("제조사를 입력하세요");
					}}catch(Exception){
						alert(Exception);
					}
					
					
					
					
					
					try {
						/*
						$.ajax({
							url : "/ajax/GetID",
							type : "POST",
							success : function(responseData){
								EquDTO.CREATE_ID = responseData;
							},
						     error:function(request,status,error){
						         alert("code = "+ request.status + " message = " + request.responseText + " error = " + error); // 실패 시 처리
						        }
						});*/
						
						EquDTO.CREATE_ID = getCookie("EmpCode");
						EquDTO.ProductNumber = $("#ProductNumber").val();
						EquDTO.ManComp = $("#mancomp").val();
						EquDTO.EquCode = $("#EquCode").val();

					} catch (Exception) {
						alert(Exception);
					}

					$.ajax({
						url : "/ajax/InEqu",
						data : JSON.stringify(EquDTO),
						dataType : "text",
						type : "POST",

						contentType : "application/json; charset=UTF-8",
						success : function(responseData) {
							if(responseData == "s"){
								alert("등록완료");
								location.reload();
							}else{
								alert("등록실패");
							}
						},
					     error:function(request,status,error){
					         alert("code = "+ request.status + " message = " + request.responseText + " error = " + error); // 실패 시 처리
					        }

					});

					
					
					
					
					 


				});

			});
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
							<th>EquCode</th>
							<td><input type="text" id='EquCode' /></td>
						</tr>


						<tr>
							<th>제조일자</th>
							<td id='MakeDate'><input type="date" id="makedate" /> 
							 제조일자모름<input
								type="checkbox" id="mdcheck"/></td>
							<th>장비종류</th>
							<td id="tdCat"><select id="EquCat">
									<option>PPC</option>
									<option>SCANNER</option>
									<option>PRINTER</option>
									<option>PDA</option>
							</select></td>
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
					<input type="button" id="confirm" value = "확인"/>
					
					</div>


					</div>
					</div>
</body>
</html>
