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

@WebServlet("/deleteStudent")
public class deleteStudent extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ID = request.getParameter("ID");
        int IDs = Integer.parseInt(ID);
        try{
            StudentsDao std = new StudentsDao(ConnectionPro.getConnection());
            if(std.deleteData(IDs)){
                RequestDispatcher rd = null;
                request.setAttribute("success","Data Deleted");
                rd =request.getRequestDispatcher("delete.jsp");
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