package org.example.hexlet.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Course {
    private String id;
    private String name;
    private String description;
}
