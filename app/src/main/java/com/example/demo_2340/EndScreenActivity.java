package com.example.demo_2340;

import static com.example.demo_2340.Leaderboard.getScore;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;


public class EndScreenActivity extends AppCompatActivity {
    private TextView scoreTextView;
    private Button restartButton;
    private TextView playerName1;
    private TextView playerScore1;
    private TextView playerName2;
    private TextView playerScore2;
    private TextView playerName3;
    private TextView playerScore3;
    private TextView playerName4;
    private TextView playerScore4;
    private TextView playerName5;
    private TextView playerScore5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_screen);

        playerName1 = findViewById(R.id.playerName1);
        playerScore1 = findViewById(R.id.playerScore1);
        playerName2 = findViewById(R.id.playerName2);
        playerScore2 = findViewById(R.id.playerScore2);
        playerName3 = findViewById(R.id.playerName3);
        playerScore3 = findViewById(R.id.playerScore3);
        playerName4 = findViewById(R.id.playerName4);
        playerScore4 = findViewById(R.id.playerScore4);
        playerName5 = findViewById(R.id.playerName5);
        playerScore5 = findViewById(R.id.playerScore5);


        scoreTextView = findViewById(R.id.score_text_view);
        restartButton = findViewById(R.id.restart_button);

        scoreTextView.setText("Your Score: ");
        // add a click listener to the restart button
        restartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // restart the game activity
                Intent intent = new Intent(EndScreenActivity.this, ConfigActivity.class);
                startActivity(intent);
            }
        });

        playerName1.setText(Leaderboard.getName(0));
        playerScore1.setText(String.valueOf(Leaderboard.getScore(0)));
        if (Leaderboard.getScoreListSize() == 2) {
            playerName1.setText(Leaderboard.getName(0));
            playerScore1.setText(String.valueOf(Leaderboard.getScore(0)));
            playerName2.setText(Leaderboard.getName(1));
            playerScore2.setText(String.valueOf(Leaderboard.getScore(1)));
        }
        if (Leaderboard.getScoreListSize() == 3) {
            playerName1.setText(Leaderboard.getName(0));
            playerScore1.setText(String.valueOf(Leaderboard.getScore(0)));
            playerName2.setText(Leaderboard.getName(1));
            playerScore2.setText(String.valueOf(Leaderboard.getScore(1)));
            playerName3.setText(Leaderboard.getName(2));
            playerScore3.setText(String.valueOf(Leaderboard.getScore(2)));
        } if (Leaderboard.getScoreListSize() == 4) {
            playerName1.setText(Leaderboard.getName(0));
            playerScore1.setText(String.valueOf(Leaderboard.getScore(0)));
            playerName2.setText(Leaderboard.getName(1));
            playerScore2.setText(String.valueOf(Leaderboard.getScore(1)));
            playerName3.setText(Leaderboard.getName(2));
            playerScore3.setText(String.valueOf(Leaderboard.getScore(2)));
            playerName4.setText(Leaderboard.getName(3));
            playerScore4.setText(String.valueOf(Leaderboard.getScore(3)));
        } if (Leaderboard.getScoreListSize() == 5) {
            playerName1.setText(Leaderboard.getName(0));
            playerScore1.setText(String.valueOf(Leaderboard.getScore(0)));
            playerName2.setText(Leaderboard.getName(1));
            playerScore2.setText(String.valueOf(Leaderboard.getScore(1)));
            playerName3.setText(Leaderboard.getName(2));
            playerScore3.setText(String.valueOf(Leaderboard.getScore(2)));
            playerName4.setText(Leaderboard.getName(3));
            playerScore4.setText(String.valueOf(Leaderboard.getScore(3)));
            playerName5.setText(Leaderboard.getName(4));
            playerScore5.setText(String.valueOf(Leaderboard.getScore(4)));
        }
    }

    public void rewriteLeaderboard() {

    }


    // to start ending screen activity from game activity
    /**
     Intent intent = new Intent(GameScreen.this, EndScreenActivity.class);
     intent.putExtra("score", playerScore);
     startActivity(intent);
     */
}