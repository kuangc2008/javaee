package test;

import com.dao.StockDao;
import com.service.StockService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;

/**
 */
public class StockTest {

    private StockService in = new StockService();


    @Before//用于在测试方法执行之前执行
    public void init()throws Exception{
        //1.读取配置文件，生成字节输入流
    }

    @After//用于在测试方法执行之后执行
    public void destroy()throws Exception{
    }

    /**
     * 测试查询所有
     */
    @Test
    public void testDingTou(){
//        in.dingTou(0, 0, 10000, 0.2f);
//        in.dingTou(2015, 0, 10000, 0.2f);
//        in.dingTou(2015, 6, 10000, 0.2f);
//        in.dingTou(2016, 6, 10000, 0.2f);

//        in.dingTou(2018, 6, 10000, 0.2f);


        in.dingTou(2018, 0, 10000, 0.3f);
        in.dingTou(2018, 0, 10000, 0.2f);
        in.dingTou(2018, 0, 10000, 0.1f);
    }



}
