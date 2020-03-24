package com.k.mapper


import com.k.bean.User
import org.apache.ibatis.annotations.Mapper


@Mapper
interface IUserDao {

    fun findAll(): List<User>

    fun findAll2(user : User): List<User>
}
