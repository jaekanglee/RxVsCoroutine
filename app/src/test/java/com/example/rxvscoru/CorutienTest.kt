import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers

class CorutienTest {

    fun testSumLogic(){
        val start = System.currentTimeMillis()
        var sum = 0
         (0 .. Int.MAX_VALUE).forEach {
             sum += it
         }

        val end = System.currentTimeMillis()

        println("시간 차이 : ${end - start}")
    }
}