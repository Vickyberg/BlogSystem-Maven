package africa.semicolon.blogProject.services;

import africa.semicolon.blogProject.data.repositories.UserRepository;
import africa.semicolon.blogProject.dtos.requests.LoginRequest;
import africa.semicolon.blogProject.dtos.requests.RegisterUserRequest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class UserServiceImplTest {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @AfterEach
    void  tearDown(){
        userRepository.deleteAll();
    }

    @Test
    void registerUser_repositorySizeIsOneTest(){
        //given that i have a register form
        //when i try to register
        //check that repository size have increased

        RegisterUserRequest registerUserForm =  new RegisterUserRequest();
        registerUserForm.setEmail("olavictor@gmail.com");
        registerUserForm.setPassword("olamide");
        userService.register(registerUserForm);

        assertEquals(1L, userRepository.count());



    }
    @Test
    void loginUserTest(){
        //given that i have register
        //when i try to login
        //check that i am in
        RegisterUserRequest registerUserForm =  new RegisterUserRequest();
        registerUserForm.setEmail("olavictor@gmail.com");
        registerUserForm.setPassword("olamide");
        userService.register(registerUserForm);


        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setEmail("olavictor@gmail.com");
        loginRequest.setPassword("olamide");
         userService.loginUser(loginRequest);

        assertEquals("olavictor@gmail.com",loginRequest.getEmail());

    }

}