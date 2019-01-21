<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>입출고내역</title>
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
	<!--
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7/jquery.js"></script> 
    <script src="http://malsup.github.com/jquery.form.js"></script> 
	-->
<script src="http://malsup.github.com/jquery.form.js"></script>
<script src="/srvm/resources/js/jquery-3.1.1.min.js"></script>--
<script src="http://code.jquery.com/ui/1.8.18/jquery-ui.min.js"></script>
<script src="/srvm/resources/js/SHA256.js"></script>
<script src="/srvm/resources/js/DateFormat.js"></script>
<script>
	$(document).ready(function() {
					
		
		function ExcelUpload(file){
			
			var formData = new FormData($("#exceluploadForm")[0]);
			
			$.ajax({
				url : 
			});
			
			var options = {
					data : formData,
					
					success : function(){
						alert('file upload success');
					}
			};
			
			$("#excelUploadForm").ajaxSubmit(options);
			
		}
						//$("#myModal").style.display = "none";

						var obj = JSON.parse('${SrvList}');

						for (var i = 0; i < obj.length; i++) {

							try {

								var td = '<tr><td>' + obj[i].SrvCode
										+ '</td><td>' + obj[i].InDate
										+ '</td><td>' + obj[i].EmpName
										+ '</td><td>' + obj[i].ProductNumber
										+ '</td><td>' + obj[i].SerialNumber
										+ '</td><td>' + obj[i].CusName
										+ '</td><td>' + obj[i].CusEmpName
										+ '</td><td>' + obj[i].Symptom
										+ '</td><td>' + obj[i].Process
										+ '</td><td>' + obj[i].RelExtDate
										+ '</td><td>' + obj[i].RelDate
										+ '</td><td>' + obj[i].Note
										+ '</td></tr>';

								$('#TBB:last').append(td);

							} catch (Exception) {
								alert(Exception);
							}

						}

						$(".close").on("click", function() {
							$("#myModal").hide();
						});

						$("#importexcelbtn").on("click",function(){
							ExcelUpload($("#excelFile").val());
						});
						
						$("#TB tr")
								.on(
										"click",
										function() {

											var Param = {};
											var tr = $(this);
											var td = tr.children();
											$("#SrvTable th")
													.each(
															function(i) {
																Param[$(
																		"#SrvTable th")
																		.eq(i)
																		.text()] = td
																		.eq(i)
																		.text();
															});
											var JsonParam = JSON
													.stringify(Param);
											alert(JsonParam);
											var Uri = "/srvm/Popup/SrvDetailPopup?SrvCode="
													+ td.eq();

											window
													.open(encodeURI(Uri),
															"newWindow",
															"resizable=no,width=1530px, height=800px, scrollbar=no");

										});

						$("#exportexcel").on("click", function() {
							$("#myModal").show();
							/*
							window.open(encodeURI("/srvm/Popup/excelUploadPopup.jsp"), "newWindow","resizable=no,width=1530px, height=800px, scrollbar=no");
							 */
						});

					});
</script>
</head>

<body>
	<div id="myModal" class="modal">


		<div class="modal-content">
			<span class="close">&times;</span>
			<form id="excelUploadForm" name="excelUploadForm"
				enctype="multipart/form-data" method="post" action="/srvm/ajax/ImportExcel_">
				<div class="contents">
					<div>첨부파일은 한개만 등록 가능합니다.</div>

					<dl class="vm_name">
						<dt class="down w90">첨부 파일</dt>
						<dd>
							<input id="excelFile" type="file" name="excelFile" />
						</dd>
					</dl>
				</div>

				<div class="bottom">
					<button type="button" id="importexcelbtn" class="btn">
						<span>추가</span>
					</button>
				</div>
			</form>



		</div>
	</div>

	<div id="wrapper">
		<p>
			<jsp:include page="../common/CommonPage.jsp" flush="false" />
		</p>
	</div>
	<div id="page-wrapper">

		<table id="TB"
			class="SrvTable table table-striped table-bordered table-hover">
			<thead id="TBH">

				<tr>
					<th>서비스코드</th>
					<th>입고일자</th>
					<th>담당사원</th>
					<th>ProductNumber</th>
					<th>SerialNumber</th>
					<th>고객사</th>
					<th>고객사담당자</th>
					<th>증상</th>
					<th>진행상황</th>
					<th>출고예상일자</th>
					<th>출고일자</th>
					<th>비고</th>
				</tr>

			</thead>


			<tbody id="TBB">


			</tbody>

		</table>

		<button id='exportexcel' type="button" class="btn btn-default">엑셀받기</button>






	</div>

</body>
</html>
