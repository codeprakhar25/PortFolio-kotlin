package com.example.portfolio

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.DatePicker
import android.widget.TextView
import android.app.DatePickerDialog
import java.util.Calendar

class SkillsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_skills)
        val datePickerButton: Button = findViewById(R.id.datePickerButton)
        val dateTextView: TextView = findViewById(R.id.dateTextView)

        datePickerButton.setOnClickListener {
            showDatePickerDialog { day, month, year ->
                val selectedDate = "$day/${month + 1}/$year"
                dateTextView.text = selectedDate
            }

        val datePicker: DatePicker = findViewById(R.id.datePicker)
        val dateTextViewLayout: TextView = findViewById(R.id.dateTextViewLayout)

        datePicker.init(
            datePicker.year,
            datePicker.month,
            datePicker.dayOfMonth
        ) { _, year, monthOfYear, dayOfMonth ->
            val selectedDate = "$dayOfMonth/${monthOfYear + 1}/$year"
            dateTextViewLayout.text = selectedDate
        }
    }
}

    private fun showDatePickerDialog(onDateSet: (day: Int, month: Int, year: Int) -> Unit) {
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        val datePickerDialog = DatePickerDialog(this, { _, selectedYear, selectedMonth, selectedDay ->
            onDateSet(selectedDay, selectedMonth, selectedYear)
        }, year, month, day)

        datePickerDialog.show()
    }
}