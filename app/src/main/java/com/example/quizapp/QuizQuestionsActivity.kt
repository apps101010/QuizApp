package com.example.quizapp

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat

class QuizQuestionsActivity : AppCompatActivity(), View.OnClickListener {

    private var progressBar: ProgressBar? = null
    private var progressTextView: TextView? = null
    private var questiontext: TextView? = null
    private var image: ImageView? = null
    private var option1: TextView? = null
    private var option2: TextView? = null
    private var option3: TextView? = null
    private var option4: TextView? = null
    private var submitBtn: Button? = null
    private var userNmae: String? = null
    private var correctAnsers: Int = 0

    private var mCurrentPostions: Int = 1
    private var mQuestionList:ArrayList<Question>? = null
    private var mSelectedOptionPosition: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions)
        progressBar = findViewById(R.id.progressbar)
        progressTextView = findViewById(R.id.progresstextview)
        questiontext = findViewById(R.id.question)
        image = findViewById(R.id.imageflag)
        option1 = findViewById(R.id.option1)
        option2 = findViewById(R.id.option2)
        option3 = findViewById(R.id.option3)
        option4 = findViewById(R.id.option4)
        submitBtn = findViewById(R.id.submitbtn)
        mQuestionList = Constants.getQuestions()
        userNmae = intent.getStringExtra(Constants.USER_NAME)
        option1?.setOnClickListener(this)
        option2?.setOnClickListener(this)
        option3?.setOnClickListener(this)
        option4?.setOnClickListener(this)
        submitBtn?.setOnClickListener(this)
        setQuestion()

    }

    private fun setQuestion() {
        defaultOptionsView()
        val question: Question = mQuestionList!![mCurrentPostions - 1]
        image?.setImageResource(question.image)
        progressBar?.progress = mCurrentPostions
        progressTextView?.text = "$mCurrentPostions/${progressBar?.max}"
        questiontext?.text = question.questions
        option1?.text = question.optionOne
        option2?.text = question.optionTwo
        option3?.text = question.optionThree
        option4?.text = question.optionFour


        if (mCurrentPostions == mQuestionList!!.size){
            submitBtn?.text = "Finish"
        }else{
            submitBtn?.text = "Submit"
        }
    }

    private fun defaultOptionsView(){
        val options = ArrayList<TextView>()
        option1?.let {
            options.add(0,it)
        }
        option2?.let {
            options.add(1,it)
        }
        option3?.let {
            options.add(2,it)
        }
        option4?.let {
            options.add(3,it)
        }

        for (option in options){
            option.setTextColor((Color.parseColor("#7A8089")))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(this,R.drawable.default_option_border_bg)
        }
    }

    private fun selectedOptionView(tv:TextView, selectedOptionNum:Int){
        defaultOptionsView()
        mSelectedOptionPosition = selectedOptionNum
        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface,Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(this,R.drawable.selected_option_border_bg)
    }

    override fun onClick(view: View?) {
          when(view?.id){
              R.id.option1 -> {
                  option1?.let {
                      selectedOptionView(it,1)
                  }
              }

              R.id.option2 -> {
                  option2?.let {
                      selectedOptionView(it,2)
                  }
              }

              R.id.option3 -> {
                  option3?.let {
                      selectedOptionView(it,3)
                  }
              }

              R.id.option4 -> {
                  option4?.let {
                      selectedOptionView(it,1)
                  }
              }

              R.id.submitbtn -> {
                  if (mSelectedOptionPosition == 0){
                      mCurrentPostions++

                      when{
                          mCurrentPostions <= mQuestionList!!.size -> {
                              setQuestion()
                          }
                          else -> {
                              val intent = Intent(this,ResultActivity::class.java)
                              intent.putExtra(Constants.USER_NAME,userNmae)
                              intent.putExtra(Constants.CORRECT_ANSWERS,correctAnsers)
                              intent.putExtra(Constants.TOTAL_QUESTIONS,mQuestionList?.size)
                              startActivity(intent)
                              finish()
                          }
                      }
                  }else{
                      val question = mQuestionList?.get(mCurrentPostions-1)
                      if (question!!.correctAnswer != mSelectedOptionPosition){
                          answerView(mSelectedOptionPosition, R.drawable.wrong_option_border_bg)
                      }else{
                          correctAnsers++
                      }
                      answerView(question.correctAnswer,R.drawable.correct_option_border_bg)

                      if (mCurrentPostions == mQuestionList!!.size){
                          submitBtn?.text = "Finish"
                      }else{
                          submitBtn?.text = "Go to next question"
                      }

                      mSelectedOptionPosition = 0
                  }
              }
          }
    }

    private fun answerView(answer: Int, drawableView: Int){
        when(answer){
            1 -> {
                option1?.background = ContextCompat.getDrawable(this,drawableView)
            }

            2 -> {
                option2?.background = ContextCompat.getDrawable(this,drawableView)
            }

            3 -> {
                option3?.background = ContextCompat.getDrawable(this,drawableView)
            }

            4 -> {
                option4?.background = ContextCompat.getDrawable(this,drawableView)
            }
        }

    }
}