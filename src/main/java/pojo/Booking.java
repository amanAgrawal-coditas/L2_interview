package pojo;

import javax.persistence.*;
import java.sql.Time;
@Entity

public class Booking
{
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookingId;
    private Time pickUpTime;
    private Time returnTime;
    @ManyToOne
    private User user;
    @OneToOne
    private Vehicle vehicle;

    public Booking() {
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public Time getPickUpTime() {
        return pickUpTime;
    }

    public void setPickUpTime(Time pickUpTime) {
        this.pickUpTime = pickUpTime;
    }

    public Time getReturnTime() {
        return returnTime;
    }

    public void setReturnTime(Time returnTime) {
        this.returnTime = returnTime;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Booking(Time pickUpTime, Time returnTime)
    {
        this.pickUpTime = pickUpTime;
        this.returnTime = returnTime;
    }

}
