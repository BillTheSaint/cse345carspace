package com.vehicle.services.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Jordan Dickow on 3/18/2016.
 */
@Table(name = "tbl_services")
@Entity
public class ServiceTable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ServiceID")
    private int serviceId;

    @Column(name = "ServiceType")
    private String serviceType;

    public int getServiceId() {
        return serviceId;
    }

    public String getServiceType() {
        return serviceType;
    }
}
