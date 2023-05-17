package com.capstone.review.service;

import com.capstone.review.domain.User;
import com.capstone.review.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UserDetailService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        List<User> user =userRepository.findByName(username);

        if(user.isEmpty())  throw new UsernameNotFoundException("d");
        return (UserDetails) user.get(0);
    }
}