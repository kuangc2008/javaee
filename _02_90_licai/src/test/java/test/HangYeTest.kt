package test

import com.bean.Scrore
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

    val allData = ArrayList<Scrore>()
    class MyPipLine(val list : ArrayList<Scrore>) : Pipeline {

        override fun process(resultItems: ResultItems, task: Task?) {
            val scrore = Scrore(resultItems["name"], resultItems["total"], resultItems["action"], resultItems["fundamentals"] );
            println(scrore)
            list.add(scrore)
        }

    }



    // 部分一：抓取网站的相关配置，包括编码、抓取间隔、重试次数等
    // 重试次数为3次，抓取间隔为一秒。
    private val site = Site.me().setRetryTimes(1).setSleepTime(20000)
    override fun getSite(): Site {
        return site
    }


    @Test
    fun test() {
        val a = arrayOf("")

        val spider = Spider.create(HangYeTest()).thread(1).addPipeline(MyPipLine(allData))

        a.forEach {
            spider.addUrl("http://reportapi.eastmoney.com/report/predic?cb=datatable2480022&dyCode=*&pageNo=1&pageSize=50&fields=&beginTime=" +
                    "2017-11-20" + "&endTime= " +
                    "2019-11-20" + "&hyCode=451&gnCode=*&marketCode=*&sort=count%2Cdesc&_=" +
                    "1574224808443")
        }

        spider.run()

        println("11111111111111:" + allData.size)
        allData.sortByDescending {
            it.fundamentals
        }
        allData.forEach {
            println(it)
        }
        println("222222222222222")


    }

    override fun process(page: Page) {

        page.putField("name", page.json.get());
        page.putField("total", (page.html.xpath("//div[@class=inner]/div[@class=stockall]//div[@class=stockvalue]/span[@class=bignum]/text()").toString()
                + page.html.xpath("//div[@class=inner]/div[@class=stockall]//div[@class=stockvalue]/span[@class=smallnum]/text()")).toFloat());

        page.putField("action", page.html.xpath("//div[@class=inner]//div[@class=value_bar]//span[@class=cur]/text()").toString());
        page.putField("fundamentals", page.html.xpath("//div[@class=chart_base]/div[@class=column_3d]").nodes().last().xpath("//div[@class=label]/text()").replace("分", "").toString().toFloat());
    }

}
