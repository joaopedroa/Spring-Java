<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Upload arquivo Excel</title>
</head>
<body>

	<form method="post" enctype="multipart/form-data" action="/projetospring/uploadExcelFile">
  			
    		<input type="file" name="file" accept=".xls,.xlsx" /> 
    		<input type="submit" value="Upload file" />
    		
	</form>
	
</body>
</html>