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
	<h1>Hóa Đơn Nhập</h1>   
    <br>
    <div style="margin: 0 1em">
    	<div align= center>
    		<a href="../hoadonnhap/newHoaDonNhap" class="btn btn-primary btn-sm">Tạo Mới</a>
    	</div>
    </div>
    	<br>
    <div id="idListHoaDonNhap"></div>
</div>
 	
	<jsp:include page="HaiTheDiv.jsp"></jsp:include>
</body>
<jsp:include page="footer.jsp"></jsp:include>
<script type="text/javascript">
	$(document).ready(function () {
		loadData();
	});

function loadData()
{
	$.ajax({
		url: "../listhoadonnhap",
		success: function (data) {

			$("#idListHoaDonNhap").dxDataGrid({
				dataSource: data,
				columns:[
					{
						caption: "STT",
						dataField: "id",
						allowFiltering: false
					},
					{
						caption: "Nhà Xuất Bản",
						dataField: "nhaxuatban.tenNhaXuatBan"
					},
					{
						caption: "Ngày Nhập",
						dataField: "NgayNhap",
						dataType: "date"
					},
					{
						caption: "Tổng Tiền",
						dataField: "tongTien",
						allowFiltering: false
					},
					{
						caption: "Action",
						allowFiltering: false,
						cellTemplate: function (container, options) {
							$('<div><a href="../hoadonnhap/edit?id='+ options.data.id+'" >Edit</a></div>')
		                       .appendTo(container);
							$('<div><a href="../hoadonnhap/delete?id='+ options.data.id+'" >Delete</a></div>')
		                       .appendTo(container);
						}
					}
					
					],
					filterRow:{
						visible: true
						}
				})
			
		}
		});
}
</script>
</html>