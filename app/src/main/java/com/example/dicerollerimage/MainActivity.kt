package com.example.dicerollerimage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import java.lang.Integer.parseInt

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnRoll: Button = findViewById(R.id.roll_button)
        btnRoll.setOnClickListener { diceRoller() }
    }

    private fun diceRoller() {

        val number = (1..6).random()
        val diceImage: ImageView = findViewById(R.id.dice_image)
        val edit: EditText = findViewById(R.id.edtNumber)
        
        val drawableResource = when (number) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        diceImage.setImageResource(drawableResource)

        if (edit.length() != 0) {
            if (number == parseInt(edit.text.toString())) {
                Toast.makeText(this, "você venceu!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "você perdeu!", Toast.LENGTH_SHORT).show()
            }

        }
        else{
            Toast.makeText(this, "campo vazio", Toast.LENGTH_SHORT).show()
        }
    }
}


