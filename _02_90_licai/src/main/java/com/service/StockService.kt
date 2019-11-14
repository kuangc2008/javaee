package com.service

import com.bean.Op
import com.bean.Trade
import com.dao.StockDao

class StockService {

    val dao = StockDao();

    @JvmOverloads
    fun dingTou(startYear : Int , startMonth : Int, monkey : Int, rationRemove: Float, monthGap : Int = 1, removeFloat : Float = 1f, code : String = "") {
        val allStockNum = dao.getAllStockNum(code)

        val monkey2 = monkey * monthGap
        var trade = Trade()

        var skip = monthGap
        var lastMonth = -1

        for (day in allStockNum) {
            if (startYear > day.getYear() || (startYear == day.getYear() && startMonth > day.getMonth())) {
                continue
            }

            if (lastMonth != day.getMonth()) {
                skip++
                lastMonth = day.getMonth()
            }

            if (skip >= monthGap) {
                skip = 0

                if ( (trade.getTotalStock() * day.startPrice) * 1.0 /  trade.getTotalMoney() >= (1 + rationRemove)) {
                    val count : Int = (trade.getTotalStock() * removeFloat).toInt()
                    trade.addOp(Trade.TradeTime(false, (count * day.startPrice).toInt(), count, day.getDayStr(),  day.startPrice))
                    continue
                }

                var stock = (monkey2 / day.startPrice / 100).toInt() * 100
                var totalMoney = (stock * day.startPrice).toInt()

                trade.addOp(Trade.TradeTime(true, totalMoney, stock, day.getDayStr(), day.startPrice))
            }
        }

        trade.print(allStockNum.last().startPrice)
    }





    @JvmOverloads
    fun dingTouEnd(startYear : Int , startMonth : Int, monkey : Int, rationRemove: Float, decrease : Float, monthGap : Int = 1) {
        val allStockNum = dao.getAllStockNum()

        var trade = Trade()

        var skip = monthGap
        var lastMonth = -1


        var currentOldPrice : Double = (-1F).toDouble()


        for (i in allStockNum.indices) {
            var day = allStockNum[i]
            if (startYear > day.getYear() || (startYear == day.getYear() && startMonth > day.getMonth())) {
                continue
            }


            if (day.startPrice > currentOldPrice) {
                currentOldPrice = day.startPrice
            }

            if (lastMonth != day.getMonth()) {
                skip++
                lastMonth = day.getMonth()
            }



            if (skip >= monthGap) {

                if ( (trade.getTotalStock() * day.startPrice) * 1.0 /  trade.getTotalMoney() >= (1 + rationRemove)) {
                    skip = 0
                    trade.addOp(Trade.TradeTime(false, (trade.getTotalStock() * day.startPrice).toInt(), trade.getTotalStock(), day.getDayStr(),  day.startPrice))
                    continue
                }



                if (currentOldPrice == (-1F).toDouble() || day.startPrice <= currentOldPrice * (1 - decrease) || (decrease == 0f)) {
                    var stock = (monkey * monthGap / day.startPrice / 100).toInt() * 100
                    var totalMoney = (stock * day.startPrice).toInt()

                    trade.addOp(Trade.TradeTime(true, totalMoney, stock, day.getDayStr(), day.startPrice))

                    skip = 0
                    currentOldPrice = day.startPrice
                } else if ( ((i + 1) < allStockNum.size) && (skip >= monthGap * 2 -1) && allStockNum[i+1].getMonth() != day.getMonth()) {
                    var stock = (monkey * monthGap / day.startPrice / 100).toInt() * 100
                    var totalMoney = (stock * day.startPrice).toInt()


                    val tradeTime = Trade.TradeTime(true, totalMoney, stock, day.getDayStr(), day.startPrice)
                    tradeTime.force = true
                    trade.addOp(tradeTime)
                    skip = 0
                    currentOldPrice = day.startPrice
                }
            }
        }

        trade.print(allStockNum.last().startPrice)
    }



