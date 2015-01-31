//package org.hawklithm.backyard.web.controller;
//
//import hello.Greeting;
//import org.hawklithm.backyard.domain.dao.ArticleInfoDAO;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.concurrent.atomic.AtomicLong;
//
///**
// * Created by bluehawky on 2014/12/9 0009.
// */
//@RestController
//public class GreetingController {
//    @Autowired
//    @Qualifier("userMapDao")
//    private ArticleInfoDAO articleInfoDao;
//
//    private static final String template = "Hello, %s!";
//    private final AtomicLong counter = new AtomicLong();
//
//    @RequestMapping("/query/article/detail")
//    public Greeting greeting(@RequestParam(value="name", defaultValue="World") Long articleId) {
//
//        return new Greeting(counter.incrementAndGet(), String.format(template, name));
//    }
//}
