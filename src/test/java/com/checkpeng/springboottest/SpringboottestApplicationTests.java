package com.checkpeng.springboottest;

import com.checkpeng.springboottest.mapper.ProductMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringboottestApplicationTests {

    @Autowired
    ProductMapper productMapper;

    @Test
    void contextLoads() {
        productMapper.deductStock(1);
    }

}
