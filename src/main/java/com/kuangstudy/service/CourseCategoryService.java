package com.kuangstudy.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kuangstudy.pojo.CourseCategory;

import java.util.List;

public interface CourseCategoryService extends IService<CourseCategory> {


    /**
     * 返回分类tree
     *
     * @return
     */
    List<CourseCategory> findCategoiresTree();
}
