package com.diplom.rande_vuz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val registration = findViewById<Button>(R.id.go_to_register_activity_tv)

        registration.setOnClickListener {
            startActivity(Intent(this, NameRegisterActivity::class.java))
        }

        val regbutton = findViewById<Button>(R.id.regbutton)
        val email_login = findViewById<EditText>(R.id.email)
        val password_login = findViewById<EditText>(R.id.password)

        regbutton.setOnClickListener {
            val email_et = email_login.text.toString()
            val password_et = password_login.text.toString()

            // Проверка на пустые поля
            if (email_et.isBlank() || password_et.isBlank()) {
                Toast.makeText(this@LoginActivity, "Заполните все необходимые поля", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (!email_et.contains("@")) {
                Toast.makeText(this@LoginActivity, "Некорректный почтовый адрес", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            else {
                startActivity(Intent(this, AfterRegistrationActivity::class.java)) }


            //добавить проверку пароля из базы данных

        }


    }


}