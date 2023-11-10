package com.example.quizapp

import android.app.AlertDialog
import android.content.Intent
import android.icu.text.CaseMap.Title
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val startBtn: Button = findViewById(R.id.startBtn)
        val nameText: TextView = findViewById(R.id.edtName)

        startBtn.setOnClickListener(View.OnClickListener {
            if (nameText.text.isEmpty()){
                Toast.makeText(this,"Please enter your name",Toast.LENGTH_SHORT).show()
            }else{
                val intent = Intent(this,QuizQuestionsActivity::class.java)
                intent.putExtra(Constants.USER_NAME ,nameText.text.toString())
                startActivity(intent)
                finish()
            }
        })
    }


}