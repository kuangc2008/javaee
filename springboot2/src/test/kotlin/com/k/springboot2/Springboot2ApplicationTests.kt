package com.k.springboot2

import com.k.bean.User
import com.k.mapper.IUserDao
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner


@SpringBootTest(classes = [Springboot2Application::class])
@RunWith(SpringRunner::class)
class Springboot2ApplicationTests {

    @Autowired
    var userDao : IUserDao? = null


    @Test
    fun test() {
        val user = User();
        user.sex = "男"
        val aa =  userDao?.findAll2(user)
        System.out.println(aa);
    }

}
