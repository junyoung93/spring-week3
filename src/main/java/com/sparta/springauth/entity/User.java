package com.sparta.springauth.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    //@Enumerated= 데이터 enum 타입을 데이터베이스에 저장
    @Enumerated(value = EnumType.STRING) // enum 그대로 스트링으로 저장
    private UserRoleEnum role;

    public User(String username, String password, String email, UserRoleEnum role) {
        this.username= username;
        this.password= password;
        this.email= email;
        this.role= role;
    }
}