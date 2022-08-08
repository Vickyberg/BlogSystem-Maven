package africa.semicolon.blogProject.data.repositories;

import africa.semicolon.blogProject.data.models.Blog;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BlogRepository extends MongoRepository<Blog, String> {
    Blog findBlogByName(String name);

}
