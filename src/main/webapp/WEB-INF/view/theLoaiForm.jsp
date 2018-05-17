<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<jsp:include page="header.jsp"></jsp:include>
<body>
<jsp:include page="menu.jsp"></jsp:include>

<div align="center">
	<h1>The loai sach</h1>   
    </div>
    <br>
    <div style="margin: 0 1em">
    	<div align= center>
    		<a href="newTheLoai" class="btn btn-primary btn-sm">Them the loai</a>
    	</div>
    	<br>
    	<table class="table table-bordered">
 			<tr>
	            <th>Name</th>
	            <th>Action</th>
 			</tr>
            <c:forEach var="theLoai" items="${listTheLoai}">
                <tr>
 
                    <td>${theLoai.id}</td>
                    <td>${theLoai.getTenTheLoai()}</td>
                    <td>
                    	<a href="editTheLoai?id=${theLoai.id}" class="btn btn-primary btn-sm">Edit</a>
                        <a href="deleteTheLoai?id=${theLoai.id}" class="btn btn-primary btn-sm">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
 	
	<jsp:include page="HaiTheDiv.jsp"></jsp:include>
</body>
<jsp:include page="footer.jsp"></jsp:include>
</html>