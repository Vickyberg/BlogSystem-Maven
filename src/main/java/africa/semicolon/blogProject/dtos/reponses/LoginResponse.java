package africa.semicolon.blogProject.dtos.reponses;

import lombok.Data;


@Data

public class LoginResponse {
    private String email;
    private String password;
    private String message;
}
