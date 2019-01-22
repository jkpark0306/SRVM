<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<head>
	<title>SRVM</title>
</head>

<style>		
<!--/*
	html, body { 
		height: 100%;
	}
	
	header {
	    text-align: center;
	    align-items: center;
	    justify-content: center;
//	    height: 40px;
	    display: flex;
	    background-color: rgb(255, 153, 0);
		color: black;
	}
	
	.main-title {
		padding: 5px;
		margin: 0px;
		font-size: 25px;
	}
	
	nav {
	    align-items: center;
//	    height: 40px;
	    display: flex;
	    background-color: rgb(221, 217, 195);
	    border: 1px solid gray;
	    padding: 5px;
	}		
	   
	.main-btn-menu {
		margin-left: 10px;
		width: 100px;
//	    height: 30px;
	    padding: 3px;
	    font-size: 18px;
	}
	
	article {
	}
		
	.dropdown-menu li {
		list-style: none; 
		float: left; 
		margin-right: 4px; 
		padding: 5px;
	}
	
	.dropdown-menu li:hover, .menu li.active {
        background-color: #f90;
    }
    -->
	*/
</style>

	
<script>
/*
$(document).ready(
	function() {
		$("#li-sw-version-info").click(
			function() {
				alert("스마트 입출고 시스템 Ver.1.2(2017-10-12)");
			}
	    );
		
		$('.dropdown-menu li').click(function(){
		    $(this).addClass('active').siblings().removeClass('active');
		});
	}
);
*/
</script>

<header>
<!--    <h4 class="main-title">스마트 입출고 시스템</h4> -->
</header>
  
<nav>
	<div class="dropdown">
	  	<button class="btn btn-primary dropdown-toggle main-btn-menu" type="button" data-toggle="dropdown">보기</button>
	  		<ul class="dropdown-menu">
    			<li><a href="/ssrm/listall">전체목록</a></li>
    			<li><a href="/ssrm/listbywarehouse">창고별목록</a></li>
	     		<li><a href="/ssrm/listbyproduct">품목별목록</a></li>
   			</ul>
   	</div>
   	<div class="dropdown">
	  	<button class="btn btn-primary dropdown-toggle main-btn-menu" type="button" data-toggle="dropdown">입출고</button>
	  		<ul class="dropdown-menu">
    			<li><a href="/ssrm/inputorder">입고지시</a></li>
    			<li><a href="/ssrm/inputprogress">입고진행</a></li>
     			<li><a href="/ssrm/outputorder">출고지시</a></li>
     			<li><a href="/ssrm/outputprogress">출고진행</a></li>
<!--      			<li><a href="#">창고이동</a></li> -->
   			</ul>
   	</div>
   	<div class="dropdown">
	  	<button class="btn btn-primary dropdown-toggle main-btn-menu" type="button" data-toggle="dropdown">기타</button>
	  		<ul class="dropdown-menu">
    			<li><a href="/ssrm/product">상품추가</a></li>
    			<li><a href="/ssrm/beacon">비콘관리</a></li>
<!--     			<li><a href="#">창고추가</a></li>
     			<li><a href="#">셀추가</a></li>
     			<li><a href="#">재고조정</a></li> -->
   			</ul>
   	</div>
   	<div class="dropdown">
	  	<button class="btn btn-primary dropdown-toggle main-btn-menu" type="button" data-toggle="dropdown">버전</button>
	  		<ul class="dropdown-menu">
    			<li id="li-sw-version-info"><a href="#">소프트웨어 버전정보</a></li>
   			</ul>
   	</div>
</nav>