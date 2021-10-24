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

      - возвращает всех не удаленных пользователей ( те у кого в колонке isDeleted = false )

2)    @GetMapping("/users/{id}")
      public User showUserById(@PathVariable int id)

      - возвращает пользователя по id , если в колонке isDeleted = false

3)    @PostMapping("/users")
      public User addNewUser(@RequestBody User user)

      - добавление нового пользователя ( id не надо указывать )
      - возвращает добаленного пользователя

      Пример JSON

          {
              "date": 1020290400000,  -- конвертирую с помощью сайта https://planetcalc.ru/7157/
              "name": "IVAN",
              "surname": "IVANOV",
              "login": "ivan",
              "deleted": false -- можно не указывать - по умолчанию будет false
          }

4)     @DeleteMapping("/users/{id}")
      public String deleteUser(@PathVariable int id)

      -
      1) Пользователя вообще нет в базе -
                "There is no User with id = "+id
      2) Пользователь есть , но уже удален ( isDeleted = true ) -
                "User with id = "+id+" already deleted "
      3) Если прошлые не сработали - пользователь есть в базе и не удален - удаляем его . -
                "User with id = "+id+" was deleted"

      - Возвращает строку


5)      @PutMapping("/users")
        public User updateUser(@RequestBody User user)

        - модифицирует пользователя
            1) Пользователя нет в базе - "There is no User with id = "+user.getId()
            2) Пользователь есть ( без разницы на значение isDeleted ) - модифицирует
        - пример JSON в пунтке 3) - ОБЯЗАТЕЛЬНО УКАЗЫВАТЬ id !!!

6)    @GetMapping("/users/deleted")
      public List<User> showDeletedUsers()

     - возвращат всех удаленных пользователей
