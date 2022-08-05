package africa.semicolon.blogProject.services;

import africa.semicolon.blogProject.dtos.reponses.RegisterUserResponse;
import africa.semicolon.blogProject.dtos.requests.RegisterUserRequest;

public interface UserService {


    RegisterUserResponse register(RegisterUserRequest request);
}
