package com.vehicle.services.dao;

import com.vehicle.services.model.CustomerTable;
import com.vehicle.services.model.VehicleTable;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by Jordan Dickow on 3/18/2016.
 */
@Component
public class VehicleServicesDAO {
    @SuppressWarnings("all")
    public List<CustomerTable> getAllCustomers(EntityManager em){
        String theQuery = "SELECT c FROM CustomerTable c";
        Query query = em.createQuery(theQuery);
        return query.getResultList();
    }

    @Transactional
    @SuppressWarnings("all")
    public void addCustomer(EntityManager em,String firstName, String lastName, String userName, String email, String phone, String password){
        CustomerTable ct = new CustomerTable();
        ct.setEmail(email);
        ct.setFirstName(firstName);
        ct.setLastName(lastName);
        ct.setPassword(password);
        ct.setPhone(phone);
        ct.setUserName(userName);
        em.persist(ct);
        em.flush();
    }

    @Transactional
    @SuppressWarnings("all")
    public void addVehicle(EntityManager em,String make, String model, Long year, Long mileage, String condition, Long customerId){
        VehicleTable vt = new VehicleTable();
        vt.setCondition(condition);
        vt.setCustomerId(customerId);
        vt.setMake(make);
        vt.setMileage(mileage);
        vt.setYear(year);
        vt.setModel(model);
        em.persist(vt);
        em.flush();
    }
}
