package ru.savinov.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.savinov.models.User;

import javax.persistence.EntityManager;

import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {
    @PersistenceContext
    private EntityManager em;

    @Override
    public List<User> index() {
        return em.createQuery("from User",User.class).getResultList();
    }
    @Override
    public User show(int id) {
        return em.find(User.class, id);
    }
    @Override
    public void save(User user) {
        em.persist(user);
    }
    @Override
    public void update(User updatedUser,int id) {

        User userToBeUpdated = em.find(User.class, id);
        userToBeUpdated.setName(updatedUser.getName());
        userToBeUpdated.setLastName(updatedUser.getLastName());
    }
    @Override
    public void delete(int id) {
        em.remove(em.find(User.class, id));
    }
}
