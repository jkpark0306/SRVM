<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="/srvm/resources/jquery-3.1.1.min.js"></script>
<script>
var obj = {
		
};
	$(document).ready(function(){
		alert('${emplist}');
		
		obj = JSON.parse('${emplist}');
		
		
		for(var i=0;i<Object.keys(obj).length;i++){
			$("#EmpTB > tbody:last").append("<tr><td>"+obj[i].EmpCode+'</td><td>'+
											obj[i].Department+'</td><td>'+
											obj[i].Name+'</td><td>'+
											obj[i].Rank+'</td><td>'+
											obj[i].Gender+'</td></tr>');
		}
	});

</script>
</head>
<body>
	<table id="EmpTB">
		<thead id="EmpTBHD">
			<tr>
				<th>사번</th>
				<th>부서</th>
				<th>이름</th>
				<th>직급</th>
				<th>성별</th>
			</tr>
		</thead>
		<tbody id="EmpTBBD">




		</tbody>



	</table>

</body>
</html>
