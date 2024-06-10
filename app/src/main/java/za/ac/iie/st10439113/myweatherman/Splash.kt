package za.ac.iie.st10439113.myweatherman

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class Splash : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val startButton = findViewById<Button>(R.id.startButton)
        val exitButton = findViewById<Button>(R.id.exitButton)
//Code for start button to work
        startButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
//code for exit button to work
        exitButton.setOnClickListener {
            finish()
        }
    }
}
