@import org.example.hexlet.dto.users.BuildUserPage
@import org.example.hexlet.util.NamedRoutes
@param BuildUserPage page

@template.layout.page(
content = @`
    @if(page.getErrors() != null)
        <ul>
            @for(var validator : page.getErrors().values())
                @for(var error : validator)
                    <li>${error.getMessage()}</li>
                @endfor
            @endfor
        </ul>
    @endif
    <form action="${NamedRoutes.usersPath()}" method="post">
        <div class="mb-3">
            <label for="nameInput" class="form-label">Имя</label>
            <input type="text" class="form-control" id="nameInput" name="name" value="${page.getName()}" placeholder="Ваше имя" required>
        </div>
        <div class="mb-3">
            <label for="emailInput" class="form-label">Email</label>
            <input type="email" class="form-control" id="emailInput" name="email" value="${page.getEmail()}" placeholder="example@email.ru" required>
        </div>
        <div class="mb-3">
            <label for="passwordInput" class="form-label">Пароль</label>
            <input type="password" class="form-control" id="passwordInput" name="password" placeholder="Пароль" required>
        </div>
        <div class="mb-3">
            <label for="passwordConfirmInput" class="form-label">Подтверждение пароля</label>
            <input type="password" class="form-control" id="passwordConfirmInput" name="passwordConfirmation" placeholder="Подтвердите пароль" required>
        </div>
        <input type="submit" value="Зарегистрироваться">
    </form>
`
)
