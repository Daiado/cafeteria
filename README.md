# Cafeteria API
This API is consisted of 4 microservices
- web```for user interface ```
- user```for user management ```
- order```for order management```
- product```for product management```

# Build Application

If you are not using mac go to /docker folder and run: 
- `docker-compose up` in your terminal, it requires docker on you machine.

If you are using a mac contact me so i can provide a jdk image (mac does not support alpine images)

App will run on http://localhost:8080/

recomennd running it on private browser since the cookie will not refresh and it will stuck the app(or remove the cookie token then your done on a normal browser)

# Specs

- Java Version```17 ```
- Build automation tool ```Gradle ```
- Framework ```Spring boot ```
- Frontend ```thymeleaf```
- Security ```JTW Bearer token (converted to cookie because of thymeleaf)```

Why timeleaf?
- JSP has a lot of issues with SpringBoot and manly with gradle and dockers. Since i don't use both and Thymeleaf was a more compatible choise.

Why not use Maven with JSP?
- I did 3 builds of multimodular projects and their where a lot of issues regarding versions and compatibility.

Why JTW Bearer token instead of 0Auth or keycloak?
- Time reasons

Why no tests?
- Time reasons/ found you about the feign problem.

This project is missing a lot of features and error handling, proper Audit and the FE is super bear bones.

What you would change?
- get rid of the thymeleaf and use something like Angular, and make a proper gateway (this is a plus to all that is missing)
Enjoy Anything let me know