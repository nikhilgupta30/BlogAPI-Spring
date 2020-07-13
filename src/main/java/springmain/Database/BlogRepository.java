package springmain.Database;

import org.springframework.stereotype.Repository;
import springmain.Models.Blog;

import java.util.List;

@Repository
public interface BlogRepository extends BlogRepositoryBasic, BlogRepositoryCustom {}
