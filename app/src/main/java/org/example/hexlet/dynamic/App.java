package org.example.hexlet.dynamic;

import io.javalin.Javalin;

public class App {
    public static Javalin getApp() {
        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
        });
        app.get("/hello", ctx -> {
            String name = ctx.queryParam("name");
            if (name == null || name.isEmpty()) {
                ctx.result("Hello, World");
            } else {
                ctx.result("Hello," + name + "!");
            }
        });
        return app;
    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}
