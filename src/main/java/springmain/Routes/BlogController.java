package springmain.Routes;

import org.springframework.web.bind.annotation.*;
import springmain.Database.BlogMockedData;
import springmain.Models.Blog;

import java.util.List;
import java.util.Map;

@RestController
public class BlogController {

  BlogMockedData blogMockedData = BlogMockedData.getInstance();

  @RequestMapping("/")
  public String index() {
    return "Welcome to your blog";
  }

  @GetMapping("/blog")
  public List<Blog> showAll(){
    return blogMockedData.fetchBlogs();
  }

  @GetMapping("/blog/{id}")
  public Blog show(@PathVariable String id){
    int blogId = Integer.parseInt(id);
    return blogMockedData.getBlogById(blogId);
  }

  @PostMapping("/blog/search")
  public List<Blog> search(@RequestBody Map<String, String> body){
    String searchTerm = body.get("text");
    return blogMockedData.searchBlogs(searchTerm);
  }

  @PostMapping("/blog/create")
  public Blog create(@RequestBody Map<String, String> body){
    int id = Integer.parseInt(body.get("id"));
    String title = body.get("title");
    String content = body.get("content");
    return blogMockedData.createBlog(id, title, content);
  }

  @PutMapping("/blog/update/{id}")
  public Blog update(@PathVariable String id, @RequestBody Map<String, String> body){
    int blogId = Integer.parseInt(id);
    String title = body.get("title");
    String content = body.get("content");
    return blogMockedData.updateBlog(blogId, title, content);
  }

  @DeleteMapping("/blog/delete/{id}")
  public boolean delete(@PathVariable String id){
    int blogId = Integer.parseInt(id);
    return blogMockedData.delete(blogId);
  }

}
