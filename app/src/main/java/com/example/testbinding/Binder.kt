package com.example.testbinding

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer


class Binder(owner: LifecycleOwner, private  val liveData: MutableLiveData<String>,
                 private val setter:(String)->Unit){
        private var settingValue = false
    init{
            liveData.observe(owner, Observer { value ->
                if (!settingValue){
                    settingValue = true
                    setter(value)
                    settingValue = false
                }
            })
        }
    fun setValue(value: String){
            if (!settingValue) {
                settingValue = true
                liveData.value = value
                settingValue = false
            }
        }
    }
