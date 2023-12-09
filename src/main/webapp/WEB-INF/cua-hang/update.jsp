<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <title>Sửa Cửa Hàng</title>
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
    <div class="row py-2">
        <form:form action="/cua-hang/update" method="POST" modelAttribute="cuaHang">
            <div class="mb-3">
                <label class="form-label">Id</label>
                <form:input path="id" class="form-control" readonly="true"/>
            </div>
            <div class="mb-3">
                <label class="form-label">Mã</label>
                <form:input path="ma" class="form-control" readonly="true"/>
                <form:errors path="ma" cssClass="text-danger"/>
            </div>
            <div class="mb-3">
                <label class="form-label">Tên Cửa Hàng</label>
                <form:input path="ten" class="form-control"/>
                <form:errors path="ten" cssClass="text-danger"/>
            </div>
            <div class="mb-3">
                <label class="form-label">Địa Chỉ</label>
                <form:input path="diaChi" class="form-control"/>
                <form:errors path="diaChi" cssClass="text-danger"/>
            </div>
            <div class="mb-3">
                <label class="form-label">Thành Phố</label>
                <form:input path="thanhPho" class="form-control"/>
                <form:errors path="thanhPho" cssClass="text-danger"/>
            </div>
            <div class="mb-3">
                <label class="form-label">Quốc Gia</label>
                <form:input path="quocGia" class="form-control"/>
                <form:errors path="quocGia" cssClass="text-danger"/>
            </div>
            <a href="/cua-hang" class="btn btn-secondary"><i
                    class="bi bi-backspace"></i> Hủy</a>
            <form:button type="submit" class="btn btn-primary">Edit</form:button>
        </form:form>
    </div>
</div>
</body>
</html>
