package com.kc._200_springboot3;

import com.kc._200_springboot3.Application;
import jdk.nashorn.internal.ir.annotations.Ignore;
//import org.junit.Ignore;
import org.junit.Test;
//import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
//import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;


@RunWith(SpringJUnit4ClassRunner.class)
//@SpringApplicationConfiguration(classes = Application.class)
@SpringBootTest(classes = Application.class)
@WebAppConfiguration
public class ApplicationTests {

    @Test
    @Ignore
    public void contextLoads() {
    }

}
