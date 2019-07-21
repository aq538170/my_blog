package top.oujq.dto;

import lombok.Data;
import top.oujq.entity.Author;
import top.oujq.entity.Category;

import java.util.Date;
import java.util.List;

/**
 * @Author: oujq
 * @Date: Create in 2019/7/21 6:47
 */
@Data
public class BlogDTO {

    private String id;

    private String title;

    private String content;

    private Date createTime;

    private Date updateTime;

    private Author author;

    private List<Category> categoryList;

}
