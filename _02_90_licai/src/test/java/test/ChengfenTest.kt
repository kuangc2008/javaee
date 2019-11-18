package test

import com.service.ChengfenService
import org.junit.Test

class ChengfenTest {
    internal var serivce = ChengfenService()


    @Test
    fun findSame() {
        val findSame = serivce.findSame("/chengfen/300jiazhi", "/chengfen/300chengzhang")
        findSame.forEach {
            println(it)
        }
    }

    @Test
    fun findSame2() {
        val findSame = serivce.findSame("/chengfen/300jiazhi", "/chengfen/300hongli")
        findSame.forEach {
            println(it)
        }
    }


    @Test
    fun findSame22() {
        val findSame = serivce.findSame("/chengfen/300jiazhi", "/chengfen/180红利")
        findSame.forEach {
            println(it)
        }
    }


    @Test
    fun findSame3() {
        val same = serivce.findSame("/chengfen/300jiazhi", "/chengfen/300hongli")
        val same1 = serivce.findSame("/chengfen/300jiazhi", "/chengfen/300chengzhang")

        val same2 = serivce.findSame(same, same1)
        same2.forEach {
            println(it)
        }
    }


    @Test
    fun findSame4() {
        val same = serivce.findSame("/chengfen/300jiazhi", "/chengfen/wending300")
        val same1 = serivce.findSame("/chengfen/300jiazhi", "/chengfen/300chengzhang")
        val findSame = serivce.findSame("/chengfen/300jiazhi", "/chengfen/180红利")
        val same2 = serivce.findSame(same, same1)
        val same3 = serivce.findSame(same2, findSame)
        same3.forEach {
            println(it)
        }
    }
}
