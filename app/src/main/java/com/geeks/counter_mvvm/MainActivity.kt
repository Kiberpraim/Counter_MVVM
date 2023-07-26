package com.geeks.counter_mvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.core.content.ContextCompat
import androidx.fragment.app.viewModels
import com.geeks.counter_mvvm.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val counterViewModel: CounterViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initClickers()
        initTextView()
        initTheme()
    }

    private fun initClickers() {
        with(binding) {
            btnIncrement.setOnClickListener {
                counterViewModel.increment()
            }
            btnDecrement.setOnClickListener {
                counterViewModel.decrement()
            }
            btnTheme.setOnClickListener {
                counterViewModel.onThemeClick()
            }
        }
    }

    private fun initTextView() {
        counterViewModel.counter.observe(this) {
            binding.tvCounter.text = it.toString()
            if (it == 10){
                Toast.makeText(this, "Поздравляем", Toast.LENGTH_SHORT).show()
            }
            if (it == 15){
                binding.tvCounter.setTextColor(ContextCompat.getColor(this, R.color.green))
            }
        }
    }

    private fun initTheme() {
        counterViewModel.themeIsDark.observe(this){
            if (it){
                binding.root.setBackgroundColor(ContextCompat.getColor(this@MainActivity, R.color.black))
                binding.tvCounter.setTextColor(ContextCompat.getColor(this@MainActivity, R.color.white))
            }else{
                binding.root.setBackgroundColor(ContextCompat.getColor(this@MainActivity, R.color.white))
                binding.tvCounter.setTextColor(ContextCompat.getColor(this@MainActivity, R.color.black))
            }
        }
    }
}