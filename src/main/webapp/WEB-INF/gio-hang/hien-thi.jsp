<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Giỏ Hàng</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        /* Tạo lớp CSS tùy chỉnh */
        .card {
            margin-top: 40px; /* Căn chỉnh margin top là 10px */
        }

        .col-md-6 img {
            margin-top: 30px;
        }
    </style>
</head>
<body>
<div class="container center-content">
    <div class="card">
        <div class="row">
            <div class="col-md-6">
                <div class="card-body">
                    <form action="/gio-hang-chi-tiet/add"
                          method="POST">
                        <h5 class="card-title">${chiTietSP.idSP.ten}</h5>
                        <p class="card-title">Số Lượng: <strong>${chiTietSP.soLuongTon}</strong></p>
                        <p class="card-text">Mô Tả: <strong>${chiTietSP.moTa}</strong></p>
                        <p class="card-text">Nhà Sản Xuất: <strong>${chiTietSP.idNsx.ten}</strong></p>
                        <p class="card-text">Màu: <strong>${chiTietSP.idMauSac.ten}</strong></p>
                        <p class="card-text">Dòng Sản Phẩm: <strong>${chiTietSP.idDongSP.ten}</strong></p>
                        <fmt:formatNumber var="giaBan" pattern="#,###" value="${chiTietSP.giaBan}"></fmt:formatNumber>
                        <p class="card-text">Giá:
                            <del>${giaBan} Đồng</del>
                        </p>
                        <p class="card-text">Số lượng: <input type="number" id="quantity" name="soLuongMua" value="1"
                                                              min="0"
                                                              max="${chiTietSP.soLuongTon}"></p>
                        <input type="hidden" name="giaBan" value="${chiTietSP.giaBan}">
                        <input type="hidden" name="idChiTietSanPham" value="${chiTietSP.id}">
                        <a href="/home" class="btn btn-primary">Hủy</a>
                        <input type="submit" value="Thêm Vào Giỏ Hàng" class="btn btn-success">
                    </form>
                </div>
            </div>
            <div class="col-md-6 img">
                <img src="https://tcorder.vn/wp-content/uploads/2020/09/noi-chien-khong-dau-lock-lock.jpg"
                     class="card-img-top" alt="Product Image" style="height: 300px; width: 280px">
            </div>
        </div>
    </div>
</div>
</body>
</html>
