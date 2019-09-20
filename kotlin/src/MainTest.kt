
fun main() {
    listOf(1, 2, 3).forEach { item -> foo2().invoke(item) }
    listOf(4, 5, 6).forEach { item -> foo3.invoke(item) }
    listOf(4, 5, 6).forEach { item -> foo3(item) }
}

fun foo(int : Int) = {
    print(int)
}

fun foo2() = { x : Int ->
    print(x)
}

val foo3 = {x : Int ->
    print(x)

}