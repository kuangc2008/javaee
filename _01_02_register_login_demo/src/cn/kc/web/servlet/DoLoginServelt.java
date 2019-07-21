package cn.kc.web.servlet;

import cn.kc.web.dao.UserDao;
import cn.kc.web.domain.User;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;


@WebServlet("/doLogin")
public class DoLoginServelt extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp);

        req.setCharacterEncoding("utf-8");
        Map<String, String[]> map = req.getParameterMap();
        User loginUser = new User();
        try {
            BeanUtils.populate(loginUser, map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }


        //3.先获取生成的验证码
        HttpSession session = req.getSession();
        String checkCode_session = (String) session.getAttribute("checkCode_session");
        //删除session中存储的验证码
        session.removeAttribute("checkCode_session");
        String checkCode = req.getParameter("checkCode");

        System.out.println("checkCode->" + checkCode);
        System.out.println("checkCode_session->" + checkCode_session);

        //3.先判断验证码是否正确
        if(checkCode_session!= null && checkCode_session.equalsIgnoreCase(checkCode)){


            //4.调用UserDao的login方法
            UserDao dao = new UserDao();
            User u  = dao.login(loginUser);
            if (u != null) {
                req.setAttribute("user", u);
                session.setAttribute("user", loginUser.getUsername());
                req.getRequestDispatcher("/success.jsp").forward(req, resp);

            }  else {

                //存储提示信息到request
                req.setAttribute("login_error","用户名或密码错误");
                //转发到登录页面
                req.getRequestDispatcher("/register/login.jsp").forward(req,resp);
            }


        } else {
            //验证码不一致
            //存储提示信息到request
            req.setAttribute("cc_error","验证码错误");
            //转发到登录页面
            req.getRequestDispatcher("/register/login.jsp").forward(req, resp);
        }





    }
}
