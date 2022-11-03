package mx.tec.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity(), View.OnClickListener {
    // scope global
    lateinit var tvDisplayAnswer:TextView
    var temporal = 0.0
    var operation = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnCero = findViewById<Button>(R.id.btnZero)
        val btnOne = findViewById<Button>(R.id.btnOne)
        val btnTwo = findViewById<Button>(R.id.btnTwo)
        val btnThree = findViewById<Button>(R.id.btnThree)
        val btnFour = findViewById<Button>(R.id.btnFour)
        val btnFive = findViewById<Button>(R.id.btnFive)
        val btnSix = findViewById<Button>(R.id.btnSix)
        val btnSeven = findViewById<Button>(R.id.btnSeven)
        val btnEight = findViewById<Button>(R.id.btnEight)
        val btnNine = findViewById<Button>(R.id.btnNine)
        val btnPlus = findViewById<Button>(R.id.btnAdd)
        val btnMinus = findViewById<Button>(R.id.btnSubtract)
        val btnBy = findViewById<Button>(R.id.btnMultiply)
        val btnEqual = findViewById<Button>(R.id.btnEqual)
        val btnDivide = findViewById<Button>(R.id.btnDivide)
        val btnAC = findViewById<Button>(R.id.btnAC)
        val btnSign = findViewById<Button>(R.id.btnSign)
        val btnPercent = findViewById<Button>(R.id.btnPercent)
        val btnDot = findViewById<Button>(R.id.btnDot)

        tvDisplayAnswer = findViewById(R.id.tvDisplayAnswer)

        btnCero.setOnClickListener(this)
        btnOne.setOnClickListener(this)
        btnTwo.setOnClickListener(this)
        btnThree.setOnClickListener(this)
        btnFour.setOnClickListener(this)
        btnFive.setOnClickListener(this)
        btnSix.setOnClickListener(this)
        btnSeven.setOnClickListener(this)
        btnEight.setOnClickListener(this)
        btnNine.setOnClickListener(this)
        btnPlus.setOnClickListener(this)
        btnMinus.setOnClickListener(this)
        btnBy.setOnClickListener(this)
        btnEqual.setOnClickListener(this)
        btnDivide.setOnClickListener(this)
        btnAC.setOnClickListener(this)
        btnSign.setOnClickListener(this)
        btnPercent.setOnClickListener(this)
        btnDot.setOnClickListener(this)
    }

    fun myFunction(number: String) {
        if (tvDisplayAnswer.text.toString() == "0") {
            tvDisplayAnswer.text = ""
        }
        tvDisplayAnswer.text = "${tvDisplayAnswer.text}$number"
    }

    override fun onClick(v: View?) {
        // Like a switch
        when(v?.id){
            //Case
            R.id.btnZero -> { myFunction("0") }
            R.id.btnOne -> {myFunction("1")}
            R.id.btnTwo -> {myFunction("2")}
            R.id.btnThree -> {myFunction("3")}
            R.id.btnFour -> {myFunction("4")}
            R.id.btnFive -> {myFunction("5")}
            R.id.btnSix -> {myFunction("6")}
            R.id.btnSeven -> {myFunction("7")}
            R.id.btnEight -> {myFunction("8")}
            R.id.btnNine -> {myFunction("9")}
            R.id.btnAdd -> {
                if (operation == "") {
                    Log.w("value", operation)
                    operation = "+"
                    temporal = tvDisplayAnswer.text.toString().toDouble()
                }
                tvDisplayAnswer.text = ""
            }

            R.id.btnSubtract -> {
                if (operation == "") {
                    operation = "-"
                    temporal = tvDisplayAnswer.text.toString().toDouble()
                }
                tvDisplayAnswer.text = ""
            }

            R.id.btnMultiply -> {
                if (operation == "") {
                    operation = "*"
                    temporal = tvDisplayAnswer.text.toString().toDouble()
                }
                tvDisplayAnswer.text = ""
            }

            R.id.btnDivide -> {
                if (operation == "") {
                    operation = "/"
                    temporal = tvDisplayAnswer.text.toString().toDouble()
                }
                tvDisplayAnswer.text = ""
            }

            R.id.btnPercent -> {
                val number = tvDisplayAnswer.text.toString().toDouble()
                tvDisplayAnswer.text = (number / 100).toString()
            }

            R.id.btnDot -> {
                if (tvDisplayAnswer.text.toString().contains(".")) {
                    // Do nothing
                } else {
                    myFunction(".")
                }
            }

            R.id.btnEqual -> {
                when(operation){
                    "+" -> {
                            tvDisplayAnswer.text = (temporal + tvDisplayAnswer.text.toString().toDouble()).toString()
                            operation = ""
                    }
                    "-" -> {
                        tvDisplayAnswer.text = (temporal - tvDisplayAnswer.text.toString().toDouble()).toString()
                    }
                    "*" -> {
                        tvDisplayAnswer.text = (temporal * tvDisplayAnswer.text.toString().toDouble()).toString()
                    }
                    "/" -> {
                        var answer = (temporal / tvDisplayAnswer.text.toString().toDouble()).toString()

                        // Divide by zero
                        if (answer.toString() == Double.POSITIVE_INFINITY.toString()) {
                            tvDisplayAnswer.text = "Cannot divide by zero"
                        } else {
                            tvDisplayAnswer.text = answer
                        }
                    }
                }
                operation = ""
            }

            R.id.btnAC -> {
                tvDisplayAnswer.text = "0"
            }

            else -> {}
        }
    }

    /*fun myFunc(v: View){

    }*/
}