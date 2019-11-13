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

    fun addOp(tradeTime: TradeTime) {
        datas.add(tradeTime)
        if (tradeTime.isBuy) {
            stock += tradeTime.stockNum
            totalUseMonkey += tradeTime.monkey
            size++
        } else {
            stock -= tradeTime.stockNum
            tradeTime.result = ( tradeTime.monkey - totalUseMonkey)
            totalUseMonkey = 0
            size = 0
        }
    }

    fun print(price : Double) {

        var totalP = 0;
        for (trade in datas) {
            if (trade.isBuy) {
                System.out.println("买入: " + trade)
            } else {
                System.out.println("卖出: " + trade)
                System.out.println("盈利:" + trade.result)
                totalP+= trade.result;
            }
        }

        System.out.println("剩下的->" + getTotalStock() +
                "  total->" + size +
                "  monkey->" + getTotalMoney() + "  current->" + getTotalStock() * price )

        totalP+= (getTotalStock() * price).toInt() - getTotalMoney()


        System.out.println("总利润是***********" + totalP)
    }

    class TradeTime (val isBuy : Boolean, val monkey : Int, val stockNum : Int, val day : String, val price : Double) {
        var result = 0

        override fun toString(): String {
            return "TradeTime(isBuy=$isBuy, monkey=$monkey, stockNum=$stockNum, day='$day', price=$price, result=$result)"
        }


    }

}
