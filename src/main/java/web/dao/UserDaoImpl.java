package web.dao;

import org.springframework.stereotype.Component;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@Component
public class UserDaoImpl implements UserDao{

    @PersistenceContext
    private EntityManager em;
    @Override
    public List<User> index() {

        List<User> users = new ArrayList<>();
//        users.add(new User("q","w",12));
//        users.add(new User("q","w",12));
//        users.add(new User("q","w",12));
//        users.add(new User("q","w",12));
//        users.add(new User("q","w",12));
        em.getTransaction().begin();
        users = em.createQuery("select User from User").getResultList();
        em.getTransaction().commit();
        return users;
    }

    @Override
    public void save(User user) {
        em.getTransaction().begin();
        this.em.persist(user);
        em.getTransaction().commit();
    }

    @Override
    public void delete(User user) {

    }

    @Override
    public User getById(int id) {
        return null;
    }

    @Override
    public void edit(int id, User updatedUser) {

    }
}
