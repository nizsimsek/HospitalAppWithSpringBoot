package com.nizdeniz.HospitalApp.DataAccess.Concrete.Hibernate;

import com.nizdeniz.HospitalApp.DataAccess.Abstract.IDegreeDal;
import com.nizdeniz.HospitalApp.Entities.Concrete.Degree;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class DegreeDal implements IDegreeDal {

    private final EntityManager _entityManager;

    @Autowired
    public DegreeDal(EntityManager _entityManager) {
        this._entityManager = _entityManager;
    }

    @Override
    @Transactional
    public List<Degree> GetAll() {
        Session session = _entityManager.unwrap(Session.class);
        return session.createQuery("FROM Degree", Degree.class).getResultList();
    }

    @Override
    @Transactional
    public void Add(Degree entity) {
        Session session = _entityManager.unwrap(Session.class);
        session.saveOrUpdate(entity);
    }

    @Override
    @Transactional
    public void Update(Degree entity) {
        Session session = _entityManager.unwrap(Session.class);
        session.saveOrUpdate(entity);
    }

    @Override
    @Transactional
    public void Delete(Degree entity) {
        Session session = _entityManager.unwrap(Session.class);
        Degree entityToDelete = session.get(Degree.class, entity.getId());
        session.delete(entityToDelete);
    }

    @Override
    @Transactional
    public Degree GetById(int id) {
        Session session = _entityManager.unwrap(Session.class);
        return session.get(Degree.class, id);
    }
}
