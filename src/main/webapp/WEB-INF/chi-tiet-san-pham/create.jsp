<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: khact
  Date: 17/07/2023
  Time: 2:36 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Thêm Sản Phẩm</title>
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
    <h1>Thêm Chi Tiet San Pham</h1>
    <div class="row py-2">
        <form:form modelAttribute="chiTietSanPham" action="/chi-tiet-san-pham" method="POST">
            <div class="row md-3">
                <div class="col-md-5">
                    <form:select path="idSP" class="form-select" required="true">
                        <form:option value="" label="Chọn Tên SP"/>
                        <form:options items="${sanPhams}" itemValue="id" itemLabel="ten"/>
                    </form:select>
                </div>
                <div class="col-md-1">
                    <a href="/san-pham" class="btn btn-primary btn-lg"><i
                            class="bi bi-plus-circle"></i></a>
                </div>
                <div class="col-md-5">
                    <div class="form-group">
                        <form:select path="idNsx" class="form-select" required="true">
                            <form:option value="" label="Chọn Nhà Sản Xuất"/>
                            <form:options items="${nsxs}" itemValue="id" itemLabel="ten"/>
                        </form:select>
                    </div>
                </div>
                <div class="col-md-1">
                    <a href="/nsx" class="btn btn-primary btn-lg"><i
                            class="bi bi-plus-circle"></i></a>
                </div>
            </div>
            <div class="row mb-3 my-3">
                <div class="col-md-5">
                    <div class="form-group">
                        <form:select path="idMauSac" class="form-select" required="true">
                            <form:option value="" label="Chọn Màu Sắc"/>
                            <form:options items="${mauSacs}" itemValue="id" itemLabel="ten"/>
                        </form:select>
                    </div>
                </div>
                <div class="col-md-1">
                    <a href="/mau-sac" class="btn btn-primary btn-lg"><i
                            class="bi bi-plus-circle"></i></a>
                </div>
                <div class="col-md-5">
                    <div class="form-group">
                        <form:select path="idDongSP" class="form-select" required="true">
                            <form:option value="" label="Chọn Dòng Sản Phẩm"/>
                            <form:options items="${dongSps}" itemValue="id" itemLabel="ten"/>
                        </form:select>
                    </div>
                </div>
                <div class="col-md-1">
                    <a href="/dong-san-pham" class="btn btn-primary btn-lg"><i
                            class="bi bi-plus-circle"></i></a>
                </div>
            </div>
            <div class="row mb-3 my-3">
                <div class="col-md-4">
                    <form:label path="soLuongTon">Số Lượng Tồn Kho</form:label>
                    <form:input path="soLuongTon" class="form-control" type="number" min="0" required="true"/>
                    <form:errors path="soLuongTon" cssClass="text-danger"/>
                </div>
                <div class="col-md-4">
                    <form:label path="giaNhap">Giá Nhập</form:label>
                    <form:input path="giaNhap" class="form-control" type="number" min="0" required="true"/>
                    <form:errors path="giaNhap" cssClass="text-danger"/>
                </div>
                <div class="col-md-4">
                    <form:label path="giaBan">Giá Bán</form:label>
                    <form:input path="giaBan" class="form-control" type="number" min="0" required="true"/>
                    <form:errors path="giaBan" cssClass="text-danger"/>
                </div>
            </div>
            <div class="row mb-3">
                <div class="col-md-6">
                    <form:label path="namBH">Năm Bảo Hành</form:label>
                    <form:input path="namBH" class="form-control" type="number" min="0" required="true"/>
                    <form:errors path="namBH" cssClass="text-danger"/>
                </div>
                <div class="col-md-6">
                    <form:label path="moTa">Mô Tả</form:label>
                    <form:textarea path="moTa" class="form-control" rows="3" required="true"/>
                    <form:errors path="moTa" cssClass="text-danger"/>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12">
                    <a href="/chi-tiet-san-pham" class="btn btn-secondary"><i
                            class="bi bi-backspace"></i> Hủy</a>
                    <form:button type="submit" class="btn btn-primary">Create</form:button>
                </div>
            </div>
        </form:form>
    </div>
</div>
</body>
</html>
