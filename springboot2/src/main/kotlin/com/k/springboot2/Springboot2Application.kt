package com.k.springboot2

import org.mybatis.spring.annotation.MapperScan
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication


@SpringBootApplication(scanBasePackages=["com.k.*"])
@MapperScan("com.k.mapper")
class Springboot2Application

fun main(args: Array<String>) {
    runApplication<Springboot2Application>(*args)
}
