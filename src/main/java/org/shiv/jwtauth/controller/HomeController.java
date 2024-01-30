package org.shiv.jwtauth.controller;

import org.shiv.jwtauth.models.User;
import org.shiv.jwtauth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/home")
public class HomeController {


    @Autowired
    private UserService userService;

  //http:localhost:8080/home/user
@GetMapping("/user")
public List<User> getUsers(){
    System.out.println("Getting Users");
    return this.userService.getUsers();
}
@GetMapping("/current-user")
public String getLoggedUser(Principal principal){
    return principal.getName();
}

}
