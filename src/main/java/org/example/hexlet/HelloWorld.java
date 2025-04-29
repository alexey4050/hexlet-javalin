package org.example.hexlet;

import io.javalin.Javalin;
import io.javalin.http.NotFoundResponse;
import io.javalin.rendering.template.JavalinJte;
import io.javalin.validation.ValidationException;
import org.example.hexlet.controller.CourseController;
import org.example.hexlet.controller.UsersController;
import org.example.hexlet.dto.courses.BuildCoursePage;
import org.example.hexlet.dto.courses.CoursePage;
import org.example.hexlet.dto.courses.CoursesPage;
import org.example.hexlet.dto.users.BuildUserPage;
import org.example.hexlet.dto.users.UsersPage;
import org.example.hexlet.model.Course;
import org.example.hexlet.model.User;
import org.example.hexlet.repository.CourseRepository;
import org.example.hexlet.repository.UserRepository;
import org.example.hexlet.util.NamedRoutes;

import java.util.List;

import static io.javalin.rendering.template.TemplateUtil.model;

public class HelloWorld {

    public static void main(String[] args) {

        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
            config.fileRenderer(new JavalinJte());
        });

        app.get(NamedRoutes.buildUserPath(), UsersController::build);
        app.get(NamedRoutes.usersPath(), UsersController::index);
        app.get("/users/{id}", UsersController::show);
        app.post("/users", UsersController::create);

        app.get(NamedRoutes.buildCoursePath(), CourseController::build);
        app.get("/courses", CourseController::index);
        app.get("/courses/{id}", CourseController::show);
        app.post("/courses", CourseController::create);


//        app.get(NamedRoutes.buildCoursePath(), ctx -> {
//            ctx.render("courses/build.jte");
//        });
//
//        app.get("/courses", ctx -> {
//           var term = ctx.queryParam("term");
//            List<Course> courses;
//
//            if (term != null && term.isEmpty()) {
//                courses = CourseRepository.search(term);
//            } else {
//                courses = CourseRepository.getEntities();
//            }
//                var header = "Курсы по программированию";
//                var page = new CoursesPage(courses, header, term);
//
//            ctx.render("courses/index.jte", model("page", page));
//        });
//
//        app.get("/courses/{id}", ctx -> {
//            var id = ctx.pathParamAsClass("id", Long.class).get();
//            var course = CourseRepository.find(id)
//                    .orElseThrow(() -> new NotFoundResponse("Entity with id = " + id + " not found"));
//
//            if (course == null) {
//                ctx.status(404);
//                ctx.result("Курс не найден");
//                return;
//            }
//            var page = new CoursePage(course);
//            ctx.render("courses/detail.jte", model("page", page));
//        });
//
//        app.post("/courses", ctx -> {
//            var name = ctx.formParam("name");
//            try {
//                var description =ctx.formParamAsClass("description", String.class)
//                        .check(x -> x.length() > 2, "Описание не должно быть меньше двух символов")
//                        .check(str -> str.length() < 20, "Описание не должно быть длиннее 20 символов")
//                        .get();
//                var course = new Course(name, description);
//                CourseRepository.save(course);
//                ctx.redirect("/courses");
//            } catch (ValidationException e) {
//                var description = ctx.formParam("description");
//                var page = new BuildCoursePage(name, description, e.getErrors());
//                ctx.status(422).render("courses/build.jte", model("page", page));
//            }
//        });

//        app.get(NamedRoutes.buildUserPath(), ctx -> {
//            var page = new BuildUserPage();
//            ctx.render("users/build.jte", model("page", page));
//        });
//
//        app.get("/users/{id}", ctx -> {
//            Long id = Long.valueOf(ctx.pathParam("id"));
//            var user = UserRepository.find(id).orElse(null);
//            if (user == null) {
//                ctx.status(404);
//                ctx.result("Пользователь не найден");
//            }
//        });
//
//        app.get(NamedRoutes.usersPath(), ctx -> {
//            var users = UserRepository.getEntities();
//            var page = new UsersPage(users);
//            ctx.render("users/index.jte", model("page", page));
//        });
//
//        app.post("/users", ctx -> {
//            var name = ctx.formParam("name");
//            var email = ctx.formParam("email");
//
//            if (email != null) {
//                email = email.trim().toLowerCase();
//            }
//
//            try {
//                var passwordConfirmation = ctx.formParam("passwordConfirmation");
//                var password = ctx.pathParamAsClass("password", String.class)
//                        .check(value -> value.equals(passwordConfirmation), "Password are nor the same")
//                        .check(value -> value.length() > 6, "Password is not short")
//                        .get();
//                var user = new User(name, email, password);
//                UserRepository.save(user);
//                ctx.redirect(NamedRoutes.usersPath());
//
//            } catch (ValidationException e) {
//                var page = new BuildUserPage(name, email, e.getErrors());
//                ctx.render("users/build.jte", model("page", page));
//            }
//        });

        app.start(7070); // Стартуем веб-сервер
    }
}
