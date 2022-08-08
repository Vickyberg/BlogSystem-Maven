package africa.semicolon.blogProject.services;

import africa.semicolon.blogProject.data.models.Article;
import africa.semicolon.blogProject.data.models.Blog;
import africa.semicolon.blogProject.dtos.requests.CreateBlogRequest;

public interface BlogService {
    Blog createBlog(CreateBlogRequest request);

}
