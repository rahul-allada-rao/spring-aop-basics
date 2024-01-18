package com.arr.aop.aspect;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AspectServiceImplTest {

    @Autowired
    private AspectService aspectService;

//    @Before
//    public void init(){
//        aspectService = new AspectServiceImpl();
//    }

    @Test
    public void testAdd() {
        int result = aspectService.add(10, 20);
        Assert.assertEquals(30, result);
    }
}