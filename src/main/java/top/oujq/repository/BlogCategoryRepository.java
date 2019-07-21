package top.oujq.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import top.oujq.entity.BlogCategory;

import java.util.List;

/**
 * @Author: oujq
 * @Date: Create in 2019/7/21 6:34
 */
public interface BlogCategoryRepository extends JpaRepository<BlogCategory, Long> {

    List<BlogCategory> findBlogCategoriesByBlogId(String blogId);

    List<BlogCategory> findBlogCategoriesByCategoryId(Long categoryId);


}
