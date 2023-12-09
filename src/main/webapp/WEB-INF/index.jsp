<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Quản Lý Cửa Hàng</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"
            integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js"
            integrity="sha384-BBtl+eGJRgqQAUMxJ7pMwbEyER4l1g+O15P+16Ep7Q9Q+zqX6gSbd85u4mG4QzX+"
            crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.1/font/bootstrap-icons.css">
</head>
<body>
<jsp:include page="../WEB-INF/layout/header.jsp"></jsp:include>
<div class="container">
    <div class="row py-2">
        <div class="row md-3">
            <c:forEach items="${list}" var="chiTietSp">
                <div class="col-md-3">
                    <div class="card product-card">
                        <img src="https://tcorder.vn/wp-content/uploads/2020/09/noi-chien-khong-dau-lock-lock.jpg"
                             class="card-img-top" alt="...">
                        <div class="card-body">
                            <h5 class="card-title">${chiTietSp.idSP.ten}</h5>
                            <p class="product-color">Màu: ${chiTietSp.idMauSac.ten}</p>
                            <p class="product-line">Dòng sản phẩm: ${chiTietSp.idDongSP.ten}</p>
                            <p class="card-title">Số Lượng: ${chiTietSp.soLuongTon}</p>
                            <fmt:formatNumber value="${chiTietSp.giaBan}" pattern="#,###"
                                              var="giaBan"></fmt:formatNumber>
                            <p class="card-title">Giá: ${giaBan}</p>
                            <fmt:formatNumber value="${chiTietSp.giaBan - (chiTietSp.giaBan * 0.1)}" pattern="#,###"
                                              var="giaGiam"></fmt:formatNumber>
                            <p class="card-title">Giảm 10% chỉ còn: ${giaGiam}</p>
                            <p class="card-text">Mô Tả: ${chiTietSp.moTa}</p>
                            <fmt:formatNumber var="gia" pattern="###"
                                              value="${chiTietSp.giaBan - (chiTietSp.giaBan * 0.1)}"></fmt:formatNumber>

                            <form action="/gio-hang-chi-tiet" method="POST">
                                <input type="hidden" name="idCTSP" value="${chiTietSp.id}">
                                <input type="hidden" name="giaGiam" value="${gia}">
                                <input type="submit" class="btn btn-primary" value="Add to cart">
                            </form>

                            <form action="/thanh-toan" method="POST">
                                <input type="hidden" name="idCTSP" value="${chiTietSp.id}">
                                <input type="hidden" name="gia" value="${gia}">
                                <input type="submit" class="btn btn-primary" value="Buy Now">
                            </form>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
    <nav aria-label="...">
        <ul class="pagination pagination-lg">
            <c:forEach var="i" begin="1" end="${endPage}">
                <li class="page-item">
                    <a class="page-link" href="/home?paing=${i}">${i}</a></li>
            </c:forEach>
        </ul>
    </nav>
</div>
<jsp:include page="../WEB-INF/layout/footer.jsp"></jsp:include>
</body>
</html>
