<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login to Menu</title>
        <link href="https://fonts.googleapis.com/css?family=ZCOOL+XiaoWei" rel="stylesheet">
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="container">
            <div class="box">
                <img class="avatar" src="img/180403151_JANSEN STANLIE_FOTO.jpg">
                <h1>Login Account</h1>
                <form action="LoginServlet" method="post">
                    <p>Username</p>
                <input type="text" placeholder="Username" name="email" required>
                    <p>Password</p>
                <input type="password" placeholder="Password" name="password" required>
                    <input type="submit" value="Login">
                    <a href="registration.jsp">Create New Account</a>

                </form><BR>
                <%String login_msg=(String)request.getAttribute("error");
                     if(login_msg!=null)
                     out.println("<font color=red size=4px>"+login_msg+"</font>");%>
</div>
</div>
</body>
</html>

