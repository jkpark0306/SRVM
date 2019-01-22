<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<input type="text" id="IDtextbox" />
	<input type="password" id="PWtextbox" />
	<input type="button" value="테스트버튼" id="testbutton"/>
	<script>

		
		$("#testbutton").on("click","button",
				function(){
			RegEmp(EmpObj);
		})

		
		function RegEmp(EmpObj){
			EmpObj.EmpNumber = '1234567';
			EmpObj.DepartCode = '1230';
			EmpObj.Name = '김승용';
			EmpObj.Rank = '01';
			EmpObj.Gender = 'M';
			EmpObj.ID = 'KSY';
			EmpObj.PASSWORD = 'ksksks';
			EmpObj.CREATE_ID = 'jkpark';
			
			$.ajax({
				url : "/srvm/ajax/RegisterEmployee",
				data : JSON.stringify(EmpObj),
				dataType : "text",
				type : "POST",
				contentType : "application/json; charset=UTF-8",
				success : function(responseData) {
					var data = JSON.parse(responseData);
					if (!data || data.Result != 0 || data.IO_CODE == 0) {
						alert("DB 에러. 입력 내용을 확인 하십시오.");
						return;
					}
					
					/*
					
					IODataObj.InputOrderCode = data.IO_CODE;
					alert("입고지시서가 등록 되었습니다.");
					$(".io-btn-new").attr("disabled", "disabled");
					$(".io-btn-complete").attr("disabled", "disabled");
					$(".io-btn-delete").attr("disabled", "disabled");

					location.href = "/ssrm/inputorder?iocode="
							+ IODataObj.InputOrderCode;
					*/
				},
				error : function() {
					alert("연결 에러. 다시 시도 하십시오.");
				}
			});
		}
	</script>
</body>
</html>
