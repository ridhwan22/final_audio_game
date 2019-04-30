package com.example.final_audio_game;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    // Create  QuestionLibrary Object
    private QuestionLibrary questLibrary = new QuestionLibrary();

    // Create variable to hold the score view
    private TextView scoreView;
    // Variable for the song player button
    private Button songSound;
    // Variable for the first choice button
    private Button choice1;
    // Variable for the second choice button
    private Button choice2;
    // Variable for the third choice button
    private Button choice3;
    // Variable for the fourth choice button
    private Button choice4;

    //exit button
    private Button exit;
    // Initialize the score to 0
    private static int score = 0;
    // Initialize question number to 0
    private int questionNumber = 0;
    // Variable for the answer
    private String answer = questLibrary.getAnswer(questionNumber);
    //Initialized the current to be the first song of the ArrayList Songs in QuestionLibrary
    private MediaPlayer song = questLibrary.getSong(questionNumber);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        // Connecting the variable with the buttons in the xml
        scoreView = (TextView)findViewById(R.id.score);
        songSound = (Button)findViewById(R.id.play_button);
        choice1 = (Button)findViewById(R.id.choice1);
        choice2 = (Button)findViewById(R.id.choice2);
        choice3 = (Button)findViewById(R.id.choice3);
        choice4 = (Button)findViewById(R.id.choice4);
        exit = (Button)findViewById(R.id.Exit);

        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        // Create a listener to handle when the play button is clicked
        songSound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Plays the song when the button is clicked
                if (song != null) {
                    song.start();
                }
            }
        });

        // Create listeners to handle when each button of the question is pressed
        choice1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // If the choice that is clicked equals to the answer, then score goes up by one
                if (choice1.getText().equals(answer)) {
                    score += 1;
                    // Update the question number
                    questionNumber++;
                    // Update the score
                    updateScore(score);
                    // Update song
                    updateMediaPlayer();
                    // Update the multiple choices
                    updateChoices();
                    // Show a short text if got the answer right, else says it's wrong
                    Toast.makeText(Main2Activity.this, "Correct!", Toast.LENGTH_SHORT).show();
                } else {
                    // Update the question number
                    questionNumber++;
                    // Update the multiple choices
                    updateChoices();
                    updateMediaPlayer();
                    Toast.makeText(Main2Activity.this, "Wrong...", Toast.LENGTH_SHORT).show();
                }
                if (questionNumber >= 17) {
                    gameOver();
                }
            }
        });

        choice2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // If the choice that is clicked equals to the answer, then score goes up by one
                if (choice2.getText().equals(answer)) {
                    score += 1;
                    // Update the question number
                    questionNumber++;
                    // Update the score
                    updateScore(score);
                    // Update song
                    updateMediaPlayer();
                    // Update the multiple choices
                    updateChoices();
                    // Show a short text if got the answer right, else says it's wrong
                    Toast.makeText(Main2Activity.this, "Correct!", Toast.LENGTH_SHORT).show();
                } else {
                    // Update the question number
                    questionNumber++;
                    // Update the multiple choices
                    updateChoices();
                    updateMediaPlayer();
                    Toast.makeText(Main2Activity.this, "Wrong...", Toast.LENGTH_SHORT).show();
                }
                if (questionNumber >= 17) {
                    gameOver();
                }
            }
        });

        choice3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // If the choice that is clicked equals to the answer, then score goes up by one
                if (choice3.getText().equals(answer)) {
                    score += 1;
                    // Update the question number
                    questionNumber++;
                    // Update the score
                    updateScore(score);
                    // Update song
                    updateMediaPlayer();
                    // Update the multiple choices
                    updateChoices();
                    // Show a short text if got the answer right, else says it's wrong
                    Toast.makeText(Main2Activity.this, "Correct!", Toast.LENGTH_SHORT).show();
                } else {
                    // Update the question number
                    questionNumber++;
                    // Update the multiple choices
                    updateChoices();
                    updateMediaPlayer();
                    Toast.makeText(Main2Activity.this, "Wrong...", Toast.LENGTH_SHORT).show();
                }
                if (questionNumber >= 17) {
                    gameOver();
                }
            }
        });

        choice4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // If the choice that is clicked equals to the answer, then score goes up by one
                if (choice4.getText().equals(answer)) {
                    score += 1;
                    // Update the question number
                    questionNumber++;
                    // Update the score
                    updateScore(score);
                    // Update song
                    updateMediaPlayer();
                    // Update the multiple choices
                    updateChoices();
                    // Show a short text if got the answer right, else says it's wrong
                    Toast.makeText(Main2Activity.this, "Correct!", Toast.LENGTH_SHORT).show();
                } else {
                    // Update the question number
                    questionNumber++;
                    // Update the multiple choices
                    updateChoices();
                    updateMediaPlayer();
                    Toast.makeText(Main2Activity.this, "Wrong...", Toast.LENGTH_SHORT).show();
                }
                if (questionNumber >= 17) {
                    gameOver();
                }
            }
        });
    }

    public int getScore() {
        return score;
    }

    private void gameOver() {
        Intent gameOver = new Intent(this, GameOver.class);
        startActivity(gameOver);
    }

    // Update the song as the question changes
    private void updateMediaPlayer() {
        song = questLibrary.getSong(questionNumber);
    }

    private void updateChoices() {
        // Update each choices of each question
        choice1.setText(questLibrary.getChoice1(questionNumber));
        choice2.setText(questLibrary.getChoice2(questionNumber));
        choice3.setText(questLibrary.getChoice3(questionNumber));
        choice4.setText(questLibrary.getChoice4(questionNumber));
    }

    // Updates the scoreView with the current score
    private void updateScore(int pt) {
        scoreView.setText("" + score);
    }
}
