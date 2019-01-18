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
<script src="/srvm/resources/jquery-3.1.1.min.js"></script>
<script src="http://code.jquery.com/ui/1.8.18/jquery-ui.min.js"></script> 
<script src="/srvm/resources/js/SHA256.js"></script>
<script>
$(document).ready(function(){
	
	function checkdepth(str){
		var cnt = 0;
		
		for(var i=0;i<str.length;i++){
			if(str.charAt(i) == '0'){
				cnt += 1;
				
			}else{
			}
			
			
		}
		
		return cnt;
	}
	
	$("#Dep2").attr("disabled",true);
	$("#Dep3").attr("disabled",true);
	
	var dptobj = JSON.parse('${dptdto}');
	var rnkobj = JSON.parse('${rnkdto}');
	
	try{
	var dep1 = {};
	var dep2 = {};
	var dep3 = {};
	
	
	for(var i =0;i<dptobj.length;i++){
		var cnt = checkdepth(dptobj[i].DepartCode);
		if(cnt==3){
			dep1[dptobj[i].DepartCode] = dptobj[i].Name;
		}else if(cnt==2){
			dep2[dptobj[i].DepartCode] = dptobj[i].Name;
		}else if(cnt == 1){
			dep3[dptobj[i].DepartCode] = dptobj[i].Name;
		}
		
	}
	
	for(key in dep1){
		$("#Dep1").append($('<option>'+dep1[key]+'</option>'))
	}
	}catch(Exception){
		alert(Exception);
	}
	
	$("#confirm").click(function(){
		
		var dptobj = {};
		
		dptobj.EmpCode = $("#EmpCode").val();
		dptobj.Name = $("#Name").val();
		dptobj.Gender = $("#gender option:selected").val();
		dptobj.ID = $("#ID").val();
		dptobj.Password = SHA256($("#password").val());
		

		for(var i =0;i<rnkobj.length;i++){
			if($("#Rank ooption:selected").val() == rnkobj[i].Name){
				dptobj.Rank = rnkobj[i].RankCode;
			}
		}
		
		alert(JSON.stringify(dptobj));
		/*
		$.ajax({
			url : "/srvm/ajax/InEmp",
			data : JSON.stringify(dptobj),
			dataType : "text",
			type : "POST",
			contentType : "application/json; charset=UTF-8",
			success : function(responseData){
				alert(responseData);
			}
		})*/
	});
	
	$("#Dep2").change(function(){
		$("#Dep3").attr("disabled",false);
		$("select#Dep3 option").remove();
		$("#Dep3").append('<option value="" selected disabled hidden>선택</option>');

		
		for(key1 in dep2){
			for(key2 in dep3){
				alert(key1.substr(0,1) + '/'+key2.substr(0,1));
				if(key1.substr(0,1) == key2.substr(0,1)){
					$("#Dep3").append($('<option>'+dep3[key2]+'</option>'));
				}
			}
		}
	});
	
	$("#passwordcheck").change(function(){
		alert('test');
		if($("#passwordcheck").val() != $("#password").val()){
			alert('비밀번호가 일치하지 않습니다.');
			
		}else{
			alert('비밀번호 일치');
		}
		
	});
	
	$("#Dep1").change(function(){
		
		
		
		$("#Dep2").attr("disabled",false);
		$("select#Dep2 option").remove();
		$("#Dep2").append('<option value="" selected disabled hidden>선택</option>');
		
		$("#Dep3").attr("disabled",true);
		$("select#Dep3 option").remove();
		$("#Dep3").append('<option value="" selected disabled hidden>선택</option>');

		
		for(key1 in dep1){
			for(key2 in dep2){
				if(key1.substr(0,1) == key2.substr(0,1)){
					$("#Dep2").append($('<option>'+dep2[key2]+'</option>'));
				}
			}
		}
		
		/*
		for(var i=0;i<dep1.length;i++){
			for(var j=0;i<dptobj[i].)
			if(dep1[i] == dptobj[i].Name){
				
				
			}
		}
		
		for(var i=0;i<dep2.length;i++){
			alert(dep2[i].substr(0,1));
			alert($("#Dep1").val().substr(0,1));
			if(dep2[i].substr(0,1) == $("#Dep1").val().substr(0,1)){
			$("#Dep2").append($('<option>'+dep2[i]+'</option>'));
			}
		}*/
	});
	
	$("#EmpCode").change(function(){
		alert('test');
		
		var EmpCode = $("#EmpCode").val();
		
		
		
		alert(EmpCode);
		
		
		$.ajax({
			url : "/srvm/ajax/CheckEmpCode",
			type : "POST",
			dataType : "text",
			data : EmpCode,
			success : function(responseData){
				if(responseData == "B"){
					alert('사번 중복');
				}
			},								error : function(request, status, error) {
				alert("code = " + request.status
						+ " message = "
						+ request.responseText
						+ " error = " + error); // 실패 시 처리
			}
			
		});
	});
	
});


</script>
</head>
<body>
	<div id="wrapper">
		<p>
			<jsp:include page="../common/CommonPage.jsp" flush="false" />
		</p>
	</div>
	<div id="page-wrapper">
		<table id="TB" class="SrvTable table table-striped table-bordered table-hover">
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
					<option value="" selected disabled hidden>선택</option>
					</select> <select id="Dep2">
					<option value="" selected disabled hidden>선택</option>
					</select> <select id="Dep3">
					<option value="" selected disabled hidden>선택</option>
					</select></td>

				</tr>


				<tr>
					<th>성별</th>
					<td><select id="gender">
							<option value="" selected disabled hidden>선택</option>
							<option>남</option>
							<option>녀</option>
					</select></td>
					<th>직급</th>
					<td><select id="Rank">
							<option value="" selected disabled hidden>선택</option>
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
					<td><input type="password" id="password" /></td>
					
				</tr>
				
				<tr>
					<th>Password확인</th>
					<td><input type="password" id="passwordcheck"/></td>
				</tr>


			</tbody>

		</table>
		<input type ="button" id="confirm"/>


	</div>

</body>
</html>