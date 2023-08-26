package com.chuka.testtask.service;

import com.chuka.testtask.entity.UserEntity;
import com.chuka.testtask.repo.UserRepo;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;


@AllArgsConstructor
@Slf4j
@Service
public class UserService {
    UserRepo userRepo;
    private BCryptPasswordEncoder encoder(){return new BCryptPasswordEncoder();}

    public void saveUser(UserEntity user){
        user.setPassword(encoder().encode(user.getPassword()));
        userRepo.save(user);
    }

    public List<UserEntity> getAll() {
        return userRepo.findAll();
    }
}
