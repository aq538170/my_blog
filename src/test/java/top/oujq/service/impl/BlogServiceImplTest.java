package top.oujq.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;
import top.oujq.dto.BlogDTO;
import top.oujq.service.BlogService;

import static org.junit.Assert.*;

/**
 * @Author: oujq
 * @Date: Create in 2019/7/21 7:09
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class BlogServiceImplTest {

    @Autowired
    private BlogService blogService;

    @Test
    public void findOne() {

        BlogDTO blogDTO = blogService.findOne("bl000001");

        System.out.println(blogDTO.toString());
    }

    @Test
    public void findAll() {

        PageRequest request = PageRequest.of(0, 10);
        Page<BlogDTO> blogDTOPage = blogService.findAll(request);

        for (BlogDTO blogDTO : blogDTOPage.getContent()){
            System.out.println(blogDTO.toString());
        }

    }

    @Test
    public void save() {
        BlogDTO blogDTO = blogService.findOne("bk201907210817479428");
        blogDTO.setId("");
        blogDTO.setCreateTime(null);
        blogDTO.setUpdateTime(null);
        BlogDTO result = blogService.save(blogDTO);
        System.out.println(result.toString());
    }

    @Test
    public void detele() {
    }

    @Test
    public void findBlogsByAuthorId() {
    }

    @Test
    public void findBlogsByCategoryId() {
    }
}