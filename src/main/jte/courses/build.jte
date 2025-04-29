@import org.example.hexlet.util.NamedRoutes
@import org.example.hexlet.dto.courses.CoursesPage
@param CoursesPage page

@template.layout.page(
content = @`
    <form action="${NamedRoutes.coursesPath()}" method="post">
        <lable>
           Название
            <input type="text" name="name">
        </lable>
        <lable>
            Описание
            <input type="text" name="description">
        </lable>
        <input type="submit" value="Создать">
    </form>
`
)