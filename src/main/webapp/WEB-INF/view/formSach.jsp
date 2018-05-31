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
	<h1 >Thêm Sách</h1>   
    </div>
    <br>
    
    <form:form modelAttribute="sach">
    	<form:hidden path="id" id="idSach"/>
    	<div class="form-group " style="width: 60%;margin: auto;">
    	  <label for="NameSach" class="col-sm-2 col-form-label">Tên Sách:</label>
	      <!-- <input type="text" class="col-sm-4 form-control" id="NameSach"  path="TenSach"/> -->
	      <form:input path="TenSach" class="col-sm-4 form-control" id="NameSach"/>
	    </div>
	    <div class="form-group " style="width: 60%;margin: auto;">
    	  <label for="GiaSachNhap" class="col-sm-2 col-form-label">Giá Nhập:</label>
	      <!-- <input type="text" class="col-sm-4 form-control" id="GiaSachNhap" path="GiaNhap" /> -->
	      <form:input class="col-sm-4 form-control" id="GiaSachNhap" path="GiaNhap"/>
	    </div>
	    <div class="form-group " style="width: 60%;margin: auto;">
    	  <label for="GiaSachBan" class="col-sm-2 col-form-label">Giá Bán:</label>
	      <!-- <input type="text" class="col-sm-4 form-control" id="GiaBanSach" path="GiaBan" /> -->
	      <form:input class="col-sm-4 form-control" id="GiaBanSach" path="GiaBan"/>
	    </div>
    	<div class="form-group " style="width: 60%;margin: auto;">
    	  <label for="idselecNXB" class="col-sm-2 col-form-label">Nhà Xuất Bản:</label>
	      <div id="idselecNXB" class="col-sm-4 form-control"></div>
	    </div>
	    
	    <div class="form-group" style="width: 60%;margin: auto;">
	    	<label for="idselecTheLoai" class="col-sm-2 col-form-label">Thể loại:</label>
	      <div id="idselecTheLoai" class="col-sm-4 form-control"></div>
	    </div>
	    
	    
    </form:form>
    
    <div class="form-group" style="width: 80%;margin: auto;">
	    	<label for="idListTacGia" class="col-sm-2 col-form-label">Tác Giả</label>
			<div class="col-sm-12 " >
				<div id="idListTacGia" ></div>
			</div>      		
	</div>
	<br>
	
	<div  class="form-group" style="width: 80%;margin: auto;">
    	<button onClick="Save()" >Lưu</button>
    </div>
      
      
      
    
    
 	
	<jsp:include page="HaiTheDiv.jsp"></jsp:include>
