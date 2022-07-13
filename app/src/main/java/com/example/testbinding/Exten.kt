package com.example.testbinding

import android.widget.EditText
import androidx.core.widget.doAfterTextChanged
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData

fun MutableLiveData<String>.bind(owner: LifecycleOwner, editText: EditText) {
    val binder = Binder(owner, this) { text -> editText.setText(text) }
    editText.doAfterTextChanged { text -> binder.setValue(text.toString()) }
}