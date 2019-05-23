package com.baiyu.hello.controller;

import com.baiyu.hello.pojo.Product;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class ProductController {
    @RequestMapping("/addProduct")
    public ModelAndView add(HttpServletRequest request, HttpServletResponse response, Product product) {
        ModelAndView model = new ModelAndView("showProduct");
        return model;
    }
}
