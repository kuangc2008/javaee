package com.kc.domain

import java.io.Serializable

/**
 * @author 黑马程序员
 * @Company http://www.ithiema.com
 */
open class Account : Serializable {

    var id: Int? = null
    var uid: Int? = null
    var money: Double? = null

    //从表实体应该包含一个主表实体的对象引用
    var user: User? = null

    override fun toString(): String {
        return "Account{" +
                "id=" + id +
                ", uid=" + uid +
                ", money=" + money +
                '}'.toString()
    }
}
