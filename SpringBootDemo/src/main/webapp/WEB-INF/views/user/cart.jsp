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

</head>

<body>

    <jsp:include page="common/navbar.jsp"></jsp:include>

	<jsp:include page="common/carousel.jsp"></jsp:include>

	<div class="container-fluid pt-5">
	<c:if test="${message != null && message != ''}">
      		<span class="text-success">${message }</span>
      	</c:if>
        <div class="row px-xl-5">
            <div class="col-lg-8 table-responsive mb-5">
                <table class="table table-bordered text-center mb-0">
                    <thead class="bg-secondary text-dark">
                        <tr>
                            <th>Products</th>
                            <th>Price</th>
                            <th>Quantity</th>
                            <th>Total</th>
                            <th>Size</th>
                            <th>Color</th>
                            <th>Remove</th>
                        </tr>
                    </thead>
                    <tbody class="align-middle">
                    	<c:forEach var="line"  items="${cart.cartLines }">
                        <tr>
                            <td class="align-middle"><img src="/images/${line.product.productPhoto}" alt="" style="width: 50px;"> ${line.product.productName}</td>
                            <td class="align-middle">$${line.product.productPrice * (1-line.product.productDiscount)}</td>
                            <td class="align-middle">
	                            <ul>
	                                	<li class="list-inline-item">
	                                		<a href="/cart/decreaseQuantity/${line.product.productId}" class="btn btn-success" id="">-</a>
	                                	</li>
	                                    <li class="list-inline-item"><span class="badge bg-secondary" >${line.cartQuantity}</span></li>
	                                    <li class="list-inline-item">
	                                		<a href="/cart/increaseQuantity/${line.product.productId}" class="btn btn-success" id="">+</a>
	                                	</li>
	                            </ul>
                            </td>
                            <td class="align-middle">$${line.product.productPrice * (1-line.product.productDiscount) * line.cartQuantity}</td>
                            <td class="align-middle">${line.cartSize}</td>
                            <td class="align-middle">${line.cartColor}</td>
                            <td class="align-middle"><a href="/cart/deleteLine/${line.product.productId}" class="btn btn-sm btn-primary"><i class="fa fa-times"></i></a></td>
                        </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
            <div class="col-lg-4">
                
                <div class="card border-secondary mb-5">
                    <div class="card-header bg-secondary border-0">
                        <h4 class="font-weight-semi-bold m-0">Cart Summary</h4>
                    </div>
                    <div class="card-body">
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
                        <a href="/order/checkout" class="btn btn-block btn-primary my-3 py-3">Proceed To Checkout</a>
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