package africa.semicolon.blogProject.dtos.requests;

import lombok.Data;

@Data

public class CreateBlogRequest {
    private String name;
    private String blogUserName;
}
