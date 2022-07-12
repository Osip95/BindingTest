package com.example.testbinding


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class TestViewModel : ViewModel(){
    var liveData = MutableLiveData<String>()
    var liveData2 = MutableLiveData<String>()

 init {
    liveData.observeForever{
        liveData2.value = it.uppercase()
    }
 }

}


