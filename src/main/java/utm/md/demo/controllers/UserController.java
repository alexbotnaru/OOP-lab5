package utm.md.demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import utm.md.demo.entity.User;

@RestController
@RequestMapping("/user")
public class UserController {

@GetMapping
    public User test(){
        User user = new User("user","user");
        return user;
    }
}
