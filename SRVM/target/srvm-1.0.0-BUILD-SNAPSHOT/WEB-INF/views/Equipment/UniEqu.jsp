<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>



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
<script>
var obj = {
	
};
$(document).ready(
		function() {
			obj = JSON.parse('${uniequlist}');
			
			
			
			for(var i=0;i<Object.keys(obj).length;i++){
				alert(JSON.stringify(obj[i]));
				
				$('#TB1 > tbody:last').append('<tr><td>'+obj[i].UniEquCode+'</td><td>'+
												 obj[i].EquCode+'</td><td>'+
												 obj[i].ProductNumber+'</td><td>'+
												 obj[i].SerialNumber+'</td><td>'+
												 obj[i].MakeDate+'</td><td>'+
												 obj[i].Customer+'</td></tr>');
			}
			
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
		<table class="table table-striped table-bordered table-hover" id="TB1">
			<thead>
				<th>UniEquCode</th>
				<th>EquCode</th>
				<th>P/N</th>
				<th>S/N</th>
				<th>제조일자</th>
				<th>고객사</th>
			</thead>
			<tbody id="tbody">
			</tbody>
		
		</table>
	</div>

</body>
</html>