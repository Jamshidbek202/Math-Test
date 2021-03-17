package com.jamshidbek.math_test

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_next.setOnClickListener{
            val name = edt_name.text.toString().trim()
            val quizNumber = edt_quiz_number.text.toString()

            if(name.isNotEmpty() && quizNumber.isNotEmpty()){
                val intent = Intent(this, SolveQuiz::class.java)
                intent.putExtra("quizNumber", quizNumber)
                intent.putExtra("name", name)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Input the data", Toast.LENGTH_SHORT).show()
            }
        }
    }
}