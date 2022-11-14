package Dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import pojo.Vehicle;

public class VehicleDaoImpl implements VehicleDao
{
    public void addVehicle()
    {
        Configuration configuration=new Configuration().configure();
        SessionFactory sessionFactory=configuration.buildSessionFactory();
        Session session= sessionFactory.openSession();
        Transaction transaction=session.beginTransaction();

        Vehicle vehicle=new Vehicle();
        vehicle.setModelName("Activa 600");
        vehicle.setVehicleOccupancy(2);
        vehicle.setVehicleType("2 Wheeler");
        vehicle.setRegistrationNumber("MH4747");
        vehicle.setRatePerHour(100.0f);

        Vehicle vehicle1=new Vehicle();
        vehicle.setModelName("Activa 600");
        vehicle.setVehicleOccupancy(2);
        vehicle.setVehicleType("2 Wheeler");
        vehicle.setRegistrationNumber("MH4747");
        vehicle.setRatePerHour(100.0f);

        Vehicle vehicle2=new Vehicle();
        vehicle.setModelName("Honda ");
        vehicle.setVehicleOccupancy(2);
        vehicle.setVehicleType("2 Wheeler");
        vehicle.setRegistrationNumber("MH3743");
        vehicle.setRatePerHour(150.0f);

        Vehicle vehicle3=new Vehicle();
        vehicle.setModelName("Maruti");
        vehicle.setVehicleOccupancy(4);
        vehicle.setVehicleType("4 Wheeler");
        vehicle.setRegistrationNumber("MH3373");
        vehicle.setRatePerHour(450.0f);

        Vehicle vehicle4=new Vehicle();
        vehicle.setModelName("Honda city");
        vehicle.setVehicleOccupancy(4);
        vehicle.setVehicleType("4 Wheeler");
        vehicle.setRegistrationNumber("MH3344");
        vehicle.setRatePerHour(500.0f);

        Vehicle vehicle5=new Vehicle();
        vehicle.setModelName("Ertiga");
        vehicle.setVehicleOccupancy(6);
        vehicle.setVehicleType("4 Wheeler");
        vehicle.setRegistrationNumber("MH8484");
        vehicle.setRatePerHour(800.0f);

        Vehicle vehicle6=new Vehicle();
        vehicle.setModelName("Verna ");
        vehicle.setVehicleOccupancy(6);
        vehicle.setVehicleType("4 Wheeler");
        vehicle.setRegistrationNumber("MH1213");
        vehicle.setRatePerHour(1500.0f);

        session.save(vehicle);
        session.save(vehicle1);
        session.save(vehicle2);
        session.save(vehicle3);
        session.save(vehicle4);
        session.save(vehicle5);
        session.save(vehicle6);

        transaction.commit();

        session.close();
        sessionFactory.close();

    }
}
