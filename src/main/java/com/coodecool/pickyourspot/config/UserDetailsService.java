package com.coodecool.pickyourspot.config;

import com.coodecool.pickyourspot.model.AppUser;
import com.coodecool.pickyourspot.storage.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {
    private final UserRepository userRepository;

    @Autowired
    public UserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<AppUser> optionalUser = userRepository.findByUsername(username);
        if (optionalUser.isEmpty()) {
            throw new UsernameNotFoundException("No such user!");
        }
        AppUser user = optionalUser.get();

        return AppUser.builder()
                .username(user.getUsername())
                .email(user.getEmail())
                .password(user.getPassword())
//               .roles(user.getRoles) //TODO add roles to user
                .build();
    }
}
