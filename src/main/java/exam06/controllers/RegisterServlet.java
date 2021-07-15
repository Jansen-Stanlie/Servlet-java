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
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ID = request.getParameter("ID");
        int IDs = Integer.parseInt(ID);
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        //make user object
        //create a database model
        User userModel = new User(IDs, email, password);
        UserDatabase regUser = new UserDatabase(ConnectionPro.getConnection());
        boolean e = isValidEmail(email);//get boolean regex for valid email
        boolean p = isValidPassword(password);//get boolean regex for valid password
        if(e  &&  p){//Validate Email and Password Format Using Regex
            try {
                if (regUser.saveUser(userModel)) {
                    response.sendRedirect("index.jsp");
                } else {
                    String errorMessage = "User UnAvailable";
                    HttpSession regSession = request.getSession();
                    regSession.setAttribute("RegError", errorMessage);
                    response.sendRedirect("registration.jsp");
                } }catch (Exception f){
                f.printStackTrace();
            } }else {
            request.setAttribute("error","Invalid Username format or Password format");
            RequestDispatcher rd=request.getRequestDispatcher("registration.jsp");
            rd.include(request, response);
        }

    }
    public static boolean isValidEmail(String email){// regex validation for email
        // Regex to check valid email.
        String regex = "([a-zA-Z0-9]+(?:[._+-][a-zA-Z0-9]+)*)@([a-zA-Z0-9]+(?:[.-][a-zA-Z0-9]+)*[.][a-zA-Z]{2,})";
        // Compile the ReGex
        boolean b = Pattern.matches(regex, email);
        if (email == null) {
            return false;
        }
        return b;
    }
    public static boolean isValidPassword(String password){//regex Validation for password
        // Regex to check valid password.
        String regex = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=_])(?=\\S+$).{8,}";
        // Compile the ReGex
        boolean b1 = Pattern.matches(regex, password);
        if (password == null) {
            return false;
        }
        return b1;
    }
//
}