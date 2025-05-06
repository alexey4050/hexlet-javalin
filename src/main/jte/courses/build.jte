@import org.example.hexlet.util.NamedRoutes
@import org.example.hexlet.dto.courses.CoursesPage
@param CoursesPage page

@template.layout.page(
content = @`
    <form action="${NamedRoutes.coursesPath()}" method="post">
        <label>
           Название
            <input type="text" name="name">
        </label>
        <label>
            Описание
            <input type="text" name="description">
        </label>
        <input type="submit" value="Создать">
    </form>
`
)