package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class UserController {
    /**
     * 日志（slf4j->logback）
     */
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @RequestMapping("/get/all/{page}/{size}")
    @ResponseBody
    public List<User> getAllUserByPage(@PathVariable("page") int page, @PathVariable("size") int size) {
        return this.userService.findAllUserByPage(page, size);
    }

    @RequestMapping("/getAll")
    @ResponseBody
    public List<User> getAll() {
        return this.userService.getAll();
    }

    ;

    /**
     * 返回text格式数据
     *
     * @param id 主键id
     * @return 用户json字符串
     */
    @RequestMapping("/get/id/{id}")
    @ResponseBody
    public User getUserById(@PathVariable("id") String id) {
        logger.info("request /user/get/id/{id}, parameter is " + id);
        User user = userService.getById(Integer.parseInt(id));
        return user;
    }
}
