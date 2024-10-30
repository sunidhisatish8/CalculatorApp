package com.example.calculatorapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.calculatorapp.databinding.ActivityMainBinding
import com.microsoft.appcenter.AppCenter
import com.microsoft.appcenter.analytics.Analytics
import com.microsoft.appcenter.crashes.Crashes

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        AppCenter.start(application, "3b484339-1589-48e6-a4e2-6da9fceeeed8",
            Analytics::class.java, Crashes::class.java)

        binding.btnAdd.setOnClickListener {
            Crashes.generateTestCrash()
            val num1 = binding.number1.text.toString()
            val num2 = binding.number2.text.toString()

            if (num1.isNotEmpty() && num2.isNotEmpty()) {
                val sum = num1.toDouble() + num2.toDouble()
                binding.resultText.text = "Result: $sum"
            } else {
                binding.resultText.text = "Please enter both numbers"
            }
        }
    }
}