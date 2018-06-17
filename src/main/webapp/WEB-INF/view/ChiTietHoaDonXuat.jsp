
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
<a href="../hoadonxuat/home" class="btn btn-default col-sm-offset-1" role="button">Trở về</a>
<br>
<div align="center">
        <h3 >Chi tiết Hóa Đơn Xuất</h3>
        
        
</div>
<form:form modelAttribute="hoadonxuat" class="form-horizontal col-sm-10 col-sm-offset-1">
        <div class="form-group">
                <label class="control-label col-sm-2"> Tên Khách Hàng:</label>
                <div class="col-sm-8">
                	<label  class="control-label" >${hoadonxuat.getTenKhachHang()}<label>
                </div>
         </div>
         <div class="form-group">
                <label class="control-label col-sm-2">Ngày Bán:</label>
                <div class="col-sm-8" >
                	<label class="control-label" style="text-align: left;">${hoadonxuat.getNgayBan()}</label>
                </div>
          </div>
          
          <div class="form-group">
                <label class="control-label col-sm-2">Tổng Tiền:</label>
                <div class="col-sm-8" >
                	<label class="control-label" style="text-align: left;">${hoadonxuat.getTongTien()}</label>
                </div>
          </div>
          
          
          <div class="form-group">
                <label class="control-label col-sm-2">Sách:</label>
                <div class="col-sm-8" >
                	
		           <table class="table table-bordered">
		 			<tr>
		 			 	<th>Tên Sách</th>
			            <th>Số Lượng</th>
		 			</tr>
		            <c:forEach var="sach" items="${hoadonxuat.getGetSach()}">
		                <tr>
		      				<td>${sach.getTenSach()}</td>
		                    <td>${sach.getSoLuong()}</td>
		                </tr>
		            </c:forEach>
		        </table>
                </div>
          </div>
          
          
</form:form>
 
 <jsp:include page="HaiTheDiv.jsp"></jsp:include>
</body>
<jsp:include page="footer.jsp"></jsp:include>

</html>