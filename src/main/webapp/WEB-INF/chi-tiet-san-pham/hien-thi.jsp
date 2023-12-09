<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Chi-Tiet-SP</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">
</head>
<body>
<jsp:include page="../layout/header.jsp"></jsp:include>
<div class="container">
    <div class="row py-5">
        <h5>Danh sách Chi Tiết Sản Phẩm</h5>
        <a href="/chi-tiet-san-pham/create" class="btn btn-primary"><i
                class="bi bi-person-add"></i>
            Thêm</a>
    </div>
    <nav class="navbar bg-body-tertiary">
        <div class="container-fluid">
            <form class="d-flex" role="search" action="/chi-tiet-san-pham/search" method="post">
                <input class="form-control me-2" name="ten" type="search" placeholder="Search Name"
                       aria-label="Search" value="${searchName}">
                <button class="btn btn-outline-success" type="submit">Search</button>
            </form>
        </div>
        <span style="color: red">${thongBao}</span>
    </nav>
</div>
<table class="table table-bordered">
    <thead>
    <tr>
        <th>ID</th>
        <th>Sản phẩm</th>
        <th>Nhà sản xuất</th>
        <th>Màu sắc</th>
        <th>Dòng sản phẩm</th>
        <th>Bảo hành</th>
        <th>Số lượng tồn</th>
        <th>Giá nhập</th>
        <th>Giá bán</th>
        <th>Mô tả</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${chiTietSanPhams}" var="chiTietSp">
        <tr>
            <th>${chiTietSp.id}</th>
            <td>${chiTietSp.idSP.ten}</td>
            <td>${chiTietSp.idNsx.ten}</td>
            <td>${chiTietSp.idMauSac.ten}</td>
            <td>${chiTietSp.idDongSP.ten}</td>
            <td>${chiTietSp.namBH} Năm</td>
            <fmt:formatNumber pattern="#,###" value="${chiTietSp.soLuongTon}" var="soLuongTon"></fmt:formatNumber>
            <td>${soLuongTon}</td>
            <fmt:formatNumber pattern="#,###" value="${chiTietSp.giaNhap}" var="giaNhap"></fmt:formatNumber>
            <td>${giaNhap}</td>
            <fmt:formatNumber pattern="#,###" value="${chiTietSp.giaBan}" var="giaBan"></fmt:formatNumber>
            <td>${giaBan}</td>
            <td>${chiTietSp.moTa}</td>
            <td><a href="/chi-tiet-san-pham/edit/${chiTietSp.id}"
                   class="btn btn-outline-warning"><i class="bi bi-pencil"></i> Edit</a></td>
            <td><a href="/chi-tiet-san-pham/delete/${chiTietSp.id}"
                   class="btn btn-outline-danger"><i class="bi bi-trash3-fill"></i> Delete</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<div class="container">
    <nav aria-label="...">
        <ul class="pagination pagination-lg">
            <c:forEach var="i" begin="1" end="${endPage}">
                <li class="page-item">
                    <a class="page-link" href="/chi-tiet-san-pham?paing=${i}">${i}</a></li>
            </c:forEach>
        </ul>
    </nav>
</div>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"
        integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.min.js"
        integrity="sha384-fbbOQedDUMZZ5KreZpsbe1LCZPVmfTnH7ois6mU1QK+m14rQ1l2bGBq41eYeM/fS"
        crossorigin="anonymous"></script>
</body>
</html>
