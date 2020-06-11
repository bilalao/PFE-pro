<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="Dashboard">
<meta name="keyword"
	content="Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">
<title>Gestion des Bus</title>

<!-- Favicons -->
<link href="/img/favicon.png" rel="icon">
<link href="/img/apple-touch-icon.png" rel="apple-touch-icon">

<!-- Bootstrap core CSS -->
<link href="/BusManagement/lib/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<!--external css-->
<link href="/BusManagement/lib/font-awesome/css/font-awesome.css"
	rel="stylesheet" />

<link href="/BusManagement/lib/advanced-datatable/css/demo_page.css"
	rel="stylesheet" />
<link href="/BusManagement/lib/advanced-datatable/css/demo_table.css"
	rel="stylesheet" />
<link rel="stylesheet"
	href="/BusManagement/lib/advanced-datatable/css/DT_bootstrap.css" />

<!-- Custom styles for this template -->
<link href="/BusManagement/css/style.css" rel="stylesheet">
<link href="/BusManagement/css/style-responsive.css" rel="stylesheet">

<!-- =======================================================
    Template Name: Dashio
    Template URL: https://templatemag.com/dashio-bootstrap-admin-template/
    Author: TemplateMag.com
    License: https://templatemag.com/license/
  ======================================================= -->
</head>

<body>
	<section id="container">
		<!-- **********************************************************************************************************************************************************
        TOP BAR CONTENT & NOTIFICATIONS
        *********************************************************************************************************************************************************** -->
		<!--header start-->
		<jsp:include page="template/header.jsp"></jsp:include>
		<!--header end-->
		<!-- **********************************************************************************************************************************************************
        MAIN SIDEBAR MENU
        *********************************************************************************************************************************************************** -->
		<!--sidebar start-->
		<jsp:include page="template/menu.jsp"></jsp:include>
		<!--sidebar end-->
		<!-- **********************************************************************************************************************************************************
        MAIN CONTENT
        *********************************************************************************************************************************************************** -->
		<!--main content start-->
		<c:if test="${not empty requestScope.page }">
			<jsp:include page="${requestScope.page}" />
		</c:if>

		<!-- /MAIN CONTENT -->
		<!--main content end-->
		<!--footer start-->
		<jsp:include page="template/footer.jsp"></jsp:include>
		<!--footer end-->
	</section>
	<!-- js placed at the end of the document so the pages load faster -->
	<script src="/BusManagement/lib/jquery/jquery.min.js"></script>
	<script src="/BusManagement/lib/bootstrap/js/bootstrap.min.js"></script>
	<script src="/BusManagement/lib/jquery-ui-1.9.2.custom.min.js"></script>
	<script src="/BusManagement/lib/jquery.ui.touch-punch.min.js"></script>
	<script class="include" type="text/javascript"
		src="/BusManagement/lib/jquery.dcjqaccordion.2.7.js"></script>
	<script src="/BusManagement/lib/jquery.scrollTo.min.js"></script>
	<script src="/BusManagement/lib/jquery.nicescroll.js"
		type="text/javascript"></script>

	<script type="text/javascript"
		src="/BusManagement/lib/advanced-datatable/js/jquery.dataTables.js"></script>
	<script type="text/javascript"
		src="/BusManagement/lib/advanced-datatable/js/DT_bootstrap.js"></script>

 
  <!--common script for all pages-->
  <script src="/BusManagement/lib/common-scripts.js"></script>
  <script type="text/javascript" src="/BusManagement/lib/script.js"></script>
  
  <!--script for this page-->

</body>

</html>

