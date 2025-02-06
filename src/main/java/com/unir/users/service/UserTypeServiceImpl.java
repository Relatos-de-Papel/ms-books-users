package com.unir.users.service;

import com.unir.users.data.UserTypeRepository;
import com.unir.users.model.pojo.User;
import com.unir.users.model.pojo.UserType;
import com.unir.users.model.request.CreateUserTypeRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserTypeServiceImpl implements UserTypeService {
    @Autowired
    private UserTypeRepository userTypeRepository;

    @Override
    public List<UserType> getUserTypes() {
        return userTypeRepository.getUserTypes();
    }
    @Override
    public UserType getUserTypeById(Long id) {
        return userTypeRepository.getById(id);
    }
    @Override
    public UserType createUserType(CreateUserTypeRequest request){
        UserType userType = new UserType();
        userType.setName(request.getName());
        return userTypeRepository.save(userType);
    }
    @Override
    public UserType updateUserType(Long id, CreateUserTypeRequest request) {
        UserType userType = userTypeRepository.getById(id);
        if (userType != null) {
            userType.setName(request.getName());
            return userTypeRepository.save(userType);
        }
        return null;
    }
    @Override
    public void deleteUserType(Long id) {
        UserType userType = userTypeRepository.getById(id);
        if (userType != null) {
            userTypeRepository.delete(userType);
        }
    }
}
