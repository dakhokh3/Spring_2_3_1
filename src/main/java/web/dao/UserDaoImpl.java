package web.dao;

import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {
    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public void saveUser(User user) {
        entityManager.merge( user);
    }

    @Override
    public void removeUserById(long id) {
        User user = entityManager.find(User.class, id);
        entityManager.remove(user);
    }

    @Override
    public List<User> getAllUsers() {
        List<User> userList = new ArrayList<>();
        userList = entityManager.createQuery("from User").getResultList();
        return userList;
    }


    @Override
    public User getUser(Long id) {
        User user = entityManager.find(User.class, id);
        return user;
    }
}
