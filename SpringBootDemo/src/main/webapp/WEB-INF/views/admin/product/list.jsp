<%@ page language="java" pageEncoding="utf-8"%>
<%-- <%@ taglib prefix="c" uri="jakarta.tags.core" %> --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>AdminLTE 3 | Dashboard</title>

  <!-- Google Font: Source Sans Pro -->
  <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback">
  <!-- Font Awesome -->
  <link rel="stylesheet" href="<c:url value='/template/plugins/fontawesome-free/css/all.min.css'/>">
  <!-- Ionicons -->
  <link rel="stylesheet" href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
  <!-- Tempusdominus Bootstrap 4 -->
  <link rel="stylesheet" href="<c:url value='/template/plugins/tempusdominus-bootstrap-4/css/tempusdominus-bootstrap-4.min.css'/>">
  <!-- iCheck -->
  <link rel="stylesheet" href="<c:url value='/template/plugins/icheck-bootstrap/icheck-bootstrap.min.css'/>">
  <!-- JQVMap -->
  <link rel="stylesheet" href="<c:url value='/template/plugins/jqvmap/jqvmap.min.css'/>">
  <!-- Theme style -->
  <link rel="stylesheet" href="<c:url value='/template/dist/css/adminlte.min.css'/>">
  <!-- overlayScrollbars -->
  <link rel="stylesheet" href="<c:url value='/template/plugins/overlayScrollbars/css/OverlayScrollbars.min.css'/>">
  <!-- Daterange picker -->
  <link rel="stylesheet" href="<c:url value='/template/plugins/daterangepicker/daterangepicker.css'/>">
  <!-- summernote -->
  <link rel="stylesheet" href="<c:url value='/template/plugins/summernote/summernote-bs4.min.css'/>">
</head>
<body class="hold-transition sidebar-mini layout-fixed">
<div class="wrapper">

	<jsp:include page="../common/navbar.jsp"></jsp:include>

  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <div class="content-header">
      <div class="container-fluid">
        <div class="row mb-2">
          <div class="col-sm-6">
            <h1 class="m-0">Danh sách sản phẩm</h1>
          </div><!-- /.col -->
          <div class="col-sm-6">
            <ol class="breadcrumb float-sm-right">
              <li class="breadcrumb-item"><a href="#">Home</a></li>
              <li class="breadcrumb-item active">Dashboard v1</li>
            </ol>
          </div><!-- /.col -->
        </div><!-- /.row -->
      </div><!-- /.container-fluid -->
    </div>
    <!-- /.content-header -->

    <!-- Main content -->
    <section class="content">
      <div class="container-fluid">
      	<c:if test="${message != null && message != ''}">
      		<span class="text-success">${message }</span>
      	</c:if>
		  <table class="table table-hover">
		  <thead>
		    <tr>
		      <th scope="col">Mã</th>
		      <th scope="col">Tên sản phẩm</th>
		      <th scope="col">Hình ảnh</th>
		      <th scope="col">Giá gốc</th>
		      <th scope="col">Giảm giá</th>
		      <th scope="col">Danh mục</th>
		      <th scope="col">Thương hiệu</th>
		      <th scope="col">Trạng thái</th>
		      <th scope="col">Ngày cập nhật</th>
		      <th scope="col">Hành động</th>
		    </tr>
		  </thead>
		  <tbody>
		  <c:forEach var="pro"  items="${products }">
			  <tr>
			      <th scope="row">${pro.productId }</th>
			      <td>${pro.productName }</td>
			      <td><img src="/images/${pro.productPhoto}" width="80" height="55"></td>
			      <td>$${pro.productPrice }</td>
			      <td>${pro.productDiscount }</td>
			      <td>${pro.category.categoryName }</td>
			      <td>${pro.brand.brandName }</td>
			      <td>
			      		<c:if test="${pro.isShow }">
			      			<a href="/admin/product/updateshow/${pro.productId }" type="button" class="btn btn-info">Hiển thị</a>
			      		</c:if>
			      		<c:if test="${!pro.isShow }">
			      			<a href="/admin/product/updateshow/${pro.productId }" type="button" class="btn btn-warning">Tạm Ẩn</a>
			      		</c:if>
			      </td>
			      <td>${pro.updateAt }</td>
			      <td>
			      <a href="/admin/product/photo/${pro.productId }" type="button" class="btn btn-info">Photos</a>
			      	<a href="/admin/product/update/${pro.productId }" type="button" class="btn btn-primary">Update</a>
			      	<a href="/admin/product/delete/${pro.productId }" type="button" class="btn btn-danger">Delete</a>
			      </td>
			    </tr>
		  </c:forEach>
		    
		  </tbody>
		</table>
      </div><!-- /.container-fluid -->
    </section>
    <!-- /.content -->
  </div>
  <!-- /.content-wrapper -->
  <footer class="main-footer">
    <strong>Copyright &copy; 2014-2021 <a href="https://adminlte.io">AdminLTE.io</a>.</strong>
    All rights reserved.
    <div class="float-right d-none d-sm-inline-block">
      <b>Version</b> 3.2.0-rc
    </div>
  </footer>

  <!-- Control Sidebar -->
  <aside class="control-sidebar control-sidebar-dark">
    <!-- Control sidebar content goes here -->
  </aside>
  <!-- /.control-sidebar -->
