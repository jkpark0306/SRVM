<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script src="/srvm/resources/jquery-3.1.1.min.js"> </script>
<script>
	$(document).ready(
		function(){
	
			$("#insertbtn").on("click",
				function(){
				testinsert();
			});
			
			$("#updatebtn").on("click",
					function(){
			});
			$("#deletebtn").on("click",
					function(){
						alert("delete");
			});
			$("#testbtn").on("click",
					function(){
				window.location.replace('/srvm');
			})
			
			
		}		
	
	);
	
	function testupdate(){
		
	}
	
	function testinsert(){
		var testobj = {
				InsertDTO : {}
		};
		
		try{
			
		testobj.InsertDTO.IDX = "1";
		testobj.InsertDTO.TC1 = $("#insertTC1text").val();
		testobj.InsertDTO.TC2 = $("#insertTC2text").val();
		testobj.InsertDTO.TC3 = $("#insertTC3text").val();
		testobj.QTY = $("#insertQTYtext").val();
		
		var IDX = JSON.stringify(testobj);
		
		alert(IDX);

	
		
		
		$.ajax({
			url : "/srvm/ajax/test_insert",
			data : JSON.stringify(testobj),
			dataType : "text",
			type : "POST",
			contentType : "application/json; charset=UTF-8",
			success : function(responseData){
				var data = JSON.parse(responseData);
				alert(responseData);
				if(!data || data.Result != 0){
					alert("DB 에러");
					return;
				}
				alert("done");
				
			}
		});
		
		
		}
		catch(e){
			alert(e);
		}
		
	}
	
	function tablerefresh(){
		
	}
	
	function testdelete(){
		
	}
	

</script>
</head>
<body>
	<table id="TestTable">
		<thead id="TestThead">
			<tr>
				<th>IDX</th>
				<th>TC1</th>
				<th>TC2</th>
				<th>TC3</th>
			</tr>
		</thead>

		<tbody id="TestTbody">
			<c:forEach var="dto" items="${TestList}">
				<tr>
					<td>${dto.getIDX()}</td>
					<td>${dto.getTC1()}</td>
					<td>${dto.getTC2()}</td>
					<td>${dto.getTC3()}</td>
				</tr>
			</c:forEach>
		</tbody>

	</table>
	<div style="border: 1px solid gold; float: left; width: 33%;">
	TC1 : <input type="text"  id="insertTC1text"/><br/>
	TC2 : <input type="text"  id="insertTC2text"/><br/>
	TC3 : <input type="text"  id="insertTC3text"/><br/>
	QTY : <input type="text"  id="insertQTYtext"/><br/>
	<input type="button" value="TestInsert" id="insertbtn" />
	</div>
	<div style="border: 1px solid red; float: left; width: 33%;">
	IDX1 : <input type="text"  id="updateIDX1text"/><br/>
	IDX2 : <input type="text"  id="updateIDX2text"/><br/>
	IDX3 : <input type="text"  id="updateIDX3text"/><br/>
	TC1 : <input type="text"  id="updateTC1text"/><br/>
	TC2 : <input type="text"  id="updateTC2text"/><br/>
	TC3 : <input type="text"  id="updateTC3text"/><br/>
	<input type="button" value="TestUpdate" id="updatebtn"/>
	</div>
	<div style="border: 1px solid blue; float: left; width: 33%;">
	IDX1 : <input type="text"  id="deleteIDX1text"/><br/>
	IDX2: <input type="text"  id="deleteIDX2text"/><br/>
	IDX3 : <input type="text"  id="deleteIDX3text"/><br/>
	
	<input type="button" value="TestDelete" id="deletebtn"/>
	</div>
	<input type="button" value="test" id="testbtn"/>
	
	
	
</body>
</html>
