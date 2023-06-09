package com.capstone.review.repository;

import com.capstone.review.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class UserRepository {

    private final EntityManager em;

    public void save(User user) {
        em.persist(user);
    }

    public User findOne(Long id) {
        return em.find(User.class, id);
    }

    public List<User> findAll() {
        return em.createQuery("select m from User m", User.class)
                .getResultList();
    }

    public Optional<User> findByName(String name) {
        return em.createQuery("select m from User m where m.username = :name", User.class)
                .setParameter("name", name)
                .getResultStream()
                .findAny();
    }

}
