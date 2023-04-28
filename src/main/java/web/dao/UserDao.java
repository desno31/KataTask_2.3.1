package web.dao;

import web.model.User;

public interface UserDao {
    User index();
    void save(User user);
    void delete(User user);
    User getById(int id);
    void edit(int id, User updatedUser);
}
