<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Khách Hàng</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">
</head>
<body>
<jsp:include page="../layout/header.jsp"></jsp:include>
<div class="container">
    <div class="row py-5">
        <h5>Danh sách Khách Hàng</h5>
        <a href="/khach-hang/create" class="btn btn-primary"><i class="bi bi-person-add"></i>
            Thêm</a>
        <nav class="navbar bg-body-tertiary">
            <div class="container-fluid">
                <form class="d-flex" role="search" action="/khach-hang/search" method="post">
                    <input class="form-control me-2" name="ten" type="search" placeholder="Search Name"
                           aria-label="Search" value="${searchName}">
                    <button class="btn btn-outline-success" type="submit">Search</button>
                </form>
            </div>
            <span style="color: red">${thongBao}</span>
        </nav>
    </div>
</div>
<table class="table table-striped table-hover">
    <thead>
    <tr>
        <th scope="col">Id</th>
        <th scope="col">Mã</th>
        <th scope="col">Họ Và Tên</th>
        <th scope="col">Ngày Sinh</th>
        <th scope="col">Số Điện Thoại</th>
        <th scope="col">Địa Chỉ</th>
        <th scope="col">Thành Phố</th>
        <th scope="col">Quốc Gia</th>
        <th scope="col" colspan="2">Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="kh" items="${khachHangs}">
        <fmt:formatDate value="${kh.ngaySinh}" pattern="dd/MM/yyyy" var="birthday"></fmt:formatDate>
        <tr>
            <th scope="row">${kh.id}</th>
            <td>${kh.ma}</td>
            <td>${kh.ho} ${kh.tenDem} ${kh.ten} </td>
            <td>${birthday}</td>
            <td>${kh.sdt}</td>
            <td>${kh.diaChi}</td>
            <td>${kh.thanhPho}</td>
            <td>${kh.quocGia}</td>
            <td><a href="/khach-hang/edit/${kh.id}"
                   class="btn btn-outline-warning"><i class="bi bi-pencil"></i> Edit</a></td>
            <td><a href="/khach-hang/delete/${kh.id}"
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
                    <a class="page-link" href="/khach-hang?paing=${i}">${i}</a></li>
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
