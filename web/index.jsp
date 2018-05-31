<%-- 
    Document   : index
    Created on : May 31, 2018, 7:13:07 PM
    Author     : sapu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <form name="f1" action="MailDispatcher" method="post">
            email:<input type="text" name="email"/>
            <br>
            sub:<input type="text" name="sub"/>
            </br>
            message:<input type="text" name="msg"/>
            <input type="submit" value="submit"/>
        </form>
    </body>
</html>
