package africa.semicolon.blogProject.services;

import africa.semicolon.blogProject.data.models.Blog;
import africa.semicolon.blogProject.data.repositories.BlogRepository;
import africa.semicolon.blogProject.dtos.requests.CreateBlogRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BlogServiceImpl implements BlogService{

    @Autowired
    private BlogRepository blogRepository;

    @Override
    public Blog createBlog(CreateBlogRequest request) {
        Blog blog = new Blog();
        blog.setName(request.getBlogUserName());
        return blogRepository.save(blog);
    }
}
