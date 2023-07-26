package com.geeks.counter_mvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CounterViewModel : ViewModel() {

    var themeIsDark = MutableLiveData<Boolean>(false)
    val counter = MutableLiveData<Int>(0)

    fun increment() {
        counter.postValue(counter.value!! + 1)
    }

    fun decrement() {
        counter.postValue(counter.value!! - 1)
    }

    fun onThemeClick(){
        if (themeIsDark.value!!){
            themeIsDark.postValue(false)
        } else{
            themeIsDark.postValue(true)
        }
    }
}