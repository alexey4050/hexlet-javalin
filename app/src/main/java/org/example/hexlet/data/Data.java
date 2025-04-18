package org.example.hexlet.data;

import org.example.hexlet.model.Course;

import java.util.Arrays;
import java.util.List;

public class Data {
    public static List<Course> getCourses() {
        return Arrays.asList(
                new Course("1", "Java для начинающих", "Изучите основы Java."),
                new Course("2", "Python для всех", "Изучите Python с нуля."),
                new Course("3", "Web-разработка", "Создайте свой первый веб-сайт.")
        );
    }


}
