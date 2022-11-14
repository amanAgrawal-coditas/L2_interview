package servlets;

import Dao.VehicleDao;
import Dao.VehicleDaoImpl;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import pojo.User;
import pojo.Vehicle;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/Login")
public class LoginServlet extends HttpServlet
{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        Configuration configuration=new Configuration().configure();
        SessionFactory sessionFactory=configuration.buildSessionFactory();
        Session session= sessionFactory.openSession();
        Transaction transaction=session.beginTransaction();
        resp.setContentType("text/html");
        PrintWriter printWriter=resp.getWriter();
        int userId=Integer.parseInt(req.getParameter("id"));
        String username=req.getParameter("userName");
        long aadharId=Long.parseLong(req.getParameter("aadharId"));
        User user=session.find(User.class,userId);
        String name=user.getUserName();
        long aadhar= user.getAadharNumber();
        int id=user.getUserId();
        if (name.equals(username)&&aadharId==aadhar&&id==userId)
        {
            printWriter.println("Login successful");
            VehicleDaoImpl vehicleDao=new VehicleDaoImpl();
            vehicleDao.addVehicle();
            Query query = session.createQuery("from Vehicle");
            List<Vehicle> list = query.list();
            transaction.commit();
            list.stream().forEach(System.out::println);
        }
        else
        {
            printWriter.println("Invalid credentials");
            RequestDispatcher requestDispatcher= req.getRequestDispatcher("Login.jsp");
            requestDispatcher.forward(req,resp);
        }
    }
}
