package top.oujq.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import top.oujq.entity.Blog;

import java.util.List;

/**
 * @Author: oujq
 * @Date: Create in 2019/7/14 10:13
 */
@Repository
public interface BlogRepository extends JpaRepository<Blog, String> {

    List<Blog> findBlogsByAuthorId(Long authorId);
}
