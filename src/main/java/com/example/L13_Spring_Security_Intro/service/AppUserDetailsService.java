package com.example.L13_Spring_Security_Intro.service;

import com.example.L13_Spring_Security_Intro.entity.AppUser;
import com.example.L13_Spring_Security_Intro.repo.IAppUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AppUserDetailsService implements UserDetailsService {

    @Autowired
    private IAppUserRepo appUserRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDetails userDetails = appUserRepo.findByUsername(username);
        if(userDetails == null) {
            throw new UsernameNotFoundException("User does not exists");
        }
        return userDetails;
    }

    public Long createUser(AppUser appUser){
        appUser.setPassword(passwordEncoder.encode(appUser.getPassword()));
        appUserRepo.save(appUser);
        return appUser.getId();
    }
}
