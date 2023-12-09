<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Chức Vụ</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">
</head>
<body>
<div class="container">
    <div class="row py-2">
        <form:form action="/chuc-vu" method="POST" modelAttribute="chucVu">
            <div class="mb-3">
                <label class="form-label">Mã</label>
                <form:input path="ma" class="form-control"/>
                <form:errors path="ma" cssStyle="color: red"/>
            </div>
            <div class="mb-3">
                <label class="form-label">Chức Vụ</label>
                <form:input path="ten" class="form-control"/>
                <form:errors path="ten" cssStyle="color: red"/>
            </div>
            </table>
            <a href="/nhan-vien" class="btn btn-primary"><i
                    class="bi bi-house-down-fill"></i> Home</a>
            <form:button type="submit" class="btn btn-primary">Thêm</form:button>
        </form:form>
    </div>
    <div class="row py-2">
        <form class="d-flex" role="search" action="/chuc-vu/search" method="post">
            <input class="form-control me-2" name="ten" type="search" placeholder="Search Name Or Mã"
                   aria-label="Search" value="${searchName}">
            <button class="btn btn-outline-success" type="submit">Search</button>
        </form>
        <span style="color: red">${thongBao}</span>
    </div>
    <table class="table table-striped table-hover">
        <thead>
        <tr>
            <th scope="col">STT</th>
            <th scope="col">ID</th>
            <th scope="col">Mã Chức Vụ</th>
            <th scope="col">Tên Chức Vụ</th>
<%--            <th scope="col">Số Lượng</th>--%>
            <th scope="col">Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="chucVu" items="${chucVus}" varStatus="i">
            <tr>
                <th scope="row">${i.index}</th>
                <td>${chucVu.id}</td>
                <td>${chucVu.ma}</td>
                <td>${chucVu.ten}</td>
<%--                <td>${chucVu.list.size()}</td>--%>
                <td><a href="/chuc-vu/view-update/${chucVu.id}"
                       class="btn btn-outline-warning"><i
                        class="bi bi-pencil"></i> Edit</a></td>
            </tr>
        </c:forEach>
        </tbody>
</div>

<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"
        integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.min.js"
        integrity="sha384-fbbOQedDUMZZ5KreZpsbe1LCZPVmfTnH7ois6mU1QK+m14rQ1l2bGBq41eYeM/fS"
        crossorigin="anonymous"></script>
</body>
</html>
