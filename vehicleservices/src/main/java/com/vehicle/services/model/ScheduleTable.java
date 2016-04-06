package com.vehicle.services.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Jordan Dickow on 3/18/2016.
 */
@Table(name = "tbl_schedule")
@Entity
public class ScheduleTable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "AvailID")
    private int availId;

    @Column(name = "VehicleID")
    private int vehicleId;

    @Column(name = "ServiceID")
    private int serviceId;

    @Column(name = "TechnicianID")
    private int technicianId;

    public int getAvailId() {
        return availId;
    }

    public int getVehicleId() {
        return vehicleId;
    }

    public int getServiceId() {
        return serviceId;
    }

    public int getTechnicianId() {
        return technicianId;
    }
}
