package com.example.testbinding
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.testbinding.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    var viewModel = TestViewModel()
    lateinit var editText: EditText
    lateinit var textView: TextView
    lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        editText = binding.editText
        textView = binding.textView
        button =   binding.button
        setContentView(binding.root)
        viewModel.liveData.bind(this,editText)
        viewModel.liveData2.observe(this,{
            textView.setText(it)
        })
        button.setOnClickListener {
            viewModel.clearText()
        }
    }
}