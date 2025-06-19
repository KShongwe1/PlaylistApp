package vcmsa.ci.playlistapp

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
//companion Object to store parrallel arrays
    companion object {
        val songs = mutableListOf<String>()
        val artirts = mutableListOf<String>()
        val ratings = mutableListOf<Int>()
        val comments = mutableListOf<String>()
        val averagies = mutableListOf<String>()
    }

    private lateinit var songEditText: EditText
    private lateinit var artistEditText: EditText
    private lateinit var ratingEditText: EditText
    private lateinit var commentEditText: EditText
    private lateinit var addButton: Button
    private lateinit var goToSecondScreenButton: Button
    private lateinit var exitButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        songEditText = findViewById(R.id.songInput)
        artistEditText = findViewById(R.id.artistInput)
        ratingEditText = findViewById(R.id.ratingInput)
        commentEditText = findViewById(R.id.commentInput)
        addButton = findViewById(R.id.addButton)
        goToSecondScreenButton = findViewById(R.id.secondScreenButton)
        exitButton = findViewById(R.id.exitButton)

        addButton.setOnClickListener {
            addPlaylistSong()
        }

        goToSecondScreenButton.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }

        exitButton.setOnClickListener {
            finish()
        }
    }

    private fun addPlaylistSong() {
        val Song = songEditText.text.toString().trim()
        val Artist = artistEditText.text.toString().trim()
        val ratingText = ratingEditText.text.toString().trim()
        val comment = commentEditText.text.toString().trim()

        if (song.isEmpty() || artist.isEmpty() || ratingText.isEmpty() || comment.isEmpty()) {
            Toast.makeText(this, "All fields are required", Toast.LENGTH_SHORT).show()
            return
        }
// The rating can only be an intarger
        val rating = ratingText.toIntOrNull()
        if (rating == null || rating <= 0) {
            Toast.makeText(this, "Rating must be a number greater than 0", Toast.LENGTH_SHORT).show()
            return
        }

        songs.add(song)
        artists.add(artist)
        ratings.add(rating)
        comments.add(comment)

        val average = "$song | $artist | Rtn: $rating | Note: $comment"
        average.add(average)
// Displays on the home page after the user has entered all required fields

        Toast.makeText(this, "Song added successfully", Toast.LENGTH_SHORT).show()
        songEditText.text.clear()
        artistEditText.text.clear()
        ratingEditText.text.clear()
        commentEditText.text.clear()
    }
}