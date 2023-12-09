<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Nhân Viên</title>
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
    <h1>Thêm Nhân Viên</h1>
    <div class="row py-2">
        <form:form action="/nhan-vien" method="POST" modelAttribute="nhanVien">
            <div class="md-3">
                <label class="form-label">Mã</label>
                <form:input path="ma" class="form-control"/>
                <form:errors path="ma" cssClass="text-danger"/>
            </div>
            <div class="row mb-3">
                <div class="col-md-4">
                    <label class="form-label">Họ</label>
                    <form:input path="ho" class="form-control"/>
                    <form:errors path="ho" cssClass="text-danger"/>
                </div>
                <div class="col-md-4">
                    <label class="form-label">Tên đệm</label>
                    <form:input path="tenDem" class="form-control"/>
                </div>
                <div class="col-md-4">
                    <label class="form-label">Tên</label>
                    <form:input path="ten" class="form-control"/>
                    <form:errors path="ten" cssClass="text-danger"/>
                </div>
            </div>
            <div class="row mb-3">
                <div class="col-md-6">
                    <label class="form-label">Ngày sinh</label>
                    <form:input path="ngaySinh" class="form-control" placeholder="dd-MM-yyyy"/>
                    <form:errors path="ngaySinh" cssClass="text-danger"/>
                </div>
                <div class="col-md-6">
                    <label class="form-label">Số điện thoại</label>
                    <form:input path="sdt" class="form-control" placeholder="0..."/>
                    <form:errors path="sdt" cssClass="text-danger"/>
                </div>
            </div>

            <div class="input-group mb-3">
                <div class="form-check form-check-inline">
                    <form:radiobutton path="gioiTinh" id="inlineRadio1" value="true" checked="true"/>
                    <label class="form-check-label text-secondary" for="inlineRadio1">Nam</label>
                </div>
                <div class="form-check form-check-inline">
                    <form:radiobutton path="gioiTinh" id="inlineRadio2" value="false"/>
                    <label class="form-check-label text-secondary" for="inlineRadio2">Nữ</label>
                </div>
            </div>
            <div class="row mb-3">
                <div class="col-md-6">
                    <label class="form-label">Địa chỉ</label>
                    <form:input path="diaChi" class="form-control"/>
                    <form:errors path="diaChi" cssClass="text-danger"/>
                </div>
                <div class="col-md-6">
                    <label class="form-label">Mật khẩu</label>
                    <form:password path="matKhau" class="form-control" minlength="6"/>
                    <form:errors path="matKhau" cssClass="text-danger"/>
                </div>
            </div>
            <div class="row mb-3">
                <div class="col-md-4">
                    <form:select path="idCV" class="form-select" >
                        <form:option value="" label="Chọn Chức Vụ"/>
                        <form:options items="${chucVus}" itemValue="id" itemLabel="ten"/>
                    </form:select>
                </div>
                <div class="col-md-1">
                    <a href="/san-pham" class="btn btn-primary btn-lg"><i
                            class="bi bi-plus-circle"></i></a>
                </div>
                <div class="col-md-4">
                    <form:select path="idCH" class="form-select">
                        <form:option value="" label="Chọn Cửa Hàng"/>
                        <form:options items="${cuaHangs}" itemValue="id" itemLabel="ten"/>
                    </form:select>
                </div>
                <div class="col-md-3">
                    <form:select path="idGuiBC" class="form-select">
                        <form:option value="" label="Chọn Gửi BC"/>
                        <form:options items="${guiBCs}" itemValue="ma" itemLabel="ten"/>
                    </form:select>
                </div>
            </div>

            <a href="/nhan-vien" class="btn btn-secondary"><i
                    class="bi bi-backspace"></i> Hủy</a>
            <form:button type="submit" class="btn btn-primary">Create</form:button>
        </form:form>
    </div>
</div>
</body>
</html>