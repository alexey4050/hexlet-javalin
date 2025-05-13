package org.example.hexlet.dto.users;
import org.example.hexlet.dto.BasePage;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.example.hexlet.model.User;

import java.util.List;

@AllArgsConstructor
@Getter

public class UsersPage extends BasePage{
    public List<User> users;
    private String header;
    private String term;
}
