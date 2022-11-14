package servlets;

import Dao.UserDao;
import Dao.UserImpl;
import pojo.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/AddUser")
public class UserSignupServlet extends HttpServlet
{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
     resp.setContentType("text/html");
        PrintWriter printWriter=resp.getWriter();
    String userName=req.getParameter("userName").trim();
    long aadharNumber=Long.parseLong(req.getParameter("aadharId"));
    String licenseNumber=req.getParameter("lisceneDetails");
    String city=req.getParameter("city");
        User user=new User(userName,aadharNumber,licenseNumber,city);
        UserImpl userImpl=new UserImpl();
        userImpl.addUser(user);
        RequestDispatcher requestDispatcher= req.getRequestDispatcher("index.jsp");
        printWriter.println("Registration Successful");
        requestDispatcher.forward(req,resp);
    }

}
