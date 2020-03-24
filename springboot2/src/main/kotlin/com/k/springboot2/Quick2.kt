package com.k.springboot2

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody


@Controller
@ConfigurationProperties(prefix = "person")
class Quick2 {

    var name: String? = null
    var age: Int? = null


    @RequestMapping("/hello")
    @ResponseBody
    fun hello() : String {
        return "hello2: $name -> $age";
    }
}