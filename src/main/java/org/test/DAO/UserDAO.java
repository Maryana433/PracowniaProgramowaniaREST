package org.test.DAO;

import org.test.Entity.User;

import java.util.List;

public interface UserDAO {
    public List<User> getAllUsers();
    public User getUserById(int id);
    public void deleteUser(int id);
    public void saveUser(User user);
    public boolean ifExistUser(int id);
    public List<User> deletedUsers();
}
