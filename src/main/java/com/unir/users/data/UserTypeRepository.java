package com.unir.users.data;

import com.unir.users.model.pojo.UserType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class UserTypeRepository {
    private final UserTypeJpaRepository repository;

    public List<UserType> getUserTypes() {
        return repository.findAll();
    }
    public UserType getById(Long id) {
        return repository.findById(id).orElse(null);
    }
    public UserType save(UserType userType) {
        return repository.save(userType);
    }
    public void delete(UserType userType) {
        repository.delete(userType);
    }
    public List<UserType> findByName(String name) {
        return repository.findByName(name);
    }
}
