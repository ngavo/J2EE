
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<jsp:include page="header.jsp"></jsp:include>
<body>
 
<jsp:include page="menu.jsp"></jsp:include>
<br>
<a href="./KhachHang" class="btn btn-default col-sm-offset-1" role="button">Trở về</a>
<br>
<div align="center">
        <h3 >Chi tiết Khách Hàng</h3>
        
        
</div>
<form:form modelAttribute="KhachHang" class="form-horizontal col-sm-10 col-sm-offset-1">
        <div class="form-group">
           		 <form:hidden path="id" id="idTacGia"/>
                <label class="control-label col-sm-2"> Tên Khách Hàng:</label>
                <div class="col-sm-8">
                	<label  class="control-label" >${KhachHang.getHoTen()}<label>
                </div>
         </div>
         <div class="form-group">
                <label class="control-label col-sm-2">Số điện thoại:</label>
                <div class="col-sm-8" >
                	<label class="control-label" style="text-align: left;">${KhachHang.getSoDienThoai()}</label>
                </div>
          </div>
          
          <div class="form-group">
                <label class="control-label col-sm-2">Địa Chỉ:</label>
                <div class="col-sm-8" >
                	<label class="control-label" style="text-align: left;">${KhachHang.getDiaChi()}</label>
                </div>
          </div>
          
          <div class="form-group">
                <label class="control-label col-sm-2">Email:</label>
                <div class="col-sm-8" >
                	<label class="control-label" style="text-align: left;">${KhachHang.getEmail()}</label>
                </div>
          </div>
          
          
</form:form>
 
 <jsp:include page="HaiTheDiv.jsp"></jsp:include>
</body>
<jsp:include page="footer.jsp"></jsp:include>

</html>