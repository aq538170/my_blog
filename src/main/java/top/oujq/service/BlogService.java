package top.oujq.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import top.oujq.dto.BlogDTO;

import java.util.List;

/**
 * @Author: oujq
 * @Date: Create in 2019/7/21 6:39
 */
public interface BlogService {

    BlogDTO findOne(String id);

    Page<BlogDTO> findAll(Pageable pageable);

    BlogDTO save(BlogDTO blogDTO);

    void detele(String id);

    List<BlogDTO> findBlogsByAuthorId(Long authorId);

    List<BlogDTO> findBlogsByCategoryId(Long categoryId);
}
