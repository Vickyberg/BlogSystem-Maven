package africa.semicolon.blogProject.services;

import africa.semicolon.blogProject.data.repositories.BlogRepository;
import africa.semicolon.blogProject.dtos.requests.CreateBlogRequest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class BlogServiceImplTest {
   @Autowired
    private BlogService blogService;

   @Autowired
    private BlogRepository blogRepository;

   CreateBlogRequest request;

   @BeforeEach
    void setUp(){
       request = new CreateBlogRequest();
       request.setName("Health And Wellness");
       request.setBlogUserName("Olams_Blog");

   }
   @AfterEach
    void  tearDown(){
       blogRepository.deleteAll();
   }

   @Test
    void blogCanBeCreatedTest(){
       blogService.createBlog(request);
       assertEquals(1L,blogRepository.count());
       assertThat(blogRepository.count(), is(1L));
   }

}
