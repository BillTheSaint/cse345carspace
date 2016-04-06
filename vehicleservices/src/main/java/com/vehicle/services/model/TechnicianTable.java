package com.vehicle.services.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Jordan Dickow on 3/18/2016.
 */
@Table(name = "tbl_technician")
@Entity
public class TechnicianTable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "TechnicianID")
    private int technicianId;

    @Column(name = "Tech_FName")
    private String firstName;

    @Column(name = "Tech_LName")
    private String lastName;

    public int getTechnicianId() {
        return technicianId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
