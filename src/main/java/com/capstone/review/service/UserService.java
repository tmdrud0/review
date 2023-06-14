package com.capstone.review.service;
import com.capstone.review.domain.User;
import com.capstone.review.repository.UserRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    /**
     * 회원 가입
     */
    @Transactional
    public Long join(User user) {
        validateDuplicateMember(user); //중복 회원 검증
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return user.getId();
    }
    private void validateDuplicateMember(User user) {
        Optional<User> findMember = userRepository.findByName(user.getUsername());
        if (findMember.isPresent()) {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
    }
    //회원 전체 조회
    public List<User> findMembers() {
        return userRepository.findAll();
    }

    public User findOne(Long memberId) {
        return userRepository.findOne(memberId);
    }

}
