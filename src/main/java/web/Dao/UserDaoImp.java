package web.Dao;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import web.models.User;

import java.util.ArrayList;
import java.util.List;

@Repository
@Component
public class UserDaoImp implements UserDao{
    public static int USER_ID;
    private List<User> users;

    {
        users = new ArrayList<>();

        users.add(new User(++USER_ID,"John", "Favroeu","jFav@gmail.com"));
        users.add(new User(++USER_ID,"Jeck", "Favroeu","jFav@gmail.com"));
        users.add(new User(++USER_ID,"Jill", "Valentain","jVal@gmail.com"));
        users.add(new User(++USER_ID,"Cris", "Redfield","umbrella@gmail.com"));
    }
    @Override
    public void add(User user) {
        user.setId(++USER_ID);
        users.add(user);
    }

    @Override
    public List<User> getUserList() {
        return users;
    }

}
