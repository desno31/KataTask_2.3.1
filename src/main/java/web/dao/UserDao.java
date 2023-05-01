package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {
    List<User> index();
    void save(User user);
    void delete(User user);
    User getById(int id);
    void edit(int id, User updatedUser);
}
