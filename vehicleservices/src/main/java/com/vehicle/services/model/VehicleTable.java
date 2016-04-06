package com.vehicle.services.model;

import javax.persistence.*;

/**
 * Created by Jordan Dickow on 3/18/2016.
 */
@Table(name = "tbl_vehicle")
@Entity
public class VehicleTable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "VehicleID")
    private Long vehicleId;

    @Column(name = "CustomerID")
    private Long customerId;

    @Column(name = "Make")
    private String make;

    @Column(name = "[Model]")
    private String model;

    @Column(name = "[Year]")
    private Long year;

    @Column(name = "[Mileage]")
    private Long mileage;

    @Column(name = "Condition")
    private String condition;

    public String getCondition() {
        return condition;
    }

    public Long getVehicleId() {
        return vehicleId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public Long getYear() {
        return year;
    }

    public Long getMileage() {
        return mileage;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setYear(Long year) {
        this.year = year;
    }

    public void setMileage(Long mileage) {
        this.mileage = mileage;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }


}
