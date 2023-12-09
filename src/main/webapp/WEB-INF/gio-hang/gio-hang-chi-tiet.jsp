<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Giỏ Hàng</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">

</head>
<body>
<jsp:include page="../layout/header.jsp"></jsp:include>
<form action="/hoa-don-chi-tiet/addList" method="post">
    <table class="table table-striped table-hover">
        <thead>
        <tr>
            <th scope="col"></th>
            <th scope="col">STT</th>
            <th scope="col">Mã SP</th>
            <th scope="col">Tên Sản Phẩm</th>
            <th scope="col">Màu Sắc</th>
            <th scope="col">Số Lượng</th>
            <th scope="col">Giá</th>
<%--            <th scope="col">Tổng Giá</th>--%>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${listGHCT}" var="ghct" varStatus="i">
            <tr>
                <td><input type="checkbox" class="form-check-input" name="idSanPhamMua"
                           value="${ghct.id}"/></td>
                <th>${i.index + 1}</th>
                <th>${ghct.chiTietSP.idSP.ma}</th>
                <th>${ghct.chiTietSP.idSP.ten}</th>
                <th>${ghct.chiTietSP.idMauSac.ten}</th>
                <td>${ghct.soLuong}</td>
                <td>${ghct.chiTietSP.giaBan}</td>
<%--                <td>${ghct.donGiaKhiGiam}</td>--%>
<%--                <td><input type="hidden" name="soLuongSanPham" value="${ghct.soLuong}"/></td>--%>
                <td><a href="/gio-hang-chi-tiet/delete/${ghct.id}" class="btn btn-outline-warning"><i class="bi bi-trash3"></i></a></td>
            </tr>
        </c:forEach>
        <tr>
        </tr>
        </tbody>
    </table>
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

<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"
        integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.min.js"
        integrity="sha384-fbbOQedDUMZZ5KreZpsbe1LCZPVmfTnH7ois6mU1QK+m14rQ1l2bGBq41eYeM/fS"
        crossorigin="anonymous"></script>
</body>
</html>
