package com.spring.security.demo.Spring.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.HashSet;
import java.util.Set;

public class CustomUserDetails implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    public UserDetails loadUserByUsername(String userEmail){
        UserInfo user = userRepository.findByEmail(userEmail);
        if(user == null){
            throw new UsernameNotFoundException(String.format("User with %s does not exist", userEmail));
        }
        System.out.println("Hey");
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority("USER");
        Set<GrantedAuthority> authorities = new HashSet<>();
        authorities.add(authority);
        User user1 = new User(userEmail, user.password, authorities);
        return user1;
    }
}
