package pojo;

import javax.persistence.*;
import java.util.List;

@Entity
public class User
{
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;
    private String userName;
    @Column(unique = true)
    private long aadharNumber;
    private String licenseNumber;
    private String city;
    @OneToMany(mappedBy = "user")
    private List<Booking>bookings;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public long getAadharNumber() {
        return aadharNumber;
    }

    public void setAadharNumber(long aadharNumber) {
        this.aadharNumber = aadharNumber;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", aadharNumber=" + aadharNumber +
                ", licenseNumber='" + licenseNumber + '\'' +
                ", city='" + city + '\'' +
                ", bookings=" + bookings +
                '}';
    }

    public User() {
    }

    public User(String userName, long aadharNumber, String licenseNumber, String city) {
        this.userName = userName;
        this.aadharNumber = aadharNumber;
        this.licenseNumber = licenseNumber;
        this.city = city;
    }
}
