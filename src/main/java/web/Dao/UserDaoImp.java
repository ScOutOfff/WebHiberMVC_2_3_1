package web.Dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import web.models.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    public UserDaoImp(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> getUserList() {
        System.err.println("\ngetUserList is now work!\n");
        return entityManager.createQuery("FROM User", User.class).getResultList();
    }
    @Override
    public void add(User user) {
        System.out.println("adding a User is now work!");
        entityManager.persist(user);
    }

    @Override
    public User getUserById(int id) {
        System.out.println("getUserById is now work!");
        return entityManager.find(User.class, id);
    }

    @Override
    public void editUser(int id, User user) {
        System.out.println("editUser is now work!");
        entityManager.merge(user);
    }


    @Override
    public void delete(int id) {
        System.out.println("delete Method is now work!");
        entityManager.remove(getUserById(id));
    }


}
