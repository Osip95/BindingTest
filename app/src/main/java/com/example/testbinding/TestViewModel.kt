package com.example.testbinding


import android.widget.EditText
import androidx.core.widget.doAfterTextChanged
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel

class TestViewModel : ViewModel(){
var liveData = MutableLiveData<String>()


    fun bind(owner: LifecycleOwner, editText: EditText){
        val binder = Binder(owner,liveData){text->
            editText.setText(text)
        }
        editText.doAfterTextChanged { text ->
            binder.setValue(text.toString().uppercase())
        }
    }

}


