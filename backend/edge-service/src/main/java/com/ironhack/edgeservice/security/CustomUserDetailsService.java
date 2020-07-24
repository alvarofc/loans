package com.ironhack.edgeservice.security;


import com.ironhack.edgeservice.model.User;
import com.ironhack.edgeservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service
public class CustomUserDetailsService implements UserDetailsService {

    private UserService userService;

    @Autowired
    public CustomUserDetailsService(UserService userService) {
        this.userService = userService;
    }


    @Transactional
    public UserDetails loadUserByEmail(String email) {
        User user = userService.findUserByEmail(email);
        return UserPrincipal.create(user);
    }

    @Transactional
    public UserDetails loadUserById(Integer id) throws Exception {
        User user = userService.findUserById(id);

        return UserPrincipal.create(user);
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userService.findUserByEmail(s);
        return UserPrincipal.create(user);
    }
}
