<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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

</head>

<body>

    <jsp:include page="common/navbar.jsp"></jsp:include>

	<jsp:include page="common/carousel.jsp"></jsp:include>

	<div class="container-fluid pt-5">
	<c:if test="${message != null && message != ''}">
      		<span class="text-success">${message }</span>
      	</c:if>
        <div class="row px-xl-5">
            <div class="col-lg-8">
                <div class="mb-4">
                    <h4 class="font-weight-semi-bold mb-4">Billing Address</h4>
                    <div class="row">
                    <form:form modelAttribute="order" action="/order/checkout" method="post">
                        <div class="col-md-6 form-group">
                            <label>Full Name</label>
                            <form:input path="customerName" class="form-control" type="text" placeholder="John"/>
                            <form:errors path="customerName" class="form-text text-danger mb-3"/>
                        </div>
                        <div class="col-md-6 form-group">
                            <label>Mobile No</label>
                            <form:input path="customerPhone" class="form-control" type="text" placeholder="+123 456 789"/>
                            <form:errors path="customerPhone" class="form-text text-danger mb-3"/>
                        </div>
                        <div class="col-md-6 form-group">
                            <label>Address Line 1</label>
                            <form:input path="customerAddress" type="text" placeholder="123 Street"/>
                            <form:errors path="customerAddress" class="form-text text-danger mb-3"/>
                        </div>
                        <div class="card-footer border-secondary bg-transparent">
                        	<button type="submit" class="btn btn-lg btn-block btn-primary font-weight-bold my-3 py-3">Place Order</button>
                    	</div>
                    </form:form>
                    </div>
                </div>
                
            </div>
            <div class="col-lg-4">
                <div class="card border-secondary mb-5">
                    <div class="card-header bg-secondary border-0">
                        <h4 class="font-weight-semi-bold m-0">Order Total</h4>
                    </div>
                    <div class="card-body">
                        <h5 class="font-weight-medium mb-3">Products</h5>
                        <c:forEach var="line"  items="${cart.cartLines }">
                        <div class="d-flex justify-content-between">
                            <p>${line.product.productName}</p>
                            <p>$${line.product.productPrice * (1-line.product.productDiscount) * line.cartQuantity}</p>
                        </div>
                        </c:forEach>
                        <hr class="mt-0">
                        <div class="d-flex justify-content-between mb-3 pt-1">
                            <h6 class="font-weight-medium">Subtotal</h6>
                            <h6 class="font-weight-medium">$${cart.totalPrice() }</h6>
                        </div>
                        <div class="d-flex justify-content-between">
                            <h6 class="font-weight-medium">Shipping</h6>
                            <h6 class="font-weight-medium">$10</h6>
                        </div>
                    </div>
                    <div class="card-footer border-secondary bg-transparent">
                        <div class="d-flex justify-content-between mt-2">
                            <h5 class="font-weight-bold">Total</h5>
                            <h5 class="font-weight-bold">$${cart.totalPrice()  + 10}</h5>
                        </div>
                    </div>
                </div>
                
            </div>
        </div>
    </div>


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