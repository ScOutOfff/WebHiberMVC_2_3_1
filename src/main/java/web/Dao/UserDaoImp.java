package web.Dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.models.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

@Repository
@Component
public class UserDaoImp implements UserDao{

//    @Autowired
//    private SessionFactory sessionFactory;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public void add(User user) {
        entityManager.persist(user);
//        user.setId(++USER_ID);
//        users.add(user);
    }

    @Override
    public User getUserById(int id) {
//        return users.stream().filter(user -> user.getId() == id).findAny().orElse(null);
        return null;
    }

    @Override
    public void editUser(int id, User user) {
//        User userForUpdate = getUserById(id);
//
//        userForUpdate.setName(user.getName());
//        userForUpdate.setLastName(user.getLastName());
//        userForUpdate.setEmail(user.getEmail());
    }

    @Override
    public void delete(int id) {
//        users.removeIf(user -> user.getId() == id);
    }

    @Transactional
    @Override
    @SuppressWarnings("unchecked")
    public List<User> getUserList() {
        return entityManager.createQuery("FROM User", User.class).getResultList();
    }

}
