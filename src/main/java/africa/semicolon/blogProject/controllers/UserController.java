package africa.semicolon.blogProject.controllers;

import africa.semicolon.blogProject.dtos.reponses.LoginResponse;
import africa.semicolon.blogProject.dtos.reponses.RegisterUserResponse;
import africa.semicolon.blogProject.dtos.requests.CreateBlogRequest;
import africa.semicolon.blogProject.dtos.requests.LoginRequest;
import africa.semicolon.blogProject.dtos.requests.RegisterUserRequest;
import africa.semicolon.blogProject.exceptions.*;
import africa.semicolon.blogProject.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/user")

    public ResponseEntity<?> registerUser(@RequestBody RegisterUserRequest request) {
        try {
            RegisterUserResponse serviceResponse = userService.register(request);
            return new ResponseEntity<>(serviceResponse, HttpStatus.CREATED);
        } catch (UserExistsException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }

    @PostMapping("/login")

    public ResponseEntity<?> loginUser(@RequestBody LoginRequest loginRequest) {
        try {
            return new ResponseEntity<>(userService.loginUser(loginRequest), HttpStatus.ACCEPTED);
        }catch (UserDoesNotExistsException | PasswordIncorrectException e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }

    }

   @PatchMapping("/user")
    public ResponseEntity<?> createBlog(@RequestBody CreateBlogRequest request){
        try {
            return new ResponseEntity<>(userService.createBlog(request), HttpStatus.CREATED);
        } catch (BlogExistsException e){
            return  new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }
}
