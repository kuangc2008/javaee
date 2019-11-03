package cn.kc.web.servelt


import cn.kc.domain.User
import cn.kc.service.impl.UserServiceImpl
import org.apache.commons.beanutils.BeanUtils

import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
import java.lang.reflect.InvocationTargetException

@WebServlet("/addUserServlet")
class AddUserServlet : HttpServlet() {

    override fun doPost(request: HttpServletRequest, response: HttpServletResponse) {
        //1.设置编码
        request.characterEncoding = "utf-8"
        //2.获取参数
        val map = request.parameterMap
        //3.封装对象
        val user = User()
        try {
            BeanUtils.populate(user, map)
        } catch (e: IllegalAccessException) {
            e.printStackTrace()
        } catch (e: InvocationTargetException) {
            e.printStackTrace()
        }

        //4.调用Service保存
        val service = UserServiceImpl()
        service.addUser(user)

        //5.跳转到userListServlet
        response.sendRedirect(request.contextPath + "/userListServlet")
    }

    override fun doGet(request: HttpServletRequest, response: HttpServletResponse) {
        this.doPost(request, response)
    }
}
