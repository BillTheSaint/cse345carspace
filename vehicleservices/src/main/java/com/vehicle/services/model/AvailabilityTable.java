package com.vehicle.services.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by Jordan Dickow on 3/18/2016.
 */
@Table(name = "tbl_availibility")
@Entity
public class AvailabilityTable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "AvailID")
    private int availId;

    @Column(name = "TimeSlot")
    private Date timeSlot;

    @Column(name = "Technician")
    private String technician;

    @Column(name = "IsAvail")
    private int isAvailable;

    public int getAvailId() {
        return availId;
    }

    public Date getTimeSlot() {
        return timeSlot;
    }

    public String getTechnician() {
        return technician;
    }

    public int getIsAvailable() {
        return isAvailable;
    }
}
