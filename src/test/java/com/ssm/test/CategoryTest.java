package com.ssm.test;

import com.ssm.dao.CategoryMapper;
import com.ssm.model.Category;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @Author: zhouheng
 * @Created: with IntelliJ IDEA.
 * @Description:
 * @Date: 2018-03-19
 * @Time: 9:15
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class CategoryTest {


    @Autowired
    private CategoryMapper categoryMapper;

    @Test
    public void testAdd() {
        for (int i = 0; i < 100; i++) {
            Category category = new Category();
            category.setName("CategoryNew");
            categoryMapper.saveCategory(category);
        }

    }

    @Test
    public void testTotal() {

        System.out.println(categoryMapper.total());
    }

    @Test
    public void testListCategory() {
        List<Category> cs = categoryMapper.listCategory();

        for (Category c : cs
                ) {
            System.out.println(c.getId() + "testCategory" + c.getName());

        }
    }

}
