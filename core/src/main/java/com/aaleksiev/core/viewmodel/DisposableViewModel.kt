package com.aaleksiev.core.viewmodel

import androidx.lifecycle.ViewModel
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.disposables.Disposable

abstract class DisposableViewModel : ViewModel() {
    private val disposables = CompositeDisposable()

    protected fun Disposable.addToDisposables() = disposables.add(this)

    override fun onCleared() {
        super.onCleared()
        disposables.clear()
    }
}