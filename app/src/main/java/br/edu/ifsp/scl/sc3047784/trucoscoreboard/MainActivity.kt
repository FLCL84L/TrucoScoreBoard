package br.edu.ifsp.scl.sc3047784.trucoscoreboard

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private var team1Score = 0
    private var team2Score = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(
                WindowInsetsCompat.Type.systemBars()
            )

            v.setPadding(
                systemBars.left,
                systemBars.top,
                systemBars.right,
                systemBars.bottom
            )

            insets
        }

        val team1ScoreText = findViewById<TextView>(R.id.team1Score)
        val team2ScoreText = findViewById<TextView>(R.id.team2Score)

        val team1Button = findViewById<Button>(R.id.team1Button)
        val team2Button = findViewById<Button>(R.id.team2Button)

        val winnerMessage = findViewById<TextView>(R.id.winnerMessage)

        val resetButton = findViewById<Button>(R.id.resetButton)

        team1Button.setOnClickListener {

            if (team1Score < 12) {
                team1Score++

                team1ScoreText.text = team1Score.toString()

                if (team1Score == 12) {

                    winnerMessage.text = "Team 1 won!"
                    winnerMessage.visibility = TextView.VISIBLE

                    team1Button.isEnabled = false
                    team2Button.isEnabled = false
                }
            }
        }

        team2Button.setOnClickListener {

            if (team2Score < 12) {
                team2Score++

                team2ScoreText.text = team2Score.toString()

                if (team2Score == 12) {

                    winnerMessage.text = "Team 2 won!"
                    winnerMessage.visibility = TextView.VISIBLE

                    team1Button.isEnabled = false
                    team2Button.isEnabled = false
                }
            }
        }

        resetButton.setOnClickListener {

            team1Score = 0
            team2Score = 0

            team1ScoreText.text = team1Score.toString()
            team2ScoreText.text = team2Score.toString()

            winnerMessage.visibility = TextView.GONE

            team1Button.isEnabled = true
            team2Button.isEnabled = true
        }
    }
}
