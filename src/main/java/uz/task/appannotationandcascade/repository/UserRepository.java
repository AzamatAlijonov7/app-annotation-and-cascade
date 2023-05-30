package uz.task.appannotationandcascade.repository;

import uz.task.appannotationandcascade.entity.User;

import java.util.Optional;

public interface UserRepository {
    User save(User user);

    Optional<Object> findById(Long id);

    void delete(User user);

}
