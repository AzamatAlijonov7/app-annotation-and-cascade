package uz.task.appannotationandcascade.repository;

import uz.task.appannotationandcascade.entity.User;

public interface UserService {
    User createUser(User user);

    User updateUser(Long id, User user);

    void deleteUser(Long id);

    User getUserById(Long id);
}
