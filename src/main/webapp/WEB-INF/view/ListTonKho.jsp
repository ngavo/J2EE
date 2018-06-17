<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%> --%>
    <%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<jsp:include page="header.jsp"></jsp:include>
<body>
<jsp:include page="menu.jsp"></jsp:include>

<div align="center">
	<h1>Danh Sách Sách Tồn Kho</h1>   
    </div>
    <br>
    
 	 
 	 <div id="idGridSach" style="width:80%; margin:auto;"></div>
 	 
	<jsp:include page="HaiTheDiv.jsp"></jsp:include>
</body>
<jsp:include page="footer.jsp"></jsp:include>
<script type="text/javascript">
 $(document).ready(function () {

			$.ajax({
				url:"./tonkhoJson",
				contentType: 'application/json; charset=utf-8',
				success: function (data) {
					$("#idGridSach").dxDataGrid({
						dataSource: data,
						filterRow:{
							visible: true
							},
						columns:[
							{
								caption:"id",
								dataField: "id",
								allowFiltering: false
							},
							{
								caption: "Tên Sách",
								dataField: "tenSach"
								
							},
							{
								caption: "Nhà Xuất Bản",
								dataField: "nhaXuatBan"
							},
							{
								caption: "Số Lượng Tồn",
								dataField: "soLuong"
							}
							]
						});	
					
				}
					
				});
				
		
		
	})
	
	
</script>
</html>