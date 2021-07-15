package exam06.controllers;


import exam06.model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.regex.Pattern;

//import sun.text.normalizer.ICUBinary.Authenticate;

@WebServlet("/addStudent")
public class addStudent extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String status = request.getParameter("status");
        String address = request.getParameter("address");
        String physics =  request.getParameter("physics");
        String calculus = request.getParameter("calculus");
        String biology = request.getParameter("biology");
         int physic = Integer.parseInt(physics);
         int bio = Integer.parseInt(biology);
         int calc = Integer.parseInt(calculus);
       User us = new User(name,address, status, physic,calc, bio);
       try{
           StudentsDao std = new StudentsDao(ConnectionPro.getConnection());
           if(std.addStudent(us)){
               response.sendRedirect("menu.jsp");
           }
       }catch (Exception e){
           e.printStackTrace();
       }
    }

//
}