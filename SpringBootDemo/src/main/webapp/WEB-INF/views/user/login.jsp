<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

<head>
    <title>Zay Shop eCommerce HTML CSS Template</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link rel="apple-touch-icon" href="<c:url value='/assets/img/apple-icon.png'/>">
    <link rel="shortcut icon" type="image/x-icon" href="assets/img/favicon.ico">

    <link rel="stylesheet" href="<c:url value='/assets/css/bootstrap.min.css'/>">
    <link rel="stylesheet" href="<c:url value='/assets/css/templatemo.css'/>">
    <link rel="stylesheet" href="<c:url value='/assets/css/custom.css'/>">

    <!-- Load fonts style after rendering the layout styles -->
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Roboto:wght@100;200;300;400;500;700;900&display=swap">
    <link rel="stylesheet" href="<c:url value='/assets/css/fontawesome.min.css'/>">
	
	<!-- Login -->
	
	
</head>

<body>

    <jsp:include page="common/navbar.jsp"></jsp:include>



    <!-- Start Contact -->
    <div class="container py-5">
        <div class="row py-5">
	        <c:if test="${message != null && message != ''}">
	      		<span class="text-danger">${message }</span>
	      	</c:if>
            <form action="/login" class="col-md-9 m-auto" method="post" role="form">
                
                <div class="mb-3">
                    <label for="inputsubject">Email</label>
                    <input name="email" type="text" class="form-control mt-1" placeholder="Email..." value="${email }">
                </div>
                
                <div class="mb-3">
                    <label for="inputsubject">Password</label>
                    <input name="password" type="password" class="form-control mt-1" placeholder="Password..." value="${password }">
                </div>
                
                <div class="mb-3">
                    <input type="checkbox" checked="checked" name="remember"> Remember me
                </div>
                
                <div class="row">
                    <div class="col text-end mt-2">
                        <button type="submit" class="btn btn-success btn-lg px-3">Login</button>
                    </div>
                </div>
                
            </form>
        </div>
    </div>
    <!-- End Contact -->


    <jsp:include page="common/footer.jsp"></jsp:include>

    <!-- Start Script -->
    <script src="<c:url value='/assets/js/jquery-1.11.0.min.js'/>"></script>
    <script src="<c:url value='/assets/js/jquery-migrate-1.2.1.min.js'/>"></script>
    <script src="<c:url value='/assets/js/bootstrap.bundle.min.js'/>"></script>
    <script src="<c:url value='/assets/js/templatemo.js'/>"></script>
    <script src="<c:url value='/assets/js/custom.js'/>"></script>
    <!-- End Script -->
</body>

</html>