## Развертывание проекта
- git clone https://github.com/rivertuq/calories-tracker.git
- cd calories-tracker
- mvn spring-boot:run

## Настройка базы данных
  ```json

spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/название созданной вами бд
    username: ваш логин
    password: ваш пароль

  jpa:
    hibernate:
      ddl-auto: update
    show-sql: true

``` 
## Postman-коллекция для тестирования API
- Коллекция находится в:
  ```json
  
    /scr/postman/tracker.postman_collection.json
  
  ```
- Чтобы импортировать коллекцию в Postman необходимо:
- **1) Открыть Postman → Import**
- **2) Выбрать tracker.postman_collection.json → view complete documentation**
