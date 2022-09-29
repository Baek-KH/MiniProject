<%@page import="java.text.DecimalFormat"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.lec.project.vo.Order_detailVO"%>
<%@page import="com.lec.project.vo.OrderVO"%>
<%@page import="com.lec.project.vo.UserVO"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>

<% 
	HttpSession sess = request.getSession();
	UserVO user = null;
	if(sess != null )  user = (UserVO) sess.getAttribute("user");
	
	OrderVO orderVO = null;
	ArrayList<Order_detailVO> orderDList = null; 
	
	if(request.getAttribute("orderVO") != null) {
		orderVO = (OrderVO) request.getAttribute("orderVO");};
	if(request.getAttribute("orderDList") != null) {
		orderDList = (ArrayList<Order_detailVO>) request.getAttribute("orderDList");};
	
		DecimalFormat dFormat = new DecimalFormat("###,###");
	
	
%>
<c:set var="dFormat" value="<%=dFormat %>"></c:set>
<c:if test="<%= orderVO!=null %>">
	<c:set var ="orderVO"  value ="<%=orderVO %>"/>
</c:if>
<c:if test="<%= orderDList!=null %>">
	<c:set var ="orderDList"  value ="<%=orderDList %>"/>
</c:if>
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
          <li>주문 확인</li>
        </ol>
        
        	<div class="container col-md-6" align="center">
				<h1> 주문 확인 </h1>
				
				<table class="table table-group">
						<tr>
							<td><h5>주문자 이름  	:</h5></td>
							<td><h5>${ orderVO.getOrder_name() }</h5></td>
						</tr>
						<tr>
							<td><h5>주문자 핸드폰  :</h5></td>
							<td><h5>${ orderVO.getOrder_phone() }</h5></td>
						</tr>
						<tr>
							<td><h5>주문자 주소    :</h5></td>
							<td>
								<h5>${ orderVO.getOrder_addr1() }</h5>
								<h5>${ orderVO.getOrder_addr2() }</h5>
								<h5>${ orderVO.getOrder_addr3() }</h5>
							</td>
						</tr>
						
				
				</table>
				
					<table class="table table-group">
						<tr>
							<th>No</th>
							<th>상품명</th>
							<th>수량</th>
							<th>가격</th>
						</tr>
				<c:forEach var="orderDList" items="${orderDList}" varStatus="s">	
						<tr>
							<td>${s.index+1}</td>
							<td><input type="text" value="${orderDList.getPro_name()}" name="pro_name" disabled="disabled" /></td>
							<td>
								<input type="number" value="${orderDList.getPro_count()}" name="pro_count" id="pro_count" disabled="disabled"/>		
							</td>
							<td>
								<input type="text" value="${ dFormat.format(orderDList.getPro_price()) }" name="pro_price" id="pro_price" disabled="disabled"/>		
							</td>
						</tr>
						<c:set var= "countTotal" value="${countTotal + orderDList.getPro_count()}"/>	
						<c:set var= "priceTotal" value="${priceTotal + orderDList.getPro_price()}"/>	
				</c:forEach>
				
						<tr>
							<td></td>
							<td></td>
							<td>총 수량 = ${countTotal }</td>
							<td>총 금액 = ${ dFormat.format(priceTotal) }</td>
						</tr>
				
				
	
		</table>	
		
	</div>

      </div>
    </section><!-- End Breadcrumbs -->
  	
	<div class="container" align="center">
	
	
	
	</div>
 
	</main>
	<footer id="footer">

    <div class="footer-newsletter">
      <div class="container">
        <div class="row">
          <div class="col-lg-6">
            <h4>Our Newsletter</h4>
            <p>Tamen quem nulla quae legam multos aute sint culpa legam noster magna</p>
          </div>
          <div class="col-lg-6">
            <form action="" method="post">
              <input type="email" name="email"><input type="submit" value="Subscribe">
            </form>
          </div>
        </div>
      </div>
    </div>

    <div class="footer-top">
      <div class="container">
        <div class="row">

          <div class="col-lg-3 col-md-6 footer-links">
            <h4>Useful Links</h4>
            <ul>
              <li><i class="bx bx-chevron-right"></i> <a href="#">Home</a></li>
              <li><i class="bx bx-chevron-right"></i> <a href="#">About us</a></li>
              <li><i class="bx bx-chevron-right"></i> <a href="#">Services</a></li>
              <li><i class="bx bx-chevron-right"></i> <a href="#">Terms of service</a></li>
              <li><i class="bx bx-chevron-right"></i> <a href="#">Privacy policy</a></li>
            </ul>
          </div>

          <div class="col-lg-3 col-md-6 footer-links">
            <h4>Our Services</h4>
            <ul>
              <li><i class="bx bx-chevron-right"></i> <a href="#">Web Design</a></li>
              <li><i class="bx bx-chevron-right"></i> <a href="#">Web Development</a></li>
              <li><i class="bx bx-chevron-right"></i> <a href="#">Product Management</a></li>
              <li><i class="bx bx-chevron-right"></i> <a href="#">Marketing</a></li>
              <li><i class="bx bx-chevron-right"></i> <a href="#">Graphic Design</a></li>
            </ul>
          </div>

          <div class="col-lg-3 col-md-6 footer-contact">
            <h4>Contact Us</h4>
            <p>
              A108 Adam Street <br>
              New York, NY 535022<br>
              United States <br><br>
              <strong>Phone:</strong> +1 5589 55488 55<br>
              <strong>Email:</strong> info@example.com<br>
            </p>

          </div>

          <div class="col-lg-3 col-md-6 footer-info">
            <h3>About Eterna</h3>
            <p>Cras fermentum odio eu feugiat lide par naso tierra. Justo eget nada terra videa magna derita valies darta donna mare fermentum iaculis eu non diam phasellus.</p>
            <div class="social-links mt-3">
              <a href="#" class="twitter"><i class="bx bxl-twitter"></i></a>
              <a href="#" class="facebook"><i class="bx bxl-facebook"></i></a>
              <a href="#" class="instagram"><i class="bx bxl-instagram"></i></a>
              <a href="#" class="google-plus"><i class="bx bxl-skype"></i></a>
              <a href="#" class="linkedin"><i class="bx bxl-linkedin"></i></a>
            </div>
          </div>

        </div>
      </div>
    </div>

    <div class="container">
      <div class="copyright">
        &copy; Copyright <strong><span>Eterna</span></strong>. All Rights Reserved
      </div>
      <div class="credits">
        <!-- All the links in the footer should remain intact. -->
        <!-- You can delete the links only if you purchased the pro version. -->
        <!-- Licensing information: https://bootstrapmade.com/license/ -->
        <!-- Purchase the pro version with working PHP/AJAX contact form: https://bootstrapmade.com/eterna-free-multipurpose-bootstrap-template/ -->
        Designed by <a href="https://bootstrapmade.com/">BootstrapMade</a>
      </div>
    </div>
  </footer><!-- End Footer -->

  <a href="#" class="back-to-top d-flex align-items-center justify-content-center"><i class="bi bi-arrow-up-short"></i></a>

  <!-- Vendor JS Files -->
  <script src="Eterna/assets/vendor/purecounter/purecounter_vanilla.js"></script>
  <script src="Eterna/assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
  <script src="Eterna/assets/vendor/glightbox/js/glightbox.min.js"></script>
  <script src="Eterna/assets/vendor/isotope-layout/isotope.pkgd.min.js"></script>
  <script src="Eterna/assets/vendor/swiper/swiper-bundle.min.js"></script>
  <script src="Eterna/assets/vendor/waypoints/noframework.waypoints.js"></script>
  <script src="Eterna/assets/vendor/php-email-form/validate.js"></script>

  <!-- Template Main JS File -->
  <script src="Eterna/assets/js/main.js"></script>    
    
	
</body>
</html>


	