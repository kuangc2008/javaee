package cn.kc.web.test;

import cn.kc.web.dao.UserDao;
import cn.kc.web.domain.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestDB {

    UserDao dao = null;


    @Before
    public void init() {
        dao = new UserDao();
    }

    @After
    public void destory() {
        dao = null;
    }

    @Test
    public void test1() {

        User u = new User();
        u.setUsername("qwer");
        u.setPassword("1234");
        u.setHobby("1&2&3&4");

        dao.save(u);
    }

    @Test
    public void test2() {
        User u = new User();
        u.setUsername("qwer");
        u.setPassword("12345");
        User u2 = dao.login(u);
        System.out.println("uu->" + (u2 == null?"null" : u2));
    }
}
