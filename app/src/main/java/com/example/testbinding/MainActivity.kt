package com.example.testbinding

import android.os.Binder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import androidx.core.widget.doAfterTextChanged
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.example.testbinding.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    var viewModel = TestViewModel()
   lateinit var editText: EditText
   lateinit var textView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        editText = binding.editTextTextPersonName
        textView = binding.textView
        setContentView(binding.root)
        viewModel.bind(owner = this, editText)
        viewModel.liveData.observe(this,{
            textView.setText(it)
        })

    }
}