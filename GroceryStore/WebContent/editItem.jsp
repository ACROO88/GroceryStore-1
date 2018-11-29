<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Item</title>
</head>
<body>

<form action="editItemServlet" method="post">
Item: <input type="text" name="item" value="${itemToEdit.item}">
DeptID: <input type="text" name="deptID" value="${itemToEdit.deptID}">
Department: <input type="text" name="department" value="${itemToEdit.department}">
Price: <input type="text" name="price" value="${itemToEdit.price}">
<input type="hidden" name="itemID" value="${itemToEdit.itemID}">
<input type="submit" value="Save Edited Item">
</form>

</body>
</html>