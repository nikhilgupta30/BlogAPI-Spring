package springmain.Database;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import springmain.Models.Blog;

@Repository
public interface BlogRepositoryBasic extends JpaRepository<Blog, Integer> {
}
