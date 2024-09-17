package com.example.quizapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.quizapp.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {

    lateinit var binding: ActivityMain2Binding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding= ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val skip = intent.getIntExtra("skip", 0)
        val correct = intent.getIntExtra("correct", 0)
        val wrong = intent.getIntExtra("wrong", 0)

        binding.resultTv.text =
            "Skip : $skip\n" + "Correct Answer : $correct\n" + "Wrong Anser : $wrong"




    }
}