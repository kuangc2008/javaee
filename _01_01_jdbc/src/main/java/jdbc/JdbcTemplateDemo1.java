package jdbc;

import org.springframework.jdbc.core.JdbcTemplate;
import util.JDBCUtils2;

/**
 * JdbcTemplate入门
 */
public class JdbcTemplateDemo1 {

    public static void main(String[] args) {
        //1.导入jar包
        //2.创建JDBCTemplate对象
        JdbcTemplate template = new JdbcTemplate(JDBCUtils2.getDataSource());
        //3.调用方法
        String sql = "update emp2 set dept_id = 5000 where id = ?";
        int count = template.update(sql, 1002);
        System.out.println(count);
    }
}
