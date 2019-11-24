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


class ValueScroeTest : PageProcessor {

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
        var data = FileUtils.getFromFile("/code/300jiazh")
        val chengfen1s = data.split("\n");

        val spider = Spider.create(ValueScroeTest()).thread(1).addPipeline(MyPipLine(allData))

        val httpClientDownloader = HttpClientDownloader()

        httpClientDownloader.setProxyProvider(SimpleProxyProvider.from(
                Proxy("110.16.80.1060",8080),
                Proxy("1.182.90.85",8118),
                Proxy("116.114.19.204",443)
                ))

//        spider.setDownloader(httpClientDownloader);

        chengfen1s.forEach {
            spider.addUrl("http://doctor.10jqka.com.cn/" + it +"/")
        }

        spider.run()

//        Spider.create(ValueScroeTest()).addUrl("http://doctor.10jqka.com.cn/000002/")
//                .addPipeline(MyPipLine(allData))
//                .thread(5).run()


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


        /**
         * <div class="inner">
            <div class="fl stockall"  >
            <div class="value">
            <div class="stockname"><a href="http://stockpage.10jqka.com.cn/000002/" target="_blank">万科A（000002）</a></div>
            <div class="stockvalue"><span class="bignum">6</span><span class="smallnum">.2</span></div>
            <div class="stocktotal">综合诊断：6.2分 打败了85%的股票！</div>
            </div>
            <div class="value_bar">
            <ul>
            <li class="value1"><span class="">卖出</span><div class="value1ico valueico none"></div></li>
            <li class="value2"><span class="">减持</span><div class="value2ico valueico none"></div></li>
            <li class="value3"><span class="">中性</span><div class="value3ico valueico none"></div></li>
            <li class="value4"><span class="cur">增持</span><div class="value4ico valueico "></div></li>
            <li class="value5"><span class="">买入</span><div class="value5ico valueico none"></div></li>
            </ul>
            </div>
         */
        page.putField("name", page.html.xpath("//div[@class=inner]/div[@class=stockall]//div[@class=stockname]/a/text()").toString());
        page.putField("total", (page.html.xpath("//div[@class=inner]/div[@class=stockall]//div[@class=stockvalue]/span[@class=bignum]/text()").toString()
                + page.html.xpath("//div[@class=inner]/div[@class=stockall]//div[@class=stockvalue]/span[@class=smallnum]/text()")).toFloat());

        page.putField("action", page.html.xpath("//div[@class=inner]//div[@class=value_bar]//span[@class=cur]/text()").toString());

        /**
         * 				<div class="chart_base">
                            <div class="column_3d">
                            <div class="grid"></div>
                            <div class="fill" style="height:108.6px"></div>
                            <div class="label">6.0分</div>
                            </div>
                            <div class="column_3d" style="left:130px;">
                            <div class="grid"></div>
                            <div class="fill" style="height:102.56px">
                            </div>
                            <div class="label">5.6分</div>
                            </div>
                            <div class="column_3d" style="left:230px;">
                            <div class="grid"></div>
                            <div class="fill" style="height:101.05px"></div>
                            <div class="label">5.5分</div>
                            </div>
                            <div class="column_3d" style="left:336px;">
                            <div class="grid"></div>
                            <div class="fill" style="height:96.52px"></div>
                            <div class="label">5.2分</div>
                            </div>
                            <div class="column_3d" style="left:440px;">
                                <div class="grid"></div>
                                <div class="fill" style="height:135.78px"></div>
                                <div class="label">7.8分</div>
                            </div>
                    </div>
                    </div>
         */
        page.putField("fundamentals", page.html.xpath("//div[@class=chart_base]/div[@class=column_3d]").nodes().last().xpath("//div[@class=label]/text()").replace("分", "").toString().toFloat());
    }

}
