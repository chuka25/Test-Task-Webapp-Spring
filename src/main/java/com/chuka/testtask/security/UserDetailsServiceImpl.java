package com.chuka.testtask.security;

import com.chuka.testtask.entity.UserEntity;
import com.chuka.testtask.repo.UserRepo;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    UserRepo userRepo;
    @Override
    @Transactional
    public UserDetailsImpl loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = userRepo.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException("User with email '" + username + "' not found"));
        return UserDetailsImpl.build(user);
    }
}
