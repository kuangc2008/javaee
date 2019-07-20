package cn.kc.web.dao;

import cn.kc.web.domain.User;
import cn.kc.web.utils.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class UserDao {


    //声明JDBCTemplate对象共用
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    /**
     * 登录方法
     * @param loginUser 只有用户名和密码
     * @return user包含用户全部数据,没有查询到，返回null
     */
    public User login(User loginUser){
        try {
            //1.编写sql
            String sql = "select * from user where username = ? and password = ?";
            //2.调用query方法
            User user = template.queryForObject(sql,
                    new BeanPropertyRowMapper<User>(User.class),
                    loginUser.getUsername(), loginUser.getPassword());


            return user;
        } catch (DataAccessException e) {
            e.printStackTrace();//记录日志
            return null;
        }
    }

    public int save(User user) {
        try {

            if (isExist(user)) {
                return 1;
            }

            String sql = "insert into user(username, password, hobby) values(?, ?, ?)";
            int save = template.update(sql, user.getUsername(), user.getPassword(), user.getHobby());
            if (save > 0) {
                return 0;
            }
        } catch (DataAccessException e) {
            e.printStackTrace();//记录日志
        }

        return -1;
    }


    public boolean isExist(User loginUser){
        try {
            //1.编写sql
            String sql = "select * from user where username = ?";
            //2.调用query方法
            User user = template.queryForObject(sql,
                    new BeanPropertyRowMapper<User>(User.class),
                    loginUser.getUsername());


            return user != null;
        } catch (DataAccessException e) {
            e.printStackTrace();//记录日志
            return false;
        }
    }
}
