<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sửa Màu Sắc</title>
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
        <form:form action="/mau-sac/edit" method="POST" modelAttribute="dongSp">
            <div class="mb-3">
                <label class="form-label">ID</label>
                <form:input path="id" class="form-control" readonly="true"/>
            </div>
            <div class="mb-3">
                <label class="form-label">Mã</label>
                <form:input path="ma" class="form-control"/>
                <form:errors path="ma" cssStyle="color: red"/>
            </div>
            <div class="mb-3">
                <label class="form-label">Dòng Sản Phẩm</label>
                <form:input path="ten" class="form-control"/>
                <form:errors path="ten" cssStyle="color: red"/>
            </div>
            <form:button type="submit" class="btn btn-primary">Sửa</form:button>
        </form:form>
    </div>
</div>
</body>
</html>
