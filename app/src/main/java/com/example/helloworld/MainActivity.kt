package com.example.helloworld

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var diceImage: ImageView
    lateinit var rollButton: Button
    lateinit var countUpButton: Button
    lateinit var reset: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        diceImage = findViewById(R.id.dice)
        diceImage.tag = R.drawable.empty_dice

        rollButton = findViewById(R.id.roll_button)
        rollButton.setOnClickListener() { roll()}

        countUpButton = findViewById(R.id.count_up)
        countUpButton.setOnClickListener() { countUp()}

        reset = findViewById(R.id.reset_button)
        reset.setOnClickListener() { resetButton()}
    }

    private fun resetButton() {
        diceImage.setImageResource(R.drawable.empty_dice)
        diceImage.tag = R.drawable.empty_dice
    }

    private fun countUp() {
        var diceImageId = when(diceImage.tag){
            R.drawable.dice_1 -> R.drawable.dice_2
            R.drawable.dice_2 -> R.drawable.dice_3
            R.drawable.dice_3 -> R.drawable.dice_4
            R.drawable.dice_4 -> R.drawable.dice_5
            R.drawable.empty_dice -> R.drawable.dice_1
            else -> R.drawable.dice_6
        }
        diceImage.setImageResource(diceImageId)
        diceImage.tag = diceImageId
    }

    private fun roll() {
//        Toast.makeText(this, "Dice is rolling", Toast.LENGTH_SHORT).show()
        var no = (1..6).random()
        val diceResource = when(no) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        diceImage.setImageResource(diceResource)
        diceImage.tag = diceResource
    }
}