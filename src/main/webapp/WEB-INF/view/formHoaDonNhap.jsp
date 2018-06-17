<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%> --%>
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
<a href="../hoadonnhap/home" class="btn btn-default col-sm-offset-1" role="button">Trở về</a>
<br>
<div align="center">
	<form:form modelAttribute="hoadonnhap">
		<form:hidden path="id" id="idHoaDonNhap"/>
	</form:form>
	<h3 id="idTieuDe">Thêm Hóa Đơn Nhập</h3>   
    <br>
    <div class="form-group">
    	<label for="idLoadNhaXuatBan" class="control-label col-sm-2">Nhà Xuất Bản:</label>
    	<div id="idLoadNhaXuatBan" class="col-sm-8"></div>
    	<div class="col-sm-2">
    		<button onClick="FindSach()" class="btn btn-primary" >Tìm</button>
    	</div>
    </div>
    <div class="form-group" >
    	<div id="idTableSachOfNXB" class="col-sm-offset-1 col-sm-10"></div>
    </div>
    <div class="form-group">
    	<div class="col-sm-offset-2 col-sm-10" style="padding-top: 10px;padding-bottom: 10px;">
    	<button onClick="save()" class="btn btn-primary">Save</button>
    	</div>
    </div>
</div>
 	
	<jsp:include page="HaiTheDiv.jsp"></jsp:include>
