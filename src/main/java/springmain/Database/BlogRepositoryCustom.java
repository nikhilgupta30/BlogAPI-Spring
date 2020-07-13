package springmain.Database;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import springmain.Models.Blog;

import java.util.List;

@Repository
public interface BlogRepositoryCustom {

  // custom query to search to blog post by title or content
  @Query(value = "SELECT * FROM blog WHERE title LIKE \"%:text\" OR content LIKE \"%:textAgain\";", nativeQuery = true)
  public List<Blog> findByTitleContainingOrContentContaining(String text, String textAgain);

}
