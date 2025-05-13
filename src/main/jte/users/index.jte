@import org.example.hexlet.util.NamedRoutes
@import org.example.hexlet.dto.users.UsersPage
@param UsersPage page

@template.layout.page(
    page = page,
content = @`
    <h1>Список пользователей</h1>
    <form action="/users" method="get">
        <input type="search" required name="term" placeholder="Поиск пользователей">
        <input type="submit" value="Искать">
    </form>

    @if(page.getUsers().isEmpty())
        <p>Пока не добавлено ни одного пользователя</p>
    @else
        @for(var user : page.getUsers())
            <div>
                <h2><a href="${NamedRoutes.userPath(user.getId())}">${user.getName()}</a></h2>
                <p>${user.getEmail()}</p>
            </div>
        @endfor
    @endif
`
)

