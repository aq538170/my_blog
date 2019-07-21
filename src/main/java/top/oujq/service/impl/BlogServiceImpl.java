package top.oujq.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import top.oujq.dto.BlogDTO;
import top.oujq.entity.Author;
import top.oujq.entity.Blog;
import top.oujq.entity.BlogCategory;
import top.oujq.entity.Category;
import top.oujq.repository.AuthorRepository;
import top.oujq.repository.BlogCategoryRepository;
import top.oujq.repository.BlogRepository;
import top.oujq.repository.CategoryRepository;
import top.oujq.service.BlogService;
import top.oujq.utils.KeyUtil;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: oujq
 * @Date: Create in 2019/7/21 6:40
 */
@Service("blogService")
@Transactional
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogRepository blogRepository;
    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private BlogCategoryRepository blogCategoryRepository;



    @Override
    public BlogDTO findOne(String id) {
        Blog blog = blogRepository.getOne(id);
        Author author = authorRepository.getOne(blog.getAuthorId());
        List<BlogCategory> blogCategoryList = blogCategoryRepository.findBlogCategoriesByBlogId(id);
        List<Long> categoryIds = new ArrayList<>();
        for (BlogCategory category : blogCategoryList){
            categoryIds.add(category.getCategoryId());
        }

        List<Category> categoryList = categoryRepository.findCategoriesByCategoryIdIn(categoryIds);

        BlogDTO blogDTO = new BlogDTO();
        BeanUtils.copyProperties(blog, blogDTO);
        blogDTO.setAuthor(author);
        blogDTO.setCategoryList(categoryList);

        return blogDTO;
    }

    @Override
    public Page<BlogDTO> findAll(Pageable pageable) {
        Page<Blog> blogPage = blogRepository.findAll(pageable);
        List<Blog> blogList = blogPage.getContent();
        List<BlogDTO> blogDTOList = new ArrayList<>();
        for (Blog blog : blogList){
            blogDTOList.add(findOne(blog.getId()));
        }

        Page<BlogDTO> blogDTOPage = new PageImpl<>(blogDTOList);

        return blogDTOPage;
    }

    @Override
    public BlogDTO save(BlogDTO blogDTO) {

        Blog blog = new Blog();
        BeanUtils.copyProperties(blogDTO, blog);
        if (null == blog.getId() || "".equals(blog.getId())){
            String blogId = KeyUtil.genUniqueKey("bk");
            blog.setId(blogId);
        }

        blog.setAuthorId(blogDTO.getAuthor().getAuthorId());

//        System.out.println(blog);

        Blog blogResult = blogRepository.save(blog);

        List<Category> categoryList = blogDTO.getCategoryList();
        List<BlogCategory> blogCategoryList = new ArrayList<>();


        for (Category category : categoryList){
            blogCategoryList.add(new BlogCategory(blogResult.getId(), category.getCategoryId()));
//            BlogCategory blogCategory = new BlogCategory(blogResult.getId(), category.getCategoryId());
//            blogCategoryRepository.save(new BlogCategory(blogId, category.getCategoryId()));
//            blogCategoryRepository.save(blogCategory);
        }

        blogCategoryRepository.saveAll(blogCategoryList);

        BeanUtils.copyProperties(blog, blogDTO);

        return blogDTO;
    }

    @Override
    public void detele(String id) {

        List<BlogCategory> blogCategoryList = blogCategoryRepository.findBlogCategoriesByBlogId(id);
        blogCategoryRepository.deleteAll(blogCategoryList);
        blogRepository.deleteById(id);

    }

    @Override
    public List<BlogDTO> findBlogsByAuthorId(Long authorId) {
        return null;
    }

    @Override
    public List<BlogDTO> findBlogsByCategoryId(Long categoryId) {
        return null;
    }
}
