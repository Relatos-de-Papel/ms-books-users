package com.unir.users.service;

import com.unir.users.data.UserJpaRepository;
import com.unir.users.data.UserTypeJpaRepository;
import com.unir.users.model.pojo.User;
import com.unir.users.model.pojo.UserType;
import com.unir.users.model.request.CreateUserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Collections;
import java.util.List;

@Service

public class UsersServiceImpl implements UsersService {

    @Autowired
    private UserJpaRepository userRepository;

    @Autowired
    private UserTypeJpaRepository userTypeJpaRepository;

    @Autowired
    private UserTypeService userTypeService;

    @Override
    public List<User> getUsers() {
        List<User> users = userRepository.findAll();
        return users.isEmpty()? Collections.emptyList():users;
    }
    @Override
    public User getUser(String userId){
        return userRepository.findById(Long.valueOf(userId)).orElse(null);
    }
    @Override
    public Boolean  deleteUser(Long userId){
        User user = userRepository.findById(userId).orElse(null);
        if(user == null){
            return false;
        }else {
            userRepository.delete(user);
            return true;
        }
    }
    @Override
    public User addUser(CreateUserRequest request){
        var userTypeId = userTypeService.getUserTypeById(request.getUserTypeId());
        if(userTypeId == null){
            return null;
        }
        User user = User.builder().cc(request.getCc())
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .userTypeId(userTypeId)
                .build();
        return userRepository.save(user);

    }
    @Override
    public User updateUser(Long userId, CreateUserRequest request) {
        User user = userRepository.findById(userId).orElse(null);
        if (user == null) {
            return null;
        }
        if (request != null && request.getCc() != null &&
                StringUtils.hasLength(request.getFirstName().trim()) &&
                StringUtils.hasLength(request.getLastName().trim()) &&
                StringUtils.hasLength(request.getEmail().trim()) &&
                request.getUserTypeId() != null) {
            // Obtener UserType a partir del ID
            UserType userType = userTypeJpaRepository.findById(request.getUserTypeId()).orElse(null);

            user.setCc(request.getCc());
            user.setFirstName(request.getFirstName());
            user.setLastName(request.getLastName());
            user.setEmail(request.getEmail());
            user.setUserTypeId(userType);

            return userRepository.save(user);
        } else {
            return null;
        }
    }
}
