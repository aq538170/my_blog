package top.oujq.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

/**
 * @Author: oujq
 * @Date: Create in 2019/7/14 10:08
 */
@Entity
@Data
public class Blog {

    @Id
    private String id;

    private String title;

    private String content;

    private Long authorId;

    private Date createTime;

    private Date updateTime;
}
