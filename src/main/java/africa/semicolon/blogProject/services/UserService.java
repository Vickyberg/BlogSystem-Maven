package africa.semicolon.blogProject.services;

import africa.semicolon.blogProject.dtos.reponses.LoginResponse;
import africa.semicolon.blogProject.dtos.reponses.RegisterUserResponse;
import africa.semicolon.blogProject.dtos.requests.LoginRequest;
import africa.semicolon.blogProject.dtos.requests.RegisterUserRequest;

public interface UserService {


    RegisterUserResponse register(RegisterUserRequest request);

    LoginResponse loginUser(LoginRequest login);

}
