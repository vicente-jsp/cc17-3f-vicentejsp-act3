package com.example.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener {
            rollDice()

            val toast = Toast.makeText(this, "Dice Rolled", Toast.LENGTH_LONG)
            toast.show()

        }
    }
        private fun rollDice() {
            val dice = Dice(6)
            val cubeRoll = dice.roll()
            val diceImage = findViewById<ImageView>(R.id.imageView)
            diceImage.setImageResource(R.drawable.one)

            when (cubeRoll){
                1 -> diceImage.setImageResource(R.drawable.one)
                2 -> diceImage.setImageResource(R.drawable.two)
                3 -> diceImage.setImageResource(R.drawable.three)
                4 -> diceImage.setImageResource(R.drawable.four)
                5 -> diceImage.setImageResource(R.drawable.five)
                6 -> diceImage.setImageResource(R.drawable.six)
            }
        }

        class Dice (val numSides: Int){
            fun roll(): Int{
                return (1..numSides).random()
            }
        }

    }
