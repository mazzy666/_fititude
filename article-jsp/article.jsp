<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE HTML>

<html>
	<head>
		<title>Fititude-專欄主頁</title>
		<meta http-equiv="content-type" content="text/html; charset=utf-8" />
		<meta name="description" content="" />
		<meta name="keywords" content="" />
		<link href='http://fonts.googleapis.com/css?family=Oxygen:400,300,700' rel='stylesheet' type='text/css'>
		<!--[if lte IE 8]><script src="js/html5shiv.js"></script><![endif]-->
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
		<script src="js/skel.min.js"></script>
		<script src="js/skel-panels.min.js"></script>
		<script src="js/init.js"></script>
		
		<noscript>
			<link rel="stylesheet" href="css/skel-noscript.css" />
			<link rel="stylesheet" href="css/style.css" />
		</noscript>
		<!--[if lte IE 8]><link rel="stylesheet" href="css/ie/v8.css" /><![endif]-->
		<!--[if lte IE 9]><link rel="stylesheet" href="css/ie/v9.css" /><![endif]-->
	</head>
	<body class="homepage">

	<!-- Header -->
	<header>
		<div id="header">
			<div class="container">			
				<!-- Logo -->
					<div id="logo">
						<h1><a href="#">專欄</a></h1>
						<span>Design by Fititude</span>
					</div>				
				<!-- Nav -->
				<div id="head">
					<nav id="nav">
						<ul id="mainBar">
							<li ><a href="#">首頁</a></li>
							<li class="active"><a href="專欄主頁面.html">專欄</a></li>
							<li class="dropdown"><a href="javascript:void(0)" class="dropbtn">社群</a>
								<div class="dropdown-content">
												<a href="#">社群論壇</a><br>
												<a href="#">二手市場</a><br>
												<a href="#">揪團</a><br>
								</div>
							</li>
							<li><a href="#">個人頁面</a></li>
							<li><a href="#">Fititude商城</a></li>
						</ul>					
					</nav>						
					<div class="topnav">
						<div class="search-container">
							  <form action="/action_page.html">
								<input type="text" placeholder="Search.." name="search" style="background-color: #d1cccc">
								<button type="submit" style="width: 50px; height:46px"><i class="fa fa-search"></i></button>
							  </form>
							</div>
					</div>					 
			</div>
		</div>
		</div>
	</header>
	<!-- Header -->
			
	<!-- Main -->
		<div id="main">
			<div class="container">
				<header>
					<h2>專欄列表</h2>
				</header>
				<div class="row">
				
				 <c:forEach varStatus="stVar"  var="articleBean"  items="${articleList}" begin="0" end="3">
					<div class="3u">
						<section>
							<a href="#" class="image full">
							<img src="${pageContext.servletContext.contextPath}/article/getListImage?id=${articleBean.articleId}" alt="" />
							</a>
							<h5>${articleBean.listtitle}</h5>
							<p><em>${articleBean.listcontent}</em></p>
							<a href="DisplayPageProducts?id=${articleBean.articleId}" class="button">Read More </a>
						</section>
					</div>
				</c:forEach> 
				
				</div>
				<div class="divider">&nbsp;</div>
				<div class="row">
				<c:forEach varStatus="stVar"  var="articleBean"  items="${articleList}" begin="4" end="7">
						<div class="3u">
							<section>
							<a href="#" class="image full">
							<img src="${pageContext.servletContext.contextPath}/article/getListImage?id=${articleBean.articleId}" alt="" />
							</a>
							<h5>${articleBean.listtitle}</h5>
							<p><em>${articleBean.listcontent}</em></p>
							<a href="DisplayPageProducts?id=${articleBean.articleId}" class="button">Read More </a>
						</section>
						</div>
				</c:forEach> 		
					</div>

				<div class="divider">&nbsp;</div>

				<div class="row">

						<div id="page">
								<nav aria-label="Page navigation">
									<ul class="pagination">
									  <li>
										<a href="DisplayListArticle?pageNo=1" aria-label="Previous">
										  <span aria-hidden="true">&laquo;</span>
										</a>


									  </li>
									  <c:choose>
										    <c:when test="${totalPages <= 9}">
										    		<c:forEach  var="i"   begin="1" end="${totalPages}">
											 			<li>
															 <a   href="DisplayListArticle?pageNo=${i}">
															 		<c:out value="${i}"/>
															 </a>
											 			</li>
											 		</c:forEach>
										    </c:when>
										    
										    

										    <c:when test="${ pageNo == 1 }">
													<c:forEach  var="i"   begin="${pageNo}" end="4">
											 			<li>
															 <a   href="DisplayListArticle?pageNo=${i}">
															 		<c:out value="${i}"/>
															 </a>
											 			</li>
											 		</c:forEach>
										    </c:when>
										    <c:when test="${ ((totalPages - pageNo) >= 2) }">
													<c:forEach  var="i"   begin="${pageNo-1}" end="${pageNo+1}">
											 			<li>
															 <a   href="DisplayListArticle?pageNo=${i}">
															 		<c:out value="${i}"/>
															 </a>
											 			</li>
											 		</c:forEach>
										    </c:when>
										    <c:when test="${(totalPages - pageNo) <= 2}">
													<c:forEach  var="i"   begin="${pageNo-3}" end="${totalPages}">
											 			<li>
															 <a   href="DisplayListArticle?pageNo=${i}">
															 		<c:out value="${i}"/>
															 </a>
											 			</li>
											 		</c:forEach>
										    </c:when>
										    <c:when test="${totalPages == pageNo}">
													<c:forEach  var="i"   begin="${pageNo-3}" end="${totalPages}">
											 			<li>
															 <a   href="DisplayListArticle?pageNo=${i}">
															 		<c:out value="${i}"/>
															 </a>
											 			</li>
											 		</c:forEach>
										    </c:when> 
										   
									</c:choose>
									  
									  
									  <li>
									  
										<a href="DisplayListArticle?pageNo=${totalPages}" aria-label="Next">
										  <span aria-hidden="true">&raquo;</span>
										</a>
									  </li>
									</ul>
								  </nav>
								</div>
				
					<!-- Content -->
					<!-- /Content -->
						
					<!-- Sidebar -->
					<!-- Sidebar -->
						
				</div>
			
			</div>
		</div>
	<!-- Main -->
		<!-- Footer -->
		<div id="footer">
			<div class="container">
				<div class="row">
					<div class="3u">
						<section>
				
						</section>
					</div>
					<div class="3u">
						<section>
						
						</section>				
					</div>
					<div class="6u">
						<section>
							<header>
								<h2><a href="#">About Us</a></h2>
							</header>
							<p>Something about FITITUDE.</p>
							<ul class="default">
								<li><a href="#">120-240 Nam bibendum consectetur diam et fringilla</a></li>
								<li><a href="#">010-020-0680</a></li>
								<li><a href="mailto:contact@fititude.com">contact@fititude.com</a></li>
								<li><a href="#">www.fititude.com</a></li>
								<li><a href="#">友站連結2</a></li>
								<li><a href="#">友站連結2</a></li>
							</ul>
						</section>
					</div>
				</div>
			</div>
		</div>
	<!-- Footer -->

	<!-- Copyright  -->
	  <div id="copyright">
			<div class="container">
						All Content Copyright &copy; 2019 Fititude Inc.
				
			</div>
		</div>

	</body>
</html>