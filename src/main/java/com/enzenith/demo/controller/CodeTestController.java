package com.enzenith.demo.controller;


import com.enzenith.demo.entity.CodeTest;
import com.enzenith.demo.service.CodeTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author xugb
 * @since 2019-01-23
 */
@Controller
@RequestMapping("/codeTest")
public class CodeTestController {

    @Autowired
    CodeTestService codeTestService;

    @RequestMapping("/insert")
    @ResponseBody
    public String index() {
        CodeTest codeTest = new CodeTest().setLoginName("xugb").setLocked(1).setCreateDate(new Date()).setNickName("清风徐来");
        codeTestService.insert(codeTest);
        return "success";
    }

    @RequestMapping("/list")
    @ResponseBody
    public List<CodeTest> list() {
        List<CodeTest> codeTests = codeTestService.selectList(null);
        return codeTests;
    }

    @RequestMapping("/hello")
    public String hello(Model m) {
        m.addAttribute("name", "thymeleaf");
        return "hello";
    }



}

