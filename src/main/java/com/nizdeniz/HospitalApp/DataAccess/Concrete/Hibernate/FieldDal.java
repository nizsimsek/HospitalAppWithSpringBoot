package com.nizdeniz.HospitalApp.DataAccess.Concrete.Hibernate;

import com.nizdeniz.HospitalApp.DataAccess.Abstract.IFieldDal;
import com.nizdeniz.HospitalApp.Entities.Concrete.Field;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class FieldDal implements IFieldDal {

    private final EntityManager _entityManager;

    @Autowired
    public FieldDal(EntityManager _entityManager) {
        this._entityManager = _entityManager;
    }

    @Override
    @Transactional
    public List<Field> GetAll() {
        Session session = _entityManager.unwrap(Session.class);
        return session.createQuery("FROM Field", Field.class).getResultList();
    }

    @Override
    @Transactional
    public void Add(Field entity) {
        Session session = _entityManager.unwrap(Session.class);
        session.saveOrUpdate(entity);
    }

    @Override
    @Transactional
    public void Update(Field entity) {
        Session session = _entityManager.unwrap(Session.class);
        session.saveOrUpdate(entity);
    }

    @Override
    @Transactional
    public void DeleteById(int id) {
        Session session = _entityManager.unwrap(Session.class);
        Field entityToDelete = session.get(Field.class, id);
        session.delete(entityToDelete);
    }

    @Override
    @Transactional
    public Field GetById(int id) {
        Session session = _entityManager.unwrap(Session.class);
        return session.get(Field.class, id);
    }
}
