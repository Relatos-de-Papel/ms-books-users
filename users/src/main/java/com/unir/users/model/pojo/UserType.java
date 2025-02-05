package com.unir.users.model.pojo;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "usertype")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString

public class UserType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idusertype;

    @Column(name = "name", nullable = false)
    private String name;
}
