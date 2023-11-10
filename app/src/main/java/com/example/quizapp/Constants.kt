package com.example.quizapp

object Constants {

    const val USER_NAME: String = "user_name"
    const val  TOTAL_QUESTIONS: String = "total_questions"
    const val CORRECT_ANSWERS: String = "correct_answers"


    fun getQuestions():ArrayList<Question>{
        val questionList = ArrayList<Question>()

        val que1 = Question(
            1,"What country this flag belong to?",
            R.drawable.ic_flag_of_australia,"Pakistan","India","Australia","Germany",3)
        questionList.add(que1)

        val que2 = Question(
            2,"What country this flag belong to?",
            R.drawable.ic_flag_of_argentina,"Argentina","India","Australia","Germany",1)
        questionList.add(que2)

        val que3 = Question(
            3,"What country this flag belong to?",
            R.drawable.ic_flag_of_belgium,"Argentina","Belgium","Australia","Germany",2)
        questionList.add(que3)


        val que4 = Question(
            4,"What country this flag belong to?",
            R.drawable.ic_flag_of_brazil,"Argentina","Belgium","Australia","Brazil",4)
        questionList.add(que4)

        val que5 = Question(
            5,"What country this flag belong to?",
            R.drawable.ic_flag_of_denmark,"Argentina","Denmark","Australia","Brazil",2)
        questionList.add(que5)

        val que6 = Question(
            6,"What country this flag belong to?",
            R.drawable.ic_flag_of_fiji,"Argentina","Denmark","Australia","Fiji",4)
        questionList.add(que6)

        val que7 = Question(
            7,"What country this flag belong to?",
            R.drawable.ic_flag_of_germany,"Germany","Denmark","Australia","Fiji",1)
        questionList.add(que7)

        val que8 = Question(
            8,"What country this flag belong to?",
            R.drawable.ic_flag_of_india,"Germany","Denmark","Australia","India",4)
        questionList.add(que8)

        val que9 = Question(
            9,"What country this flag belong to?",
            R.drawable.ic_flag_of_kuwait,"Germany","Denmark","Kuwait","India",3)
        questionList.add(que9)

        val que10 = Question(
            10,"What country this flag belong to?",
            R.drawable.ic_flag_of_new_zealand,"Germany","New Zealand","Kuwait","India",2)
        questionList.add(que10)
        return questionList
    }
}