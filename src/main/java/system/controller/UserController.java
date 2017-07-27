package system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import system.model.User;
import system.service.UserService;

import java.util.List;

/**
 * Created by drake on 27/07/17.
 */

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    //Response from db to client
    public @ResponseBody
    List<User> getUsers() {
        return userService.getUsers();
    }
}
