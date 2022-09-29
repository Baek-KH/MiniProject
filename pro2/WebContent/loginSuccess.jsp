<%@page import="com.lec.project.vo.UserVO"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>

<% 
	HttpSession sess = request.getSession();
	UserVO user = null;
	if(sess != null )  user = (UserVO) sess.getAttribute("user");
%>
<c:if test="<%= user!=null %>">
	<c:set var ="user"  value ="<%=user.getUser_id() %>"/>
</c:if>
<!-- -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

  <meta content="width=device-width, initial-scale=1.0" name="viewport">

  <title>Eterna Bootstrap Template - Index</title>
  <meta content="" name="description">
  <meta content="" name="keywords">
  <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css" 
		integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ"
		crossorigin="anonymous"> 
  <!-- Favicons -->
  <link href="Eterna/assets/img/favicon.png" rel="icon">
  <link href="Eterna/assets/img/apple-touch-icon.png" rel="apple-touch-icon">

  <!-- Google Fonts -->
  <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Raleway:300,300i,400,400i,500,500i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i" rel="stylesheet">

  <!-- Vendor CSS Files -->
  <link href="Eterna/assets/vendor/animate.css/animate.min.css" rel="stylesheet">
  <link href="Eterna/assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <link href="Eterna/assets/vendor/bootstrap-icons/bootstrap-icons.css" rel="stylesheet">
  <link href="Eterna/assets/vendor/boxicons/css/boxicons.min.css" rel="stylesheet">
  <link href="Eterna/assets/vendor/glightbox/css/glightbox.min.css" rel="stylesheet">
  <link href="Eterna/assets/vendor/swiper/swiper-bundle.min.css" rel="stylesheet">

  <!-- Template Main CSS File -->
  <link href="Eterna/assets/css/style.css" rel="stylesheet">

	
	
	
</head>
<body>
	  <!-- ======= Top Bar ======= -->
  <section id="topbar" class="d-flex align-items-center">
    <div class="container d-flex justify-content-center justify-content-md-between">
      <div class="contact-info d-flex align-items-center">
        <i class="bi bi-envelope d-flex align-items-center"><a href="mailto:contact@example.com">contact@example.com</a></i>
        <i class="bi bi-phone d-flex align-items-center ms-4"><span>+1 5589 55488 55</span></i>
      </div>
      <div class="social-links d-none d-md-flex align-items-center">
      	<c:if test="<%= user==null %>">
        	<h4><a href="/pro2/login.jsp" class="twitter"><strong>로그인</strong></a></h4>      	
        	 <h4><a href="/pro2/crateUser.jsp" class="twitter">회원가입</a></h4>
      	</c:if>
      	<c:if test="<%= user!=null %>">
        	<h4><a href="logOut.do" class="twitter"><strong>로그아웃</strong></a></h4>
        	<h4><a href="myPage.do">마이페이지</a></h4>
      	</c:if>
  
      </div>
    </div>
  </section>

  <!-- ======= Header ======= -->
  <header id="header" class="d-flex align-items-center">
    <div class="container d-flex justify-content-between align-items-center">

      <div class="logo">
        <h1><a href="index.html">쇼핑몰</a></h1>
        <!-- Uncomment below if you prefer to use an image logo -->
        <!-- <a href="index.html"><img src="assets/img/apple-touch-icon.png" alt="" class="img-fluid"></a> -->
      </div>

      <nav id="navbar" class="navbar">
        <ul>
          <li><a class="active" href="index.jsp">Home</a></li>

          <li><a class="active" href="productList.do">상품리스트</a></li>
          <li><a class="active" href="orderCheck.do">주문확인</a></li>

          <li><a href="cartList.do"><i class="fa fa-shopping-cart"></i>CART</a></li>
        </ul>
        <i class="bi bi-list mobile-nav-toggle"></i>
      </nav><!-- .navbar -->

    </div>
  </header><!-- End Header -->
  <main id="main">

    <!-- ======= Breadcrumbs ======= -->
    <section id="breadcrumbs" class="breadcrumbs">
      <div class="container">

        <ol>
          <li><a href="index.html">Home</a></li>
          <li>상품 상세</li>
        </ol>
        <h2>Product Details</h2>

      </div>
    </section><!-- End Breadcrumbs -->
  	
	<div class="container" align="center">
	
		<h1>로그인이 완료 되었습니다.</h1>
		<br />
		<a class="active" href="productList.do">상품 구경하러가기</a>	
	
	</div>
 
	</main>
	
</body>
</html>


	