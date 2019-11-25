package com.github.meixuesong.hibernatespike.user;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public interface UserJpaRepository extends CrudRepository<User, String> {
}
