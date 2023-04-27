package web.Dao;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.models.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Component
public class UserDaoImp implements UserDao{

//    @Autowired
//    private SessionFactory sessionFactory;

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    @Override
    public void add(User user) {
        System.out.println("adding a User is now work!");
        entityManager.persist(user);
    }

    @Transactional
    @Override
    public User getUserById(int id) {
        System.out.println("getUserById is now work!");
        return entityManager.find(User.class, id);
    }

    @Override
    public void editUser(int id, User user) {
        System.out.println("editUser is now work!");
//        User userForUpdate = getUserById(id);
//
//        userForUpdate.setName(user.getName());
//        userForUpdate.setLastName(user.getLastName());
//        userForUpdate.setEmail(user.getEmail());
    }

    //DONT WORK
    @Transactional
    @Override
    public void delete(int id) {
        System.out.println("delete Method is now work!");
        entityManager.remove(getUserById(id));
    }

    @Transactional
    @Override
    @SuppressWarnings("unchecked")
    public List<User> getUserList() {
        System.out.println("getUserList is now work!");
        return entityManager.createQuery("FROM User", User.class).getResultList();
    }

}
