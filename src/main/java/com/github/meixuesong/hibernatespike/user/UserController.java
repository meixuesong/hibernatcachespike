package com.github.meixuesong.hibernatespike.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    private UserService service;

    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public User findOrder(@PathVariable String id) {
        User user = service.findById(id);

        return user;
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateOrder(@PathVariable String id, @RequestBody ChangeUserNameRequest request) {
        service.updateUser(id, request);
    }


}
