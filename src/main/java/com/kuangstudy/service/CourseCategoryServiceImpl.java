package com.kuangstudy.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kuangstudy.mapper.CourseCategoryMapper;
import com.kuangstudy.pojo.CourseCategory;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Log4j2
public class CourseCategoryServiceImpl extends ServiceImpl<CourseCategoryMapper, CourseCategory>
        implements CourseCategoryService {


    public List<CourseCategory> findCategoiresTree() {
        // 1 :查询表中所有的数据
        List<CourseCategory> allList = this.list();
        // 2: 找到所有的根节点 pid = 0
        List<CourseCategory> rootList = allList.stream().filter(category -> category.getPid().equals(0))
                .sorted((a, b) -> a.getSorted() - b.getSorted()).collect(Collectors.toList());
        // 3 : 查询所有的非根节点
        List<CourseCategory> subList = allList.stream().filter(category -> !category.getPid().equals(0)).collect(Collectors.toList());
        // 4 : 循环根节点去subList去找对应的子节点
        rootList.forEach(root -> findCategoiresChildrenList(root, subList));
        return rootList;
    }


    private void findCategoiresChildrenList(CourseCategory root, List<CourseCategory> subList) {
        // 通过根节点去id和子节点的pid是否相等，如果相等的话，代表是当前根的子集
        List<CourseCategory> childrenList = subList.stream().filter(category -> root.getId().equals(category.getPid()))
                .sorted((a, b) -> a.getSorted() - b.getSorted())
                .collect(Collectors.toList());
        if (!CollectionUtils.isEmpty(childrenList)) {
            root.setChildrenList(childrenList);
            childrenList.forEach(category -> findCategoiresChildrenList(category, subList));
        } else {
            root.setChildrenList(new ArrayList<>());
        }
    }
}
