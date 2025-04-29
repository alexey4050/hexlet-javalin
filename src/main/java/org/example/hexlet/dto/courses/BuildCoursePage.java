package org.example.hexlet.dto.courses;
import lombok.AllArgsConstructor;
import lombok.Getter;

import io.javalin.validation.ValidationError;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@AllArgsConstructor
@Getter
@Setter

public class BuildCoursePage {
    private String name;
    private String description;
    private Map<String, List<ValidationError<Object>>> errors;
}
