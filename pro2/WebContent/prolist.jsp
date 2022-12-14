<%@page import="com.lec.project.vo.UserVO"%>
<%@page import="com.lec.project.vo.PageInfo"%>
<%@page import="com.lec.project.vo.ProductVO"%>
<%@page import="java.util.ArrayList"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>

<% 
	PageInfo pageInfo = (PageInfo) request.getAttribute("pageInfo");
	ArrayList<ProductVO> productList = (ArrayList<ProductVO>) request.getAttribute("productList");
	
	HttpSession sess = request.getSession();
	UserVO user = null;
	if(sess != null )  user = (UserVO) sess.getAttribute("user");

	
	int curPage = pageInfo.getPage();
	int totalPage = pageInfo.getTotalPage();
	int startPage = pageInfo.getStartPage();
	int endPage = pageInfo.getEndPage();
	
	
%>
<c:if test="<%= user!=null %>">
	<c:set var ="user"  value ="<%=user.getUser_id() %>"/>
</c:if>

<c:set var ="productList"  value ="<%=productList %>"/>
<c:set var ="curPage"  value ="<%=curPage %>"/>
<c:set var ="totalPage"  value ="<%=totalPage %>"/>
<c:set var ="startPage"  value ="<%=startPage %>"/>
<c:set var ="endPage"  value ="<%=endPage %>"/>
<c:set var="q" value="query"/>
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
      	<c:if test="<%= user!=null %>">
        	<h4><a href="logOut.do" class="twitter"><strong>????????????</strong></a></h4>
        	<h4><a href="myPage.do">???????????????</a></h4>
      	</c:if>
      	<c:if test="<%= user==null %>">
        	<h4><a href="/pro2/login.jsp" class="twitter"><strong>?????????</strong></a></h4>      	
        	 <h4><a href="/pro2/crateUser.jsp" class="twitter">????????????</a></h4>
      	</c:if>
      	
      </div>
    </div>
  </section>

  <!-- ======= Header ======= -->
  <header id="header" class="d-flex align-items-center">
    <div class="container d-flex justify-content-between align-items-center">

      <div class="logo">
        <h1><a href="index.html">?????????</a></h1>
        <!-- Uncomment below if you prefer to use an image logo -->
        <!-- <a href="index.html"><img src="assets/img/logo.png" alt="" class="img-fluid"></a>-->
      </div>

      <nav id="navbar" class="navbar">
        <ul>
		  <li><a class="active" href="index.jsp">Home</a></li>
          <li><a class="active" href="productList.do">???????????????</a></li>
          <li><a class="active" href="orderCheck.do">????????????</a></li>
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
          <li>?????? ??????</li>
        </ol>
        <h2>???????????????</h2>

      </div>
    </section><!-- End Breadcrumbs -->

    <!-- ======= Portfolio Section ======= -->
    <section id="portfolio" class="portfolio">
      <div class="container">

        <div class="row">
          <div class="col-lg-12 d-flex justify-content-center">
            <ul id="portfolio-flters">
              <li data-filter="*" class="filter-active">All</li>
              <li data-filter=".filter-top">TOP</li>
              <li data-filter=".filter-bottom">BOTTOM</li>
              <li data-filter=".filter-outer">OUTER</li>
            </ul>
          </div>
        </div>
        
         <div class="row portfolio-container">
        
        
		<c:forEach var="product" items="${productList}">
        <c:choose>
        	<c:when test="${product.getCategory_code() =='??????1'}"><div class="col-lg-4 col-md-6 portfolio-item filter-top"></c:when>
        	<c:when test="${product.getCategory_code() =='??????2'}"><div class="col-lg-4 col-md-6 portfolio-item filter-bottom"></c:when>
        	<c:otherwise><div class="col-lg-4 col-md-6 portfolio-item filter-outer"></c:otherwise>
        </c:choose>
            <div class="portfolio-wrap">
              <img src="${product.getPro_img() }" class="img-fluid" alt="">
               <div class="portfolio-info">
                <h4>${product.getPro_name()}</h4>
                <p>${product.getPro_price()}</p>
                <p>${product.getPro_hit()}</p>
                <a href="detailProduct.do?p_num=${product.getPro_num()}"><i class="fa fa-plus"></i>????????????</a>
                <a href="addCart.do?p_num=${product.getPro_num()}"><i class="fa fa-cart-plus"></i>????????? ??????</a>
               </div>
              </div>
            </div>
		</c:forEach>
		
         </div>
      </div>
    </section><!-- End Portfolio Section -->
    
    </div>
	<br />
	<div class="container" align="center">
		<ul class="pagination justify-content-center">
			<c:if test="${startPage!=1 }">
				<li class="page-item"><a href="productList.do?p=1" class="page-link"><i class="fas fa-fast-backward"></i></a></li>
				<li class="page-item"><a href="productList.do?p=${startPage-1}" class="page-link"><i class="fas fa-backward"></i></a></li>
			</c:if>
			
				<c:forEach var="page_num" begin="${startPage }" end ="${endPage }">
					<li class="page-item"><a href="productList.do?p=${page_num}" class="page-link"> ${page_num}</a></li>
				</c:forEach>
			
			<c:if test="${endPage < totalPage }">
				<li class="page-item"><a href="productList.do?p=${endPage+1}" class="page-link"><i class="fas fa-forward"></i></a></li>
				<li class="page-item"><a href="productList.do?p=${totalPage}" class="page-link"><i class="fas fa-fast-forward"></i></a></li>
			</c:if>
		</ul>
	</div>
    
    
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