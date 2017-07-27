package system.dao;

import org.springframework.stereotype.Repository;
import system.model.User;

import java.util.Arrays;
import java.util.List;

/**
 * Created by drake on 27/07/17.
 */


// unchanged
@Repository
public class UserDao {


    private List<User> users = Arrays.asList(new User("admin", "admin"),
            new User("test", "test"));

    public List<User> getUsers() {
        return users;
    }

}
