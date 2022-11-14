package servlets;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import pojo.User;

import javax.jws.soap.SOAPBinding;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Time;

public class BookingServlet extends HttpServlet
{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Configuration configuration=new Configuration().configure();
        SessionFactory sessionFactory=configuration.buildSessionFactory();
        Session session= sessionFactory.openSession();
        Transaction transaction=session.beginTransaction();
        resp.setContentType("text/html");
        PrintWriter printWriter=resp.getWriter();
        int userId=Integer.parseInt(req.getParameter("id"));
        String userName=req.getParameter("userName");
        Time intime=Time.valueOf(req.getParameter("inTime"));
        Time endTime=Time.valueOf(req.getParameter("endTime"));
        if(intime==endTime)
        {
            printWriter.println("booking not allowed");
            RequestDispatcher requestDispatcher= req.getRequestDispatcher("Booking.jsp");
            requestDispatcher.include(req,resp);
        }

    }
}
