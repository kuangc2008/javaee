package com.k.bean

import java.io.Serializable
import java.util.Date


class User : Serializable {
    var id: Int? = null
    var username: String? = null
    var birthday: Date? = null
    var sex: String? = null
    var address: String? = null
    var password: String? = null
    var hobby: String? = null

    override fun toString(): String {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\''.toString() +
                ", birthday=" + birthday +
                ", sex='" + sex + '\''.toString() +
                ", address='" + address + '\''.toString() +
                ", password='" + password + '\''.toString() +
                ", Hobby='" + hobby + '\''.toString() +
                '}'.toString()
    }
}
