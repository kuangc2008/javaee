package kckotlin

import org.junit.Test

class HelloTest {


    @Test
    fun test1() {
        println("fsaf")

        val mutableListOf = mutableListOf<String>("111", "12222", "333", "1444")
        mutableListOf.any()

        val reduce = mutableListOf.reduceRight{ next, sum ->
            sum + next
        }
//        println(reduce)
        
        val r = mutableListOf.fold("first->") { acc, s ->
            acc + s
        }
//        println (r)

        var list = mutableListOf.dropLastWhile { it.contains("1") }
//        println (list)


        list = mutableListOf.slice(listOf(0, 3))
        println (list)





    }



    fun <T> Iterable<T>.forEach2 (action : (T) -> Unit) : Unit {
        for (element in this) {
            action (element)
        }
    }
}
