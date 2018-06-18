package com.example.immad.ghost;

import android.content.res.AssetManager;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.IOException;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private static final String COMPUTER_TURN = "Computer's Turn";
    private static final String YOUR_TURN = "Your Turn";
    private TextView ghostTextView, gameStatus;
    private Button restartButton, challengeButton;
    private boolean turn;
    SimpleDictionary simpleDictionary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ghostTextView = findViewById(R.id.ghost_text_view);
        gameStatus = findViewById(R.id.game_status);
        challengeButton = findViewById(R.id.challenge);
        restartButton = findViewById(R.id.restart);

        AssetManager assetManager = getAssets();
        try {
            simpleDictionary = new SimpleDictionary(assetManager.open("words.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        challenge();
        restart();
        begin();
    }

    private void begin() {
        turn = new Random().nextBoolean();
        if (turn) {
            //user
            gameStatus.setText(YOUR_TURN);
        } else {
            //computer
            gameStatus.setText(COMPUTER_TURN);
            computerTurn();
        }
    }

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {

        if(turn) {
            //user's turn
            char userInput = (char) event.getUnicodeChar();

            turn = false;
            if(Character.isLetter(userInput)) {
                ghostTextView.append(Character.toString(userInput));
                computerTurn();
            }
        } else {
            //Computer cannot type :(
        }

        return super.onKeyUp(keyCode, event);
    }

    private void computerTurn() {
        // Computer's Turn
        Log.v("Turn", COMPUTER_TURN);
        gameStatus.setText(COMPUTER_TURN);

        new Handler().postDelayed(() -> {
            String ghostWord = ghostTextView.getText().toString();

            if(ghostWord.length() >= 4 && simpleDictionary.isGoodWord(ghostWord)) {
                gameStatus.setText("Computer Wins !!");
                challengeButton.setEnabled(false);
            } else {
                String computerWord = simpleDictionary.getGoodWord(ghostWord);
                if(computerWord == null) {
                    gameStatus.setText("Computer Wins !!");
                    challengeButton.setEnabled(false);
                } else {
                    ghostTextView.append(computerWord.charAt(ghostWord.length())+"");
                    gameStatus.setText(YOUR_TURN);
                    turn = true;
                }
            }
        }, 2000);
    }

    public void challenge() {
        challengeButton.setOnClickListener((view) -> {
            Log.v("challenge", "challenge button pressed");

            String ghostWord = ghostTextView.getText().toString();

            if(ghostWord.length() >= 4 && simpleDictionary.isGoodWord(ghostWord)) {
                gameStatus.setText("You Won !!");
                challengeButton.setEnabled(false);
            } else {
                String computerWord = simpleDictionary.getGoodWord(ghostWord);
                if (computerWord == null) {
                    gameStatus.setText("You Won !!");
                    challengeButton.setEnabled(false);
                } else {
                    gameStatus.setText("Computer Wins !!");
                    ghostTextView.setText(computerWord);
                    challengeButton.setEnabled(false);
                }
            }
        });
    }

    public void restart() {
        restartButton.setOnClickListener((view) -> {
            Log.v("restart", "restart button pressed");

            ghostTextView.setText("");
            challengeButton.setEnabled(true);
            begin();
        });
    }
}
