package com.nizdeniz.HospitalApp.DataAccess.Concrete.Hibernate;

import com.nizdeniz.HospitalApp.DataAccess.Abstract.IPatientDal;
import com.nizdeniz.HospitalApp.Entities.Concrete.Patient;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class PatientDal implements IPatientDal {

    private final EntityManager _entityManager;

    @Autowired
    public PatientDal(EntityManager _entityManager) {
        this._entityManager = _entityManager;
    }

    @Override
    @Transactional
    public List<Patient> GetAll() {
        Session session = _entityManager.unwrap(Session.class);
        return session.createQuery("FROM Patient", Patient.class).getResultList();
    }

    @Override
    @Transactional
    public void Add(Patient entity) {
        Session session = _entityManager.unwrap(Session.class);
        session.saveOrUpdate(entity);
    }

    @Override
    @Transactional
    public void Update(Patient entity) {
        Session session = _entityManager.unwrap(Session.class);
        session.saveOrUpdate(entity);
    }

    @Override
    @Transactional
    public void Delete(Patient entity) {
        Session session = _entityManager.unwrap(Session.class);
        Patient entityToDelete = session.get(Patient.class, entity.getId());
        session.delete(entityToDelete);
    }

    @Override
    @Transactional
    public Patient GetById(int id) {
        Session session = _entityManager.unwrap(Session.class);
        return session.get(Patient.class, id);
    }
}
