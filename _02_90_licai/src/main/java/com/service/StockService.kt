package com.service

import com.bean.Trade
import com.dao.StockDao
import java.util.*

class StockService {

    val dao = StockDao();




    fun dingTou(startYear : Int , startMonth : Int, monkey : Int, rationRemove: Float) {
        val allStockNum = dao.getAllStockNum()
        var currentMonth = -1


        var trade = Trade()

        for (day in allStockNum) {
            if (startYear > day.getYear() || (startYear == day.getYear() && startMonth > day.getMonth())) {
                continue
            }
            if (currentMonth != day.getMonth()) {

                currentMonth = day.getMonth()

                if ( (trade.getTotalStock() * day.startPrice) * 1.0 /  trade.getTotalMoney() >= (1 + rationRemove)) {

                    trade.addOp(Trade.TradeTime(false, (trade.getTotalStock() * day.startPrice).toInt(), trade.getTotalStock(), day.getDayStr(),  day.startPrice))
                    continue
                }

                var stock = (monkey / day.startPrice / 100).toInt() * 100
                var totalMoney = (stock * day.startPrice).toInt()

                trade.addOp(Trade.TradeTime(true, totalMoney, stock, day.getDayStr(), day.startPrice))
            }
        }

        trade.print(allStockNum.last().startPrice)




    }


}
