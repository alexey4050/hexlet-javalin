/*
 * This source file was generated by the Gradle 'init' task
 */
package org.example;

import io.javalin.Javalin;

public class HelloWorld {

    public static void main(String[] args) {

        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
        });
        // Описываем, что загрузится по адресу /
        app.get("/", ctx -> ctx.result("Hello World"));
        app.start(7070); // Стартуем веб-сервер
    }
}
