package com.dao

import com.bean.StockDay
import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream
import com.utils.FileUtils
import org.json.JSONObject
import java.io.FileInputStream
import java.io.InputStream
import java.net.URL
import java.util.*

class StockDao {

    fun getAllStockNum(file : String = "/wanke") : ArrayList<StockDay> {

        val data: String = FileUtils.getFromFile(  if (file.isEmpty()) "/wanke" else file)


        val jsonObject = JSONObject(data)
        val array = jsonObject.getJSONObject("data").getJSONArray("item")


        val length = array.length()
        val arrayList = ArrayList<StockDay>(length)
        for (i in 0 until  length) {
            val item = array.getJSONArray(i)


            val day : Long = item.getLong(0)
            val num : Long = item.getLong(1)
            val start  = item.getDouble(2)
            val top  = item.getDouble(3)
            val low  = item.getDouble(4)
            val end  = item.getDouble(5)
            val diff  = item.getDouble(6)
            val diffP  = item.getDouble(7)


            var total : Long
            try {
                total = (item.getDouble(8) * 1e8).toLong()
            } catch (e : Exception) {
                total = item.optLong(8)
            }

            val stockDay = StockDay(day, num, start, top, low, end, diff, diffP, total)
            arrayList.add(stockDay)
        }

//        for (day in arrayList) {
//            System.out.println(day)
//        }
        return arrayList
    }



}
