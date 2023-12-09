<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<nav class="navbar navbar-expand-lg bg-body-tertiary">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">Khắc Thịnh</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="/home">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="/hoa-don-chi-tiet/history">Lịch Sử Hóa Đơn</a>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown"
                       aria-expanded="false">
                        Quản Lý
                    </a>
                    <ul class="dropdown-menu">
                        <li><a class="dropdown-item" href="/cua-hang">Cửa Hàng</a></li>
                        <li><a class="dropdown-item" href="/khach-hang">Khách Hàng</a></li>
                        <li><a class="dropdown-item" href="/nhan-vien">Nhân Viên</a></li>
                        <li><a class="dropdown-item" href="/chi-tiet-san-pham">Chi Tiết Sản Phẩm</a></li>
                        <li>
                            <hr class="dropdown-divider">
                        </li>
                        <li><a class="dropdown-item" href="#">Đăng Xuất</a></li>
                    </ul>
                </li>
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="/gio-hang-chi-tiet"><i class="bi bi-cart2"></i></a>
                </li>
            </ul>
            <form class="d-flex" role="search" action="/home/search" method="post">
                <input class="form-control me-2" name="tenSanPham" type="search" placeholder="Search"
                       aria-label="Search" value="${tenSanPham}">
                <button class="btn btn-outline-success" type="submit">Search</button>
            </form>
            <%--            <a href="https://accounts.google.com/o/oauth2/auth?scope=email&redirect_uri=http://localhost:8080/StoreManager_war_exploded/login-google&response_type=code--%>
            <%--    &client_id=1008526930092-lq6dqlrkp245v4m9fanfmehq4b22tkdn.apps.googleusercontent.com&approval_prompt=force"--%>
            <%--               class="btn btn-primary d-flex"><img--%>
            <%--                    src="https://cdn1.iconfinder.com/data/icons/google-s-logo/150/Google_Icons-09-512.png"--%>
            <%--                    style="width: 25px"> Login Google</a>--%>
        </div>
    </div>
</nav>
