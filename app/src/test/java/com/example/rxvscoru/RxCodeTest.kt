import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.internal.schedulers.IoScheduler
import io.reactivex.rxkotlin.addTo
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers

class RxCodeTest {
    private val compositeDisposable = CompositeDisposable()

    private val IoScheduler = Schedulers.io()
    private val computationScheduler = Schedulers.computation()

    init {

    }

    fun testSumLogic() {
        val start = System.currentTimeMillis()

        Observable.range(0, Int.MAX_VALUE)
            .scan { t1, t2 ->
                t1 + t2 }
            //.subscribeOn(computationScheduler)
            .subscribeBy(
                onNext = {

                },
                onComplete = {
                    val end = System.currentTimeMillis()
                    println("${end - start}")

                },
                onError = {
                    println("error : ${it.localizedMessage}")
                }
            ).addTo(compositeDisposable)
    }


    fun testIoLogic(){
        val start = System.currentTimeMillis()

        Observable.range(0,Int.MAX_VALUE)
            .subscribeOn(Schedulers.trampoline())
            .doAfterTerminate {
                val end = System.currentTimeMillis()
                println("${end - start}")
            }
            .doOnError {
                println(it.localizedMessage)
            }
            .subscribe {
                println("출력 : ${it}")
            }
            .addTo(compositeDisposable)
    }

    fun clearDisposable() {
        compositeDisposable.clear()
    }
}