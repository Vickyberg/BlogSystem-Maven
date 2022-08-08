package africa.semicolon.blogProject.data.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.util.ArrayList;
import java.util.List;
@Data
public class Blog {
    @Id
    private String id;
    private String name;
    @DBRef
    private List<Article> articles = new ArrayList<>();


}
