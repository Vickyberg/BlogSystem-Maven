package africa.semicolon.blogProject.services;

import africa.semicolon.blogProject.data.repositories.UserRepository;
import africa.semicolon.blogProject.dtos.requests.RegisterUserRequest;
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

    @Test
    void registerUser_repositorySizeIsOneTest(){
        //given that i have a register form
        //when i try to register
        //check that repository size have increased

        RegisterUserRequest registerUserForm =  new RegisterUserRequest();
        registerUserForm.setUserName("olavictor");
        registerUserForm.setPassword("olamide");
        userService.registerUser(registerUserForm);

        assertEquals(1L, userRepository.count());


;
    }

}