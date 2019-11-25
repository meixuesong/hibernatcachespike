package com.github.meixuesong.hibernatespike.user;

import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UserRepository {
    private UserJpaRepository repository;

    public UserRepository(UserJpaRepository repository) {
        this.repository = repository;
    }

    public Optional<User> findById(String id) {
        return repository.findById(id);
    }

    public void save(User user) {
        Optional<User> newResult = repository.findById(user.getId());
        User newUser = newResult.get();
        newUser.setName(user.getName());

        repository.save(newUser);
    }
}
