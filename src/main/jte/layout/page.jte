@import gg.jte.Content
@import org.example.hexlet.util.NamedRoutes
@param Content content
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Мой сайт</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <div class="container-fluid">
            <a class="navbar-brand" href="/">Мой сайт</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false"
                    aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav">
                    <li class="nav-item">
                        <a class="nav-link" href="${NamedRoutes.buildUserPath()}">Создать пользователя</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="${NamedRoutes.usersPath()}">Поиск пользователя</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="${NamedRoutes.coursesPath()}">Поиск курсов</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="${NamedRoutes.buildCoursePath()}">Создание курсов</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>

<main class="container mt-4">
    ${content}
</main>

<footer class="bg-light text-center py-3">
    <p>&copy; 2025 <a href="https://github.com/alexey4050" target="_blank">Мой профиль на GitHub</a></p>
</footer>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
