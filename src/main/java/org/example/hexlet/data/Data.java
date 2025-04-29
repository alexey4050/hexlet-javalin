package org.example.hexlet.data;

import org.example.hexlet.model.Course;

import java.util.Arrays;
import java.util.List;

public class Data {
    public static List<Course> getCourses() {
        return Arrays.asList(
                new Course("Java для начинающих", "Изучите основы Java."),
                new Course("Python для всех", "Изучите Python с нуля."),
                new Course("Web-разработка", "Создайте свой первый веб-сайт.")
        );
    }
}
