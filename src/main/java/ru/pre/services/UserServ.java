package ru.pre.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.pre.repositories.Repositories;
import ru.pre.repositories.UserRep;
import ru.pre.model.User;

import java.util.List;

@Service
@Transactional
public class UserServ implements Services {
    private Repositories userRep;

    @Autowired
    public UserServ(Repositories userRep) {
        this.userRep = userRep;
    }

    @Transactional(readOnly = true)
    public List<User> getAllUser() {
        return userRep.getAllUser();
    }

    @Transactional(readOnly = true)
    public User getUserById(int id) {
        return userRep.getUserById(id);
    }

    public void addNewUser(User user) {
        userRep.addNewUser(user);
    }

    public void deleteById(int id) {
        userRep.deleteById(id);
    }

    public void update(int id, User updatedUser) {
        userRep.update(id, updatedUser);
    }
}
