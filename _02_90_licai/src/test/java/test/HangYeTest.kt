package test

import com.bean.Scrore
import com.bean.StockYuCe
import com.google.gson.Gson
import com.utils.FileUtils
import org.junit.Test
import us.codecraft.webmagic.*
import us.codecraft.webmagic.pipeline.Pipeline
import us.codecraft.webmagic.processor.PageProcessor
import java.util.concurrent.TimeUnit
import java.util.concurrent.Executors
import java.util.concurrent.ScheduledExecutorService
import us.codecraft.webmagic.proxy.SimpleProxyProvider
import us.codecraft.webmagic.downloader.HttpClientDownloader
import us.codecraft.webmagic.proxy.Proxy


class HangYeTest : PageProcessor {

    class Result {
        var data : List<StockYuCe>? = null


    }

    val allData = ArrayList<StockYuCe>()
    class MyPipLine(val list : ArrayList<StockYuCe>) : Pipeline {
        override fun process(resultItems: ResultItems, task: Task?) {

            val value: String = resultItems["page"];

            println(value)
            if (value is String) {
                val result = value.toString()



                val gson = Gson()
                val r = gson.fromJson(result, Result::class.java);

                println("lala")

                if (r.data != null) {

                    println("hehe")
                    list.addAll(r.data!!)
                }
            }
        }
    }



    // 部分一：抓取网站的相关配置，包括编码、抓取间隔、重试次数等
    // 重试次数为3次，抓取间隔为一秒。
    private val site = Site.me().setRetryTimes(1).setSleepTime(100)
    override fun getSite(): Site {
        return site
    }


    @Test
    fun test() {
        val spider = Spider.create(HangYeTest()).thread(1).addPipeline(MyPipLine(allData))


        // 房地产
//        spider.addUrl("http://reportapi.eastmoney.com/report/predic?cb=datatable3410691&dyCode=*&pageNo=1&pageSize=5&fields=&beginTime=2017-11-20&endTime=2019-11-20&hyCode=451&gnCode=*&marketCode=*&sort=count%2Cdesc&_=1574230746531")

//         家电
        spider.addUrl("http://reportapi.eastmoney.com/report/predic?cb=datatable2457615&dyCode=*&pageNo=1&pageSize=20&fields=&beginTime=2017-11-20&endTime=2019-11-20&hyCode=456&gnCode=*&marketCode=*&sort=count%2Cdesc&_=1574231332102")

        // 银行
//        spider.addUrl("http://reportapi.eastmoney.com/report/predic?cb=datatable4074277&dyCode=*&pageNo=1&pageSize=5&fields=&beginTime=2017-11-20&endTime=2019-11-20&hyCode=475&gnCode=*&marketCode=*&sort=count%2Cdesc&_=1574232817188")


        // 食品
//        spider.addUrl("http://reportapi.eastmoney.com/report/predic?cb=datatable5420439&dyCode=*&pageNo=1&pageSize=5&fields=&beginTime=2017-11-20&endTime=2019-11-20&hyCode=438&gnCode=*&marketCode=*&sort=count%2Cdesc&_=1574232817191")


        spider.run()

        println("11111111111111:" + allData.size)
        allData.sortByDescending {
            (it.afterYearEps.toFloat() / it.thisYearEps.toFloat())
        }
        allData.forEach {
            println(it)
        }
        println("222222222222222")


    }

    override fun process(page: Page) {
        val aaaaa = page.rawText.toString()
        val f = aaaaa.substring(aaaaa.indexOf("(") +1);

        page.putField("page", f.replace(")" , ""))
    }

}
