package com.example.rxvscoru

import CorutienTest
import RxCodeTest
import androidx.lifecycle.ViewModel
import io.reactivex.Observable
import io.reactivex.Scheduler
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class TestViewModel : ViewModel() {
    private val compositeDisposable = CompositeDisposable()

    lateinit var rxObject: RxCodeTest
    lateinit var coObject: CorutienTest

    fun initObjectInstance() {
        rxObject = RxCodeTest()
        coObject = CorutienTest()
    }

    fun rxSumTest() : Single<Unit>{
        return Single.fromCallable {
            rxObject.testSumLogic()
            return@fromCallable Unit
        }
    }

    fun rxIoTest(schedulers: Scheduler) {
        val start = System.currentTimeMillis()
        Observable.range(0, 10000)
            .subscribeOn(schedulers)
            .subscribeBy(
                onNext = {
                    println("$it")
                },
                onComplete = {
                    val end = System.currentTimeMillis()
                    println("걸린 시간 : ${end - start}")
                },
                onError = {

                }
            )
    }


    suspend fun coroutineSum() {
        withContext(Dispatchers.Default) {

        }
    }

    fun tearUp() {
        compositeDisposable.clear()
    }

    override fun onCleared() {
        super.onCleared()
    }
}