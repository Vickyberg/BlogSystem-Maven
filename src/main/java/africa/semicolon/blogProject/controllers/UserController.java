package africa.semicolon.blogProject.controllers;

import africa.semicolon.blogProject.dtos.reponses.RegisterUserResponse;
import africa.semicolon.blogProject.dtos.requests.RegisterUserRequest;
import africa.semicolon.blogProject.exceptions.UserExistsException;
import africa.semicolon.blogProject.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
@Autowired
private UserService userService;

    public ResponseEntity<?> registerUser(@RequestBody RegisterUserRequest request){
try {
    RegisterUserResponse  serviceResponse  =  userService.register(request);
    return new ResponseEntity<>(serviceResponse, HttpStatus.CREATED);
}catch (UserExistsException e){
    return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
}

    }
}
