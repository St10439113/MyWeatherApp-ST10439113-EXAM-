package za.ac.iie.st10439113.myweatherman

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private val screenTimeDataList = mutableListOf<WeatherTemp>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dayEditText = findViewById<EditText>(R.id.dayEditText)
        val yesterdayTempEditText = findViewById<EditText>(R.id.yesterdayTempEditText)
        val todayTempEditText = findViewById<EditText>(R.id.todayTempEditText)
        val activityNotesEditText = findViewById<EditText>(R.id.activityNotesEditText)
        val submitButton = findViewById<Button>(R.id.submitButton)
        val clearButton = findViewById<Button>(R.id.clearButton)
        val detailedViewButton = findViewById<Button>(R.id.detailedViewButton)

        submitButton.setOnClickListener {
            val day = dayEditText.text.toString()
            val yesterdayTemp = yesterdayTempEditText.text.toString().toIntOrNull()
            val todayTemp = todayTempEditText.text.toString().toIntOrNull()
            val activityNotes = activityNotesEditText.text.toString()

            if (day.isNotEmpty() && yesterdayTemp != null && todayTemp != null && activityNotes.isNotEmpty()) {
                val screenTimeData = WeatherTemp(day, yesterdayTemp, todayTemp, activityNotes)
                screenTimeDataList.add(screenTimeData)
                Toast.makeText(this, "Data added successfully", Toast.LENGTH_SHORT).show()
                clearInputs()
            } else {
                Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show()
            }
        }
// This code will clear all data
        clearButton.setOnClickListener {
            //weatherDataList.clear()
            clearInputs()
            //Toast.makeText(this, "Data cleared", Toast.LENGTH_SHORT).show()
        }

        detailedViewButton.setOnClickListener {
            val intent = Intent(this, Detailed::class.java).apply {
            }
            startActivity(intent)
        }
    }

    private fun clearInputs() {
        findViewById<EditText>(R.id.dayEditText).text.clear()
        findViewById<EditText>(R.id.yesterdayTempEditText).text.clear()
        findViewById<EditText>(R.id.todayTempEditText).text.clear()
        findViewById<EditText>(R.id.activityNotesEditText).text.clear()
    }
}
