package za.ac.iie.st10439113.myweatherman

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent

class DetailedViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detailed)

        val weatherDetailsTextView = findViewById<TextView>(R.id.weatherDetailsTextView)
        val backButton = findViewById<Button>(R.id.backButton)

        val weatherDataList = intent.getSerializableExtra("weatherDataList") as ArrayList<WeatherTemp>

        val details = StringBuilder()
        var totalWeatherTemp = 0
        for (data in weatherDataList) {
            details.append("${data.day}: Morning - ${data.morningScreenTime} degree celsius, Afternoon - ${data.afternoonScreenTime} degree celsius \nActivity Notes: ${data.activityNotes}\n\n")
            totalWeatherTemp += data.morningScreenTime + data.afternoonScreenTime
        }
        val averageScreenTime = if (weatherDataList.isNotEmpty()) totalWeatherTemp / weatherDataList.size else 0
        details.append("Average Weather Temp: $averageScreenTime *C")

        weatherDetailsTextView.text = details.toString()

        backButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)

        }
    }
}
