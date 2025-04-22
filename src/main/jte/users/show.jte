@import org.example.hexlet.dto.users.UserPage
@param UserPage page

@template.layout.page(
content = @`
    <h1>${page.getUser().getName()}</h1>
    <p>Email: ${page.getUser().getEmail()}</p>
    <a href="/users" class="btn btn-primary">Назад к списку пользователей</a>
`
)
