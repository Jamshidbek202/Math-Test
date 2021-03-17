package com.jamshidbek.math_test

import android.os.Bundle
import android.widget.RadioButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_solve_quiz.*
import java.lang.Exception
import kotlin.random.Random

class SolveQuiz : AppCompatActivity() {

    var number1 = 0
    var number2 = 0
    var amal = 0
    var javob = 0
    var name: String? = null
    var rightVariant = 0
    var firstVariant = 0
    var secondVariant = 0
    var thirdVariant = 0
    var fourthVariant = 0
    var userAnswer = 0
    var rightAnswer = 0
    var quizNumber = 0
    var quizLiveNumber = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_solve_quiz)

        quizNumber = intent.getStringExtra("quizNumber")!!.toInt()
        name = intent.getStringExtra("name")
        random()
        random2()

        next2.setOnClickListener {

            when {
                first.isChecked -> userAnswer = first.text.toString().toInt()
                second.isChecked -> userAnswer = second.text.toString().toInt()
                third.isChecked -> userAnswer = third.text.toString().toInt()
                fourth.isChecked -> userAnswer = fourth.text.toString().toInt()
            }

            if (quizNumber > quizLiveNumber){
                quizLiveNumber++
                if (userAnswer == javob) {
                    Toast.makeText(this, "Correct!", Toast.LENGTH_SHORT).show()
                    rightAnswer++
                } else {
                    Toast.makeText(this, "Incorrect!", Toast.LENGTH_SHORT).show()
                }
                random()
                random2()
            }

            if(quizNumber == quizLiveNumber){
                next2.isEnabled = false
                Toast.makeText(this, "$name, you found $rightAnswer our of $quizNumber", Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun random() {
        number1 = Random.nextInt(10)
        number2 = Random.nextInt(10)
        amal = Random.nextInt(4)
        var misol = ""

        when (amal) {
            0 -> {
                misol = "$number1 + $number2 = "
                txt_quiz.text = misol
                javob = number1 + number2
            }
            1 -> {
                misol = "$number1 - $number2 = "
                txt_quiz.text = misol
                javob = number1 - number2
            }
            2 -> {
                misol = "$number1 * $number2 = "
                txt_quiz.text = misol
                javob = number1 * number2
            }
            3 -> {
                try {

                    misol = "$number1 / $number2 = "
                    txt_quiz.text = misol
                    javob = number1 / number2
                } catch (e: Exception) {
                    random()
                }
            }
        }
    }

    fun random2() {
        rightVariant = Random.nextInt(4)
        firstVariant = Random.nextInt(100)
        secondVariant = Random.nextInt(100)
        thirdVariant = Random.nextInt(100)
        fourthVariant = Random.nextInt(100)

        first.text = firstVariant.toString()
        second.text = secondVariant.toString()
        third.text = thirdVariant.toString()
        fourth.text = fourthVariant.toString()

        when (rightVariant) {
            0 -> {
                first.text = javob.toString()
                second.text = secondVariant.toString()
                third.text = thirdVariant.toString()
                fourth.text = fourthVariant.toString()
            }
            1 -> {
                second.text = javob.toString()
                third.text = thirdVariant.toString()
                first.text = firstVariant.toString()
                fourth.text = fourthVariant.toString()
            }
            2 -> {
                third.text = javob.toString()
                first.text = firstVariant.toString()
                second.text = secondVariant.toString()
                fourth.text = fourthVariant.toString()
            }
            3 -> {
                fourth.text = javob.toString()
                first.text = firstVariant.toString()
                second.text = secondVariant.toString()
                third.text = thirdVariant.toString()
            }
        }
    }
}