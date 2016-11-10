<%-- 
    Document   : index
    Created on : Nov 9, 2016, 12:49:56 PM
    Author     : Gihan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Neth Fm</title>
    </head>
    <body>
        <h1>Your in the Home Page</h1></Br>
        <div>
            <form method="post" action="/Project02/webresources/pesentNew/Postme">
                User :<input type="text" name="user">
                <input type="submit">
            </form>
        </div></Br>
        <div>
            <form method="post" action="/Project03/webresources/presentNew/Postme/readData">
                <p> Read Data </p></Br>
                Insert username :<input type="text" name="user">
                <input type="submit">
            </form>
        </div></Br>
        <div>
            <a href="/Project03/webresources/presentNew">Continue</a>
        </div>
    </body>
</html>
