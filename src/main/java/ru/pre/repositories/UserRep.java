package ru.pre.repositories;

import ru.pre.model.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class UserRep implements Repositories {

    @PersistenceContext
    private EntityManager entityManager;

    public List<User> getAllUser() {
        return entityManager.createQuery("FROM User", User.class).getResultList();
    }

    public User getUserById(int id) {
        User user = entityManager.find(User.class, id);
        if (user == null) {
            throw new EntityNotFoundException("Пользователь не найден");
        }
        return user;
    }

    public void addNewUser(User user) {
        entityManager.persist(user);
    }

    public void deleteById(int id) {
        User user = entityManager.find(User.class, id);
        if (user == null) {
            throw new EntityNotFoundException("Пользователь не найден!");
        }
        entityManager.remove(user);

    }

    public void update(int id, User updatedUser) {
        User user = entityManager.find(User.class, id);
        if (user == null) {
            throw new EntityNotFoundException("Пользователь не найден");
        }
        user.setFullName(updatedUser.getFullName());
        user.setDateOfBirth(updatedUser.getDateOfBirth());
        user.setCountry(updatedUser.getCountry());
    }

}
