package com.diplom.rande_vuz.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.view.View
import android.widget.Button
import android.widget.Toast
import android.content.Intent
import com.diplom.rande_vuz.R
import com.diplom.rande_vuz.models.Month
import com.diplom.rande_vuz.models.UserData
import java.util.Calendar

class BirthDateActivity : AppCompatActivity() {

    private lateinit var userData: UserData
    private lateinit var datePickerDialog: DatePickerDialog
    private lateinit var dateButton: Button
    private var selectedDate: String? = null

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_birth_date)

        userData = intent.getSerializableExtra("userData") as? UserData ?: UserData()

        dateButton = findViewById(R.id.datePickerButton)
        val nextButton = findViewById<Button>(R.id.next_btn)
        initDatePicker()
//TODO добавить проверку возраста
        nextButton.setOnClickListener {
            userData.birthDate = dateButton.text.toString()

            if (dateButton.text.toString() == getString(R.string.select_date)) {
                Toast.makeText(this, "Дата не выбрана", Toast.LENGTH_SHORT).show()
            } else {
                Intent(this, WhereStudyActivity::class.java).apply {
                    putExtra("userData", userData)
                    startActivity(this)
                }
            }
        }
    }

    private fun initDatePicker() {
        val cal = Calendar.getInstance()
        val day = cal.get(Calendar.DAY_OF_MONTH)
        val month = cal.get(Calendar.MONTH)
        val year = cal.get(Calendar.YEAR)

        datePickerDialog = DatePickerDialog(this, { _, selectedYear, selectedMonth, selectedDay ->
            val adjustedMonth = selectedMonth + 1
            selectedDate = makeDateString(selectedDay, adjustedMonth, selectedYear)
            dateButton.text = selectedDate
        }, year, month, day)
    }
// TODO наверное стоит вынести отсюда всю лишнюю логику обработки дат
    private fun makeDateString(day: Int, month: Int, year: Int): String {
        return "$day/${getMonthFormat(month)}/$year"
    }

    private fun getMonthFormat(month: Int): String {
        return Month.fromInt(month).displayName
    }

    fun openDatePicker(view: View) {
        datePickerDialog.show()
    }
}
