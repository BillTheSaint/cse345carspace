package com.vehicle.services.model;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Jordan Dickow on 3/18/2016.
 */
@Table(name = "tbl_customer")
@Entity
public class CustomerTable {
    private static final long serialVersionUID = 1L;

    @Id @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "CustomerID")
    private int customerId;

    @Column(name = "FirstName")
    private String firstName;

    @Column(name = "LastName")
    private String lastName;

    @Column(name = "UserName")
    private String userName;

    @Column(name = "Email")
    private String email;

    @Column(name = "PhoneNumber")
    private String phone;

    @Column(name = "Password")
    private String password;

    @OneToMany(cascade = CascadeType.ALL, fetch=FetchType.EAGER)
    @JoinColumn(name = "CustomerID", referencedColumnName = "CustomerID")
    @Fetch(FetchMode.JOIN)
    private List<VehicleTable> vehicles;

    public List<VehicleTable> getVehicles() {
        return vehicles;
    }
    public int getCustomerId() {
        return customerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getUserName() {
        return userName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getPassword() {
        return password;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setVehicles(List<VehicleTable> vehicles) {
        this.vehicles = vehicles;
    }
}
