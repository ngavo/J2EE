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
	<h1>Hóa Đơn Xuất</h1>   
    <br>
    <div style="margin: 0 1em">
    	<div align= center>
    		<a href="../hoadonxuat/newhoadonxuat" class="btn btn-primary btn-sm">Tạo Mới</a>
    	</div>
    </div>
    	<br>
    <div id="idListHoaDonXuat"></div>
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
		url: "../listhoadonxuat",
		success: function (data) {

			$("#idListHoaDonXuat").dxDataGrid({
				dataSource: data,
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
						caption: "STT",
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
						caption: "Khách Hàng",
						dataField: "khachhang.hoTen"
					},
					{
						caption: "Ngày Bán Hàng",
						dataField: "ngayBan",
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
							$('<a class="btn btn-primary btn-sm" href="../hoadonxuat/edit?id='+ options.data.id+'" >Edit</a>')
		                       .appendTo(container);
							$('<a class="btn btn-primary btn-sm" href="../hoadonxuat/delete?id='+ options.data.id+'" >Delete</a>')
		                       .appendTo(container);
							$('<a class="btn btn-primary btn-sm" href="../hoadonxuat/chitiet?id='+ options.data.id+'" >Chi Tiết</a>')
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