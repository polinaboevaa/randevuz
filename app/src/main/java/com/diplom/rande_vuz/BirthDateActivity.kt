package com.diplom.rande_vuz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.view.View
import android.widget.Button
import java.util.Calendar

class BirthDateActivity : AppCompatActivity() {

    private lateinit var datePickerDialog: DatePickerDialog
    private lateinit var dateButton: Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_birth_date)

        dateButton = findViewById(R.id.datePickerButton)
        dateButton.text = getTodaysDate()
        initDatePicker()
    }

    private fun getTodaysDate(): String {
        val cal = Calendar.getInstance()
        val year = cal.get(Calendar.YEAR)
        val month = cal.get(Calendar.MONTH) + 1 // Месяцы начинаются с 0
        val day = cal.get(Calendar.DAY_OF_MONTH)
        return makeDateString(day, month, year)
    }

    private fun initDatePicker() {
        val cal = Calendar.getInstance()
        val day = cal.get(Calendar.DAY_OF_MONTH)
        val month = cal.get(Calendar.MONTH)
        val year = cal.get(Calendar.YEAR)

        datePickerDialog = DatePickerDialog(this, { _, selectedYear, selectedMonth, selectedDay ->
            val adjustedMonth = selectedMonth + 1 // Месяцы начинаются с 0
            val date = makeDateString(selectedDay, adjustedMonth, selectedYear)
            dateButton.text = date
        }, year, month, day)
    }

    private fun makeDateString(day: Int, month: Int, year: Int): String {
        return "$day/${getMonthFormat(month)}/$year"
    }

    private fun getMonthFormat(month: Int): String {
        return when (month) {
            1 -> "январь"
            2 -> "февраль"
            3 -> "март"
            4 -> "апрель"
            5 -> "май"
            6 -> "июнь"
            7 -> "июль"
            8 -> "август"
            9 -> "сентябрь"
            10 -> "октябрь"
            11 -> "ноябрь"
            12 -> "декабрь"
            else -> "январь"
        }
    }

    fun openDatePicker(view: View) {
        datePickerDialog.show()
    }


}
