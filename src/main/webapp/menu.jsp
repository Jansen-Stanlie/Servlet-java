<%@page import="exam06.model.User"%>
<%@page import="java.util.List"%>
<%@page import="exam06.controllers.StudentsDao"%>
<%@page import="exam06.controllers.ConnectionPro"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<%
    StudentsDao std = new StudentsDao(ConnectionPro.getConnection());
    List<User> user = std.getAllStud();
    request.setAttribute("Student", user);
%>


<!DOCTYPE html>
<html>
    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
      <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

        <title>Student Database</title>

        <style>
            .inner{
                margin: 15px 0;
            }
        </style>
    </head>
    <body>
        <div  class="container-fluid">
            <nav class="navbar navbar-light">
                <a class="navbar-brand">Student</a>
                <form class="form-inline">
                     <a class="btn btn-danger" href="index.jsp">Log Out</a>
                </form>
</nav>
        </div>
<div class="container">
            <div class="inner">
                <div class="row">
                    <div class="col-md-3">
                        <h3>Add Student Information</h3>

                        <form action="addStudent" method="post">
                            <div class="form-group">
                                <label>Name</label>
                                <input class="form-control" name="name" place-holder="Student" required>
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
                                 <label>Nilai Fisika</label>
                                 <input class="form-control" name="physics" place-holder="Student" required>
                            </div>
                    <div class="form-group">
                                  <label>Nilai Kalkulus</label>
                                  <input class="form-control" name="calculus" place-holder="Student" required>
                             </div>
                    <div class="form-group">
                                 <label>Nilai Biologi</label>
                                 <input class="form-control" name="biology" place-holder="Student" required>
                             </div>
                            <button type="submit" class="btn btn-primary">Submit</button>
                            <button type="reset" class="btn btn-primary">Reset</button>
                        </form>
                    </div>
                    <div class="col-md-9">
                        <h3>Student Information From Database</h3>
                        <table class="table">
                            <thead class="bg-light">
                                         <th scope="col" style="text-align: center">ID</th>
                                         <th scope="col" style="text-align: center">FULLNAME</th>
                                          <th scope="col" style="text-align: center">Address</th>
                                         <th scope="col" style="text-align: center">STATUS</th>
                                         <th colspan="3" style="text-align: center">
                                           Nilai
                                           <table style="width:100% ; text-align: center">
                                             <tr>
                                               <td>physics</td>
                                               <td>calculus</td>
                                               <td>biologi</td>
                                             </tr>
                                           </table>
                                         </th>
                                       </tr>
                                     </thead>
                            <tbody>
                                        <c:forEach var="tempStd" items="${Student}">
                                        <tr>
                                        <td style="text-align: center">${tempStd.id}</td>
                                        <td style="text-align: center">${tempStd.name}</td>
                                        <td style="text-align: center">${tempStd.address}</td>
                                        <td style="text-align: center">${tempStd.status}</td>
                                        <td style="text-align: center">${tempStd.physics}</td>
                                        <td style="text-align: center">${tempStd.calculus}</td>
                                        <td style="text-align: center">${tempStd.biologi}</td>
                                        <td ></td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                         <a href="editData.jsp" class="btn btn-primary">Edit</a>
                         <a href="delete.jsp" class="btn btn-danger">Delete</a>

                </div>
            </div>
        </div>
</div>
<!-- Optional JavaScript -->
        <!-- jQuery first, then Popper.js, then Bootstrap JS -->
        <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
    </body>
</html>

