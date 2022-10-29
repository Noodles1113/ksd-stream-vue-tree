package com.kuangstudy.controller;

import com.kuangstudy.pojo.CourseCategory;
import com.kuangstudy.service.CourseCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
public class CourseCategoryController {

    @Autowired
    private CourseCategoryService courseCategoryService;

    @GetMapping("/tree")
    public String treepage(){
        return "tree";
    }

    /**
     * 查询分类的接口信息-tree
     * @return
     */
    @GetMapping("/api/category/tree")
    @ResponseBody
    public List<CourseCategory> tree(){
        return courseCategoryService.findCategoiresTree();
    }

}
