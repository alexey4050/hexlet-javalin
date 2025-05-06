package org.example.hexlet.controller;

import io.javalin.http.Context;
import org.example.hexlet.dto.MainPage;

import static io.javalin.rendering.template.TemplateUtil.model;

public class SessionController {

    public static void  build(Context ctx) {
        ctx.render("sessions/index.jte", model("page", new MainPage(ctx.sessionAttribute("currentUser"))));
    }

    public static void create(Context ctx) {
        var nickname = ctx.formParam("nickname");
        var password = ctx.formParam("password");

        if (nickname == null || nickname.isEmpty()) {
            ctx.status(400).result("Никнейм не может быть пустым");
            return;
        }

        if (password == null || password.isEmpty()) {
            ctx.status(400).result("Пароль не может быть пустым");
            return;
        }

        ctx.sessionAttribute("currentUser", nickname);
        ctx.redirect("/");
    }

    public  static void destroy(Context ctx) {
        ctx.sessionAttribute("currentUser", null);
        ctx.redirect("/");
    }
}
