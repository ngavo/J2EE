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
	                        width: 50,
	                        alignment: 'center'
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
								$('<a class="btn btn-primary btn-sm" href="chiTietTacGia?id='+options.data.id+'" >Chi Tiết</a>').appendTo(container);
								
								}
						}
						]
					});	
				
			}
				
			});
			
	})
</script>
</html>