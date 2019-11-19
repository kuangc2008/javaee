package test;

import com.bean.BuyGridOp;
import com.bean.Op;
import com.bean.SellerGridOp;
import com.dao.StockDao;
import com.service.StockService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * 目前来说最优方案是，每3个月定投一次。 大概：
 * 447551  current->510701.80000000005
 * 总利润是***********63150
 *
 * 三年中： 14%，不足以。。
 *
 * 目前来看，定投，然后20的收益取出，是比较好的吧。  和不取出差不多
 */
public class StockTest {

    private StockService in = new StockService();

    int year = 2018;
    int month = 2;
    int endYear = 1;
    int endMonth = 1;
    int money = 10000;


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




        System.out.println("2222222");
//        in.dingTou(year, month, money, 3f, 1, 0.5f);
//        in.dingTou(year, month, money, 1f, 1, 0.5f);
//        in.dingTou(year, month, money, 0.3f, 1, 0.5f);
//        in.dingTou(year, month, money, 100f, 3, 1f, "/500etf");
//        in.dingTou(year, month, money, 10f, 3, 1f, "/500etf");
//        in.dingTou(year, month, money, 3f, 3, 1f, "/500etf");
//        in.dingTou(year, month, money, 1f, 3, 1f, "/50etf");
        in.dingTou(year, month, money, 0.3f, 3, 1f, "/50etf");
        in.dingTou(year, month, money, 0.3f, 1, 1f, "/50etf");

