package com.nizdeniz.HospitalApp.DataAccess.Concrete.Hibernate;

import com.nizdeniz.HospitalApp.DataAccess.Abstract.IUserDal;
import com.nizdeniz.HospitalApp.Entities.Concrete.User;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class UserDal implements IUserDal {

    private final EntityManager _entityManager;

    @Autowired
    public UserDal(EntityManager entityManager) {
        _entityManager = entityManager;
    }

    @Override
    @Transactional
    public List<User> GetAll() {
        Session session = _entityManager.unwrap(Session.class);
        return session.createQuery("FROM User", User.class).getResultList();
    }

    @Override
    @Transactional
    public void Add(User entity) {
        Session session = _entityManager.unwrap(Session.class);
        session.saveOrUpdate(entity);
    }

    @Override
    @Transactional
    public void Update(User entity) {
        Session session = _entityManager.unwrap(Session.class);
        session.saveOrUpdate(entity);
    }

    @Override
    @Transactional
    public void DeleteById(int id) {
        Session session = _entityManager.unwrap(Session.class);
        User entityToDelete = session.get(User.class, id);
        session.delete(entityToDelete);
    }

    @Override
    @Transactional
    public User GetById(int id) {
        Session session = _entityManager.unwrap(Session.class);
        return session.get(User.class, id);
    }
}
