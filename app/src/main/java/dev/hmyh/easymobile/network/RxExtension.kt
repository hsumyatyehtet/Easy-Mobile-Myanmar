package dev.hmyh.easymobile.network

import android.annotation.SuppressLint
import android.util.Log
import dev.hmyh.easymobile.data.vos.MetaVO
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

// MoreData Response
@SuppressLint("CheckResult")
fun <T : MoreDataResponse<W>, W> Observable<T>.subscribeMoreDataResponse(
    success: (W, MetaVO?) -> Unit,
    failure: (String) -> Unit,
    subscribeOnScheduler: Scheduler = Schedulers.io()
) {
    this.subscribeOn(subscribeOnScheduler)
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe({
            it.processResponse({ data, meta ->
                success(data, meta)
            }, { message ->
                failure(message)
            })
        }, {
            failure("No internet connection")
        })
}
//Data Response
@SuppressLint("CheckResult")
fun <T : DataResponse<W>, W> Observable<T>.subscribeDataResponse(
    success: (W) -> Unit,
    failure: (String) -> Unit
) {
    this.subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe({
            it.processDataResponse({ data ->
                success(data)
            }, { message ->
                failure(message)
            })
        }, {
            failure("No internet connection")
        })
}
@SuppressLint("CheckResult")
fun Completable.subscribeDBWithCompletable() {
    this.subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe {
            doOnComplete {
                Log.d("Database CRUD", "Operation is successful.")
            }
            doOnError {
                Log.e("Database CRUD", "Operation is fail. Error message => ${it.message}")
            }
        }
}
//Base Response
@SuppressLint("CheckResult")
fun Observable<BaseResponse>.subscribeBaseResponse(
    success: (String) -> Unit,
    failure: (String) -> Unit
) {
    this.subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe({
            it.processBaseResponse({
                success.invoke(it)
            }, {
                failure.invoke(it)
            })
        }, {
            failure("No internet connection")
        })
}
private fun <T> MoreDataResponse<T>?.processResponse(
    success: (T, MetaVO?) -> Unit,
    failure: (String) -> Unit
) {
    if (this != null) {
        if (this.isResponseOk()) {
            success.invoke(this.data!!, this.meta)
        } else {
            failure(this.message)
        }
    } else {
        failure.invoke("Response Was Null")
    }
}
private fun <T> DataResponse<T>?.processDataResponse(
    success: (T) -> Unit,
    failure: (String) -> Unit
) {
    if (this != null) {
        if (this.isResponseOk()) {
            success.invoke(this.data!!)
        } else {
            failure(this.message)
        }
    } else {
        failure.invoke("Response Was Null")
    }
}
private fun BaseResponse.processBaseResponse(success: (String) -> Unit, failure: (String) -> Unit) {
    if (this.isResponseOk()) {
        success.invoke(this.message)
    } else {
        failure(this.message)
    }
}
