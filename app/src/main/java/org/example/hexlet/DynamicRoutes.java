package org.example.hexlet;

import io.javalin.Javalin;

public class DynamicRoutes {
    public static void main(String[] args) {
        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
        });

        app.get("/users", ctx -> ctx.result("GET /users"));
        app.post("/users", ctx -> ctx.result("POST /users"));

        app.get("users/{id}/post/{postId}", ctx -> {
            var userId = ctx.pathParam("id");
            var postId = ctx.pathParam("postId");
            ctx.result("User ID: " + userId + " Post ID: " + postId);
        });

        app.error(404, ctx -> {
            ctx.result("Custom Not Found Message: The requested resource was not found.");
            ctx.status(404);
        });

        app.start(7070);
    }
}