        System.out.println("3333333");
//        in.dingTou(year, month, money, 0.15f);
    }


    @Test
    public void testDingTou2(){
        in.dingTou(2013, 4, money, 0.3f);
        in.dingTou(2014, 0, money, 0.3f);
        in.dingTou(2015, 0, money, 0.3f);
        in.dingTou(2016, 0, money, 0.3f);
        in.dingTou(2017, 0, money, 0.3f);
        in.dingTou(2018, 0, money, 0.3f);

    }


    @Test
    public void testDingTou3(){
        in.dingTou(year, month, money, 0.3f, 3);
        in.dingTou(year, month, money, 0.3f, 1);
//        in.dingTou(year, month, money, 0.2f, 3);
//        in.dingTou(year, month, money, 0.15f, 3);
//        in.dingTou(year, month, money, 0.1f, 3);



    }

    @Test
    public void testDingTouMultiYear(){
        /**
         * 因为将来可能会更低呀，中间就买了，所以差别不大.
         */
//        in.dingTouMultiYear(year, month, money, 1f, 3, 0.01f);
//        in.dingTouMultiYear(year, month, money, 1f, 3, 0.09f);
//        in.dingTouMultiYear(year, month, money, 1f, 3, 0.08f);
//        in.dingTouMultiYear(year, month, money, 1f, 3, 0.07f);
//        in.dingTouMultiYear(year, month, money, 1f, 3, 0.06f);
//        in.dingTouMultiYear(year, month, money, 1f, 3, 0.05f);
//        in.dingTouMultiYear(year, month, money, 1f, 3, 0.04f);
//        in.dingTouMultiYear(year, month, money, 1f, 3, 0.03f);
//        in.dingTouMultiYear(year, month, money, 1f, 3, 0.02f);
//        in.dingTouMultiYear(year, month, money, 1f, 12, 0.01f);
//        in.dingTouMultiYear(year, month, money, 1f, 6, 0.00f);


//        in.dingTouMultiYear(year, month, money, 1f, 3, 0.1f, true);
//        in.dingTouMultiYear(year, month, money, 0.5f, 3, 0.1f, true);

        /**
         * 如果从下走，3个月一次的话，能减少亏损
         *
         * 对于万科也是一样的啦.  回撤10%就定投是比较好的.
         */
        in.dingTouMultiYear(year, month, money, 0.5f, 4, 0.15f, false);
        in.dingTou(year, month, money, 0.5f);


        /*
        in.dingTouMultiYear(year, month, money, 0.3f, 3, 0.12f, true);
        in.dingTou(year, month, money, 0.3f);

        in.dingTouMultiYear(year, month, money, 0.15f, 3, 0.12f, true);
        in.dingTou(year, month, money, 0.15f);
        */

//        in.dingTouMultiYear(year, month, money, 0.2f, 3, 0.1f, true);
//        in.dingTouMultiYear(year, month, money, 0.15f, 3, 0.1f, true);
//        in.dingTouMultiYear(year, month, money, 0.3f, 3, 0.1f, false);
//        in.dingTou(year, month, money, 0.3f, 3);












//        in.dingTouMultiYear(year, month, money, 0.25f, 4, 0.1f);
//        in.dingTouMultiYear(year, month, money, 1f, 1, 0.00f);
//        in.dingTouMultiYear(year, month, money, 1f, 6, 0.00f);
//        in.dingTouMultiYear(year, month, money, 1f, 12, 0.00f);
//        in.dingTouEnd(year, month, money, 1f, 3);
//        in.dingTouEnd(year, month, money, 0.3f, 3);
//        in.dingTouEnd(year, month, money, 0.25f, 3);
//        in.dingTouEnd(year, month, money, 0.25f, 0.1f ,3);
    }


    /**
     * H333策略会完全错过大牛市
     * 卖出: TradeTime(isBuy=false, monkey=0, stockNum=0, day='2014-11-03', price=2.3776, result=0, force=false, liruilv=0.0)*********************************
     * 盈利:0
     * 卖出: TradeTime(isBuy=false, monkey=0, stockNum=0, day='2014-12-01', price=2.6605, result=0, force=false, liruilv=0.0)*********************************
     * 盈利:0
     * 卖出: TradeTime(isBuy=false, monkey=0, stockNum=0, day='2014-12-05', price=2.9685, result=0, force=false, liruilv=0.0)*********************************
     * 盈利:0
     * 卖出: TradeTime(isBuy=false, monkey=0, stockNum=0, day='2014-12-29', price=3.3222, result=0, force=false, liruilv=0.0)*********************************
     * 盈利:0
     * 卖出: TradeTime(isBuy=false, monkey=0, stockNum=0, day='2015-03-17', price=3.4941, result=0, force=false, liruilv=0.0)*********************************
     * 盈利:0
     * 卖出: TradeTime(isBuy=false, monkey=0, stockNum=0, day='2015-03-31', price=3.8882, result=0, force=false, liruilv=0.0)*********************************
     * 盈利:0
     * 卖出: TradeTime(isBuy=false, monkey=0, stockNum=0, day='2015-04-17', price=4.2606, result=0, force=false, liruilv=0.0)*********************************
     * 盈利:0
     * 卖出: TradeTime(isBuy=false, monkey=0, stockNum=0, day='2015-05-26', price=4.7967, result=0, force=false, liruilv=0.0)*********************************
     * 盈利:0
     * 卖出: TradeTime(isBuy=false, monkey=0, stockNum=0, day='2015-06-09', price=4.9989, result=0, force=false, liruilv=0.0)*********************************
     *
     *
     * 舍弃h333， 舍弃任何比对， 完全定投！   3个月一次!!!!  可以根据点数定投.
     */
    @Test
    public void testH333(){
        in.h333_2(2008, 6, 2015, 7, money, 1f,  0,
                0.2f, 0.15f, 0.15f,
                0.3f, 0.3f, 0.3f);
//        in.h333(2016, 1, 2019, 10, money, 1f,  0, 0.12f);

//        in.dingTou(2016, 6, money, 0.15f, 3);
    }


    /**
     * 定投不定额，这个额怎么算？;
     *
     * 弄了这么多，的出来一个真理：
     *
     * 定投定投再定投！！！！！！！！！！
     * 指数太低的时候，20%的下跌，可以进行h333操作！  将咸鱼资金分成3份进行！
     */
    @Test
    public void testDingTouEnd(){
        in.dingTouEnd(2018, 6, money, 0.15f, 3);
    }




    @Test
    public void testH333End(){
        ArrayList<Op> a = new ArrayList<Op>();

        a.add(new BuyGridOp(0.25f, 0.1f, 20000, false));
        a.add(new BuyGridOp(0.5f, 0.1f, 30000, false));
        a.add(new BuyGridOp(0.75f, 0.1f, 30000, false));
        a.add(new BuyGridOp(1f, 0.1f, 20000, false));

        a.add(new SellerGridOp(0.8f, 0.25f, 50000, false));
        a.add(new SellerGridOp(0.6f, 0.25f, 0000, false));
        a.add(new SellerGridOp(0.4f, 0.1f, 10000, false));

        in.h333_end(2008, 6, 2015, 7, 0, 4, a);

    }
}
