sealed class CanWalk(val legs: Int) //usar cuando sea necesario definir properties

sealed interface CanFly //interfaz si quiero que extienda de varias

class Elephant(val name: String): CanWalk(4)
class Spider(val age: Int): CanWalk(8)
object Swan: CanWalk(2), CanFly

object Fly: CanFly

fun test(canWalk: CanWalk): Int = when(canWalk){
    is Elephant -> canWalk.name.toInt()
    is Spider -> TODO()
    Swan -> TODO()
}

fun test2(canFly: CanFly): Int = when(canFly){
    Swan -> TODO()
    Fly -> TODO()
}

val elephant = Elephant("Miguel")