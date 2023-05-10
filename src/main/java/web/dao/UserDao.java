package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {
    List<User> index();
    void save(User user);
    void deleteById(int id);
    User getById(int id);
    void edit(User updatedUser);
}
