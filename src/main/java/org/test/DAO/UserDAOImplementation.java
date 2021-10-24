package org.test.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.test.Entity.User;

import java.util.List;

@Repository
public class UserDAOImplementation implements UserDAO{

    @Autowired
    private SessionFactory factory;


    @Override
    public List<User> getAllUsers() {
        Session session = factory.getCurrentSession();
//        List<Employee> allEmployees = session.createQuery("from Employee ").getResultList();
        Query<User> query = session.createQuery("from User where isDeleted = false ",User.class);
        List<User> allEmployees = query.getResultList();

        return allEmployees;
    }

    @Override
    public User getUserById(int id) {
        Session session = factory.getCurrentSession();
        Query<User> query = session.createQuery("from User where isDeleted = false and id =:ID  ",User.class);
        query.setParameter("ID",id);
        List <User> user = query.getResultList();
        if(user.size() == 0){
            return null;
        }
        else {
            User findUser = user.get(0);
            return findUser;
        }
    }

    @Override
    public void deleteUser(int id) {
        Session session = factory.getCurrentSession();
        Query query = session.createQuery("update User set isDeleted = true where id =:ID ");
        query.setParameter("ID",id);
        query.executeUpdate();
    }

    @Override
    public void saveUser(User user) {
        Session session = factory.getCurrentSession();
        if(user.getId()==0){
            session.save(user);
        }
        else{
            session.update(user);
        }
    }

    @Override
    public boolean ifExistUser(int id) {
        Session session = factory.getCurrentSession();
        Query<User> query = session.createQuery("from User where id =:ID  ",User.class);
        query.setParameter("ID",id);
        List <User> user = query.getResultList();
        if(user.size() == 0){
            return false;
        }
        return true;
    }

    @Override
    public List<User> deletedUsers() {
        Session session = factory.getCurrentSession();
//        List<Employee> allEmployees = session.createQuery("from Employee ").getResultList();
        Query<User> query = session.createQuery("from User where isDeleted = true ",User.class);
        List<User> allEmployees = query.getResultList();

        return allEmployees;
    }

}
