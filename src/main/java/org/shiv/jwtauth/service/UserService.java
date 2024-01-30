package org.shiv.jwtauth.service;

import org.shiv.jwtauth.models.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class UserService {
    private List<User> store=new ArrayList<>();

    public UserService() {
        store.add( new User(UUID.randomUUID().toString(),"user1","demo1@gmail.com"));
        store.add( new User(UUID.randomUUID().toString(),"user2","demo2@gmail.com"));
        store.add( new User(UUID.randomUUID().toString(),"user3","demo3@gmail.com"));
        store.add( new User(UUID.randomUUID().toString(),"user4","demo4@gmail.com"));
    }
    public List<User> getUsers(){
        return this.store;
    }
}
