package ru.pre.config.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.pre.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class UserRep {

    @PersistenceContext
    private EntityManager entityManager;
    @Transactional(readOnly = true)
    public List<User> getAllUser() {
        return entityManager.createQuery("FROM User", User.class).getResultList();
    }
    @Transactional(readOnly = true)
    public User getUserById(int id) {
        return entityManager.find(User.class, id);
    }

    public void addNewUser(User user) {
        entityManager.persist(user);
    }

    public void deleteById(int id) {
        User user = entityManager.find(User.class, id);
        if (user != null) {
            entityManager.remove(user);
        }

    }

    public void update(int id, User updatedUser) {
        User user = entityManager.find(User.class, id);
        if (user != null) {
            user.setFullName(updatedUser.getFullName());
            user.setDateOfBirth(updatedUser.getDateOfBirth());
            user.setCountry(updatedUser.getCountry());
        }
    }

}
