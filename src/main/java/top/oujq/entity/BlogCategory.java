package top.oujq.entity;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Proxy;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @Author: oujq
 * @Date: Create in 2019/7/21 6:31
 */
@Entity
@Data
//@DynamicUpdate
@Proxy(lazy = false)
public class BlogCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String blogId;

    private Long categoryId;

    public BlogCategory(){}

    public BlogCategory(String blogId, Long categoryId){
        this.blogId = blogId;
        this.categoryId = categoryId;
    }
}
