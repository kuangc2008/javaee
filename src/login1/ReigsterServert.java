package login1;

import com.mysql.cj.xdevapi.SqlStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

public class ReigsterServert extends HttpServlet {


    @Override
    public void init() throws ServletException {
        super.init();


        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp);
        doHttp(req, resp);
    }

    void doHttp(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("utf-8");

        String name = req.getParameter("username");
        String password = req.getParameter("password");
        String type = req.getParameter("login");




        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/stu", "root", "rootroot");

            if ("登陆".equals(type)) {
                PreparedStatement preparedStatement2 = connection.prepareStatement("select * from user where name=? And password=?");
                preparedStatement2.setString(1, name);
                preparedStatement2.setString(2, password);
                ResultSet set2 = preparedStatement2.executeQuery();
                resp.setHeader("Content-Type", "text/html; charset=UTF-8");
                if (set2.next()) {
                    resp.getWriter().write("登陆成功啦");
                } else {
                    resp.getWriter().write("登陆失败啦");
                }

            }else {
                PreparedStatement preparedStatement = connection.prepareStatement("select * from user where name=?");
                preparedStatement.setString(1, name);
                ResultSet set = preparedStatement.executeQuery();
                if (set.next()) {
                    resp.getWriter().write("have the same value");
                } else {
                    PreparedStatement preparedStatement2 = connection.prepareStatement("insert into user values (NULL, ?, ?)");
                    preparedStatement2.setString(1, name);
                    preparedStatement2.setString(2, password);
                    int result = preparedStatement2.executeUpdate();
                    if (result > 0) {
                        resp.sendRedirect("register_success2.html");
                    } else {
                        resp.getWriter().write("register failture");
                    }
                }

                }
            } catch(SQLException e){
                e.printStackTrace();

                resp.getWriter().write("register failture<br>" + e.getStackTrace().toString());

                for (StackTraceElement e2 : e.getStackTrace()) {
                    resp.getWriter().write(e2.toString() + "<br>");
                }

            }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
        doHttp(req, resp);

    }
}
