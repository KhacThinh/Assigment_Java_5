<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Giỏ Hàng</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"
            integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js"
            integrity="sha384-BBtl+eGJRgqQAUMxJ7pMwbEyER4l1g+O15P+16Ep7Q9Q+zqX6gSbd85u4mG4QzX+"
            crossorigin="anonymous"></script>
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
                    <form action="/hoa-don-chi-tiet"
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
                        <!-- Button trigger modal -->
                        <button type="button" class="btn btn-primary" data-bs-toggle="modal"
                                data-bs-target="#exampleModal">
                            Mua Ngay
                        </button>

                        <!-- Modal -->
                        <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel"
                             aria-hidden="true">
                            <div class="modal-dialog">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <h1 class="modal-title fs-5" id="exampleModalLabel">Thông Tin Người Nhận</h1>
                                        <button type="button" class="btn-close" data-bs-dismiss="modal"
                                                aria-label="Close"></button>
                                    </div>
                                    <div class="modal-body">
                                        <table class="table">
                                            <tr>
                                                <td><label class="form-label" for="tenNguoiNhan">Tên người nhận:</label></td>
                                                <td><input class="form-control" type="text" id="tenNguoiNhan" name="tenNguoiNhan" ></td>
                                            </tr>
                                            <tr>
                                                <td><label class="form-label" for="sdt">Số điện thoại:</label></td>
                                                <td><input type="number" id="sdt" name="sdt"  class="form-control" maxlength="10"></td>
                                            </tr>
                                            <tr>
                                                <td><label class="form-label" for="diaChi">Địa chỉ nhận:</label></td>
                                                <td><input class="form-control" type="text" id="diaChi" name="diaChi" ></td>
                                            </tr>
                                        </table>
                                    </div>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close
                                        </button>
                                        <button type="submit" class="btn btn-primary">Thanh Toán</button>
                                    </div>
                                </div>
                            </div>
                        </div>
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
