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
						
						
						
						obj = JSON.parse('${InUniEquParam}');
						
						
						var mancarr = new Array();
						for(var i=0;i<obj.equdtos.length;i++){
							$("#PNLIST").append($('<option>'+obj.equdtos[i].ProductNumber+'</option>'));
							var mancstr = obj.equdtos[i].ManComp;
							
							if($.inArray(mancstr,mancarr) == -1){
								mancarr.push(obj.equdtos[i].ManComp);
								
								
								$("#mancomplist").append($('<option>'+obj.equdtos[i].ManComp+'</option>'));
							}
							
							
						}
						
						for(var i=0;i<obj.cusdtos.length;i++){
							$("#cuslist").append($('<option>'+obj.cusdtos[i].Name+'</option>'));
						}
						
						
						$("#PNLIST").change(function(){
							
							var index = $("#PNLIST option").index($("#PNLIST option:selected"));
							
							$("#EquCode").val(obj.equdtos[index].EquCode);
							
						});
						
						$("#mdcheck").change(function(){
							try{
							alert( $("#makedate").val().toString().format('yyyyMMdd'));
							}catch(Excpetion){
								alert(Exception);
							}
							if($("input:checkbox[id='mdcheck']").is(":checked") == true){

								$("#makedate").attr("disabled",true);
							}else{
								$("#makedate").attr("disabled",false);
							}
							
						});
						
						$("#confirm").click(function(){
							
							var UniEquCode = "";
							
							var today = new Date();
							try{
							}catch(Exception){
								alert(Exception);
							}
							
							UniEquCode = $("#EquCode").val() + today.format('yyMM')+'001';
							
							alert("before/"+UniEquCode);
							
							$.ajax({
								url : "/srvm/ajax/GetNewUniEquCode",
								data : UniEquCode,
								dataType : "text",
								type: "POST",
								success : function(responseData){
									try{
									UniEquCode = responseData.substr(0,responseData.length-2);
									}catch(Exception){
										alert(Exception);
									}
									
								}
								
							});
							
							

							alert("after/"+UniEquCode);
							

							var index = $("#cuslist option").index($("#cuslist option:selected"));
							
							
							
							var EquCode = $("#EquCode").val();
							var SerialNumber = $("#SerialNumber").val();
							var CusCode = obj.cusdtos[index].CusCode;
							
							
							var UniEquDTO = {};
							
							if($("input:checkbox[id='mdcheck']").is(":checked") == false){
								
								UniEquDTO.MakeDate = $("makedate").val().format('yyyy-MM-dd');
							}
							
							UniEquDTO.UniEquCode = UniEquCode;
							UniEquDTO.EquCode = $("#EquCode").val();
							UniEquDTO.SerialNumber = $("#SerialNumber").val();
							UniEquDTO.CusCode = CusCode;
							UniEquDTO.MakeDate = $("#makedate").val().format('yyyy-MM-dd');
							
							$.ajax({
								url : "/srvm/ajax/InUniEQu",
								data : JSON.stringify(UniEquDTO),
								dataType : "text",
								type : "POST",
								contentType : "application/json; charset=UTF-8",
								success : function(responseData){
									alert(responseData);
								}
							});
							
							
							
							
							
							
							alert(JSON.stringify(UniEquDTO));
							
							
							
							
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
	<div id="wrapper">
		<p>
			<jsp:include page="../common/CommonPage.jsp" flush="false"/>
		</p>
	</div>
	<div id="page-wrapper" class="col-lg-4">
	
		<div class="panel panel-primary" style="width: 1500px;">
		
			<div class="panel-heading">장비등록</div>
			<div class="panel-body">

				<table id="TB1" class="SrvTable table table-striped table-bordered table-hover">
					<tbody>
						<tr>
							<th>제조사</th>
							<td>
								<select id="mancomplist">
								
								</select>
							</td>
							<th>고객사</th>
							<td>
								<select id="cuslist">
								
								</select>
							</td>
						</tr>
						<tr>
							<th>ProductNumber</th>
							<td id='ProductNumber'><select id="PNLIST"></select></td>
							<td>SerialNumber</td>
							<td><input type="text" id="SerialNumber"></input></td>
						</tr>
						
						
						<tr>
							<th>제조일자</th>
							<td id='MakeDate'>
								<input type="date" id = "makedate"/>
								<input type="checkbox" id="mdcheck" value="제조일자 모름"/>
							</td>
														<th>EquCode</th>
							<td>
							<input type="text" id='EquCode' />
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
				</table>
			</div>
			<input type="button" id="confirm" value="확인">

</div>
</div>

</body>
</html>
