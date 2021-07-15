package exam06.controllers;


import exam06.model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//import sun.text.normalizer.ICUBinary.Authenticate;

@WebServlet("/editStudent")
public class editStudent extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ID = request.getParameter("ID");
        int IDs = Integer.parseInt(ID);
        String name = request.getParameter("Name");
        String address = request.getParameter("address");
        String status = request.getParameter("status");
        String physics =  request.getParameter("Physics");
        String calculus = request.getParameter("Calculus");
        String biology = request.getParameter("Biology");
        int physic = Integer.parseInt(physics);
        int bio = Integer.parseInt(biology);
        int calc = Integer.parseInt(calculus);
        User us = new User(IDs,name,address,status, physic,calc, bio);
        try{
            StudentsDao std = new StudentsDao(ConnectionPro.getConnection());
            if(std.editUser(us)){
                RequestDispatcher rd = null;
                request.setAttribute("success","Data Updated");
                rd =request.getRequestDispatcher("editData.jsp");
                rd.forward(request, response);
            }else{
                response.sendRedirect("editData.jsp");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

//
}