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
	<h1>Danh Sách Sách</h1>   
    </div>
    <br>
    <div style="margin: 0 1em">
    	<div align= center>
    		<a href="newSach" class="btn btn-primary btn-sm">Tạo Mới</a>
    	</div>
    	<br>
    	<%-- <table class="table table-bordered">
 			<tr>
 				<th>id</th>
	            <th>Tên Sách</th>
	            <th>Nhà xuất bản</th>
	            <th>Thể loại</th>
	            <th>Giá bán</th>
	            <th>Giá nhập</th>
	            <th>Tác giả</th>
	            <th>Hoạt động</th>
 			</tr>
            <c:forEach var="sach" items="${listSach}">
                <tr>
 					<td>${sach.id}</td>
                    <td>${sach.getTenSach()}</td>
                    <td>${sach.getNhaxuatban().getTenNhaXuatBan()}</td>
                    <td>${sach.getTheloai().getTenTheLoai() }</td>
                    <td>${sach.getGiaNhap() }</td>
                    <td>${sach.getGiaBan()}</td>
                    <td>
                    	<c:forEach var="tacgia" items="${sach.getTacgia() }">
                    		<p> - ${tacgia.getTenTacGia() }</p>
                    	</c:forEach>
                    </td>
                    <td>
                    	<a href="editSach?id=${sach.id}" class="btn btn-primary btn-sm">Edit</a>
                        <a href="deleteSach?id=${sach.id}" class="btn btn-primary btn-sm">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </table> --%>
    </div>
 	
 	 
 	 <div id="idGridSach" style="width:80%; margin:auto;"></div>
 	 
	<jsp:include page="HaiTheDiv.jsp"></jsp:include>
</body>
<jsp:include page="footer.jsp"></jsp:include>
<script type="text/javascript">
 $(document).ready(function () {

			$.ajax({
				url:"./listSach/dataOfSach",
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
								caption: "Giá Nhập",
								dataField: "giaNhap"
							},
							{
								caption: "Giá Bán",
								dataField: "giaBan"
							},
							{
								cellTemplate: function(container, options){

									$('<a class="btn btn-primary btn-sm" href="editSach?id='+options.data.id+'" >Edit</a>').appendTo(container);
									$('<a class="btn btn-primary btn-sm" href="deleteSach?id='+options.data.id+'" >Delete</a>').appendTo(container);
									
									}
							}
							]
						});	
					
				}
					
				});
				
		
		
	})
	
	
</script>
</html>