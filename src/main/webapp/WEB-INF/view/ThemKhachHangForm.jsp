
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
        <h3 id="idTieuDe">Thêm/sửa khách hàng</h3>
        <form:form action="saveKhachHang" method="post" modelAttribute="KhachHang" class="form-horizontal col-sm-10 col-sm-offset-1">
        
        <div class="form-group">
            <form:hidden path="id" id="idKhachHang"/>
            <label class="control-label col-sm-2">Tên:</label>
            <div class="col-sm-10">
            	<form:input path="HoTen" class="form-control" />
            </div>
            
        </div>
        <div class="form-group">
            <label class="control-label col-sm-2">Email:</label>
            <div class="col-sm-10">
                <form:input path="Email" class="form-control" />
            </div>
        </div>
        
        <div class="form-group">
            <label class="control-label col-sm-2">Địa chỉ:</label>
            <div class="col-sm-10">
               <form:input path="DiaChi" class="form-control" />
            </div>
        </div>
        
        <div class="form-group">
            <label class="control-label col-sm-2">SĐT: </label>
            <div class="col-sm-10">
            	<form:input path="SoDienThoai" class="form-control" />
            </div>
        </div>
        
             
        	<div class="form-group"> 
	    		<div class="col-sm-offset-2 col-sm-10">            
	          		<button type="submit" class="btn btn-primary">Lưu</button>
	          	</div>
          	</div>
        
        </form:form>
        
    </div>
    
 <jsp:include page="HaiTheDiv.jsp"></jsp:include>
</body>
<jsp:include page="footer.jsp"></jsp:include>
<script type="text/javascript">
	$(document).ready(function(){
		var YesOrNo = $("#idKhachHang").val();
		if(YesOrNo!=0)
			{
				$("#idTieuDe").html("Chỉnh sửa Khách Hàng");
			}
		else
			{
			$("#idTieuDe").html("Thêm mới Khách Hàng");
			}
		});
</script>
</html>