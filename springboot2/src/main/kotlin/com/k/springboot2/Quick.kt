package com.k.springboot2

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody


@Controller
class Quick {

    @Value("\${person.name}")
    private val name: String? = null

    @Value("\${person.age}")
    private val age: Int? = null



    @RequestMapping("/hello2")
    @ResponseBody
    fun hello() : String {
        return "123: $name -> $age";
    }
}