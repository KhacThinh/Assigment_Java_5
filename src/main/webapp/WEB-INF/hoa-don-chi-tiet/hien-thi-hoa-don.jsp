<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Hóa Đơn</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">

</head>
<body>
<h1>HÓA ĐƠN THANH TOÁN</h1>
<h3>Thông Tin Hóa Đơn</h3>
<p>ID: <strong>${hoaDon.id}</strong></p>
<fmt:formatDate value="${hoaDon.ngayTao}" var="ngayTao" pattern="yyyy-MM-dd HH:mm"></fmt:formatDate>
<p>Ngày tạo: <strong>${ngayTao}</strong></p>
<p>Tên Khách Hàng: <strong>${hoaDon.khachHang.ho} ${hoaDon.khachHang.tenDem} ${hoaDon.khachHang.ten}</strong></p>
<p>Nhân Viên: <strong>${hoaDon.nhanVien.ho} ${hoaDon.nhanVien.tenDem} ${hoaDon.nhanVien.ten}</strong></p>
<p>Tên Người Nhận: <strong>${hoaDon.tenNguoiNhan}</strong></p>
<p>Số Điện Thoại: <strong>${hoaDon.sdt}</strong></p>
<p>Địa Chỉ: <strong>${hoaDon.diaChi}</strong></p>

<h3>Chi Tiết Hóa Đơn</h3>
<table class="table table-striped table-bordered">
    <tr>
        <th>STT</th>
        <th>Tên sản phẩm</th>
        <th>Số lượng</th>
        <th>Đơn giá</th>
        <th>Thành tiền</th>
    </tr>
    <c:forEach items="${hoaDonChiTiets}" var="hdct" varStatus="i">
        <tr>
            <td>${i.index + 1}</td>
            <td>${hdct.chiTietSanPham.idSP.ten}</td>
            <td>${hdct.soLuong}</td>
            <fmt:formatNumber pattern="#,###" var="donGia" value="${hdct.donGia}"></fmt:formatNumber>
            <td>${donGia}</td>
            <fmt:formatNumber pattern="#,###" var="thanhTien" value="${hdct.soLuong * hdct.donGia}"></fmt:formatNumber>
            <td>${thanhTien}</td>
        </tr>
    </c:forEach>
</table>
<a class="btn btn-primary" href="/home">Trở về Home</a>
</body>
</html>
