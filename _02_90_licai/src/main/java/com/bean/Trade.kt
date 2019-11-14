package com.bean

import java.util.*

class Trade {

    private val datas  = ArrayList<TradeTime>()

    var stock = 0
    var totalUseMonkey = 0
    var size: Int = 0

    fun getTotalStock() : Int {
        return stock
    }

    fun getTotalMoney() : Int {
        return totalUseMonkey
    }


    fun getH333Position() : Int {
        return (2000 + totalUseMonkey) / 10000
    }




    @JvmOverloads
    fun addOp(tradeTime: TradeTime) {
        datas.add(tradeTime)
        if (tradeTime.isBuy) {
            stock += tradeTime.stockNum
            totalUseMonkey += tradeTime.monkey
            size++

            if (tradeTime.price > 0) {
                tradeTime.liruilv = ((tradeTime.price * stock) / totalUseMonkey).toFloat()
            }


        } else {

            val perPrice = totalUseMonkey * 1.0/ stock;

            tradeTime.result = tradeTime.monkey - (perPrice * tradeTime.stockNum).toInt();
            stock -= tradeTime.stockNum

            totalUseMonkey = (tradeTime.price * stock).toInt()
//            totalUseMonkey -=  (perPrice * tradeTime.stockNum).toInt();
            size = 0
        }
    }


    fun sellWithNum(stockNum: Int, dayStr: String, startPrice: Double) {


        val totalMoney =  (startPrice * stockNum).toInt()
        val trade = Trade.TradeTime(false, totalMoney, stockNum, dayStr, startPrice)


        datas.add(trade)

        if (stockNum == 0) {
            return;
        }

        val perPrice = totalUseMonkey * 1.0/ stock;
        trade.result = totalMoney - (perPrice * stockNum).toInt();

        stock -= stockNum
        totalUseMonkey -=  (perPrice * stockNum).toInt();
        size = 0

    }

    fun print(price : Double) {

        var totalP = 0;
        for (trade in datas) {
            if (trade.isBuy) {
                System.out.println("买入: " + trade + if (trade.stockNum == 0) "=================================" else "")
            } else {
                System.out.println("卖出: " + trade + if (trade.stockNum == 0) "*********************************" else "")
                System.out.println("盈利:" + trade.result)
                totalP+= trade.result;
            }
        }

        System.out.println("剩下的->" + getTotalStock() +
                "  monkey->" + getTotalMoney() + "  current->" + getTotalStock() * price )

        totalP+= (getTotalStock() * price).toInt() - getTotalMoney()


        System.out.println("总利润是***********" + totalP)
    }

    class TradeTime (val isBuy : Boolean, val monkey : Int, val stockNum : Int, val day : String, val price : Double) {
        var result = 0
        var force = false

        var liruilv : Float = 0f
        override fun toString(): String {
            return "TradeTime(isBuy=$isBuy, monkey=$monkey, stockNum=$stockNum, day='$day', price=$price, result=$result, force=$force, liruilv=$liruilv)"
        }


    }

}
