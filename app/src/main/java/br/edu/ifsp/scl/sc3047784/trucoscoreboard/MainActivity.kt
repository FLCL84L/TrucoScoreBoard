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

    private var pointsToAdd = 1

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

        val trucoButton = findViewById<Button>(R.id.trucoButton)

        val hand11Message = findViewById<TextView>(R.id.hand11Message)
        val winnerMessage = findViewById<TextView>(R.id.winnerMessage)

        val resetButton = findViewById<Button>(R.id.resetButton)

        team1Button.setOnClickListener {

            if (team1Score < 12) {

                team1Score += pointsToAdd

                if (team1Score > 12) {
                    team1Score = 12
                }

                team1ScoreText.text = team1Score.toString()

                pointsToAdd = 1
                trucoButton.text = "Truco! (1)"

                if (team1Score == 12) {

                    winnerMessage.text = "Team 1 won!"
                    winnerMessage.visibility = TextView.VISIBLE

                    hand11Message.visibility = TextView.GONE

                    team1Button.isEnabled = false
                    team2Button.isEnabled = false
                    trucoButton.isEnabled = false

                } else if (team1Score == 11) {

                    hand11Message.text = "Team 1 is on hand 11!"
                    hand11Message.visibility = TextView.VISIBLE

                    trucoButton.isEnabled = false
                }
            }
        }

        team2Button.setOnClickListener {

            if (team2Score < 12) {

                team2Score += pointsToAdd

                if (team2Score > 12) {
                    team2Score = 12
                }

                team2ScoreText.text = team2Score.toString()

                pointsToAdd = 1
                trucoButton.text = "Truco! (1)"

                if (team2Score == 12) {

                    winnerMessage.text = "Team 2 won!"
                    winnerMessage.visibility = TextView.VISIBLE

                    hand11Message.visibility = TextView.GONE

                    team1Button.isEnabled = false
                    team2Button.isEnabled = false
                    trucoButton.isEnabled = false

                } else if (team2Score == 11) {

                    hand11Message.text = "Team 2 is on hand 11!"
                    hand11Message.visibility = TextView.VISIBLE

                    trucoButton.isEnabled = false
                }
            }
        }

        trucoButton.setOnClickListener {

            pointsToAdd = when (pointsToAdd) {
                1 -> 3
                3 -> 6
                6 -> 9
                9 -> 12
                12 -> 1
                else -> 1
            }

            trucoButton.text = "Truco! ($pointsToAdd)"
        }

        resetButton.setOnClickListener {

            team1Score = 0
            team2Score = 0
            pointsToAdd = 1

            team1ScoreText.text = "0"
            team2ScoreText.text = "0"

            trucoButton.text = "Truco! (1)"

            hand11Message.visibility = TextView.GONE
            winnerMessage.visibility = TextView.GONE

            team1Button.isEnabled = true
            team2Button.isEnabled = true
            trucoButton.isEnabled = true
        }
    }
}