    fun dingTouMultiYear(startYear : Int , startMonth : Int, monkey : Int, rationRemove: Float, monthGap : Int, decrease : Float, isAddMoney : Boolean) {
        val allStockNum = dao.getAllStockNum()

        var currentOldPrice : Double = (-1F).toDouble()

        var currentNum = -1
        var currentYear = -1

        var trade = Trade()

        for (i in allStockNum.indices) {
            var day = allStockNum[i]

            val dayNum = (day.getMonth()) / monthGap

            if (startYear > day.getYear() || (startYear == day.getYear() && startMonth > day.getMonth())) {
                continue
            }

            if (day.startPrice > currentOldPrice) {
                currentOldPrice = day.startPrice
            }



            if (currentNum != dayNum || currentYear != day.getYear()) {

                if ( (trade.getTotalStock() * day.startPrice) * 1.0 /  trade.getTotalMoney() >= (1 + rationRemove)) {

                    trade.addOp(Trade.TradeTime(false, (trade.getTotalStock() * day.startPrice).toInt(), trade.getTotalStock(), day.getDayStr(),  day.startPrice))
                    continue
                }


                if (currentOldPrice == (-1F).toDouble() || day.startPrice <= currentOldPrice * (1 - decrease) || (decrease == 0f)) {


                    var mon = if (isAddMoney) monkey * (monthGap + 1) else monkey * monthGap

                    var stock = (mon / day.startPrice / 100).toInt() * 100
                    var totalMoney = (stock * day.startPrice).toInt()

                    trade.addOp(Trade.TradeTime(true, totalMoney, stock, day.getDayStr(), day.startPrice))


                    currentNum = dayNum
                    currentYear = day.getYear()
                    currentOldPrice = day.startPrice
                } else if ( (i + 1) < allStockNum.size && (allStockNum[i+1].getMonth()) / monthGap != dayNum) {
                    var stock = (monkey * monthGap / day.startPrice / 100).toInt() * 100
                    var totalMoney = (stock * day.startPrice).toInt()


                    val tradeTime = Trade.TradeTime(true, totalMoney, stock, day.getDayStr(), day.startPrice)
                    tradeTime.force = true
                    trade.addOp(tradeTime)


                    currentNum = dayNum
                    currentOldPrice = day.startPrice
                }




            }
        }

        trade.print(allStockNum.last().startPrice)

    }





    fun h333(startYear : Int , startMonth : Int, endYear : Int , endMonth : Int, monkey : Int, rationRemove: Float, monthGap : Int, decrease : Float) {
        val allStockNum = dao.getAllStockNum()

        var currentTopPrice : Double = (-1F).toDouble()
        var currentLowPrice : Double = (-1F).toDouble()

        var currentNum = -1
        var currentYear = -1


        var trade = Trade()

        for (i in allStockNum.indices) {
            var day = allStockNum[i]

            var dayNum = -1
            if (monthGap != 0) {
                dayNum = (day.getMonth()) / monthGap
            }

            if (startYear > day.getYear() || (startYear == day.getYear() && startMonth > day.getMonth())) {
                continue
            }
            if (endYear < day.getYear() || (endYear == day.getYear() && endMonth < day.getMonth())) {
                break
            }

            if (day.startPrice > currentTopPrice) {
                currentTopPrice = day.startPrice
            }

            if (currentLowPrice < 0 || day.startPrice < currentLowPrice) {
                currentLowPrice = day.startPrice;
            }



            if (dayNum == -1 || currentNum != dayNum || currentYear != day.getYear()) {




                if (currentTopPrice == (-1F).toDouble() || day.startPrice <= currentTopPrice * (1 - decrease)) {




                    var qian : Int = 0
                    if (trade.getH333Position() == 0) {
                        qian = 2 * monkey
                    } else if (trade.getH333Position() == 1 || trade.getH333Position() == 2) {
                        qian =  monkey
                    } else if (trade.getH333Position() == 3) {
                        System.out.println ("没钱了")
                    }

                    var stock = (qian / day.startPrice / 100).toInt() * 100
                    var totalMoney = (stock * day.startPrice).toInt()

                    trade.addOp(Trade.TradeTime(true, totalMoney, stock, day.getDayStr(), day.startPrice))


                    currentNum = dayNum
                    currentYear = day.getYear()


                    currentTopPrice  = (-1F).toDouble()
                    currentLowPrice  = (-1F).toDouble()
                } else if (day.startPrice >= currentLowPrice * (1 + decrease)) {

                    var stock : Int = trade.getTotalStock()
                    if (trade.getH333Position() == 0) {
                        System.out.println ("全部取出来了")
//                        continue
                        stock = 0
                    } else if (trade.getH333Position() == 1 || trade.getH333Position() == 2) {
                        stock =  stock/trade.getH333Position();

                        currentTopPrice  = (-1F).toDouble()
                    } else if (trade.getH333Position() == 3) {
                        stock /= trade.getH333Position();

                        currentTopPrice  = (-1F).toDouble()
                    }

//                    if (stock > 0) {
                         trade.sellWithNum(stock, day.getDayStr(),  day.startPrice);
//                    }



                    currentLowPrice  = (-1F).toDouble()

                    continue
                }




            }
        }

        trade.print(allStockNum.last().startPrice)

    }





