package org.example.hexlet.repository;

import org.example.hexlet.model.User;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserRepository extends BaseRepository {
    //private static final List<User> entities = new ArrayList<>();

    public static void save(User user) throws SQLException {
        String sql = "INSERT INTO users (name, email, password) VALUES (?, ?, ?)";
        try (var conn = dataSource.getConnection();
             var preparedStatement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.executeUpdate();

            var generateKeys = preparedStatement.getGeneratedKeys();
            if (generateKeys.next()) {
                user.setId(generateKeys.getLong(1));
            } else {
                throw new SQLException("DB have not returned an id after saving an entity");
            }
        }
//        user.setId((long) entities.size() + 1);
//        user.setCreatedAt(LocalDateTime.now());
//        entities.add(user);
    }

    public static Optional<User> find(Long id) throws SQLException {
//        var maybeUser = entities.stream()
//                .filter(entity -> entity.getId() == id)
//                .findAny();
//        return maybeUser;
        var sql = "SELECT * FROM users WHERE id = ?";
        try (var conn = dataSource.getConnection();
             var stmt = conn.prepareStatement(sql)) {
            stmt.setLong(1, id);
            var resultSet = stmt.executeQuery();
            if (resultSet.next()) {
                var name = resultSet.getString("name");
                var email = resultSet.getString("email");
                var password = resultSet.getString("password");
                var users = new User(name, email, password);
                users.setId(id);
                return Optional.of(users);
            }
            return Optional.empty();
        }
    }

    public static List<User> search(String term) throws SQLException {
        var sql = "SELECT * FROM users WHERE name LIKE ?";
        try (var conn = dataSource.getConnection();
             var stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, "%" + term + "%");
            var resultSet = stmt.executeQuery();
            var result = new ArrayList<User>();
            while (resultSet.next()) {
                var id = resultSet.getLong("id");
                var name = resultSet.getString("name");
                var email = resultSet.getString("email");
                var password = resultSet.getString("password");
                var user = new User(name, email, password);
                user.setId(id);
                result.add(user);
            }
            return result;
        }
//        var users = entities.stream()
//                .filter(entity -> entity.getName().startsWith(term))
//                .toList();
//        return users;
    }

    public static List<User> getEntities() throws SQLException {
        var sql = "SELECT * FROM users";
        try (var conn = dataSource.getConnection();
             var stmt = conn.prepareStatement(sql)) {
            var resultSet = stmt.executeQuery();
            var result = new ArrayList<User>();
            while (resultSet.next()) {
                var id = resultSet.getLong("id");
                var name = resultSet.getString("name");
                var email = resultSet.getString("email");
                var password = resultSet.getString("password");
                var user = new User(name, email, password);
                user.setId(id);
                result.add(user);
            }
            return result;
        }
    }
}
