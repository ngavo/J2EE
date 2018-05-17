<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>New/Edit Contact</title>
</head>
<body>
<div align="center">
        <h1>New/Edit Employee</h1>
        <form:form action="saveNXB" method="post" modelAttribute="NXB">
        
        <table>
            <form:hidden path="id"/>
            <tr>
                <td>Ten NXB:</td>
                <td><form:input path="TenNhaXuatBan" /></td>
            </tr>
            <tr>
                <td>SDT:</td>
                <td><form:input path="DiaChi" /></td>
            </tr>
            <tr>
                <td>Dia chi:</td>
                <td><form:input path="SoDienThoai" /></td>
            </tr>
            <tr>
                <td>Email:</td>
                <td><form:input path="Email" /></td>
            </tr>
            <tr>
                <td colspan="2" align="center"><input type="submit" value="Save"></td>
            </tr>
        </table>
        </form:form>
        
    </div>
    
</body>
</html>