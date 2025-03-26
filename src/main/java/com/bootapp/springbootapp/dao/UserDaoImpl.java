package com.bootapp.springbootapp.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import com.bootapp.springbootapp.model.User;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void addUser(User user) {
        em.persist(user);
    }

    @Override
    public List<User> getUsers() {
        return em.createQuery("from User", User.class).getResultList();
    }

    @Override
    public void deleteUser(long id) {
        if (em.find(User.class, id) != null) {
            em.remove(em.find(User.class, id));
        }
    }

    @Override
    public User getUserById(long id) {
        return em.find(User.class, id);
    }

    @Override
    public void editUser(User user) {
        em.merge(user);
    }
}
