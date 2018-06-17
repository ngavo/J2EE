<%@page session="false"%>
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
<a href="./listSach" class="btn btn-default col-sm-offset-1" role="button">Trở về</a>
<br>
<div align="center">
	<h3 id="idTieuDe"></h3>   
    </div>
    <br>
    
    <form:form modelAttribute="sach" class="form-horizontal col-sm-10 col-sm-offset-1">
    
    	<form:hidden path="id" id="idSach"/>
    	
    	<div class="form-group " >
    	  <label for="NameSach" class="control-label col-sm-2">Tên Sách:</label>
	      <div class="col-sm-10">
	      	<form:input path="TenSach" class="form-control" id="NameSach"/>
	      </div>
	    </div>
	    
	    
	    <div class="form-group " >
    	  <label for="GiaSachNhap" class="control-label col-sm-2">Giá Nhập:</label>
	      <div class="col-sm-10">
	      	<form:input class="form-control" id="GiaSachNhap" path="GiaNhap"/>
	      </div>
	    </div>
	    
	    
	    
	    <div class="form-group " >
    	  <label for="GiaSachBan" class="control-label col-sm-2">Giá Bán:</label>
	      <!-- <input type="text" class="col-sm-4 form-control" id="GiaBanSach" path="GiaBan" /> -->
	      <div class="col-sm-10">
	      	<form:input class="form-control" id="GiaBanSach" path="GiaBan"/>
	      </div>
	    </div>
	    
	    
    	<div class="form-group " >
    	  <label for="idselecNXB" class="control-label col-sm-2">Nhà Xuất Bản:</label>
    	  
    	  <div class="col-sm-10">
	      	<div id="idselecNXB" class="col-sm-4 form-control"></div>
	      </div>
	      
	    </div>
	    
	    <div class="form-group" >
	    	<label for="idselecTheLoai" class="control-label col-sm-2">Thể loại:</label>
	    	<div class="col-sm-10">
	      		<div id="idselecTheLoai" class="col-sm-4 form-control"></div>
	      	</div>
	    </div>
	    
	    
    </form:form>
    
    <div class="form-group" style="width: 80%;margin: auto;">
	    	<label for="idListTacGia" class="col-sm-2 col-form-label">Tác Giả</label>
			<div class="col-sm-12 " >
				<div id="idListTacGia" ></div>
			</div>      		
	</div>
	<br>
	
	<div  class="form-group" >
		<div class="col-sm-offset-2 col-sm-10" style="padding-top: 10px;padding-bottom: 10px;">
    	<button onClick="Save()" class="btn btn-primary">Lưu</button>
    	</div>
    </div>
      
      
      
    
    
 	
	<jsp:include page="HaiTheDiv.jsp"></jsp:include>
</body>
<jsp:include page="footer.jsp"></jsp:include>
<script type="text/javascript">
var YesOrNoId;
	$(document).ready(function(){

		YesOrNoId =  $("#idSach").val();
		if(YesOrNoId!=0)
		{
			$("#idTieuDe").html("Chỉnh sửa Sách");
		}
		else
		{
			$("#idTieuDe").html("Thêm mới Sách");
		}
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
		                filterRow:{
							visible: true
							},

		                columns:[
			                {
			                	caption: "id",
				                dataField: "id",
				                allowFiltering: false
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