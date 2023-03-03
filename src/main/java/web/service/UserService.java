package web.service;

import web.model.User;

import java.util.List;

public interface UserService {
    void saveUser(User user);

    User getUser(Long id);

    void removeUserById(long id);

    List<User> getAllUsers();

}
