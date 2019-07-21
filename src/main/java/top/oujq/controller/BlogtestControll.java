//package top.oujq.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//import top.oujq.entity.Blogtest;
//import top.oujq.repository.BlogtestRepository;
//import top.oujq.utils.JsonUtil;
//
//import java.util.List;
//
///**
// * @Author: oujq
// * @Date: Create in 2019/7/14 10:46
// */
//@RestController
//@RequestMapping("/blog")
//public class BlogtestControll {
//
//    @Autowired
//    private BlogtestRepository blogtestRepository;
//
//    @RequestMapping("/list")
//    public String list(){
//        List<Blogtest> blogList = blogtestRepository.findAll();
//
//
//        return JsonUtil.toJson(blogList);
//
//    }
//
//    @GetMapping("/detail/{blogId}")
//    public String findOne(@PathVariable("blogId") Integer blogId){
//
//        Blogtest blogtest;
//        try {
//            blogtest = blogtestRepository.getOne(blogId);
//        }catch (Exception e){
//            return "blogId不正确";
//        }
//
//        if (null != blogtest){
//            return JsonUtil.toJson(blogtest);
//        } else {
//            return "blogId不正确";
//        }
//
//
//    }
//
//    @RequestMapping("/delete")
//    public String delete(@RequestParam Integer id){
//        blogtestRepository.deleteById(id);
//
//        return "success";
//    }
//
//
//    @PostMapping("/save")
//    public String save(@RequestBody Blogtest blogtest){
//
//        Blogtest result = blogtestRepository.save(blogtest);
//
//        if (null == result){
//            return "error";
//        }
//
//        return "success";
//    }
//}
