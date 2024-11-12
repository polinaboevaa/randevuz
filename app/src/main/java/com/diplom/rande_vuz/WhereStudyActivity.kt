package com.diplom.rande_vuz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class WhereStudyActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_where_study)

        val next_btn = findViewById<Button>(R.id.next_btn)
        val vuz_button = findViewById<EditText>(R.id.vuz_btn)

        next_btn.setOnClickListener {
            val name = vuz_button.text.toString().trim()

            if (name.isEmpty()) {
                Toast.makeText(this, "Поле не должно быть пустым", Toast.LENGTH_SHORT).show()
            } else {
                startActivity(Intent(this, BirthDateActivity::class.java))
            }
        }
    }
}