package com.vehicle.services.dao;

import com.vehicle.services.model.CustomerTable;
import com.vehicle.services.model.EntityModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Jordan Dickow on 3/18/2016.
 */
@Component
public class VehicleServicesModel {
    @Autowired
    public EntityModel em;

    @Autowired
    public VehicleServicesDAO dao;

    public List<CustomerTable> getAllCustomers(){
        return dao.getAllCustomers(em.getEntityManager());
    }

    public void addCustomer(String firstName, String lastName, String userName, String email, String phone, String password){
        dao.addCustomer(em.getEntityManager(), firstName,lastName,userName,email,phone,password);
    }

    public void addVehicle(String make, String model, Long year, Long mileage, String condition, Long customerId){
        dao.addVehicle(em.getEntityManager(),make,model,year,mileage,condition,customerId);
    }
}
