package com.example.spring_rest.service;



import com.example.spring_rest.model.User;
import com.example.spring_rest.repo.UserRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepo repo;
    PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

    @Transactional
    public User saveUser(User user){
        user.setPassword(encoder.encode(user.getPassword()));
        //System.out.println(user.getPassword());
        return repo.save(user);
    }

}
