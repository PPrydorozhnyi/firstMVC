package system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
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
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public @ResponseBody
    List<User> getUsers() {
        return userService.getUsers();
    }

    @RequestMapping(value = "/validate", method = RequestMethod.GET)
    public ModelAndView validateUser() {
        ModelAndView modelAndView = new ModelAndView();
        // unite UI view and user model
        modelAndView.addObject("userFromServer", new User());
        // page to view
        modelAndView.setViewName("users_check_page");
        return modelAndView;
    }

    //from UI
    @RequestMapping(value = "/check", method = RequestMethod.POST)
    public @ResponseBody String checkUser(@ModelAttribute("userFromServer") User user) {

        if ("admin".equals(user.getPassword()) && "admin".equals(user.getName()))
            return "valid";
        return "invalid";

    }
}
