package mx.tec.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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

        val btnCero = findViewById<Button>(R.id.btnCero)
        val btnOne = findViewById<Button>(R.id.btnOne)
        val btnTwo = findViewById<Button>(R.id.btnTwo)
        val btnThree = findViewById<Button>(R.id.btnThree)
        val btnFour = findViewById<Button>(R.id.btnFour)
        val btnFive = findViewById<Button>(R.id.btnFive)
        val btnSix = findViewById<Button>(R.id.btnSix)
        val btnSeven = findViewById<Button>(R.id.btnSeven)
        val btnEight = findViewById<Button>(R.id.btnEight)
        val btnNine = findViewById<Button>(R.id.btnNine)
        val btnPlus = findViewById<Button>(R.id.btnPlus)
        val btnMinus = findViewById<Button>(R.id.btnMinus)
        val btnBy = findViewById<Button>(R.id.btnBy)
        val btnEqual = findViewById<Button>(R.id.btnEqual)
        val btnDivide = findViewById<Button>(R.id.btnDivide)

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
    }

    override fun onClick(v: View?) {
        // Like a switch
        when(v?.id){
            //Case
            R.id.btnCero -> {tvDisplayAnswer.text = "${tvDisplayAnswer.text}0"}
            R.id.btnOne -> {tvDisplayAnswer.text = "${tvDisplayAnswer.text}1"}
            R.id.btnTwo -> {tvDisplayAnswer.text = "${tvDisplayAnswer.text}2"}
            R.id.btnThree -> {tvDisplayAnswer.text = "${tvDisplayAnswer.text}3"}
            R.id.btnFour -> {tvDisplayAnswer.text = "${tvDisplayAnswer.text}4"}
            R.id.btnFive -> {tvDisplayAnswer.text = "${tvDisplayAnswer.text}5"}
            R.id.btnSix -> {tvDisplayAnswer.text = "${tvDisplayAnswer.text}6"}
            R.id.btnSeven -> {tvDisplayAnswer.text = "${tvDisplayAnswer.text}7"}
            R.id.btnEight -> {tvDisplayAnswer.text = "${tvDisplayAnswer.text}8"}
            R.id.btnNine -> {tvDisplayAnswer.text = "${tvDisplayAnswer.text}9"}
            R.id.btnPlus -> {
                operation = "+"
                temporal = tvDisplayAnswer.text.toString().toDouble()
                tvDisplayAnswer.text = ""
            }

            R.id.btnMinus -> {
                operation = "-"
                temporal = tvDisplayAnswer.text.toString().toDouble()
                tvDisplayAnswer.text = ""
            }

            R.id.btnBy -> {
                operation = "*"
                temporal = tvDisplayAnswer.text.toString().toDouble()
                tvDisplayAnswer.text = ""
            }

            R.id.btnDivide -> {
                operation = "/"
                temporal = tvDisplayAnswer.text.toString().toDouble()
                tvDisplayAnswer.text = ""
            }

            R.id.btnEqual -> {
                if (operation == "+") {
                    tvDisplayAnswer.text = (temporal + tvDisplayAnswer.text.toString().toDouble()).toString()
                } else if (operation == "-") {
                    tvDisplayAnswer.text = (temporal - tvDisplayAnswer.text.toString().toDouble()).toString()
                } else if (operation == "*") {
                    tvDisplayAnswer.text = (temporal * tvDisplayAnswer.text.toString().toDouble()).toString()
                } else if (operation == "/") {
                    tvDisplayAnswer.text = (temporal / tvDisplayAnswer.text.toString().toDouble()).toString()
                } else {
                    tvDisplayAnswer.text = "Syntax Error"
                }
            }
            else -> {}
        }
    }

    /*fun myFunc(v: View){

    }*/
}