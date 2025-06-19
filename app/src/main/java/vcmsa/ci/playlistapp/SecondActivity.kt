package vcmsa.ci.playlistapp

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {

    private lateinit var displayPlayListButton: Button
    private lateinit var displayAverageButton: Button
    private lateinit var returnButton: Button
    private lateinit var outputTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        displayPlaylistButton = findViewById(R.id.displayPlaylistButton)
        displayAverageButton = findViewById(R.id.displayAverageButton)
        returnButton = findViewById(R.id.returnButton)
        outputTextView = findViewById(R.id.outputTextView)

        displayPlaylistButton.setOnClickListener {
            displayAllSongs()
        }

        displayAverageButton.setOnClickListener {
            displayAveragies()
        }

        returnButton.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }

    private fun displayAllSongs() {
        val builder = StringBuilder()
        for (i in MainActivity.songs.indices) {
            builder.append("Song: ${MainActivity.songs[i]}\n")
            builder.append("Artist: ${MainActivity.artists[i]}\n")
            builder.append("Rating: ${MainActivity.ratings[i]}\n")
            builder.append("Comments: ${MainActivity.comments[i]}\n\n")
        }
        outputTextView.text = builder.toString()
    }

    private fun displayItemsWithRating2OrMore() {
        val builder = StringBuilder()
        for (i in MainActivity.songs.indices) {
            if (MainActivity.ratings[i] >= 2) {
                builder.append("${MainActivity.songs[i]} (Rtn: ${MainActivity.ratings[i]})\n")
            }
        }
        outputTextView.text = builder.toString()
    }

    private fun displayAveragies() {
        outputTextView.text = MainActivity.averagies.joinToString("\n\n")
    }
}