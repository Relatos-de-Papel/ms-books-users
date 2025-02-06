package com.unir.users.model.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserRequest {
    private Integer cc;
    private String firstName;
    private String lastName;
    private String email;
    private Long userTypeId;
}
