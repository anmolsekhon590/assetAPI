package com.anmolsekhon.interviewproject.services;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * Service Layer - Contains business logic
 * */
@Service
public class UserService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        Hardcoded user
        if (username.equals("admin"))
            return new User("admin", "password", new ArrayList<>());
        else
            throw new UsernameNotFoundException("User with username " + username + " not found");
    }
}
