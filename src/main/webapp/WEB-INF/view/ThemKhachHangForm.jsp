<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Thêm/sửa khách hàng</title>
</head>
<body>
<div align="center">
        <h1>Thêm/sửa khách hàng</h1>
        <form:form action="saveKhachHang" method="post" modelAttribute="KhachHang">
        
        <table>
            <form:hidden path="id"/>
            <tr>
                <td>Tên:</td>
                <td><form:input path="HoTen" /></td>
            </tr>
            <tr>
                <td>Email:</td>
                <td><form:input path="Email" /></td>
            </tr>
            <tr>
                <td>Địa chỉ:</td>
                <td><form:input path="DiaChi" /></td>
            </tr>
            <tr>
                <td>SĐT: </td>
                <td><form:input path="SoDienThoai" /></td>
            </tr>
            <tr>
                <td colspan="2" align="center"><input type="submit" value="Save"></td>
            </tr>
        </table>
        </form:form>
        
    </div>
    
</body>
</html>