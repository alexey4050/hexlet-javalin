package org.example.hexlet;

import io.javalin.Javalin;
import io.javalin.rendering.template.JavalinJte;
import org.example.hexlet.controller.UsersController;
import org.example.hexlet.data.Data;
import org.example.hexlet.dto.courses.CoursesPage;
import org.example.hexlet.dto.users.BuildUserPage;
import org.example.hexlet.dto.users.UsersPage;
import org.example.hexlet.repository.UserRepository;
import org.example.hexlet.util.NamedRoutes;

import static io.javalin.rendering.template.TemplateUtil.model;

public class HelloWorld {

    public static void main(String[] args) {

        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
            config.fileRenderer(new JavalinJte());
        });
        app.get("/courses", ctx -> {
            var courses = Data.getCourses();
            var header = "Курсы по программированию";
            var page = new CoursesPage(courses, header);
            ctx.render("courses/index.jte", model("page", page));
        });

        app.get("/courses/{id}", ctx -> {
            var id = ctx.pathParam("id");
            var course = Data.getCourses().stream()
                    .filter(c -> c.getId().equals(id))
                    .findFirst()
                    .orElse(null);

            if (course == null) {
                ctx.status(404);
                ctx.result("Курс не найден");
                return;
            }

            ctx.render("courses/detail.jte", model("course", course));
        });

        app.get(NamedRoutes.buildUserPath(), ctx -> {
            var page = new BuildUserPage();
            ctx.render("users/build.jte", model("page", page));
        });

        app.get("/users/{id}", UsersController::show);

        app.get(NamedRoutes.usersPath(), ctx -> {
            var users = UserRepository.getEntities();
            var page = new UsersPage(users);
            ctx.render("users/index.jte", model("page", page));
        });

        app.start(7070); // Стартуем веб-сервер
    }
}
