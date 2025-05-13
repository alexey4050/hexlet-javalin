package org.example.hexlet.controller;

import io.javalin.http.Context;
import io.javalin.http.NotFoundResponse;
import io.javalin.validation.ValidationException;
import org.example.hexlet.dto.courses.BuildCoursePage;
import org.example.hexlet.dto.courses.CoursePage;
import org.example.hexlet.dto.courses.CoursesPage;
import org.example.hexlet.model.Course;
import org.example.hexlet.repository.CourseRepository;

import java.util.List;

import static io.javalin.rendering.template.TemplateUtil.model;

public class CourseController {
    public static void index(Context ctx) {
        var term = ctx.queryParam("term");
        List<Course> courses;

        if (term != null && term.isEmpty()) {
            courses = CourseRepository.search(term);
        } else {
            courses = CourseRepository.getEntities();
        }
        var header = "Курсы по программированию";
        var page = new CoursesPage(courses, header, term);
        page.setFlash(ctx.consumeSessionAttribute("flash"));
        ctx.render("courses/index.jte", model("page", page));
    }

    public static void show(Context ctx) {
        var id = ctx.pathParamAsClass("id", Long.class).get();
        var course = CourseRepository.find(id)
                .orElseThrow(() -> new NotFoundResponse("Entity with id = " + id + " not found"));

        var page = new CoursePage(course);
        ctx.render("courses/detail.jte", model("page", page));
    }

    public static void build(Context ctx) {
        ctx.render("courses/build.jte");
    }

    public static void create(Context ctx) {
        var name = ctx.formParam("name");
        try {
            var description = ctx.formParamAsClass("description", String.class)
                    .check(x -> x.length() > 2, "Описание не должно быть меньше двух символов")
                    .check(str -> str.length() < 20, "Описание не должно быть длиннее 20 символов")
                    .get();
            var course = new Course(name, description);
            CourseRepository.save(course);
            ctx.sessionAttribute("flash", "Course has been created!");
            ctx.redirect("/courses");
        } catch (ValidationException e) {
            var description = ctx.formParam("description");
            var page = new BuildCoursePage(name, description, e.getErrors());
            ctx.status(422).render("courses/build.jte", model("page", page));
        }
    }

}
