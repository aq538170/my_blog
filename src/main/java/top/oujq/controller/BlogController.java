package top.oujq.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;
import top.oujq.dto.BlogDTO;
import top.oujq.entity.Author;
import top.oujq.entity.Category;
import top.oujq.form.BlogForm;
import top.oujq.repository.AuthorRepository;
import top.oujq.repository.CategoryRepository;
import top.oujq.service.BlogService;
import top.oujq.utils.JsonUtil;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: oujq
 * @Date: Create in 2019/7/21 14:09
 */
@RestController
@RequestMapping("/blog")
public class BlogController {

    @Autowired
    private BlogService blogService;
    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    @RequestMapping("/list")
    public String list(@RequestParam(value = "page", defaultValue = "1")Integer page,
                       @RequestParam(value = "size", defaultValue = "10")Integer size){
        PageRequest request = PageRequest.of(page - 1, size);
        Page<BlogDTO> blogDTOPage = blogService.findAll(request);

        return JsonUtil.toJson(blogDTOPage);
    }

    @RequestMapping("/detail/{id}")
    public String detail(@PathVariable String id){
        BlogDTO blogDTO = blogService.findOne(id);

        return JsonUtil.toJson(blogDTO);

    }

    @PostMapping("/save")
    public String save(@Valid BlogForm form){
        Author author = new Author();
        Category category = new Category();
        List<Category> categoryList = new ArrayList<>();

        if (null != form.getAuthor()){
            author = authorRepository.getOne(form.getAuthor());
        }
        if (null != form.getCategory()){
            category = categoryRepository.getOne(form.getCategory());
            categoryList.add(category);
        }

        BlogDTO blogDTO = new BlogDTO();
        blogDTO.setTitle(form.getTitle());
        blogDTO.setContent(form.getContent());
        blogDTO.setAuthor(author);
        blogDTO.setCategoryList(categoryList);
        BlogDTO result = blogService.save(blogDTO);

        return JsonUtil.toJson(result);
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable("id") String id){
        blogService.detele(id);

        return "success";
    }
}
