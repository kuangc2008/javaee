package cn.kc.web.servlet;

import cn.kc.web.domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/loginSuccess")
public class LoginSuccessServelt extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp);


        User user = (User) req.getAttribute("user");

        if(user != null){
            //给页面写一句话

            //设置编码
            resp.setContentType("text/html;charset=utf-8");
            //输出
            resp.getWriter().write("登录成功！"+user.getUsername()+",欢迎您");
        }
    }
}


