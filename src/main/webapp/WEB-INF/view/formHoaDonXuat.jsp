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

<div align="center">
	<form:form modelAttribute="hoadonxuat">
		<form:hidden path="id" id="idHoaDonXuat"/>
	</form:form>
	<h1>Thêm Hóa Đơn Xuất</h1>   
    <br>
    <div id="idLoadKhachHang" style="width: 50%; margin: auto;"></div>
    <div id="idTableSach"></div>
    <button onClick="save()">Save</button>
</div>
 	
	<jsp:include page="HaiTheDiv.jsp"></jsp:include>
</body>
<jsp:include page="footer.jsp"></jsp:include>
<script type="text/javascript">
var YesOrNo;
		$(document).ready(function () {
			YesOrNo = $("#idHoaDonXuat").val();

			LoadKhachHang();
			LoadSach()
		});

function save()
{
	var k = $("#idTableSach").dxDataGrid("instance");
	var k_lenght = k._controllers.data._dataSource._items.length;
	var dataSend =[];
	for(var i=0; i<k_lenght;i++)
	{
		var m = $("#idValueSoLuongSach"+i).val();
		if(m!="")
			{
				var resultObject = new Object();
				resultObject.giaBan = k.cellValue(i,2);
				resultObject.idSach = k.cellValue(i,0);
				
				resultObject.soLuongXuat = m;
				dataSend.push(resultObject);
				
			}
	}

	var result = new Object();
	result.idHoaDonXuat = $("#idHoaDonXuat").val();
	result.tenKhachHang = $("#idLoadKhachHang").dxAutocomplete("instance").option("value");
	result.listSachInsetHdx = dataSend;
	var myJsonString = JSON.stringify(result);

	if(YesOrNo==0)
		{
		$.ajax({
			url:"../hoadonxuat/insertSach",
			type: "POST",
			contentType: 'application/json; charset=utf-8',
			data: myJsonString,
			success:function(datak){
				window.location.href="../hoadonxuat/home";
				}
			});
		}
	else
		{
		$.ajax({
			url:"../hoadonxuat/editSach?id="+YesOrNo,
			type: "POST",
			contentType: 'application/json; charset=utf-8',
			data: myJsonString,
			success:function(datak){
				window.location.href="../hoadonxuat/home";
				}
			});
			
		}
	
	
}

		
function LoadKhachHang()
{
	if(YesOrNo==0)
		{
		LoadKhachHangOfNew();
		
		}
	else
		{
			LoadKhachHangOfEdit();
		}
}


function LoadKhachHangOfNew()
{
	$.ajax({
		url: "../hoadonxuat/loadkhachhangnew",
		success: function(data){
			$("#idLoadKhachHang").dxAutocomplete({
				dataSource: data,
				valueExpr: "hoTen",
				});
			}
		});	
}

function LoadKhachHangOfEdit()
{
	$.ajax({
		url: "../hoadonxuat/loadkhachhangnew",
		success: function(data){

			$.ajax({
				url: "../hoadonxuat/loadkhachhangedit?id="+YesOrNo,
				contentType: "application/json; charset=utf-8",
				dataType: "text",
				success: function(datak){

					$("#idLoadKhachHang").dxAutocomplete({
						dataSource: data,
						valueExpr: "hoTen",
						value: datak
						});
					
					}
				});
			
			
			}
		});
}


function LoadSach()
{
	if(YesOrNo==0)
		{
			LoadSachForNew();
		}
	else
		{
			LoadSachForEdit();
		}
	
}

function LoadSachForNew()
{
	$.ajax({
		url: "../hoadonxuat/loadsachfornew",
		success: function(data){
			$("#idTableSach").dxDataGrid({
				dataSource: data,
				columns:[
					{
						caption:"id",
						dataField: "idSach",
					},
					{
						caption: "Tên Sách",
						dataField: "tenSach"
					},
					{
						caption: "Giá Bán",
						dataField: "giaBan"
					},
					
					{
						caption: "Số Lượng",
						dataField: "soLuong"
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
		});
	
}

function LoadSachForEdit()
{
	$.ajax({
		url: "../hoadonxuat/loadsachfornew",
		success: function(data){


			$.ajax({
				url: "../hoadonxuat/getsachkhachhangdamua?id="+YesOrNo,
				success: function(datak){

					//ket thuc			
					$("#idTableSach").dxDataGrid({
						dataSource: data,
						columns:[
							{
								caption:"id",
								dataField: "idSach",
							},
							{
								caption: "Tên Sách",
								dataField: "tenSach"
							},
							{
								caption: "Giá Bán",
								dataField: "giaBan"
							},
							
							{
								caption: "Số Lượng",
								dataField: "soLuong"
							},
							{
								caption: "Nhập số lượng sach",
								/* allowEditing: true, */
								cellTemplate: function (container, options) {

									var l = datak.length;
									var i=0;
									for(i;i<l;i++)
										{
											if(datak[i].idSach==options.data.idSach)
												{
												$('<div><input type="text" id="idValueSoLuongSach'+options.rowIndex + '"value="' + datak[i].soLuong   + '" /></div>').appendTo(container);
												return;
												}
										}
									if(i==l)
										{
											$('<div><input type="text" id="idValueSoLuongSach'+options.rowIndex + '" /></div>').appendTo(container);
										}
									
									
									
								}
							}
							
							]
						});

					//ket thuc
					
					}
				});	
			


			
			
			}
		});
}

</script>
</html>