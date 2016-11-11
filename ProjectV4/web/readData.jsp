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
            <form method="GET" action="/ProjectV4/webresources/present/gihan">
                get User XML(default gives gihan) :<input type="text" name="user">
                <input type="submit">
            </form>
        </div></Br>
        <div>
            <form method="post" action="/ProjectV4/webresources/presentNew/Postme/readData">
                <p> Read Data </p></Br>
                Insert username :<input type="text" name="user">
                <input type="submit">
            </form>
        </div></Br>
        
<!--        <div>
            <form method="delete" action="/Project03/webresources/presentNew/gihan">
                <p> Read Data </p></Br>
                Insert username :<input type="text" name="user">
                <input type="submit">
            </form>
            Delete gihan account
            <a href="/Project03/webresources/presentNew/gihan">Delete</a>
        </div>-->
        <div>
            <form method="post" action="/ProjectV4/webresources/presentNew/checkDelete">
                <p> Delete Data </p></Br>
                Insert username :<input type="text" name="username">
                <input type="submit">
            </form>
        </div>
    </body>
</html>
