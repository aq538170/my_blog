package top.oujq.converter;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import top.oujq.dto.BlogDTO;
import top.oujq.entity.Author;
import top.oujq.form.BlogForm;
import top.oujq.repository.AuthorRepository;
import top.oujq.repository.CategoryRepository;

/**
 * @Author: oujq
 * @Date: Create in 2019/7/21 21:05
 */
@Data
public class BlogForm2BlogDTOConverter {

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    public BlogDTO convert(BlogForm blogForm){
        Author author = authorRepository.getOne(blogForm.getAuthor());

        return null;
    }
}
