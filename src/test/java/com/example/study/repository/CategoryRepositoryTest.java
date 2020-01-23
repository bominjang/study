package com.example.study.repository;

import com.example.study.StudyApplicationTests;
import com.example.study.model.entity.Category;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.Optional;

@SpringBootTest
public class CategoryRepositoryTest extends StudyApplicationTests {

    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    public void Create(){
        String type = "COMPUTER";
        String title = "컴퓨터";
        LocalDateTime createdAt = LocalDateTime.now();
        String createdBy = "AdminServer";

        Category category = new Category();
        category.setType(type);
        category.setTitle(title);
        category.setCreatedAt(createdAt);
        category.setCreatedBy(createdBy);

        Category newCategory = categoryRepository.save(category);

        Assert.assertNotNull(newCategory);
        Assert.assertEquals(newCategory.getType(), type);
        Assert.assertEquals(newCategory.getTitle(), title);

    }

    @Test
    public void read(){

        String type = "COMPUTER";

        Optional<Category> optionalCategory = categoryRepository.findByType(type);

        //select * from category where type = 'COMPUTER'

        optionalCategory.ifPresent(c ->{

            //c의 type이 우리가 지정한 type과 같은 타입인 지 검사.
            Assert.assertEquals(c.getType(),type);


            System.out.println(c.getId());
            System.out.println(c.getType());
            System.out.println(c.getTitle());

        });

    }
}
