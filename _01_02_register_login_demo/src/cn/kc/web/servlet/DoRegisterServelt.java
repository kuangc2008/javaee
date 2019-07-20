package cn.kc.web.servlet;

import cn.kc.web.dao.UserDao;
import cn.kc.web.domain.User;
import com.oracle.tools.packager.Log;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/doRegister")
public class DoRegisterServelt extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp);

        //1.设置编码
        req.setCharacterEncoding("utf-8");


       /* //2.获取请求参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        //3.封装user对象
        User loginUser = new User();
        loginUser.setUsername(username);
        loginUser.setPassword(password);*/
        //2.获取所有请求参数
        Map<String, String[]> map = req.getParameterMap();
        //3.创建User对象
        User registerUser = new User();
        //3.2使用BeanUtils封装
        try {
            BeanUtils.populate(registerUser, map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }


        //4.调用UserDao的login方法
        UserDao dao = new UserDao();
        int result = dao.save(registerUser);
        if (result == 0) {
            req.setAttribute("user", registerUser);
            req.getRequestDispatcher("/loginSuccess").forward(req, resp);
        } else if (result == 1){
            resp.setContentType("text/html;charset=utf-8");
            //输出
            resp.getWriter().write("用户名已存在");
        } else {
            resp.setContentType("text/html;charset=utf-8");
            //输出
            resp.getWriter().write("其他错误");
        }

    }
}
