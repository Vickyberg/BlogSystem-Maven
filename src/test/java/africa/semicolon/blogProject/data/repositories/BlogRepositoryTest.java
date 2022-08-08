package africa.semicolon.blogProject.data.repositories;

import africa.semicolon.blogProject.data.models.Blog;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static com.mongodb.assertions.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
@SpringBootTest
public class BlogRepositoryTest {

    @Autowired
    private  BlogRepository blogRepository;

    @Test
    void  blogCanBeCreatedTest(){
        Blog blog  = new Blog();
        Blog createdBlog = blogRepository.save(blog);
        assertEquals(1,blogRepository.count());
        assertNotNull(createdBlog.getId());
    }
}
