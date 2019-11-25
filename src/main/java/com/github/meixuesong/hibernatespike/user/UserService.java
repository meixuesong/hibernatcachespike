package com.github.meixuesong.hibernatespike.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class UserService {
    private UserRepository repository;

    @Autowired
    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public User findById(String id) {
        Optional<User> result = repository.findById(id);

        if (result.isPresent()) {
            return result.get();
        }

        return null;
    }

    @Transactional
    public User updateUser(String id, ChangeUserNameRequest request) {
        Optional<User> result = repository.findById(id);
        if (result.isPresent()) {
            User user = result.get();
            user.setName(request.getName());

            repository.save(user);

            return user;
        }

        return null;
    }
}
