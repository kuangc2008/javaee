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


/**
 * 11.24
 * Scrore(name='汇顶科技（603160）', total=7.4, action='买入', fundamentals=8.1)
Scrore(name='三七互娱（002555）', total=7.7, action='买入', fundamentals=8.0)
Scrore(name='成都银行（601838）', total=5.6, action='中性', fundamentals=7.9)
Scrore(name='欧派家居（603833）', total=4.9, action='减持', fundamentals=7.9)
Scrore(name='格力电器（000651）', total=5.3, action='中性', fundamentals=7.9)
Scrore(name='长春高新（000661）', total=5.4, action='中性', fundamentals=7.9)
Scrore(name='智飞生物（300122）', total=5.1, action='中性', fundamentals=7.9)
Scrore(name='信维通信（300136）', total=4.3, action='减持', fundamentals=7.9)
Scrore(name='万科A（000002）', total=6.7, action='增持', fundamentals=7.8)
Scrore(name='中兴通讯（000063）', total=4.8, action='减持', fundamentals=7.8)
Scrore(name='万华化学（600309）', total=7.0, action='买入', fundamentals=7.7)
Scrore(name='通威股份（600438）', total=6.3, action='增持', fundamentals=7.7)
Scrore(name='海尔智家（600690）', total=6.1, action='增持', fundamentals=7.7)
Scrore(name='美的集团（000333）', total=5.5, action='中性', fundamentals=7.7)
Scrore(name='古井贡酒（000596）', total=6.5, action='增持', fundamentals=7.7)
Scrore(name='金科股份（000656）', total=5.4, action='中性', fundamentals=7.7)
Scrore(name='绿地控股（600606）', total=5.9, action='中性', fundamentals=7.6)
Scrore(name='中航沈飞（600760）', total=5.5, action='中性', fundamentals=7.6)
Scrore(name='新城控股（601155）', total=5.5, action='中性', fundamentals=7.6)
Scrore(name='潍柴动力（000338）', total=5.9, action='中性', fundamentals=7.6)
Scrore(name='荣盛发展（002146）', total=5.9, action='中性', fundamentals=7.6)
Scrore(name='立讯精密（002475）', total=5.6, action='中性', fundamentals=7.6)
Scrore(name='圆通速递（600233）', total=5.4, action='中性', fundamentals=7.5)
Scrore(name='中南建设（000961）', total=5.8, action='中性', fundamentals=7.5)
Scrore(name='华东医药（000963）', total=5.1, action='中性', fundamentals=7.5)
Scrore(name='海康威视（002415）', total=5.5, action='中性', fundamentals=7.5)
Scrore(name='鹏鼎控股（002938）', total=5.8, action='中性', fundamentals=7.5)
Scrore(name='华能水电（600025）', total=4.7, action='减持', fundamentals=7.4)
Scrore(name='保利地产（600048）', total=6.0, action='增持', fundamentals=7.4)
Scrore(name='金地集团（600383）', total=6.8, action='增持', fundamentals=7.4)
Scrore(name='用友网络（600588）', total=5.8, action='中性', fundamentals=7.4)
Scrore(name='隆基股份（601012）', total=6.3, action='增持', fundamentals=7.4)
Scrore(name='陕西煤业（601225）', total=5.7, action='中性', fundamentals=7.4)
Scrore(name='兴业证券（601377）', total=5.3, action='中性', fundamentals=7.4)
Scrore(name='美凯龙（601828）', total=5.2, action='中性', fundamentals=7.4)
Scrore(name='永辉超市（601933）', total=5.8, action='中性', fundamentals=7.4)
Scrore(name='兆易创新（603986）', total=5.5, action='中性', fundamentals=7.4)
Scrore(name='华侨城A（000069）', total=5.4, action='中性', fundamentals=7.4)
Scrore(name='阳光城（000671）', total=5.6, action='中性', fundamentals=7.4)
Scrore(name='乐普医疗（300003）', total=6.9, action='增持', fundamentals=7.4)
Scrore(name='爱尔眼科（300015）', total=5.6, action='中性', fundamentals=7.4)
Scrore(name='利亚德（300296）', total=4.7, action='减持', fundamentals=7.4)
Scrore(name='浙江龙盛（600352）', total=5.2, action='中性', fundamentals=7.3)
Scrore(name='福耀玻璃（600660）', total=5.3, action='中性', fundamentals=7.3)
Scrore(name='东吴证券（601555）', total=5.4, action='中性', fundamentals=7.3)
Scrore(name='大华股份（002236）', total=6.6, action='增持', fundamentals=7.3)
Scrore(name='洋河股份（002304）', total=5.9, action='中性', fundamentals=7.3)
Scrore(name='上汽集团（600104）', total=5.5, action='中性', fundamentals=7.2)
Scrore(name='华夏幸福（600340）', total=5.7, action='中性', fundamentals=7.2)
Scrore(name='恒力石化（600346）', total=5.6, action='中性', fundamentals=7.2)
Scrore(name='中国人寿（601628）', total=5.8, action='中性', fundamentals=7.2)
Scrore(name='泸州老窖（000568）', total=5.8, action='中性', fundamentals=7.2)
Scrore(name='苏泊尔（002032）', total=5.4, action='中性', fundamentals=7.2)
Scrore(name='韵达股份（002120）', total=6.1, action='增持', fundamentals=7.2)
Scrore(name='完美世界（002624）', total=6.8, action='增持', fundamentals=7.2)
Scrore(name='中国石化（600028）', total=6.4, action='增持', fundamentals=7.1)
Scrore(name='中直股份（600038）', total=6.7, action='增持', fundamentals=7.1)
Scrore(name='上海银行（601229）', total=6.0, action='增持', fundamentals=7.1)
Scrore(name='紫光股份（000938）', total=6.0, action='增持', fundamentals=7.1)
Scrore(name='老板电器（002508）', total=5.5, action='中性', fundamentals=7.1)
Scrore(name='中国巨石（600176）', total=7.0, action='买入', fundamentals=7.0)
Scrore(name='新湖中宝（600208）', total=5.2, action='中性', fundamentals=7.0)
Scrore(name='华域汽车（600741）', total=6.7, action='增持', fundamentals=7.0)
Scrore(name='山西汾酒（600809）', total=5.6, action='中性', fundamentals=7.0)
Scrore(name='长城汽车（601633）', total=5.7, action='中性', fundamentals=7.0)
Scrore(name='正泰电器（601877）', total=6.1, action='增持', fundamentals=7.0)
Scrore(name='科大讯飞（002230）', total=6.1, action='增持', fundamentals=7.0)
Scrore(name='海大集团（002311）', total=5.1, action='中性', fundamentals=7.0)
Scrore(name='顺丰控股（002352）', total=5.5, action='中性', fundamentals=7.0)
Scrore(name='比亚迪（002594）', total=5.2, action='中性', fundamentals=7.0)
Scrore(name='宋城演艺（300144）', total=5.1, action='中性', fundamentals=7.0)
Scrore(name='芒果超媒（300413）', total=7.0, action='买入', fundamentals=7.0)
Scrore(name='蓝思科技（300433）', total=4.8, action='减持', fundamentals=7.0)
Scrore(name='三一重工（600031）', total=6.1, action='增持', fundamentals=6.9)
Scrore(name='兖州煤业（600188）', total=5.7, action='中性', fundamentals=6.9)
Scrore(name='白云山（600332）', total=5.1, action='中性', fundamentals=6.9)
Scrore(name='海澜之家（600398）', total=6.2, action='增持', fundamentals=6.9)
Scrore(name='恒生电子（600570）', total=6.0, action='增持', fundamentals=6.9)
Scrore(name='中航资本（600705）', total=5.6, action='中性', fundamentals=6.9)
Scrore(name='海通证券（600837）', total=5.7, action='中性', fundamentals=6.9)
Scrore(name='东方证券（600958）', total=5.3, action='中性', fundamentals=6.9)
Scrore(name='中国平安（601318）', total=5.7, action='中性', fundamentals=6.9)
Scrore(name='中国太保（601601）', total=5.5, action='中性', fundamentals=6.9)
Scrore(name='光大银行（601818）', total=5.4, action='中性', fundamentals=6.9)
Scrore(name='中国银河（601881）', total=4.5, action='减持', fundamentals=6.9)
Scrore(name='中国核电（601985）', total=5.3, action='中性', fundamentals=6.9)
Scrore(name='药明康德（603259）', total=5.1, action='中性', fundamentals=6.9)
Scrore(name='TCL集团（000100）', total=6.1, action='增持', fundamentals=6.9)
Scrore(name='申万宏源（000166）', total=5.4, action='中性', fundamentals=6.9)
Scrore(name='徐工机械（000425）', total=4.6, action='减持', fundamentals=6.9)
Scrore(name='金风科技（002202）', total=5.4, action='中性', fundamentals=6.9)
Scrore(name='欧菲光（002456）', total=6.6, action='增持', fundamentals=6.9)
Scrore(name='世纪华通（002602）', total=6.3, action='增持', fundamentals=6.9)
Scrore(name='国信证券（002736）', total=5.2, action='中性', fundamentals=6.9)
Scrore(name='温氏股份（300498）', total=4.6, action='减持', fundamentals=6.9)
Scrore(name='烽火通信（600498）', total=4.5, action='减持', fundamentals=6.8)
Scrore(name='海螺水泥（600585）', total=7.2, action='买入', fundamentals=6.8)
Scrore(name='君正集团（601216）', total=5.2, action='中性', fundamentals=6.8)
Scrore(name='中科曙光（603019）', total=5.1, action='中性', fundamentals=6.8)
Scrore(name='天茂集团（000627）', total=5.9, action='中性', fundamentals=6.8)
Scrore(name='京东方A（000725）', total=5.5, action='中性', fundamentals=6.8)
Scrore(name='长江证券（000783）', total=5.3, action='中性', fundamentals=6.8)
Scrore(name='美年健康（002044）', total=5.6, action='中性', fundamentals=6.8)
Scrore(name='三花智控（002050）', total=6.5, action='增持', fundamentals=6.8)
Scrore(name='汇川技术（300124）', total=6.6, action='增持', fundamentals=6.8)
Scrore(name='招商银行（600036）', total=5.7, action='中性', fundamentals=6.7)
Scrore(name='恒瑞医药（600276）', total=5.5, action='中性', fundamentals=6.7)
Scrore(name='片仔癀（600436）', total=4.6, action='减持', fundamentals=6.7)
Scrore(name='国投电力（600886）', total=5.8, action='中性', fundamentals=6.7)
Scrore(name='工业富联（601138）', total=6.2, action='增持', fundamentals=6.7)
Scrore(name='农业银行（601288）', total=6.5, action='增持', fundamentals=6.7)
Scrore(name='新华保险（601336）', total=5.6, action='中性', fundamentals=6.7)
Scrore(name='三六零（601360）', total=3.9, action='卖出', fundamentals=6.7)
Scrore(name='中煤能源（601898）', total=6.2, action='增持', fundamentals=6.7)
Scrore(name='紫金矿业（601899）', total=7.0, action='买入', fundamentals=6.7)
Scrore(name='中远海控（601919）', total=5.1, action='中性', fundamentals=6.7)
Scrore(name='养元饮品（603156）', total=5.6, action='中性', fundamentals=6.7)
Scrore(name='合盛硅业（603260）', total=5.8, action='中性', fundamentals=6.7)
Scrore(name='金融街（000402）', total=5.7, action='中性', fundamentals=6.7)
Scrore(name='五粮液（000858）', total=4.7, action='减持', fundamentals=6.7)
Scrore(name='苏宁易购（002024）', total=5.3, action='中性', fundamentals=6.7)
Scrore(name='中航光电（002179）', total=6.0, action='增持', fundamentals=6.7)
Scrore(name='复星医药（600196）', total=4.8, action='减持', fundamentals=6.6)
Scrore(name='广汇汽车（600297）', total=5.4, action='中性', fundamentals=6.6)
Scrore(name='天士力（600535）', total=6.0, action='增持', fundamentals=6.6)
Scrore(name='山东黄金（600547）', total=6.2, action='增持', fundamentals=6.6)
Scrore(name='济川药业（600566）', total=5.5, action='中性', fundamentals=6.6)
Scrore(name='招商证券（600999）', total=5.9, action='中性', fundamentals=6.6)
Scrore(name='南京银行（601009）', total=5.0, action='中性', fundamentals=6.6)
Scrore(name='工商银行（601398）', total=5.6, action='中性', fundamentals=6.6)
Scrore(name='中国国旅（601888）', total=5.3, action='中性', fundamentals=6.6)
Scrore(name='建设银行（601939）', total=6.0, action='增持', fundamentals=6.6)
Scrore(name='平安银行（000001）', total=5.2, action='中性', fundamentals=6.6)
Scrore(name='华兰生物（002007）', total=4.7, action='减持', fundamentals=6.6)
Scrore(name='宁波银行（002142）', total=5.6, action='中性', fundamentals=6.6)
Scrore(name='中信证券（600030）', total=4.9, action='减持', fundamentals=6.5)
Scrore(name='宇通客车（600066）', total=5.9, action='中性', fundamentals=6.5)
Scrore(name='贵州茅台（600519）', total=5.6, action='中性', fundamentals=6.5)
Scrore(name='陆家嘴（600663）', total=5.9, action='中性', fundamentals=6.5)
Scrore(name='物产中大（600704）', total=5.8, action='中性', fundamentals=6.5)
Scrore(name='伊利股份（600887）', total=5.8, action='中性', fundamentals=6.5)
Scrore(name='中国化学（601117）', total=5.8, action='中性', fundamentals=6.5)
Scrore(name='中国铁建（601186）', total=6.0, action='增持', fundamentals=6.5)
Scrore(name='中国中铁（601390）', total=5.6, action='中性', fundamentals=6.5)
Scrore(name='中航飞机（000768）', total=5.4, action='中性', fundamentals=6.5)
Scrore(name='招商蛇口（001979）', total=5.0, action='中性', fundamentals=6.5)
Scrore(name='东方雨虹（002271）', total=5.2, action='中性', fundamentals=6.5)
Scrore(name='申通快递（002468）', total=4.5, action='减持', fundamentals=6.5)
Scrore(name='碧水源（300070）', total=5.2, action='中性', fundamentals=6.5)
Scrore(name='葛洲坝（600068）', total=6.5, action='增持', fundamentals=6.4)
Scrore(name='雅戈尔（600177）', total=5.5, action='中性', fundamentals=6.4)
Scrore(name='中国人保（601319）', total=5.4, action='中性', fundamentals=6.4)
Scrore(name='浙商证券（601878）', total=5.3, action='中性', fundamentals=6.4)
Scrore(name='步长制药（603858）', total=6.0, action='增持', fundamentals=6.4)
Scrore(name='恒逸石化（000703）', total=5.6, action='中性', fundamentals=6.4)
Scrore(name='广发证券（000776）', total=5.7, action='中性', fundamentals=6.4)
Scrore(name='科伦药业（002422）', total=5.6, action='中性', fundamentals=6.4)
Scrore(name='沃森生物（300142）', total=6.2, action='增持', fundamentals=6.4)
Scrore(name='中国联通（600050）', total=5.1, action='中性', fundamentals=6.3)
Scrore(name='中国卫星（600118）', total=5.2, action='中性', fundamentals=6.3)
Scrore(name='上海建工（600170）', total=5.4, action='中性', fundamentals=6.3)
Scrore(name='五矿资本（600390）', total=4.6, action='减持', fundamentals=6.3)
Scrore(name='小商品城（600415）', total=5.9, action='中性', fundamentals=6.3)
Scrore(name='长江电力（600900）', total=6.5, action='增持', fundamentals=6.3)
Scrore(name='中信建投（601066）', total=5.8, action='中性', fundamentals=6.3)
Scrore(name='长沙银行（601577）', total=4.9, action='减持', fundamentals=6.3)
Scrore(name='光大证券（601788）', total=5.3, action='中性', fundamentals=6.3)
Scrore(name='中国交建（601800）', total=5.7, action='中性', fundamentals=6.3)
Scrore(name='渤海租赁（000415）', total=5.5, action='中性', fundamentals=6.3)
Scrore(name='攀钢钒钛（000629）', total=4.6, action='减持', fundamentals=6.3)
Scrore(name='新希望（000876）', total=5.1, action='中性', fundamentals=6.3)
Scrore(name='传化智联（002010）', total=5.7, action='中性', fundamentals=6.3)
Scrore(name='广联达（002410）', total=5.7, action='中性', fundamentals=6.3)
Scrore(name='西部证券（002673）', total=5.3, action='中性', fundamentals=6.3)
Scrore(name='牧原股份（002714）', total=4.9, action='减持', fundamentals=6.3)
Scrore(name='国电电力（600795）', total=5.2, action='中性', fundamentals=6.2)
Scrore(name='中国银行（601988）', total=5.4, action='中性', fundamentals=6.2)
Scrore(name='贵阳银行（601997）', total=5.2, action='中性', fundamentals=6.2)
Scrore(name='北新建材（000786）', total=6.4, action='增持', fundamentals=6.2)
Scrore(name='盈趣科技（002925）', total=6.0, action='增持', fundamentals=6.2)
Scrore(name='上海机场（600009）', total=4.5, action='减持', fundamentals=6.1)
Scrore(name='华夏银行（600015）', total=5.9, action='中性', fundamentals=6.1)
Scrore(name='国投资本（600061）', total=5.8, action='中性', fundamentals=6.1)
Scrore(name='方大炭素（600516）', total=5.9, action='中性', fundamentals=6.1)
Scrore(name='杭州银行（600926）', total=5.2, action='中性', fundamentals=6.1)
Scrore(name='九州通（600998）', total=6.1, action='增持', fundamentals=6.1)
Scrore(name='财通证券（601108）', total=4.8, action='减持', fundamentals=6.1)
Scrore(name='兴业银行（601166）', total=5.6, action='中性', fundamentals=6.1)
Scrore(name='交通银行（601328）', total=5.9, action='中性', fundamentals=6.1)
Scrore(name='中国铝业（601600）', total=5.2, action='中性', fundamentals=6.1)
Scrore(name='华泰证券（601688）', total=5.0, action='中性', fundamentals=6.1)
Scrore(name='大族激光（002008）', total=3.5, action='卖出', fundamentals=6.1)
Scrore(name='航天信息（600271）', total=5.7, action='中性', fundamentals=6.0)
Scrore(name='中天科技（600522）', total=5.5, action='中性', fundamentals=6.0)
Scrore(name='川投能源（600674）', total=5.5, action='中性', fundamentals=6.0)
Scrore(name='通化东宝（600867）', total=5.1, action='中性', fundamentals=6.0)
Scrore(name='中国国航（601111）', total=5.4, action='中性', fundamentals=6.0)
Scrore(name='中国建筑（601668）', total=5.9, action='中性', fundamentals=6.0)
Scrore(name='中国电建（601669）', total=5.3, action='中性', fundamentals=6.0)
Scrore(name='中信银行（601998）', total=5.6, action='中性', fundamentals=6.0)
Scrore(name='海天味业（603288）', total=5.3, action='中性', fundamentals=6.0)
Scrore(name='延安必康（002411）', total=6.8, action='增持', fundamentals=6.0)
Scrore(name='东方财富（300059）', total=4.8, action='减持', fundamentals=6.0)
Scrore(name='亨通光电（600487）', total=5.7, action='中性', fundamentals=5.9)
Scrore(name='江苏银行（600919）', total=5.2, action='中性', fundamentals=5.9)
Scrore(name='春秋航空（601021）', total=5.7, action='中性', fundamentals=5.9)
Scrore(name='中国神华（601088）', total=5.6, action='中性', fundamentals=5.9)
Scrore(name='白银有色（601212）', total=5.2, action='中性', fundamentals=5.9)
Scrore(name='中国中冶（601618）', total=5.4, action='中性', fundamentals=5.9)
Scrore(name='金隅集团（601992）', total=5.3, action='中性', fundamentals=5.9)
Scrore(name='华友钴业（603799）', total=6.3, action='增持', fundamentals=5.9)
Scrore(name='金螳螂（002081）', total=5.3, action='中性', fundamentals=5.9)
Scrore(name='歌尔股份（002241）', total=5.5, action='中性', fundamentals=5.9)
Scrore(name='荣盛石化（002493）', total=6.8, action='增持', fundamentals=5.9)
Scrore(name='龙蟒佰利（002601）', total=6.7, action='增持', fundamentals=5.9)
Scrore(name='光线传媒（300251）', total=6.1, action='增持', fundamentals=5.9)
Scrore(name='白云机场（600004）', total=4.4, action='减持', fundamentals=5.8)
Scrore(name='西南证券（600369）', total=5.2, action='中性', fundamentals=5.8)
Scrore(name='中航电子（600372）', total=6.1, action='增持', fundamentals=5.8)
Scrore(name='广州港（601228）', total=4.4, action='减持', fundamentals=5.8)
Scrore(name='东旭光电（000413）', total=5.1, action='中性', fundamentals=5.8)
Scrore(name='云南白药（000538）', total=5.5, action='中性', fundamentals=5.8)
Scrore(name='长安汽车（000625）', total=6.4, action='增持', fundamentals=5.8)
Scrore(name='铜陵有色（000630）', total=5.0, action='中性', fundamentals=5.8)
Scrore(name='双汇发展（000895）', total=5.4, action='中性', fundamentals=5.8)
Scrore(name='新和成（002001）', total=6.0, action='增持', fundamentals=5.8)
Scrore(name='分众传媒（002027）', total=4.8, action='减持', fundamentals=5.8)
Scrore(name='巨人网络（002558）', total=5.7, action='中性', fundamentals=5.8)
Scrore(name='华能国际（600011）', total=6.2, action='增持', fundamentals=5.7)
Scrore(name='华电国际（600027）', total=6.1, action='增持', fundamentals=5.7)
Scrore(name='国金证券（600109）', total=4.7, action='减持', fundamentals=5.7)
Scrore(name='安迪苏（600299）', total=5.5, action='中性', fundamentals=5.7)
Scrore(name='江西铜业（600362）', total=4.7, action='减持', fundamentals=5.7)
Scrore(name='中国动力（600482）', total=5.7, action='中性', fundamentals=5.7)
Scrore(name='上海石化（600688）', total=6.1, action='增持', fundamentals=5.7)
Scrore(name='国泰君安（601211）', total=4.8, action='减持', fundamentals=5.7)
Scrore(name='广汽集团（601238）', total=6.0, action='增持', fundamentals=5.7)
Scrore(name='上海医药（601607）', total=4.5, action='减持', fundamentals=5.7)
Scrore(name='国元证券（000728）', total=5.3, action='中性', fundamentals=5.7)
Scrore(name='天齐锂业（002466）', total=5.8, action='中性', fundamentals=5.7)
Scrore(name='万达电影（002739）', total=4.2, action='减持', fundamentals=5.7)
Scrore(name='网宿科技（300017）', total=4.9, action='减持', fundamentals=5.7)
Scrore(name='民生银行（600016）', total=5.8, action='中性', fundamentals=5.6)
Scrore(name='同仁堂（600085）', total=4.7, action='减持', fundamentals=5.6)
Scrore(name='建发股份（600153）', total=4.9, action='减持', fundamentals=5.6)
Scrore(name='青岛港（601298）', total=4.4, action='减持', fundamentals=5.6)
Scrore(name='中国中车（601766）', total=5.1, action='中性', fundamentals=5.6)
Scrore(name='中联重科（000157）', total=5.1, action='中性', fundamentals=5.6)
Scrore(name='康弘药业（002773）', total=6.0, action='增持', fundamentals=5.6)
Scrore(name='长城证券（002939）', total=5.9, action='中性', fundamentals=5.6)
Scrore(name='三环集团（300408）', total=4.8, action='减持', fundamentals=5.6)
Scrore(name='中油工程（600339）', total=5.0, action='中性', fundamentals=5.5)
Scrore(name='国电南瑞（600406）', total=6.0, action='增持', fundamentals=5.5)
Scrore(name='中金黄金（600489）', total=5.4, action='中性', fundamentals=5.5)
Scrore(name='三安光电（600703）', total=6.6, action='增持', fundamentals=5.5)
Scrore(name='中国石油（601857）', total=5.5, action='中性', fundamentals=5.5)
Scrore(name='方正证券（601901）', total=5.1, action='中性', fundamentals=5.5)
Scrore(name='东华软件（002065）', total=5.8, action='中性', fundamentals=5.5)
Scrore(name='光启技术（002625）', total=4.5, action='减持', fundamentals=5.5)
Scrore(name='华林证券（002945）', total=4.4, action='减持', fundamentals=5.5)
Scrore(name='浦发银行（600000）', total=5.2, action='中性', fundamentals=5.4)
Scrore(name='宝钢股份（600019）', total=5.7, action='中性', fundamentals=5.4)
Scrore(name='宁波港（601018）', total=5.3, action='中性', fundamentals=5.4)
Scrore(name='东兴证券（601198）', total=4.4, action='减持', fundamentals=5.4)
Scrore(name='中国重工（601989）', total=5.1, action='中性', fundamentals=5.4)
Scrore(name='安道麦A（000553）', total=5.8, action='中性', fundamentals=5.4)
Scrore(name='河钢股份（000709）', total=5.2, action='中性', fundamentals=5.4)
Scrore(name='石基信息（002153）', total=5.8, action='中性', fundamentals=5.4)
Scrore(name='信立泰（002294）', total=5.3, action='中性', fundamentals=5.4)
Scrore(name='机器人（300024）', total=4.6, action='减持', fundamentals=5.4)
Scrore(name='南方航空（600029）', total=4.9, action='减持', fundamentals=5.3)
Scrore(name='南山铝业（600219）', total=5.9, action='中性', fundamentals=5.3)
Scrore(name='航发动力（600893）', total=5.8, action='中性', fundamentals=5.3)
Scrore(name='大秦铁路（601006）', total=6.5, action='增持', fundamentals=5.3)
Scrore(name='上海莱士（002252）', total=4.8, action='减持', fundamentals=5.3)
Scrore(name='赣锋锂业（002460）', total=6.1, action='增持', fundamentals=5.3)
Scrore(name='同方股份（600100）', total=5.2, action='中性', fundamentals=5.2)
Scrore(name='北方稀土（600111）', total=5.2, action='中性', fundamentals=5.2)
Scrore(name='东方航空（600115）', total=4.6, action='减持', fundamentals=5.2)
Scrore(name='北京银行（601169）', total=5.4, action='中性', fundamentals=5.2)
Scrore(name='上海电气（601727）', total=5.1, action='中性', fundamentals=5.2)
Scrore(name='洛阳钼业（603993）', total=5.8, action='中性', fundamentals=5.2)
Scrore(name='特变电工（600089）', total=5.2, action='中性', fundamentals=5.1)
Scrore(name='天风证券（601162）', total=4.9, action='减持', fundamentals=5.1)
Scrore(name='中海油服（601808）', total=6.5, action='增持', fundamentals=5.1)
Scrore(name='鞍钢股份（000898）', total=5.5, action='中性', fundamentals=5.1)
Scrore(name='藏格控股（000408）', total=4.4, action='减持', fundamentals=5.0)
Scrore(name='上港集团（600018）', total=5.5, action='中性', fundamentals=4.9)
Scrore(name='中国电影（600977）', total=5.4, action='中性', fundamentals=4.9)
Scrore(name='浙能电力（600023）', total=5.1, action='中性', fundamentals=4.8)
Scrore(name='海航控股（600221）', total=5.4, action='中性', fundamentals=4.8)
Scrore(name='海油工程（600583）', total=6.5, action='增持', fundamentals=4.8)
Scrore(name='北汽蓝谷（600733）', total=5.3, action='中性', fundamentals=4.7)
Scrore(name='东方园林（002310）', total=4.6, action='减持', fundamentals=4.7)
Scrore(name='包钢股份（600010）', total=5.1, action='中性', fundamentals=4.6)
Scrore(name='东方明珠（600637）', total=5.3, action='中性', fundamentals=4.6)
Scrore(name='三聚环保（300072）', total=5.0, action='中性', fundamentals=4.1)
Scrore(name='东阿阿胶（000423）', total=4.4, action='减持', fundamentals=3.7)
Scrore(name='安信信托（600816）', total=4.8, action='减持', fundamentals=3.6)
 */
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
    private val site = Site.me().setRetryTimes(1).setSleepTime(1000)
    override fun getSite(): Site {
        return site
    }


    @Test
    fun test() {
        var data = FileUtils.getFromFile("/code/300")
        val chengfen1s = data.split("\n");

        val spider = Spider.create(ValueScroeTest()).thread(1).addPipeline(MyPipLine(allData))

        val httpClientDownloader = HttpClientDownloader()

//        httpClientDownloader.setProxyProvider(SimpleProxyProvider.from(
//                Proxy("110.16.80.1060",8080),
//                Proxy("1.182.90.85",8118),
//                Proxy("116.114.19.204",443)
//                ))
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
