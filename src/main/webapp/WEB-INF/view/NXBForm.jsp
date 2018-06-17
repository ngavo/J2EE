  <%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<jsp:include page="header.jsp"></jsp:include>
<body>
<jsp:include page="menu.jsp"></jsp:include>

<div align="center">
	<h3>Danh sách Nhà Xuất Bản</h3>   
    </div>
    <br>
    <div style="margin: 0 1em">
    	<div align= center>
    		<a href="newNXB" class="btn btn-primary btn-sm">Thêm mới Nhà Xuất Bản</a>
    	</div>
    	<br>
    	<%-- <table class="table table-bordered">
 			<tr>
 			 	<th>ID</th>
	            <th>Ten NXB</th>
	            <th>Dia chi</th>
	            <th>So Dien Thoai</th>
	            <th>Email</th>
	            <th>Action</th>
 			</tr>
            <c:forEach var="NXB" items="${listNXB}">
                <tr>
      				<td>${NXB.id}</td>
                    <td>${NXB.getTenNhaXuatBan()}</td>
                    <td>${NXB.getDiaChi()}</td>
                    <td>${NXB.getSoDienThoai()}</td>
                    <td>${NXB.getEmail()}</td>
                    <td>
                    	<a href="editNXB?id=${NXB.id}" class="btn btn-primary btn-sm">Edit</a>
                        <a href="deleteNXB?id=${NXB.id}" class="btn btn-primary btn-sm">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </table> --%>
        <div id="formNXB"></div>
    </div>
 	
	<jsp:include page="HaiTheDiv.jsp"></jsp:include>
</body>

<jsp:include page="footer.jsp"></jsp:include>
<script type="text/javascript">
	$(document).ready(function () {
		
		$.ajax({
			url:"listNXBJson",
			contentType: 'application/json; charset=utf-8',
			success: function (data) {
				$("#formNXB").dxDataGrid({
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
							caption: "Tên Nhà Xuất Bản",
							dataField: "tenNhaXuatBan"
							
						},
						{
							caption: "Địa Chỉ",
							dataField: "diaChi"
						},
						{
							caption: "Số Điện Thoại",
							dataField: "soDienThoai"
						},
						{
							caption: "Email",
							dataField: "email"
						},
						{
							cellTemplate: function(container, options){

								$('<a class="btn btn-primary btn-sm" href="editNXB?id='+options.data.id+'" >Edit</a>').appendTo(container);
								$('<a class="btn btn-primary btn-sm" href="deleteNXB?id='+options.data.id+'" >Delete</a>').appendTo(container);
								$('<a class="btn btn-primary btn-sm" href="chitietNXB?id='+options.data.id+'" >Chi Tiết</a>').appendTo(container);
								
								}
						}
						]
					});	
				
			}
				
			});
			
	})
</script>
</html>