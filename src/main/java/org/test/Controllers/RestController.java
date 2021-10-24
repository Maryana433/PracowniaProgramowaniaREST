package org.test.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.test.Entity.User;
import org.test.ExceptionHandler.NoSuchUserException;
import org.test.Services.UserService;


import java.util.List;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api")
public class RestController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<User> showUsers(){
        List<User> users = userService.getAllUsers();
        return users;
    }

    @GetMapping("/users/{id}")
    public User showUserById(@PathVariable int id){
        User user = userService.getUserById(id);
        if (user == null){
            throw new NoSuchUserException("There is no User with id =  "+id);
        }
        else
            return user;
    }

    // добавление нового пользователя без id
    @PostMapping("/users")
    public User addNewUser(@RequestBody User user){
        userService.saveUser(user);
        return user;
    }


    /*
    1) Пользователя вообще нет в базе
    2) Пользователь есть , но уже удален
    3) Если прошлые не сработали - пользователь есть в базе и не удален - удаляем его .
     */
    @DeleteMapping("/users/{id}")
    public String deleteUser(@PathVariable int id){
        if(!userService.ifExistUser(id)){
            throw new NoSuchUserException("There is no User with id = "+id);
        }
        else if(userService.getUserById(id).isDeleted()){
            throw new NoSuchUserException("User with id = "+id+" already deleted ");
        }
        else {
            userService.deleteUser(userService.getUserById(id).getId());
        }
        return "User with id = "+id+" was deleted";
    }

    /*
    1) Пользователя нет в базе
    2) Есть в базе
     */
    @PutMapping("/users")
    public User updateUser(@RequestBody User user){
        if(userService.ifExistUser(user.getId())){
            userService.saveUser(user);
            return user;
        }
        else{
            throw new NoSuchUserException("There is no User with id = "+user.getId());
        }
    }

    @GetMapping("/users/deleted")
    public List<User> showDeletedUsers(){
        return userService.deletedUsers();
    }
}
