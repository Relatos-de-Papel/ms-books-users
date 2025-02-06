package com.unir.users.data;

import com.unir.users.model.pojo.UserType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserTypeJpaRepository extends JpaRepository<UserType, Long> {
    List<UserType> findByName(String name);
}
