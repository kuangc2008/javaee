package com.bean

class Scrore (val name : String, val total : Float, val action:String, val fundamentals : Float) {

    override fun toString(): String {
        return "Scrore(name='$name', total=$total, action='$action', fundamentals=$fundamentals)"
    }
}