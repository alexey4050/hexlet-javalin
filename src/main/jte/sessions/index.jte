@import org.example.hexlet.dto.MainPage
@import org.example.hexlet.util.NamedRoutes
@param MainPage page

<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <title>Hello Hexlet!</title>
</head>
<body>
<main>
    <h1>Привет, Хекслет!</h1>
    @if(page.getCurrentUser() != null)
        Добро пожаловать, ${page.getCurrentUser()}.
        Чтобы разлогиниться, удалите куку JSESSIONID из браузера
        <a href="${NamedRoutes.coursesPath()}">Назад к списку курсов</a>
    @else
        <h2>Форма входа</h2>
        <form action="${NamedRoutes.sessionsPath()}" method="post">
            <input type="text" placeholder="Nickname" name="nickname" required class="form-control mb-2" />
            <input type="password" placeholder="Password" name="password" required class="form-control mb-2" />
            <input type="submit" value="Войти" class="btn btn-primary" />
        </form>
    @endif
</main>
</body>
</html>
