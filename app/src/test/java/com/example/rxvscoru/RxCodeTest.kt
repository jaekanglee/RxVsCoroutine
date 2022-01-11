import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.internal.schedulers.IoScheduler
import io.reactivex.rxkotlin.addTo
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestCoroutineDispatcher

class RxCodeTest {

    @ExperimentalCoroutinesApi
    private val testDispatcher = TestCoroutineDispatcher()

    init {

    }

    fun testSumLogic() {
        var sum = 0
        (0..Int.MAX_VALUE).forEach {
            sum += it
        }
    }


    fun testIoLogic(): Unit {
        (0..10000).forEach { it ->
            println("$it")
        }
        return Unit
    }

}