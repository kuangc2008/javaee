package com.bean


interface  Op

class BuyGridOp(val belowPositionPercent : Float, val range : Float, val money : Int, val fix : Boolean) : Op

class SellerGridOp( val abovePositionPercent : Float, val range : Float, val money : Int, val fix : Boolean) : Op