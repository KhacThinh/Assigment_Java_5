<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Hóa Đơn</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"
            integrity="sha384-I7E8VVD/ismYTF4hNIPjV/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js"
            integrity="sha384-BBtl+eGJRgqQAUMxJ7pMwbEyER4l1g+O15P+16Ep7Q9Q+zqX6gSbd85u4mG4QzX+"
            crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.1/font/bootstrap-icons.css">
</head>
<body>
<jsp:include page="../layout/header.jsp"></jsp:include>
<div class="container">
    <h3>Lịch Sử Hóa Đơn</h3>
    <table class="table table-striped table-bordered">
        <tr>
            <th>STT</th>
            <th>ID Hóa Đơn</th>
            <th>Nhân Viên</th>
            <th>Ngày Tạo</th>
            <th>Thành tiền</th>
            <th>Chi Tiết</th>
        </tr>
        <c:forEach items="${hoaDons}" var="hd" varStatus="i">
            <tr>
                <th>${i.index + 1}</th>
                <td>${hd.id}</td>
                <td>${hd.nhanVien.ho} ${hd.nhanVien.tenDem} ${hd.nhanVien.ten}</td>
                <fmt:formatDate value="${hd.ngayTao}" var="ngayTao" pattern="HH:mm:ss dd-MM-yyyy"/>
                <td>${ngayTao}</td>
                <c:set var="total" value="0"/>
                <c:forEach items="${hd.chiTietHoaDon}" var="hdct">
                    <c:set var="total" value="${total +(hdct.soLuong*hdct.donGia)}"/>
                </c:forEach>
                <fmt:formatNumber pattern="#,###" var="abcd" value="${total}"></fmt:formatNumber>
                <td>${abcd}</td>
                <td>
                    <button type="button" class="btn btn-primary" data-bs-toggle="modal"
                            data-bs-target="#exampleModal${i.index}">
                        Chi Tiết
                    </button>
                    <div class="modal fade modal-lg" id="exampleModal${i.index}" tabindex="-1"
                         aria-labelledby="exampleModalLabel"
                         aria-hidden="true">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h1 class="modal-title fs-5" id="exampleModalLabel">Hóa Đơn Chi Tiết</h1>
                                    <button type="button" class="btn-close" data-bs-dismiss="modal"
                                            aria-label="Close"></button>
                                </div>
                                <div class="modal-body">
                                    <table class="table table-striped">
                                        <tr>
                                            <th>STT</th>
                                            <th>Tên Sản Phẩm</th>
                                            <th>Màu Sắc</th>
                                            <th>Dòng Sản Phẩm</th>
                                            <th>Xuất xứ</th>
                                            <th>Số Lượng</th>
                                            <th>Đơn Giá</th>
                                            <th>Thành Tiền</th>
                                        </tr>
                                        <c:forEach items="${hd.chiTietHoaDon}" var="hdct" varStatus="j">
                                            <tr>
                                                <th>${j.index + 1}</th>
                                                <td>${hdct.chiTietSanPham.idSP.ten}</td>
                                                <td>${hdct.chiTietSanPham.idMauSac.ten}</td>
                                                <td>${hdct.chiTietSanPham.idDongSP.ten}</td>
                                                <td>${hdct.chiTietSanPham.idNsx.ten}</td>
                                                <td>${hdct.soLuong}</td>
                                                <fmt:formatNumber pattern="#,###" var="donGia"
                                                                  value="${hdct.donGia}"></fmt:formatNumber>
                                                <td>${donGia}</td>
                                                <fmt:formatNumber pattern="#,###" var="thanhTien"
                                                                  value="${hdct.soLuong * hdct.donGia}"></fmt:formatNumber>
                                                <td>${thanhTien}</td>
                                            </tr>
                                        </c:forEach>
                                    </table>
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </td>
            </tr>
        </c:forEach>
    </table>
    <a class="btn btn-primary" href="/home">Trở về Home</a>
</div>
</body>
</html>
