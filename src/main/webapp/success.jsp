<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login to Menu</title>
        <link href="https://fonts.googleapis.com/css?family=ZCOOL+XiaoWei" rel="stylesheet">
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <link href="css/style2.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="container">
            <div class="box">
                <img class="avatar" src="img/img.png">
                <h1>Welcome to the Club</h1>
                <h3> By Anonymous </h3>
                <a class="icon" href="menu.jsp" >Continue...</a>

                </form><BR>
                <%String login_msg=(String)request.getAttribute("error");
                     if(login_msg!=null)
                     out.println("<font color=red size=4px>"+login_msg+"</font>");%>
</div>
</div>
</body>
</html>

