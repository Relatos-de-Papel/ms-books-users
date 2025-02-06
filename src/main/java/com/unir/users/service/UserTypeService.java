package com.unir.users.service;

import com.unir.users.model.pojo.UserType;
import com.unir.users.model.request.CreateUserTypeRequest;
import java.util.List;

public interface UserTypeService {
    List<UserType> getUserTypes();
    UserType getUserTypeById(Long id);
    UserType createUserType(CreateUserTypeRequest request);
    UserType updateUserType(Long id, CreateUserTypeRequest request);
    void deleteUserType(Long id);
}
