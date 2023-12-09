<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: khact
  Date: 06/07/2023
  Time: 2:48 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Khách Hàng</title>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"
            integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.min.js"
            integrity="sha384-fbbOQedDUMZZ5KreZpsbe1LCZPVmfTnH7ois6mU1QK+m14rQ1l2bGBq41eYeM/fS"
            crossorigin="anonymous"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">
</head>
<body>
<div class="container">
    <h1>Thêm Khách Hàng</h1>
    <div class="row py-2">
        <form:form modelAttribute="khachHang" method="post" action="/khach-hang/add">
            <div class="mb-3">
                <label class="form-label">Mã</label>
                <form:input path="ma" class="form-control"/>
                <form:errors path="ma" class="text-danger"/>
            </div>
            <div class="row mb-3">
                <div class="col-md-4">
                    <label class="form-label">Họ</label>
                    <form:input path="ho" class="form-control"/>
                    <form:errors path="ho" class="text-danger"/>
                </div>
                <div class="col-md-4">
                    <label class="form-label">Tên Đệm</label>
                    <form:input path="tenDem" class="form-control"/>
                    <form:errors path="tenDem" class="text-danger"/>
                </div>
                <div class="col-md-4">
                    <label class="form-label">Tên</label>
                    <form:input path="ten" class="form-control"/>
                    <form:errors path="ten" class="text-danger"/>
                </div>
            </div>
            <div class="row mb-3">
                <div class="col-md-6">
                    <label class="form-label">Ngày Sinh</label>
                    <form:input path="ngaySinh" class="form-control" placeholder="dd-MM-yyyy"/>
                    <form:errors path="ngaySinh" class="text-danger"/>
                </div>
                <div class="col-md-6">
                    <label class="form-label">PhoneNumber</label>
                    <form:input path="sdt" class="form-control"/>
                    <form:errors path="sdt" class="text-danger"/>
                </div>
            </div>
            <div class="row mb-3">
                <div class="col-md-4">
                    <label class="form-label">Địa Chỉ</label>
                    <form:input path="diaChi" class="form-control"/>
                    <form:errors path="diaChi" class="text-danger"/>
                </div>
                <div class="col-md-4">
                    <label class="form-label">Thành Phố</label>
                    <form:input path="thanhPho" class="form-control"/>
                    <form:errors path="thanhPho" class="text-danger"/>
                </div>
                <div class="col-md-4">
                    <label class="form-label">Quốc Gia</label>
                    <form:input path="quocGia" class="form-control"/>
                    <form:errors path="quocGia" class="text-danger"/>
                </div>
            </div>
            <div class="row mb-3">
                <div class="col-md-8">
                    <label class="form-label">Mật Khẩu</label>
                    <form:password path="matKhau" class="form-control" minlength="6"/>
                    <form:errors path="matKhau" class="text-danger"/>
                </div>
            </div>
            <a href="/khach-hang" class="btn btn-secondary"><i
                    class="bi bi-backspace"></i> Hủy</a>
            <form:button type="submit" class="btn btn-primary">Lưu Khách Hàng</form:button>
        </form:form>
    </div>
</div>
</body>
</html>
