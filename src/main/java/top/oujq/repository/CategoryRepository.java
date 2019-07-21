package top.oujq.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import top.oujq.entity.Category;

import java.util.List;

/**
 * @Author: oujq
 * @Date: Create in 2019/7/14 10:15
 */
@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    List<Category> findCategoriesByCategoryIdIn(List<Long> categoryIds);
}
