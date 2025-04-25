package com.example.spring_rest.service;



import com.example.spring_rest.model.User;
import com.example.spring_rest.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepo repo;
    private BCryptPasswordEncoder encoder=new BCryptPasswordEncoder(10);

    public User saveUser(User user){
        user.setPassword(encoder.encode(user.getPassword()));
        System.out.println(user.getPassword());
        return repo.save(user);

    }

}
