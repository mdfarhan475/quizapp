package com.example.quizapp

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.widget.RadioButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.quizapp.databinding.ActivityPlay2Binding

class play2 : AppCompatActivity() {
    lateinit var binding: ActivityPlay2Binding

    var updateQuestion = 1

    val quizList = listOf<QU>(

        QU(
            "How many elements are in the periodic table? ",
            "118",
            "112",
            "114",
            "108",
            "118"
        ),
        QU(
            "Which planet in the Milky Way is the hottest?",
            "Mercury",
            "Mars",
            "Venus",
            "Earth",
            "Venus"
        ),

        QU(
            "Which planet has the most moons",
            "Jupiter",
            "Saturn",
            "Uranus",
            "Neptune",
            "Saturn"
        ),
        QU(
            "How many bones do we have in an ear?",
            "3",
            "1",
            "14",
            "6",
            "3"
        ),

        QU(
            "Which country has the highest life expectancy? ",
            "Hong Kong",
            "singapore ",
            "China",
            "Japan",
            "Hong Kong"
        ),
        QU(
            "Which planet is closest to the sun? ",
            "Jupiter",
            "Saturn",
            "Neptune",
            "Mercury",
            "Mercury"
        ),


    )

    var index = 0
    var hasFinished = false
    var skip = -1
    var correct = 0
    var wrong = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPlay2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        initQuestion()

        binding.nextBtn.setOnClickListener {

            showNextQuestion()

        }


    }

    private fun initQuestion() {
        val quizQuestion = quizList[index]

        binding.apply {

            questionTv.text = quizQuestion.question
            option1Btn.text = quizQuestion.option1
            option2Btn.text = quizQuestion.option2
            option3Btn.text = quizQuestion.option3
            option4Btn.text = quizQuestion.option4

        }


    }

    private fun showNextQuestion() {
        checkAnswer()
        binding.apply {

            if (updateQuestion < quizList.size) {
                updateQuestion++
                initQuestion()
            } else if (index <= quizList.size - 1) {
                index++
            } else {
                hasFinished = true
            }

            radioGroup.clearCheck()

        }


    }

    private fun checkAnswer() {

        binding.apply {

            if (radioGroup.checkedRadioButtonId == -1) {

                skip++
            } else {
                val checkButton = findViewById<RadioButton>(radioGroup.checkedRadioButtonId)
                val checkAnswer = checkButton.text.toString()

                if (checkAnswer == quizList[index].answer) {

                    correct++
                    showAlertDialouge("Correct Answer")

                } else {
                    wrong++
                    showAlertDialouge("Wrong Answer")
                }


            }

            if (index <= quizList.size - 1) {
                index++
            } else {
                showAlertDialouge("Finished")
            }


        }

    }


    fun showAlertDialouge(message: String) {

        val builder = AlertDialog.Builder(this)
        builder.setTitle(message)

        builder.setPositiveButton("ok",object : DialogInterface.OnClickListener{
            override fun onClick(p0: DialogInterface?, p1: Int) {

                if (message == "Finished") {
                    val intent = Intent(this@play2,MainActivity2::class.java)
                    intent.putExtra("skip", skip)
                    intent.putExtra("correct", correct)
                    intent.putExtra("wrong", wrong)



                    startActivity(intent)

                }



            }
        })
        var alertDialog = builder.create()
        alertDialog.show()



    }    }