</body>
<jsp:include page="footer.jsp"></jsp:include>
<script type="text/javascript">
var YesOrNoId;
	$(document).ready(function () {
		YesOrNoId = $("#idHoaDonNhap").val();
		if(YesOrNoId!=0)
		{
			$("#idTieuDe").html("Chỉnh sửa Hóa Đơn Nhập");
		}
		else
		{
		$("#idTieuDe").html("Thêm mới Hóa Đơn Nhập");
		}
		loadNhaXuatBan();


		
		
	});

	function save() {
		var k = $("#idTableSachOfNXB").dxDataGrid("instance");
		var k_lenght = k._controllers.data._dataSource._items.length;
		var dataSend =[];
		for(var i=0; i<k_lenght;i++)
			{
				var m = $("#idValueSoLuongSach"+i).val();
				if(m!="")
					{
						var resultObject = new Object();
						resultObject.giaNhap = k.cellValue(i,2);
						resultObject.idSach = k.cellValue(i,0);
						
						resultObject.solong = m;
						dataSend.push(resultObject);
						
					}
				var z =0;
			}
		var result = new Object();
		result.tenNhaXuatBan = $("#idLoadNhaXuatBan").dxAutocomplete("instance").option("value");
		result.listResultObject = dataSend;
		result.idHoaDonNhap = YesOrNoId;
		var myJsonString = JSON.stringify(result);
		if(YesOrNoId==0)
			{
				$.ajax({
					url:"../hoadonnhap/saveHoaDonNhap",
					type: "POST",
					contentType: 'application/json; charset=utf-8',
					data: myJsonString,
					success:function(datak){
						window.location.href="../hoadonnhap/home";
						}
					});	
			}
		else
			{
			$.ajax({
				url:"../hoadonnhap/editHoaDonNhap",
				type: "POST",
				contentType: 'application/json; charset=utf-8',
				data: myJsonString,
				success:function(datak){
					window.location.href="../hoadonnhap/home";
					}
				});	
			}
		
		
	}

 function FindSach(){

	 
	 LoadSachOfNhaXuatBan();
	 
	 }

 function LoadSachOfNhaXuatBan(){

	 $.ajax({
			url: "../hoadonnhap/loadSachOfNhaXuatBan?name="+ $("#idLoadNhaXuatBan").dxAutocomplete("instance").option("value"),
			contentType: "application/json; charset=utf-8",
			success: function (dataSach) {

				if(YesOrNoId!=0)//truong hop edit
					{
						$.ajax({
							url:"../hoadonnhap/loadNhaXuatBanForEdit?id="+YesOrNoId,
							contentType: "application/json; charset=utf-8",
							dataType: "text",
							success: function(datak){

								if(datak==$("#idLoadNhaXuatBan").dxAutocomplete("instance").option("value"))//truong hop chon lai nha xuat ban da dc them vao
									{


										$.ajax({
											url:"../hoadonnhap/LoadHoaDonNhapSachForEdit?id="+YesOrNoId,
											success: function(datam){

												//batdau

												$("#idTableSachOfNXB").dxDataGrid({
													dataSource: dataSach,
													columns:[
														{
															caption:"id",
															dataField:"id",
															allowEditing: false
														},
														{
															caption: "Tên Sách",
															dataField: "tensach",
															allowEditing: false
														},
														
														{
															caption: "Giá Nhập",
															dataField: "gianhap",
															allowEditing: false
														},
														
														{
															caption: "Tên thể loại",
															dataField: "theloai",
															allowEditing: false
														},
														{
															caption: "Nhập số lượng sach",
															/* allowEditing: true, */
															cellTemplate: function (container, options) {
																var i=0
																for(i;i<datam.length;i++)
																	{
																		if(datam[i].idSach==options.data.id)
																			{
																			$('<div><input type="text" id="idValueSoLuongSach'+options.rowIndex + '" value='+datam[i].soLuong+ ' /></div>').appendTo(container);
																			return ;			
																			}
																	}
																if(i==datam.length)
																	{
																	$('<div><input type="text" id="idValueSoLuongSach'+options.rowIndex + '"  /></div>').appendTo(container);
																	}
																
															} 
														}
														
														
														] 
													});	
													//ket thuc
															
												
												}
											});

									
									
									}
								else{

									//batdau

									$("#idTableSachOfNXB").dxDataGrid({
										dataSource: dataSach,
										columns:[
											{
												caption:"id",
												dataField:"id",
												allowEditing: false
											},
											{
												caption: "Tên Sách",
												dataField: "tensach",
												allowEditing: false
											},
											
											{
												caption: "Giá Nhập",
												dataField: "gianhap",
												allowEditing: false
											},
											
											{
												caption: "Tên thể loại",
												dataField: "theloai",
												allowEditing: false
											},
											{
												caption: "Nhập số lượng sach",
												/* allowEditing: true, */
												cellTemplate: function (container, options) {
													
													
														$('<div><input type="text" id="idValueSoLuongSach'+options.rowIndex + '"  /></div>').appendTo(container);
														
													
												} 
											}
											
											
											] 
										});	
										//ket thuc
									
									
									}
								
								}
							});
					}
				else//truong hop new
					{

					$("#idTableSachOfNXB").dxDataGrid({
						dataSource: dataSach,
						columns:[
							{
								caption:"id",
								dataField:"id",
								allowEditing: false
							},
							{
								caption: "Tên Sách",
								dataField: "tensach",
								allowEditing: false
							},
							
							{
								caption: "Giá Nhập",
								dataField: "gianhap",
								allowEditing: false
							},
							
							{
								caption: "Tên thể loại",
								dataField: "theloai",
								allowEditing: false
							},
							{
								caption: "Nhập số lượng sach",
								/* allowEditing: true, */
								cellTemplate: function (container, options) {
									$('<div><input type="text" id="idValueSoLuongSach'+options.rowIndex + '" /></div>').appendTo(container);
									
								} 
							}
							
							
							] 
						});		
						
					}
				
			
			}
			});
	 
	 }


function loadSachForEdit() {

	LoadSachOfNhaXuatBan();
	
	
}
	
function loadNhaXuatBan() {
		
		$.ajax({
			url:"../hoadonnhap/loadNhaXuatBan",
			success:function(data){
				if(YesOrNoId!=0)
				{
					$.ajax({
						url:"../hoadonnhap/loadNhaXuatBanForEdit?id="+YesOrNoId,
						contentType: "application/json; charset=utf-8",
						dataType: "text",
						success: function(datak){
							$("#idLoadNhaXuatBan").dxAutocomplete({
								dataSource: data,
								valueExpr: "tenNhaXuatBan",
								value: datak
								});

							loadSachForEdit();	
							
							}
						});
				}
				else
				{
					$("#idLoadNhaXuatBan").dxAutocomplete({
						dataSource: data,
						valueExpr: "tenNhaXuatBan"
						});
				}
				
				}
			})
		
	}

</script>
</html>