</div>
<!-- ./wrapper -->

<!-- jQuery -->
<script src="<c:url value='/template/plugins/jquery/jquery.min.js'/>"></script>
<!-- jQuery UI 1.11.4 -->
<script src="<c:url value='/template/plugins/jquery-ui/jquery-ui.min.js'/>"></script>
<!-- Resolve conflict in jQuery UI tooltip with Bootstrap tooltip -->
<script>
  $.widget.bridge('uibutton', $.ui.button)
</script>
<!-- Bootstrap 4 -->
<script src="<c:url value='/template/plugins/bootstrap/js/bootstrap.bundle.min.js'/>"></script>
<!-- ChartJS -->
<script src="<c:url value='/template/plugins/chart.js/Chart.min.js'/>"></script>
<!-- Sparkline -->
<script src="<c:url value='/template/plugins/sparklines/sparkline.js'/>"></script>
<!-- JQVMap -->
<script src="<c:url value='/template/plugins/jqvmap/jquery.vmap.min.js'/>"></script>
<script src="<c:url value='/template/plugins/jqvmap/maps/jquery.vmap.usa.js'/>"></script>
<!-- jQuery Knob Chart -->
<script src="<c:url value='/template/plugins/jquery-knob/jquery.knob.min.js'/>"></script>
<!-- daterangepicker -->
<script src="<c:url value='/template/plugins/moment/moment.min.js'/>"></script>
<script src="<c:url value='/template/plugins/daterangepicker/daterangepicker.js'/>"></script>
<!-- Tempusdominus Bootstrap 4 -->
<script src="<c:url value='/template/plugins/tempusdominus-bootstrap-4/js/tempusdominus-bootstrap-4.min.js'/>"></script>
<!-- Summernote -->
<script src="<c:url value='/template/plugins/summernote/summernote-bs4.min.js'/>"></script>
<!-- overlayScrollbars -->
<script src="<c:url value='/template/plugins/overlayScrollbars/js/jquery.overlayScrollbars.min.js'/>"></script>
<!-- AdminLTE App -->
<script src="<c:url value='/template/dist/js/adminlte.js'/>"></script>
<!-- AdminLTE for demo purposes -->
<script src="<c:url value='/template/dist/js/demo.js'/>"></script>
<!-- AdminLTE dashboard demo (This is only for demo purposes) -->
<script src="<c:url value='/template/dist/js/pages/dashboard.js'/>"></script>
</body>
</html>
