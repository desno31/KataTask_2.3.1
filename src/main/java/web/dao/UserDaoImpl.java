package web.dao;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@Component
@Transactional
public class UserDaoImpl implements UserDao{

    @PersistenceContext
    private EntityManager em;
    @Override
    public List<User> index() {
        return em.createQuery("select u from User u", User.class).getResultList();
    }

    @Override
    public void save(User user) {
        em.persist(user);
    }

    @Override
    public void deleteById(int id) {
        em.remove(em.find(User.class, id));
    }

    @Override
    public User getById(int id) {
        return em.find(User.class, id);
    }

    @Override
    public void edit(User updatedUser) {
        em.merge(updatedUser);
    }
}
