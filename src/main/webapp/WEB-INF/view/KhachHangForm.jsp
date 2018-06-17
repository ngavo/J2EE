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
    	<%-- <table class="table table-bordered">
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
        </table> --%>
    </div>
    
    <div id="idKhachHang"></div>
 	
	<jsp:include page="HaiTheDiv.jsp"></jsp:include>
</body>
<jsp:include page="footer.jsp"></jsp:include>
<script type="text/javascript">
	$(document).ready(function () {
		
		$.ajax({
			url:"./listKhachHangJson",
			contentType: 'application/json; charset=utf-8',
			success: function (data) {
				$("#idKhachHang").dxDataGrid({
					dataSource: data,
					filterRow:{
						visible: true
						},
						onRowPrepared: function (info) {
		                    if (info.rowType != "header") {
		                        if (info.rowIndex % 2 == 0)
		                            info.rowElement.css("background-color", "aliceblue");
		                    }
		                    else {
		                        info.rowElement.css("font-weight", "bold" );
		                    }
		                },
		                onCellPrepared: function(e) {
		                    if (e.rowType == "header") {
		                        e.cellElement.css("text-align", "center");
		                    }
		                    
		                },
					columns:[
						{
							caption:"id",
							dataField: "id",
							allowFiltering: false,
							visible: false
						},
						{
	                        caption: "STT",
	                        cellTemplate: function (container, options) {
	                            container.append($('<div >' + parseInt(parseInt(options.rowIndex) + 1) + '</div>'));
	                        },
	                        width: "50px",
	                        alignment: 'center'
	                    },
						{
							caption: "Tên Khách Hàng",
							dataField: "hoTen"
							
						},
						{
							caption: "Số Điện Thoại",
							dataField: "soDienThoai"
						},
						{
							caption: "Địa Chỉ",
							dataField: "diaChi"
						},
						{
							caption: "Email",
							dataField: "email"
						},
						{
							cellTemplate: function(container, options){

								$('<a class="btn btn-primary btn-sm" href="editKhachHang?id='+options.data.id+'" >Edit</a>').appendTo(container);
								$('<a class="btn btn-primary btn-sm" href="deleteKhachHang?id='+options.data.id+'" >Delete</a>').appendTo(container);
								$('<a class="btn btn-primary btn-sm" href="chitietKhachHang?id='+options.data.id+'" >Chi Tiết</a>').appendTo(container);
								
								}
						}
						]
					});	
				
			}
				
			});
			
	})
</script>
</html>