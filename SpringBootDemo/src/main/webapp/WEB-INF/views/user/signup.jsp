<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
	        
            <!-- Start Contact -->
    <div class="container py-5">
        <div class="row py-5">
        <c:if test="${message != null && message != ''}">
	      		<span class="text-success">${message }</span>
	      	</c:if>
            <form:form modelAttribute="customer" action="/signup" class="col-md-9 m-auto" method="post" role="form">
                <div class="row">
                    <div class="form-group col-md-6 mb-3">
                        <label for="inputname">Name</label>
                        <form:input path="customerName" type="text" class="form-control mt-1" placeholder="Name"/>
                        <form:errors path="customerName" class="form-text text-danger mb-3"/>
                    </div>
                    <div class="form-group col-md-6 mb-3">
                        <label for="inputemail">Email</label>
                        <form:input path="customerEmail" type="email" class="form-control mt-1"  placeholder="Email"/>
                        <form:errors path="customerEmail" class="form-text text-danger mb-3"/>
                    </div>
                </div>
                <div class="mb-3">
                    <label for="inputsubject">Password</label>
                    <form:input path="customerPassword" type="password" class="form-control mt-1"   placeholder="Password"/>
                    <form:errors path="customerPassword" class="form-text text-danger mb-3"/>
                </div>
                <div class="mb-3">
                    <label for="inputsubject">Phone</label>
                    <form:input path="customerPhone" type="text" class="form-control mt-1"  placeholder="Phone"/>
                    <form:errors path="customerPhone" class="form-text text-danger mb-3"/>
                </div>
                <div class="mb-3">
	                  <form:radiobutton path="sex" id="html"  value="1"/>
					  <label for="html">Nam</label><br>
					  <form:radiobutton path="sex" id="css"  value="0"/>
					  <label for="css">Nữ</label><br>
				</div>
                <div class="mb-3">
                    <label for="inputmessage">Address</label>
                    <form:textarea path="customerAddress" class="form-control mt-1" id="message" name="message" placeholder="Message" rows="5"/>
                    <form:errors path="customerAddress" class="form-text text-danger mb-3"/>
                </div>
                <div class="row">
                    <div class="col text-end mt-2">
                        <button type="submit" class="btn btn-success btn-lg px-3">SignUp</button>
                    </div>
                </div>
            </form:form>
        </div>
    </div>
    <!-- End Contact -->
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