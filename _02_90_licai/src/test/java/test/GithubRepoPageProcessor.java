package test;

import com.oracle.tools.packager.Log;
import org.junit.Test;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.ConsolePipeline;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Html;
import us.codecraft.webmagic.selector.Selectable;

import javax.swing.text.html.HTML;
import java.util.List;

public class GithubRepoPageProcessor implements PageProcessor {


    @Test
    public void test() {

        Spider.create(new GithubRepoPageProcessor()).addUrl("http://basic.10jqka.com.cn/601633/worth.html")
//                .addPipeline(new ConsolePipeline())
                .thread(5).run();
    }

    // 部分一：抓取网站的相关配置，包括编码、抓取间隔、重试次数等
    // 重试次数为3次，抓取间隔为一秒。
    private Site site = Site.me().setRetryTimes(3).setSleepTime(100);



    // process是定制爬虫逻辑的核心接口，在这里编写抽取逻辑
    public void process(Page page) {

//        page.getHtml().$("div.m_box div.bd strong").select(new )

//        page.putField("6个月以内共有", page.getHtml().xpath("//div[@class=bd]//p[@class=tip]/strong/text()"));
//        page.putField("每股收益", page.getHtml().xpath("//div[@class=bd]/p[@class=tip]/strong[2]/text()"));
//        page.putField("较去年同比增长", page.getHtml().xpath("//div[@class=bd]/p[@class=tip]/strong[3]/text()"));
//        page.putField("净利润", page.getHtml().xpath("//div[@class=bd]/p[@class=tip]/strong[4]/text()"));
//        page.putField("较去年同比增长2", page.getHtml().xpath("//div[@class=bd]/p[@class=tip]/strong[5]/text()"));


        List<Selectable> tr = page.getHtml().xpath("//div[@class=m_box]//div[@class=bd]//table[@class=posi_table]//tbody").css("tr").nodes();
        for (Selectable html : tr) {
            System.out.println("---------");
//            Html html = Html.create(s);
//            System.out.println(html);
            System.out.println(  html.xpath("//th/text()") );
            System.out.println(  html.xpath("//td/text()") );
            System.out.println(  html.xpath("//td[2]/text()") );
            System.out.println(  html.xpath("//td[3]/text()") );
            System.out.println(  html.xpath("//td[4]/text()") );
            System.out.println(  html.xpath("//td[5]/text()") );
            System.out.println(  html.xpath("//td[6]/text()") );
            System.out.println(  html.xpath("//td[7]/text()") );
            System.out.println(  html.xpath("//td[8]/text()") );


//            page.putField("2019平均：" + );

        }


//        page.putField("机构名称", );




//        page.putField("研究员", page.getHtml().xpath("//div[@class=bd]/p[@class=tip]/strong[2]/text()"));
//        page.putField("2019预测", page.getHtml().xpath("//div[@class=bd]/p[@class=tip]/strong[3]/text()"));
//        page.putField("2020预测", page.getHtml().xpath("//div[@class=bd]/p[@class=tip]/strong[4]/text()"));
//        page.putField("2021预测", page.getHtml().xpath("//div[@class=bd]/p[@class=tip]/strong[5]/text()"));


//        // 部分二：定义如何抽取页面信息，并保存下来
//        page.putField("author", page.getUrl().regex("https://github\\.com/(\\w+)/.*").toString());
//        page.putField("name", page.getHtml().xpath("//h1[@class='entry-title public']/strong/a/text()").toString());
//        if (page.getResultItems().get("name") == null) {
//            //skip this page
//            page.setSkip(true);
//        }
//        page.putField("readme", page.getHtml().xpath("//div[@id='readme']/tidyText()"));

//        // 部分三：从页面发现后续的url地址来抓取
//        page.addTargetRequests(page.getHtml().links().regex("(https://github\\.com/[\\w\\-]+/[\\w\\-]+)").all());
    }


    public Site getSite() {
        return site;
    }


//    public static void main(String[] args) {
//        Spider.create(new GithubRepoPageProcessor()).addUrl("https://github.com/code4craft").thread(5).run();
//    }
}
