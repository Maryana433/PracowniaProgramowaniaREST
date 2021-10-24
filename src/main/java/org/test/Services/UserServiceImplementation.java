package org.test.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.test.DAO.UserDAOImplementation;
import org.test.Entity.User;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserServiceImplementation implements UserService {

    @Autowired
    private UserDAOImplementation userDAOImplementation;

    @Override
    @Transactional
    public List<User> getAllUsers() {
        return userDAOImplementation.getAllUsers();
    }

    @Override
    @Transactional
    public User getUserById(int id) {
        return userDAOImplementation.getUserById(id);
    }

    @Override
    @Transactional
    public void deleteUser(int id) {
        userDAOImplementation.deleteUser(id);
    }

    @Override
    @Transactional
    public void saveUser(User user) {
         userDAOImplementation.saveUser(user);
    }

    @Override
    @Transactional
    public boolean ifExistUser(int id) {
        return userDAOImplementation.ifExistUser(id);
    }

    @Override
    @Transactional
    public List<User> deletedUsers() {
        return userDAOImplementation.deletedUsers();
    }
}
