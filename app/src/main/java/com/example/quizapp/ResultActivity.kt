package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val username: TextView = findViewById(R.id.username)
        val score: TextView = findViewById(R.id.score)
        val finishbrtn: Button = findViewById(R.id.finishbtn)

        username.text = intent.getStringExtra(Constants.USER_NAME)
        val question = intent.getIntExtra(Constants.TOTAL_QUESTIONS,0)
        val correctionanswers  = intent.getIntExtra(Constants.CORRECT_ANSWERS,0)
        score.text = "Your Score is $correctionanswers out of $question"

        finishbrtn.setOnClickListener {
            startActivity(Intent(this,MainActivity::class.java))
        }

    }
}