
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
         <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">

        <title>Edit Student Data</title>
        <style>
            .inner{
                position: relative;
                margin: 0 auto;
                width: 650px;
                display: block;
                padding: 50px 0;
            }
            h3{
                text-align: center;
                border-bottom: 2px solid midnightblue;
                margin-bottom: 20px;
            }
            nav li a{
                font-size: 25px;
                font-weight: 500;
            }
            a{
                color: #fff;
                text-decoration: none;
            }
        </style>
    </head>
    <body>
       <div  class="container-fluid">
            <nav class="navbar navbar-light">
                <a class="navbar-brand">Student Apps</a>
                <ul class="navbar-nav ml-auto mt-3 mx-5">
                     <li class="nav-item">
                    <a class="btn btn-primary" href="index.jsp">logOut</a>
                     </li>
                </ul>
        </nav>
        </div>
<div class="inner">
            <div class=" container">
                <div class="row">
                    <div class="col-12">
                        <h3>Edit Student Details</h3>
                        <form action="editStudent" method="post">
                            <div class="form-group">
                                <label>Student ID</label>
                                <input class="form-control" name="ID" place-holder="Student"required>
                            </div>
                            <div class="form-group">
                                <label>Student Name</label>
                                <input class="form-control" name="Name" place-holder="Student" required>
                            </div>
                            <div class="form-group">
                                 <label>Address</label>
                                 <input class="form-control" name="address" place-holder="Student" required>
                            </div>
                             <div class="form-group">
                                 <label>Status</label>
                                 <input class="form-control" name="status" place-holder="Student" required>
                              </div>
                            <div class="form-group">
                                <label>Physics Grades</label>
                                <input class="form-control" name="Physics" place-holder="Student" required>
                            </div>
                            <div class="form-group">
                                <label>Calculus Grades</label>
                                <input class="form-control" name="Calculus" place-holder="Student" required>
                            </div>
                            <div class="form-group" >
                                <label>Biology Grades</label>
                                <input class="form-control" name="Biology" place-holder="Student" required>
                              </div>
                            <button type="submit" class="btn btn-primary">Submit</button>
                            <button  class="btn btn-primary"><a href="menu.jsp">Cancel</a></button>
                        </form><BR>
                         <%String login_msg=(String)request.getAttribute("success");
                                 if(login_msg!=null)
                        out.println("<font green=red size=3px>"+login_msg+"</font>");%>
</div>
</div>
</div>
</div>
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
        <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>

    </body>
</html>

