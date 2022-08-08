package africa.semicolon.blogProject.utils;

import africa.semicolon.blogProject.data.models.User;
import africa.semicolon.blogProject.dtos.requests.LoginRequest;
import africa.semicolon.blogProject.dtos.requests.RegisterUserRequest;

public class Mapper {
    public static void  map(RegisterUserRequest request, User user){
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
    }

    public static void map(LoginRequest login, User user){
        user.setEmail(login.getEmail());
        user.setPassword(login.getPassword());
    }
}
