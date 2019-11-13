package com.bean

import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*


/**
 * [1573488000000,330054660,
 *  3.962,3.979,3.938,3.962,
 *  -0.005,-0.13,0.0,1.30674607E9,null,null]
 */
class StockDay(val day :Long, val totalNum : Long,
               val startPrice : Double, val topPrice : Double, val lowPrice: Double, val endPrice: Double,
               val change : Double, val changePer : Double, val totalPrice : Long)  {

    companion object {
        val df : DateFormat = SimpleDateFormat("yyyy-MM-dd");
    }

    fun getDayStr() : String {
        return df.format(day)
    }

    fun getYear() : Int {
        val c = Calendar.getInstance()
        c.timeInMillis = day
        return c.get(Calendar.YEAR)

    }

    fun getMonth() : Int {
        val c = Calendar.getInstance()
        c.timeInMillis = day
        return c.get(Calendar.MONTH)

    }




    override fun toString(): String {
        return getDayStr() +  " month"  + getMonth()  +   "StockDay(day=$day, totalNum=$totalNum, startPrice=$startPrice, topPrice=$topPrice, lowPrice=$lowPrice, endPrice=$endPrice, change=$change, changePer=$changePer, totalPrice=$totalPrice)"
    }


}
