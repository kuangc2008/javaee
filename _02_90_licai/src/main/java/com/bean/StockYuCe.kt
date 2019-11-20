package com.bean

class StockYuCe {
    var stockName =  "长城汽车";
    var stockCode= "601633"
    var total= 96
    var rateBuy= 64
    var rateIncrease= 32
    var rateNeutral= 0
    var rateReduce= 0
    var rateSellout= 0
    var ratekanduo= 96
    var lastYearEps= "0.5705"
    var lastYearProfit= "5.2073139E9"
    var thisYearEps= "0.4983"
    var thisYearPe= ""
    var thisYearProfit= "4.5750298E9"
    var nextYearEps= "0.6308"
    var nextYearPe= ""
    var nextYearProfit= "5.7894692E9"
    var afterYearEps= "0.7645"
    var afterYearPe= ""
    var afterYearProfit= ""
    var lastYearActualProfit= "5.2073139E9"
    var lastYearActualEps= "0.5705"
    var beforeYearActualProfit= "5.0272978E9"
    var beforeYearActualEps= "0.5508"
    var aimPriceT= "20.4"
    var aimPriceL= "8.3"
    var updateTime= "2019-11-20 12=30=11"
    var dyBK= "199003"


    override fun toString(): String {
        return "StockYuCe(stockName='$stockName') count='$total' low-'$aimPriceL' will->(${afterYearEps.toFloat() / thisYearEps.toFloat() }))"
    }


}