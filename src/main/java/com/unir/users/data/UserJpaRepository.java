package com.unir.users.data;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.unir.users.model.pojo.User;

public interface UserJpaRepository extends JpaRepository<User, Long> {
    List<User> findByFirstName(String firstName);
}
