package africa.semicolon.blogProject.services;

import africa.semicolon.blogProject.data.models.Blog;
import africa.semicolon.blogProject.data.models.User;
import africa.semicolon.blogProject.data.repositories.UserRepository;
import africa.semicolon.blogProject.dtos.reponses.CreateBlogResponse;
import africa.semicolon.blogProject.dtos.reponses.LoginResponse;
import africa.semicolon.blogProject.dtos.reponses.RegisterUserResponse;
import africa.semicolon.blogProject.dtos.requests.CreateBlogRequest;
import africa.semicolon.blogProject.dtos.requests.LoginRequest;
import africa.semicolon.blogProject.dtos.requests.RegisterUserRequest;
import africa.semicolon.blogProject.exceptions.*;
import africa.semicolon.blogProject.utils.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BlogService blogService;



    @Override
    public RegisterUserResponse register(RegisterUserRequest request) {
        isExist(request);

        User user = new User();
        Mapper.map(request, user);

        userRepository.save(user);

        RegisterUserResponse response = new RegisterUserResponse();
        response.setMessage("Registration successful!");

        return response;

    }

    @Override
    public LoginResponse loginUser(LoginRequest login) {

        User user = userRepository.findByEmail(login.getEmail());
        if(user == null) throw new UserDoesNotExistsException("User does not exist!!");
        else if (!Objects.equals(user.getPassword(),login.getPassword())) throw new PasswordIncorrectException("Password Does not match!!") ;


        LoginResponse response = new LoginResponse();
        response.setMessage(String.format("%s Logged in successfully!!", login.getEmail()));

        return  response;
    }

    @Override
    public CreateBlogResponse createBlog(CreateBlogRequest request) {
        User savedUser = userRepository.findByEmail(request.getBlogUserName());
        if(savedUser.getBlog() !=  null) throw new BlogExistsException(String.format("%s You already have a blog!!!", request.getBlogUserName()));

        Blog blog = blogService.createBlog(request);
        savedUser.setBlog( blog);

        userRepository.save(savedUser);

        CreateBlogResponse response = new CreateBlogResponse();
        response.setMessage(String.format("%s Blog name %s has been created!!!",request.getBlogUserName(), request.getName()));
        return response;
    }


    private void isExist(RegisterUserRequest request) {
        User savedUser = userRepository.findByEmail(request.getEmail());
        if(savedUser != null) throw new UserExistsException(request.getEmail() + " already exists.");
    }
}
