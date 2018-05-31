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
	<h1>Danh Sách Tác Giả</h1>   
    </div>
    <br>
    <div style="margin: 0 1em">
    	<div align= center>
    		<a href="newTacGia" class="btn btn-primary btn-sm">Tạo Mới</a>
    	</div>
    	<br>
    	<%-- <table class="table table-bordered">
 			<tr>
	            <th>Tên Tác Giả</th>
	            <th>Mô Tả</th>
	            <th>Action</th>
 			</tr>
            <c:forEach var="tacgia" items="${listTacGia}">
                <tr>
 
                    <td>${tacgia.getTenTacGia()}</td>
                    <td>${tacgia.getMoTa()}</td>
                    <td>
                    	<a href="editTacGia?id=${tacgia.id}" class="btn btn-primary btn-sm">Edit</a>
                        <a href="deleteTacGia?id=${tacgia.id}" class="btn btn-primary btn-sm">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </table> --%>
    </div>
    
    <div id="idTacGia"></div>
 	
	<jsp:include page="HaiTheDiv.jsp"></jsp:include>
</body>
<jsp:include page="footer.jsp"></jsp:include>

<script type="text/javascript">
	$(document).ready(function () {
		
		$.ajax({
			url:"./listTacGiaJson",
			contentType: 'application/json; charset=utf-8',
			success: function (data) {
				$("#idTacGia").dxDataGrid({
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
							caption: "Tên Tác Giả",
							dataField: "tenTacGia"
							
						},
						{
							caption: "Mô Tả",
							dataField: "moTa"
						},
						{
							cellTemplate: function(container, options){

								$('<a class="btn btn-primary btn-sm" href="editTacGia?id='+options.data.id+'" >Edit</a>').appendTo(container);
								$('<a class="btn btn-primary btn-sm" href="deleteTacGia?id='+options.data.id+'" >Delete</a>').appendTo(container);
								
								}
						}
						]
					});	
				
			}
				
			});
			
	})
</script>
</html>