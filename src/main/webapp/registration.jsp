<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register Account</title>
        <link href="https://fonts.googleapis.com/css?family=ZCOOL+XiaoWei" rel="stylesheet">
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="container">

            <div class="regbox box">
                <img class="avatar" src="img/collaboration.png">
                <h1>Register your Account</h1>
                <form action="RegisterServlet" method="post">
                    <p>ID Student</p>
                <input type="text" placeholder="ID Student" name="ID" required>
                   <p>Username</p>
                <input type="text" placeholder="User email" name="email" required>
                   <p>Password</p>
                <input type="password" placeholder="Password" name="password" required>
                   <input type="submit" value="Register">
                   <a href="index.jsp">Already have Account?</a>
                   <Br>
                   <%String login_msg=(String)request.getAttribute("error");
                           if(login_msg!=null)out.println("<font color=red size=2px>"+login_msg+"</font>");
                           %>
                </form>
            </div>
        </div>
    </body>
</html>
