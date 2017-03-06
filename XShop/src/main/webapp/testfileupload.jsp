<%-- 
    Document   : testfileupload
    Created on : Mar 6, 2017, 5:11:59 PM
    Author     : Merna
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>File upload</h1>
        <form method="post" action="AddNewProduct" enctype="multipart/form-data">
            Select file to upload<input type="file" name="file" size="60"/>
            <input name="test" type="text"/>
            <br><input type="submit" value="Uploads"/>
        </form>
    </body>
</html>
