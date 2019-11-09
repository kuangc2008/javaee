package com.kc.domain

import java.io.Serializable
import java.util.Date

/**
 * @author 黑马程序员
 * @Company http://www.ithiema.com
 */
class User : Serializable {

    var id: Int? = null
    var username: String? = null
    var address: String? = null
    var sex: String? = null
    var birthday: Date? = null

    //一对多关系映射：主表实体应该包含从表实体的集合引用
    var accounts: List<Account>? = null

    override fun toString(): String {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\''.toString() +
                ", address='" + address + '\''.toString() +
                ", sex='" + sex + '\''.toString() +
                ", birthday=" + birthday +
                '}'.toString()
    }
}