    fun h333_2(startYear : Int , startMonth : Int, endYear : Int , endMonth : Int, monkey : Int, rationRemove: Float, monthGap : Int,
               decrease1 : Float,decrease2 : Float,decrease3 : Float,
               increase1: Float, increase2 : Float, ncrease3 : Float) {
        val allStockNum = dao.getAllStockNum()

        var currentTopPrice : Double = (-1F).toDouble()
        var currentLowPrice : Double = (-1F).toDouble()

        var currentNum = -1
        var currentYear = -1


        var trade = Trade()

        var priceEnd : Double = (-1F).toDouble()

        for (i in allStockNum.indices) {
            var day = allStockNum[i]

            var dayNum = -1
            if (monthGap != 0) {
                dayNum = (day.getMonth()) / monthGap
            }

            if (startYear > day.getYear() || (startYear == day.getYear() && startMonth > day.getMonth())) {
                continue
            }
            if (endYear < day.getYear() || (endYear == day.getYear() && endMonth < day.getMonth())) {
                priceEnd = day.startPrice
                break
            }

            if (day.startPrice > currentTopPrice ) {
                currentTopPrice = day.startPrice
            }

            if (currentLowPrice < 0 || day.startPrice < currentLowPrice) {
                currentLowPrice = day.startPrice;
            }



            if (dayNum == -1 || currentNum != dayNum || currentYear != day.getYear()) {

                if ( (trade.getH333Position() == 0  &&  day.startPrice <= currentTopPrice * (1 - decrease1) )
                        || (trade.getH333Position() == 1 &&  day.startPrice <= currentTopPrice * (1 - decrease2))
                        || (trade.getH333Position() == 2 &&  day.startPrice <= currentTopPrice * (1 - decrease3))
                        || (trade.getH333Position() == 3 &&  day.startPrice <= currentTopPrice * (1 - decrease3))) {

                    var qian: Int = 0
                    if (trade.getH333Position() == 0 || trade.getH333Position() == 1) {
                        qian = 2 * monkey
                    } else if (trade.getH333Position() == 2) {
                        qian = monkey
                    } else if (trade.getH333Position() == 3) {
                        System.out.println("没钱了")
                    }

                    var stock = (qian / day.startPrice / 100).toInt() * 100
                    var totalMoney = (stock * day.startPrice).toInt()

                    trade.addOp(Trade.TradeTime(true, totalMoney, stock, day.getDayStr(), day.startPrice))


                    currentNum = dayNum
                    currentYear = day.getYear()


                    currentTopPrice = day.startPrice
                    currentLowPrice = day.startPrice

                } else if (
                    (trade.getH333Position() == 0  &&  day.startPrice >= currentLowPrice * (1 + increase1))
                        || (trade.getH333Position() == 1 &&  day.startPrice >= currentLowPrice * (1 + increase1))
                        || (trade.getH333Position() == 2 &&  day.startPrice >= currentLowPrice * (1 + increase2))
                        || (trade.getH333Position() == 3 &&  day.startPrice >= currentLowPrice * (1 + ncrease3)))

                {

                    var stock : Int = trade.getTotalStock()
                    if (trade.getH333Position() == 0) {
                        System.out.println ("全部取出来了")
//                        continue
                        stock = 0
                    } else if (trade.getH333Position() == 1) {
                        stock =  stock/trade.getH333Position();

                        currentTopPrice  = (-1F).toDouble()
                    } else if (trade.getH333Position() == 3 || trade.getH333Position() == 2) {
                        stock /= trade.getH333Position()  * 2;

                        currentTopPrice  = (-1F).toDouble()
                    }

//                    if (stock > 0) {
                    trade.sellWithNum(stock, day.getDayStr(),  day.startPrice);
//                    }



                    currentTopPrice  = day.startPrice
                    currentLowPrice  = day.startPrice

                }
            }
        }

        priceEnd = if (priceEnd > 0) priceEnd else allStockNum.last().startPrice
        trade.print(priceEnd)

    }


    /**
     * 程序网格；  上涨与下跌是根据，投入值或者变动的值。 是否间隔月份 （0的话不讲个）
     * 设计：总共n个格子
     *
     * 1. 当指数下跌x(10%)， 投入y格子
     *  2. 位于这个格子，当指数继续下跌x(8%), 投入 y 格子
     *      3. 位于这个格子，当指数继续下跌x(8%), 投入 y 格子
     *  2. 位于这个格子，当指数上涨x(10%)， 取出y格子
     *
     *
     *
     * 总资金100万，然后分成24期定投；   如果收益目标达到，按计划取出部分钱；  取出的钱，按照4%的收益计算！
     *     最终计算出整个收益率是多少！
     *
     * 1， 按照计算，定投就行。 或者大幅度回调的时候 （对最终收益影响有限）
     * 2.  翻倍的时候，讲钱取出
     *
     *
     *
     *
     */

    fun h333_end(startYear : Int , startMonth : Int, endYear : Int , endMonth : Int, money : Int,  monthGap : Int, op : List<Op>) {


    }
}
