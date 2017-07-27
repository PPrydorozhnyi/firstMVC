package system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import system.dao.UserDao;

import java.util.List;

/**
 * Created by drake on 27/07/17.
 */

@Service
public class UserService {

    @Autowired
    private UserDao dao;

    //additional checks could be added
    public List getUsers() {
        return dao.getUsers();
    }

}
