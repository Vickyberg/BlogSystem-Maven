package africa.semicolon.blogProject.services;

import africa.semicolon.blogProject.data.models.User;
import africa.semicolon.blogProject.data.repositories.UserRepository;
import africa.semicolon.blogProject.dtos.reponses.RegisterUserResponse;
import africa.semicolon.blogProject.dtos.requests.RegisterUserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;
    @Override
    public RegisterUserResponse registerUser(RegisterUserRequest request) {
        User user = new User();
        user.setEmail(request.getUserName());
        user.setPassword(request.getPassword());
        userRepository.save(user);
        return null;
    }

    @Override
    public RegisterUserResponse register(RegisterUserRequest request) {
        return null;
    }
}
