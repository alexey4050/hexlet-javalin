package org.example.hexlet.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@Setter
@ToString

public class User {
    private Long id;

    @ToString.Include
    private String name;

    private String email;
    private String password;
    private LocalDateTime createdAt;
}
