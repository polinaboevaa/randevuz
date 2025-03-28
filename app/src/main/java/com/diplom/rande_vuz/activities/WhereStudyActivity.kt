package com.diplom.rande_vuz.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.diplom.rande_vuz.R
import com.diplom.rande_vuz.models.UserData


class WhereStudyActivity : AppCompatActivity() {
    private lateinit var userData: UserData
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_where_study)

        userData = intent.getSerializableExtra("userData") as? UserData ?: UserData()

        val next_btn = findViewById<Button>(R.id.next_btn)
        val vuz_button = findViewById<EditText>(R.id.vuz_btn)

        next_btn.setOnClickListener {
            userData.vuzName = vuz_button.text.toString().trim()

            if (userData.vuzName.isEmpty()) {
                Toast.makeText(this, "Поле не должно быть пустым", Toast.LENGTH_SHORT).show()
            } else {
                Intent(this, SpecializationActivity::class.java).apply {
                    putExtra("userData", userData)
                    startActivity(this)
                }
            }
        }
    }
}
