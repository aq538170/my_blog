//package top.oujq.entity;
//
//import lombok.Data;
//import org.hibernate.annotations.DynamicUpdate;
//import org.hibernate.annotations.Proxy;
//
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//
///**
// * @Author: oujq
// * @Date: Create in 2019/7/14 10:36
// */
//@Entity
//@Data
//@DynamicUpdate
//@Proxy(lazy = false)
//public class Blogtest {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Integer blogId;
//
//    private String title;
//
//    private String content;
//
//    private String author;
//
//    private String category;
//
//    public Blogtest() {
//    }
//
//    public Blogtest(String title, String content, String author, String category) {
//        this.title = title;
//        this.content = content;
//        this.author = author;
//        this.category = category;
//    }
//}
