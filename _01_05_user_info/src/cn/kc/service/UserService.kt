package cn.kc.service

import cn.kc.domain.PageBean
import cn.kc.domain.User

/**
 * 用户管理的业务接口
 */
interface UserService {

    /**
     * 查询所有用户信息
     * @return
     */
    fun findAll(): List<User>

    /**
     * 登录方法
     * @param user
     * @return
     */
    fun login(user: User): User

    /**
     * 保存User
     * @param user
     */
    fun addUser(user: User)

    /**
     * 根据id删除User
     * @param id
     */
    fun deleteUser(id: String)

    /**
     * 根据id查询
     * @param id
     * @return
     */
    fun findUserById(id: String): User

    /**
     * 修改用户信息
     * @param user
     */
    fun updateUser(user: User)

    /**
     * 批量删除用户
     * @param ids
     */
    fun delSelectedUser(ids: Array<String>)

    /**
     * 分页条件查询
     * @param currentPage
     * @param rows
     * @param condition
     * @return
     */
    fun findUserByPage(currentPage: String, rows: String, condition: Map<String, Array<String>>): PageBean<User>
}
