<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<jsp:include page="header.jsp"></jsp:include>
<body>
<jsp:include page="menu.jsp"></jsp:include>

<div align="center">
	<h1>Khách Hàng</h1>   
    </div>
    <br>
    <div style="margin: 0 1em">
    	<div align= center>
    		<a href="newKhachHang" class="btn btn-primary btn-sm">Thêm khách hàng</a>
    	</div>
    	<br>
    	<table class="table table-bordered">
 			<tr>
	            <th>Name</th>
	            <th>Email</th>
	            <th>Address</th>
	            <th>Telephone</th>
	            <th>Action</th>
 			</tr>
            <c:forEach var="khachHang" items="${listKhachHang}">
                <tr>
 
                    <td>${khachHang.getHoTen()}</td>
                    <td>${khachHang.getDiaChi()}</td>
                    <td>${khachHang.getSoDienThoai()}</td>
                    <td>${khachHang.getEmail()}</td>
                    <td>
                    	<a href="editKhachHang?id=${khachHang.id}" class="btn btn-primary btn-sm">Edit</a>
                        <a href="deleteKhachHang?id=${khachHang.id}" class="btn btn-primary btn-sm">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
 	
	<jsp:include page="HaiTheDiv.jsp"></jsp:include>
</body>
<jsp:include page="footer.jsp"></jsp:include>
</html>