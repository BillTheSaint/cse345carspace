package com.vehicle.services.model;

import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
@Component
public class EntityModel {
    @PersistenceContext(unitName = "database")
    private EntityManager database;

    public EntityManager getEntityManager() {
        return database;
    }
}
