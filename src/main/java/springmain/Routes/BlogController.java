package springmain.Routes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springmain.Database.BlogRepository;
import springmain.Models.Blog;

import java.util.List;
import java.util.Map;

@RestController
public class BlogController {

  // Repository for db
  @Autowired
  BlogRepository blogRepository;

  // @route   GET /
  // @desc    Welcome route
  // @access  PUBLIC
  @RequestMapping("/")
  public String index() {
    return "Welcome to your blog";
  }

  // @route   POST /blog
  // @desc    Fetch all blogs
  // @access  PUBLIC
  @GetMapping("/blog")
  public List<Blog> showAll(){
    return blogRepository.findAll();
  }

  // @route   GET /blog/{id}
  // @desc    Fetch blog by id
  // @access  PUBLIC
  @GetMapping("/blog/{id}")
  public Blog show(@PathVariable String id){
    int blogId = Integer.parseInt(id);
    return blogRepository.findOne(blogId);
  }

  // @route   POST /blog/search
  // @desc    Search blog by title / content
  // @access  PUBLIC
  @PostMapping("/blog/search")
  public List<Blog> search(@RequestBody Map<String, String> body){
    String searchTerm = body.get("text");
    return blogRepository.findByTitleContainingOrContentContaining(searchTerm, searchTerm);
  }

  // @route   POST /blog/create
  // @desc    Create new blog
  // @access  PUBLIC
  @PostMapping("/blog/create")
  public Blog create(@RequestBody Map<String, String> body){
    int id = Integer.parseInt(body.get("id"));
    String title = body.get("title");
    String content = body.get("content");
    return blogRepository.save(new Blog(title, content));
  }

  // @route   PUT /blog/update/{id}
  // @desc    Update blog title / content by id
  // @access  PUBLIC
  @PutMapping("/blog/update/{id}")
  public Blog update(@PathVariable String id, @RequestBody Map<String, String> body){
    int blogId = Integer.parseInt(id);
    // getting blog
    Blog blog = blogRepository.findOne(blogId);
    blog.setTitle(body.get("title"));
    blog.setContent(body.get("content"));
    return blogRepository.save(blog);
  }

  // @route   DELETE /blog/delete/{id}
  // @desc    Delete blog by id
  // @access  PUBLIC
  @DeleteMapping("/blog/delete/{id}")
  public boolean delete(@PathVariable String id){
    int blogId = Integer.parseInt(id);
    Blog blog = blogRepository.findOne(blogId);
    blogRepository.delete(blog);
    return true;
  }

}
