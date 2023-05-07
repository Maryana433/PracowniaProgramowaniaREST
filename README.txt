        БАЗА ДАННЫХ :
CREATE DATABASE  PP;
USE PP;



CREATE TABLE users (
  id int NOT NULL AUTO_INCREMENT,
  name varchar(30),
  surname varchar(30),
  data_of_birth Date,
  login varchar(30),
  is_deleted boolean,
  PRIMARY KEY (id)
);

----------------------------------------------------------------------------------------
    Описание REST методов :

1)    @GetMapping("/users")
      public List<User> showUsers()

      - return all not deleted user ( isDeleted = false )

2)    @GetMapping("/users/{id}")
      public User showUserById(@PathVariable int id)

      - return user by id with isDeleted = false

3)    @PostMapping("/users")
      public User addNewUser(@RequestBody User user)

      - add new user
      - return new user

       JSON

          {
              "date": 1020290400000,  --https://planetcalc.ru/7157/
              "name": "IVAN",
              "surname": "IVANOV",
              "login": "ivan",
              "deleted": false -- by default false
          }

4)     @DeleteMapping("/users/{id}")
      public String deleteUser(@PathVariable int id)

      -
      1)
                "There is no User with id = "+id
      2) 
                "User with id = "+id+" already deleted "
      3) 
                "User with id = "+id+" was deleted"


5)      @PutMapping("/users")
        public User updateUser(@RequestBody User user)

        - modify user
            1) "There is no User with id = "+user.getId()
            2) Modify if user with id exists

6)    @GetMapping("/users/deleted")
      public List<User> showDeletedUsers()

     - return deleted users
