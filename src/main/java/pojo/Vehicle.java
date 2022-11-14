package pojo;

import javax.persistence.*;

@Entity
public class Vehicle
{
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int vehicleId;
    private String vehicleType ;
    private String modelName;
    private String registrationNumber;
    private int vehicleOccupancy;
    private float ratePerHour;
    @OneToOne(mappedBy = "vehicle")
    private Booking booking;

    public int getVehicleId()
    {
        return vehicleId;
    }

    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public int getVehicleOccupancy() {
        return vehicleOccupancy;
    }

    public void setVehicleOccupancy(int vehicleOccupancy) {
        this.vehicleOccupancy = vehicleOccupancy;
    }

    public float getRatePerHour() {
        return ratePerHour;
    }

    public void setRatePerHour(float ratePerHour) {
        this.ratePerHour = ratePerHour;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "vehicleId=" + vehicleId +
                ", vehicleType='" + vehicleType + '\'' +
                ", modelName='" + modelName + '\'' +
                ", registrationNumber='" + registrationNumber + '\'' +
                ", vehicleOccupancy=" + vehicleOccupancy +
                ", ratePerHour=" + ratePerHour +
                '}';
    }
}