</body>
<jsp:include page="footer.jsp"></jsp:include>
<script type="text/javascript">
var YesOrNoId;
	$(document).ready(function(){

		YesOrNoId =  $("#idSach").val();
		loadNXB();

		loadTheLoai();
		
		loadTacGia();


	});


	function loadNXB()
	{
		$.ajax({
			url: "./listSach/NXB",
			contentType: "application/json",
			dataType : 'json',
			success: function(data){
				var valueforNXB="";
				if(YesOrNoId!=0)
					{
						$.ajax({
							url: "getDataNXBForEdit?id="+YesOrNoId,
							contentType: "application/json; charset=utf-8",
							dataType: "text",
							success: function (datak) {
								valueforNXB = datak;
								$("#idselecNXB").dxAutocomplete({
									dataSource: data,
									valueExpr: "tenNhaXuatBan",
									value: valueforNXB
									});
							}
							});
					}
				else
					{
					$("#idselecNXB").dxAutocomplete({
						dataSource: data,
						valueExpr: "tenNhaXuatBan"
						});
					
					}
			}
				
			});
	};


	function loadTheLoai()
	{
		$.ajax({
			url:"./listSach/theloai",
			contentType: "application/json",
			dataType: "json",
			success: function(data){

				if(YesOrNoId!=0)
					{
					$.ajax({
						url: "getDataTheLoaiForEdit?id="+YesOrNoId,
						contentType: "application/json; charset=utf-8",
						dataType: "text",
						success: function (datak) {
							valueforNXB = datak;
							$("#idselecTheLoai").dxAutocomplete({
								dataSource: data,
								valueExpr: "tenTheLoai",
								value: datak
								});
						}
						});
					
					}
				else
					{
						$("#idselecTheLoai").dxAutocomplete({
							dataSource: data,
							valueExpr: "tenTheLoai"
							})
					}
				
				
			}
			});
	};

	function loadTacGia()
	{
		$.ajax({
			url: "./listSach/tacgia",
			contentType: "application/json",
			dataType : 'json',
			success: function(data){

				
					//bat dau
					$("#idListTacGia").dxDataGrid({
						dataSource: data,
						wordWrapEnabled: true,
						onRowPrepared: function (info) {
		                    if (info.rowType != "header") {
		                        if (info.rowIndex % 2 == 0)
		                            info.rowElement.css("background-color", "aliceblue");
		                    }
		                },

		                columns:[
			                {
			                	caption: "id",
				                dataField: "id"
				             },
				             {
				                	caption: "Tên tác giả",
					                dataField: "tenTacGia"
					          },

					          {
					               caption: "Mô tả",
						           dataField: "moTa"
						       },
					           {
							       caption: "Chọn",
							      dataType: "boolean",
					               cellTemplate: function(container, options){

										if(YesOrNoId!=0)
											{
											var idTacgiadata;
												$.ajax({
													url: "getIdTacGiaForEdit?id="+ YesOrNoId,
													success: function (datak) {
														idTacgiadata = datak;
														var i =0;
														for(var i; i< idTacgiadata.length;i++)
															{
																if(idTacgiadata[i]==options.data.id)
																	{
																	$('<div><input type="checkbox" checked id="idCheck'+ options.data.id+'" /></div>')
												                       .appendTo(container);
												                       return;
																	}
															}
														if(i==idTacgiadata.length)
															{
															$('<div><input type="checkbox"  id="idCheck'+ options.data.id+'" /></div>')
										                       .appendTo(container);
															}
																											
													}
													});
											}
										else
											{
											 $('<div><input type="checkbox" id="idCheck'+ options.data.id+'" /></div>')
						                       .appendTo(container);
											}
						               
					                     
						            }
						       }
					             
				             
			                
			                ]
					})

					//ke thuc dxDataGid
				

				
				
			}
	});



		
	};
	
	function Save()
	{
		
		var k = $("#idListTacGia").dxDataGrid("instance");
		var k_lenght = k._controllers.data._dataSource._items.length;

		var idSach = YesOrNoId;
		var tenSach = $("#NameSach").val();
		var giaNhap = $("#GiaSachNhap").val();
		var giaBan = $("#GiaBanSach").val();
		var theLoai = $("#idselecTheLoai").dxAutocomplete("instance").option("value");
		var tenNhaXuatBan = $("#idselecNXB").dxAutocomplete("instance").option("value");
		var listIdTacGia =[];
		
		for(var i=0; i< k_lenght; i++ )
		{
			 if($("#idListTacGia #idCheck"+k.cellValue(i,0)).is(':checked'))
				 {
				 	listIdTacGia.push(k.cellValue(i,0));
				 }
		}

		var result = new Object();
		result.idSach = idSach;
		result.tenSach = tenSach;
		result.giaNhap = giaNhap;
		result.giaBan = giaBan;
		result.tenNhaXuatBan = tenNhaXuatBan;
		result.listIdTacGia = listIdTacGia;
		result.theLoai = theLoai;

		var myJsonString = JSON.stringify(result);
		
		$.ajax({
			url: "./listSach/insertSach",
			type: "POST",
			contentType: 'application/json; charset=utf-8',
			data: myJsonString,
			success: function(data){
				window.location.href="listSach";
			},
			error: function(data)
			{
				console.log("nfksjdgs");
			}
			
			});
		
	};
	
</script>
</html>