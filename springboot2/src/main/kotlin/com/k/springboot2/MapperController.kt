package com.k.springboot2

import com.k.bean.User
import com.k.mapper.IUserDao
import org.springframework.stereotype.Controller
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody



@Controller
class MapperController {

    @Autowired
    private var userMapper: IUserDao? = null

    @RequestMapping("/queryUser")
    @ResponseBody
    fun queryUser(): List<User>? {
        val user = User();
        user.sex = "男"
        return userMapper?.findAll2(user)
    }

}