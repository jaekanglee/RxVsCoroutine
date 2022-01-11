package com.example.rxvscoru

import CorutienTest
import RxCodeTest
import io.reactivex.rxkotlin.addTo
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.*
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {

    @Rule
    @JvmField
    val testSchedulerRule = SchedulersRule()
    private val mainThreadSurrogate = newSingleThreadContext("UI thread")
    lateinit var viewmodel: TestViewModel

    @ExperimentalCoroutinesApi
    @Before
    fun setUp() {
        viewmodel = TestViewModel()
        viewmodel.initObjectInstance()
        Dispatchers.setMain(mainThreadSurrogate)
    }
//
//    @Test
//    fun RxcomputationLogic() {
//        val start = System.currentTimeMillis()
//        viewmodel.rxSumTest()
//            //.subscribeOn(Schedulers.trampoline())
//            .subscribeBy(
//                onSuccess = {
//                    val end = System.currentTimeMillis()
//                    println("걸린 시간 : ${end - start}")
//                },
//                onError = {
//
//                }
//            )
//    }

    //    @Test
//     fun RxIOLogic() {
//        viewmodel.rxIoTest(Schedulers.trampoline())
//    }
////
    @Test
    fun coComputationTest()  {
        val start = System.currentTimeMillis()
        viewmodel.coroutineSum()
        val end = System.currentTimeMillis()
        println("걸린 시간 : ${end - start}")

    }


    @ExperimentalCoroutinesApi
    @After
    fun tearUp() {
        viewmodel.tearUp()
        Dispatchers.resetMain() // reset the main dispatcher to the original Main dispatcher
        mainThreadSurrogate.close()
    }
}