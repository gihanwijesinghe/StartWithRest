<%-- 
    Document   : index.1
    Created on : Nov 9, 2016, 2:14:50 PM
    Author     : Gihan
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
        <div>
<!--            <form action="Project02/webresources/entity.user/testing1" method="POST">
                <label for="email">Email</label>
                <input name="email" /><br/>
                <label for="password">Password</label>
                <input name="password" />
                <br/>
                <input type="submit" value="Submit" />
            </form>
            	<h1>JAX-RS @FormQuery Testing</h1>-->

            <form action="/Project02/webresources/entity.user/testing1" method="post">
                <p>
			Name : <input type="text" name="user" />
                </p>
		<p>
			Age : <input type="text" name="age" />
		</p>
		<input type="submit" value="Add User" />
	</form>
        </div>
    </body>
</html>
