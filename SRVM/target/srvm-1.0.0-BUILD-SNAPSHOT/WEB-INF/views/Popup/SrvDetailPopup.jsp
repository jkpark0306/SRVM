<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="/srvm/resources/js/DateFormat.js"></script>
<script type="text/javascript">
	function _GET(search) {
		var obj = {};
		var uri = decodeURI(search);
		uri = uri.slice(1, uri.length);

		var param = uri.split('&');

		for (var i = 0; i < param.length; i++) {
			var devide = param[i].split('=');
			obj = JSON.parse(devide[1]);
		}

		return obj;
	}/*
		function getServiceClass(SrvCode){
			if(SrvCode.substring(7,1) == '1'){
				return 'Rep';
			}else{
				return 'Set';
			}
		}*/
	function getview(json) {
		try {
			var srvdto = (JSON.parse(json)).srvdto;
			var repdetdtos = []; 
			repdetdtos = (JSON.parse(json)).repdetdtos;
			
			var indatestr = srvdto.SrvCode.toString().substring(0, 6);
			var indate = new Date('20' + indatestr.substring(0, 2), indatestr
					.substring(2, 2), indatestr.substring(4, 2));
			var outdate = new Date(srvdto.RelDate);
			var ServiceClass;

			if (srvdto.SrvCode.toString().substring(7, 1) == '1') {
				ServiceClass = '수리';
			} else {
				ServiceClass = '세팅';
			}

			$('#SrvCode').text(srvdto.SrvCode);

			$('#EmpName').text(srvdto.EmpName);
			$('#WrtFlag').text(srvdto.WrtFlag);
			$('#CusName').text(srvdto.CusName);
			$('#Indate').text(indate.format('yyyy년 MM월 dd일'));
			$('#Maintenance').text(srvdto.MatFlag);
			$('#CusEmpName').text(srvdto.CusEmpName);
			if ('RelDate' in srvdto) {
				$('#OutDate').text(outdate.format('yyyy년 MM월 dd일'));
			}
			$('#PartSrvFlag').text(srvdto.PartSrvFlag);
			$('#ProductNumber').text(srvdto.ProductNumber);
			$('#SerialNumber').text(srvdto.SerialNumber);
			$('#Process').text(srvdto.Process);
			$('#ObtAmount').text(srvdto.ObtAmount);
			$('#ServiceClass').text(ServiceClass);
			$('#OrdAmount').text(srvdto.OrdAmount);
			/*
			$('#Symptom1').text(repdetdtos[0].Symptom);
			$('#Symptom2').text(repdetdtos[1].Symptom);
			$('#Symptom3').text(repdetdtos[2].Symptom);
			$('#Action1').text(repdetdtos[0].Action);
			$('#Action2').text(repdetdtos[1].Action);
			$('#Action3').text(repdetdtos[2].Action);
			*/
			for(i=0;i<repdetdtos.length;i++){
				$('#TB2 > tbody:last').append('<tr><td>'+(i+1).toString()+'</td><td>'+repdetdtos[i].Symptom+'</td><td>'+repdetdtos[i].Action+'</td><td>'+repdetdtos[i].Cause+'</td></tr>');
			}
			

			/*							<td id='PartRepFlag'/>
							</tr>
							<tr>
								<th>P/N</th>
								<td id='ProductNumber'/>
								<th>서비스분류</th>
								<td id='ServiceKind'/>
								<th>수주금액</th>
								<td id='ObjAmount'/>
							</tr>
							<tr>
								<th>S/N</th>
								<td id=SerialNumber'/>
								<th>진행상황</th>
								<td id='Process'/>
								<th>발주금액</th>
								<td id='OrdAmount'/>*/

		} catch (Exception) {
			alert(Exception);
		}
	}
	window.onload = function() {
		try {
			var search = window.location.search;
			var object = _GET(search);

			//$('#SrvCode').text(object.ServiceCode);

			$.ajax({
				url : "/srvm/ajax/GetDetSrv",
				data : object.ServiceCode,
				dataType : "text",
				type : "POST",
				contentType : "application/json; charset=UTF-8",
				async : false,
				success : function(responseData) {
					alert('success');
					alert(responseData);
					getview(responseData);
				},
				error : function(request, status, error) {
					alert("code = " + request.status + " message = "
							+ request.responseText + " error = " + error); // 실패 시 처리
				},

				complete : function() {
					alert('complete');
				}

			});

		} catch (Exception) {
			alert(Exception);
		}
	}
</script>
<script src="/srvm/resources/jquery-3.1.1.min.js"></script>
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
			<div class="panel-heading">서비스상세조회</div>
			<div class="panel-body">

				<table id="TB1"
					class="SrvTable table table-striped table-bordered table-hover">
					<tbody>
						<tr>
							<th>서비스코드</th>
							<td id='SrvCode' />
							<th>담당자</th>
							<td id='EmpName' />
							<th>Warranty</th>
							<td id='WrtFlag' />
						</tr>
						<tr>
							<th>고객사</th>
							<td id='CusName' />
							<th>입고일자</th>
							<td id='Indate' />
							<th>유지보수</th>
							<td id='Maintenance' />
						</tr>
						<tr>
							<th>고객사담당자</th>
							<td id='CusEmpName' />
							<th>출고일자</th>
							<td id='OutDate' />
							<th>외부지원여부</th>
							<td id='PartSrvFlag' />
						</tr>
						<tr>
							<th>P/N</th>
							<td id='ProductNumber' />
							<th>서비스분류</th>
							<td id='ServiceClass' />
							<th>수주금액</th>
							<td id='ObtAmount' />
						</tr>
						<tr>
							<th>S/N</th>
							<td id='SerialNumber'/>
							<th>진행상황</th>
							<td id='Process' />
							<th>발주금액</th>
							<td id='OrdAmount' />
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
			</div>


		</div>
	</div>

</body>
</html>
