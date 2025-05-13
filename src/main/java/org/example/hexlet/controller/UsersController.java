package org.example.hexlet.controller;

import io.javalin.http.Context;
import io.javalin.http.NotFoundResponse;
import io.javalin.validation.ValidationException;
//import org.example.hexlet.dto.courses.CoursesPage;
import org.example.hexlet.dto.users.BuildUserPage;
import org.example.hexlet.dto.users.UserPage;
import org.example.hexlet.dto.users.UsersPage;
//import org.example.hexlet.model.Course;
import org.example.hexlet.model.User;
//import org.example.hexlet.repository.CourseRepository;
import org.example.hexlet.repository.UserRepository;
//import org.example.hexlet.util.NamedRoutes;

import java.util.List;

import static io.javalin.rendering.template.TemplateUtil.model;

public class UsersController {
    public static void index(Context ctx) {
        var term = ctx.queryParam("term");
        List<User> users;

        if (term != null && term.isEmpty()) {
            users = UserRepository.search(term);
        } else {
            users = UserRepository.getEntities();
        }
        var header = "Список пользователей";
        var page = new UsersPage(users, header, term);
        page.setFlash(ctx.consumeSessionAttribute("flash"));
        ctx.render("users/index.jte", model("page", page));
    }

    public static void show(Context ctx) {
        try {
            var id = ctx.pathParamAsClass("id", Long.class).get();
            var user = UserRepository.find(id)
                    .orElseThrow(() -> new NotFoundResponse("Entity with id = " + id + " not found"));
            var page = new UserPage(user);
            ctx.render("users/show.jte", model("page", page));
        } catch (NotFoundResponse e) {
            ctx.status(404);
            ctx.result(String.valueOf(e));
        }
    }

    public static void build(Context ctx) {
        try {
            ctx.render("users/build.jte", model("page", new BuildUserPage(null, null, null)));
        } catch (Exception e) {
            e.printStackTrace(); // Вывод ошибки в консоль
            ctx.status(500).result("Ошибка рендеринга страницы создания пользователя");
        }
    }

    public static void create(Context ctx) {
        var name = ctx.formParam("name");
        var email = ctx.formParam("email");

        if (email != null) {
            email = email.trim().toLowerCase();
        }

        try {
            var passwordConfirmation = ctx.formParam("passwordConfirmation");
            var password = ctx.formParamAsClass("password", String.class)
                    .check(value -> value.equals(passwordConfirmation), "Пароли не совпадают")
                    .check(x -> x.length() > 6, "Пароль слишком короткий")
                    .get();
            var user = new User(name, email, password);
            UserRepository.save(user);
            ctx.sessionAttribute("flash", "User add to list!");
            ctx.redirect("/users");
        } catch (ValidationException e) {
            var page = new BuildUserPage(name, email, e.getErrors());
            ctx.status(422).render("users/build.jte", model("page", page));
        } catch (Exception e) {
            e.printStackTrace();
            ctx.status(500).result("Server Error: " + e.getMessage());
        }
    }
}
