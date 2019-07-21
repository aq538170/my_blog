package top.oujq.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import top.oujq.entity.Author;

/**
 * @Author: oujq
 * @Date: Create in 2019/7/14 10:14
 */
@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
}
