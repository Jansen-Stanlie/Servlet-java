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


public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String logemail = request.getParameter("email");
        String logpass = request.getParameter("password");

        UserDatabase db =  new UserDatabase(ConnectionPro.getConnection());
        User user = db.logUser(logemail, logpass);
        boolean e = isValidEmail(logemail);//get boolean regex for valid email
        boolean p = isValidPassword(logpass);//get boolean regex for valid password
        if(e  &&  p){//Validate Email and Password Format Using Regex
                if(user!=null){
                    HttpSession session = request.getSession();
                    request.setAttribute("user", user);
                    RequestDispatcher rd = request.getRequestDispatcher("success.jsp");
                    rd.include(request, response);
                }else{
                    request.setAttribute("error","Invalid Username or Password");
                    RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
                    rd.include(request, response); }
            }else {
                request.setAttribute("error","Invalid Username format or Password format");
                RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
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