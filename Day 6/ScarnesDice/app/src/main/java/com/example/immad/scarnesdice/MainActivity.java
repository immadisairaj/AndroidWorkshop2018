package com.example.immad.scarnesdice;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView playersText;
    int change = 0;
    boolean playerSwitch = false;

    int scoreComputer=0, scorePlayer=0, turnScorePlayer=0, turnScoreComputer=0,
            scorePlayer2=0, turnScorePlayer2=0;

    String userScoreText = " Your score : ";
    String userTurnScoreText = " Your Turn Score : ";
    String compScoreText = "\t\tComputer Score : ";
    String compTurnScoreText = " Computer Turn Score : ";
    String user1ScoreText = " Player1 score : ";
    String user1TurnScoreText = " Player1 Turn Score : ";
    String user2ScoreText = "\t\tPlayer2 score : ";
    String user2TurnScoreText = " Player2 Turn Score : ";

    String Text = userScoreText+scorePlayer+compScoreText+scoreComputer;
    TextView text;
    String Text2 = "";
    TextView text2;
    String Text3 = "For Two Players Press this Button";
    String Text4 = "For One Player Press this Button";

    TextView playerTurn;
    String Text5 = "Your Turn";
    String Text6 = "Computer Turn";

    boolean notWon = true;
    boolean reset = false;
    boolean player1 = true;

    int[] drawables = {
            R.drawable.dice1,
            R.drawable.dice2,
            R.drawable.dice3,
            R.drawable.dice4,
            R.drawable.dice5,
            R.drawable.dice6,
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        playerTurn = findViewById(R.id.players_text);
        playerTurn.setText(Text5);
        playerTurn.setTextColor(Color.GREEN);
        playersText = findViewById(R.id.change_players_text);
        playersText.setText(Text3);
        text = findViewById(R.id.score);
        text.setText(Text);
        text2 = findViewById(R.id.turnScore);
        text2.setText(Text2);
    }

    public void changePlayerClick (View v) {
        change++;
        if (change%2 == 1) {
            playerSwitch = true;
            playersText.setText(Text4);
            player1Turn();
        }
        else {
            playerSwitch = false;
            playersText.setText(Text3);
        }
        resetButtons();
        enableButtons(true);
        TextView winnerView;
        winnerView=findViewById(R.id.winner);
        winnerView.setText("");
        reset = true;
        notWon = true;
        if (playerSwitch) {
            playerTurn.setText("Player 1 Turn");
            playerTurn.setTextColor(Color.BLUE);
            Text = user1ScoreText+scorePlayer+user2ScoreText+scorePlayer2;
            text.setText(Text);
            Text2 = "";
            text2.setText(Text2);
        }
        else {
            playerTurn.setText(Text5);
            playerTurn.setTextColor(Color.GREEN);
            Text = userScoreText+scorePlayer+compScoreText+scoreComputer;
            text.setText(Text);
            Text2 = "";
            text2.setText(Text2);
        }
    }

    private int rollDice() {
        Random random = new Random();
        int randomNumber = random.nextInt(6)+1;
        return randomNumber;
    }

    public void rollButtonClick(View v) {
        int number = rollDice();
        ImageView imageView = findViewById(R.id.dice_image);
        imageView.setImageResource(drawables[number-1]);
        reset = false;
        if (player1) {
            if (number == 1) {
                if(playerSwitch) {
                    turnScorePlayer = 0;
                    Text = user1ScoreText+scorePlayer+user2ScoreText+scorePlayer2;
                    text.setText(Text);
                    Text2 = user1TurnScoreText+turnScorePlayer;
                    text2.setText(Text2);
                    player2Turn();
                }
                else {
                    turnScorePlayer = 0;
                    Text = userScoreText+scorePlayer+compScoreText+scoreComputer;
                    text.setText(Text);
                    Text2 = userTurnScoreText+turnScorePlayer;
                    text2.setText(Text2);
                    computerTurn();
                }
            }
            else {
                turnScorePlayer+=number;
            }
            if(playerSwitch) {
                Text = user1ScoreText+scorePlayer+user2ScoreText+scorePlayer2;
                text.setText(Text);
                Text2 = user1TurnScoreText+turnScorePlayer;
                text2.setText(Text2);
            }
            else {
                Text = userScoreText+scorePlayer+compScoreText+scoreComputer;
                text.setText(Text);
                Text2 = userTurnScoreText+turnScorePlayer;
                text2.setText(Text2);
            }
        }
        else {
            if (number == 1) {
                turnScorePlayer2 = 0;
                Text = user1ScoreText+scorePlayer+user2ScoreText+scorePlayer2;
                text.setText(Text);
                Text2 = user2TurnScoreText+turnScorePlayer2;
                text2.setText(Text2);
                player1Turn();
            }
            else {
                turnScorePlayer2+=number;
            }
            Text = user1ScoreText+scorePlayer+user2ScoreText+scorePlayer2;
            text.setText(Text);
            Text2 = user2TurnScoreText+turnScorePlayer2;
            text2.setText(Text2);
        }
    }

    public void holdButtonClick(View v) {
        if (player1) {
            if (playerSwitch) {
                scorePlayer+=turnScorePlayer;
                turnScorePlayer=0;

                reset = false;

                Text = user1ScoreText+scorePlayer+user2ScoreText+scorePlayer2;
                text.setText(Text);
                Text2 = "";
                text2.setText(Text2);
                checkWinner();
                if (notWon) {
                    player2Turn();
                }
            }
            else {
                scorePlayer+=turnScorePlayer;
                turnScorePlayer=0;

                reset = false;

                Text = userScoreText+scorePlayer+compScoreText+scoreComputer;
                text.setText(Text);
                Text2 = "";
                text2.setText(Text2);
                checkWinner();
                if (notWon) {
                    computerTurn();
                }

            }
        }
        else{
            scorePlayer2+=turnScorePlayer2;
            turnScorePlayer2=0;

            reset = false;

            Text = user1ScoreText+scorePlayer+user2ScoreText+scorePlayer2;
            text.setText(Text);
            Text2 = "";
            text2.setText(Text2);
            checkWinner();
            if (notWon) {
                player1Turn();
            }
        }
    }

    public void resetButtons() {
        scoreComputer=0;
        scorePlayer=0;
        scorePlayer2=0;
        turnScorePlayer=0;
        turnScoreComputer=0;
        turnScorePlayer2=0;
    }

    public void resetButtonClick(View v) {
        resetButtons();
        enableButtons(true);
        TextView winnerView;
        winnerView=findViewById(R.id.winner);
        winnerView.setText("");
        reset = true;
        notWon = true;
        if (playerSwitch) {
            playerTurn.setText("Player 1 Turn");
            playerTurn.setTextColor(Color.BLUE);
            Text = user1ScoreText+scorePlayer+user2ScoreText+scorePlayer2;
            text.setText(Text);
            Text2 = "";
            text2.setText(Text2);
        }
        else {
            playerTurn.setText(Text5);
            playerTurn.setTextColor(Color.GREEN);
            Text = userScoreText+scorePlayer+compScoreText+scoreComputer;
            text.setText(Text);
            Text2 = "";
            text2.setText(Text2);
        }
    }

    public void enableButtons(boolean enable) {
        Button rollButton = findViewById(R.id.roll_button);
        Button holdButton = findViewById(R.id.hold_button);
        rollButton.setEnabled(enable);
        holdButton.setEnabled(enable);
    }

    public void checkWinner() {
        if (playerSwitch) {
            TextView winnerView;
            if (scorePlayer>=100) {
                winnerView=findViewById(R.id.winner);
                enableButtons(false);
                notWon = false;
                winnerView.setText("Player 1 Won !!");
                winnerView.setTextColor(Color.BLUE);
                resetButtons();
            }
            else if (scorePlayer2>=100) {
                winnerView=findViewById(R.id.winner);
                enableButtons(false);
                notWon = false;
                winnerView.setText("Player 2 Won !!");
                winnerView.setTextColor(Color.MAGENTA);
                resetButtons();
            }
        }
        else {
            TextView winnerView;
            if (scorePlayer>=100) {
                winnerView=findViewById(R.id.winner);
                enableButtons(false);
                notWon = false;
                winnerView.setText("You Won !!");
                winnerView.setTextColor(Color.GREEN);
                resetButtons();
            }
            else if (scoreComputer>=100) {
                winnerView=findViewById(R.id.winner);
                enableButtons(false);
                notWon = false;
                winnerView.setText("Computer Won !!");
                winnerView.setTextColor(Color.RED);
                resetButtons();
            }
        }
    }

    public void computerTurn() {
        enableButtons(false);

        playerTurn.setText(Text6);
        playerTurn.setTextColor(Color.RED);

        Thread thread = new Thread() {
            int number;
            ImageView imageView;

            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(1500);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                    number = rollDice();
                    imageView = findViewById(R.id.dice_image);
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            if (reset) {
                                return;
                            }
                            imageView.setImageResource(drawables[number-1]);
                        }
                    });

                    if (number == 1) {
                        turnScoreComputer = 0;
                        Text = userScoreText+scorePlayer+compScoreText+scoreComputer;
                        Text2 = compTurnScoreText+turnScoreComputer;
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                if (reset) {
                                    return;
                                }
                                text.setText(Text);
                                text2.setText(Text2);
                                checkWinner();
                                if (notWon) {
                                    playerTurn.setText(Text5);
                                    playerTurn.setTextColor(Color.GREEN);
                                    enableButtons(true);
                                }
                            }
                        });
                        return;
                    }
                    else {
                        turnScoreComputer+=number;
                        Text = userScoreText+scorePlayer+compScoreText+scoreComputer;
                        Text2 = compTurnScoreText+turnScoreComputer;
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                if (reset) {
                                    return;
                                }
                                text.setText(Text);
                                text2.setText(Text2);
                            }
                        });
                    }
                    if (turnScoreComputer>=20) {
                        scoreComputer+=turnScoreComputer;
                        turnScoreComputer=0;
                        Text = userScoreText+scorePlayer+compScoreText+scoreComputer;
                        Text2 = "";
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                text.setText(Text);
                                text2.setText(Text2);
                                checkWinner();
                                if (notWon) {
                                    playerTurn.setText(Text5);
                                    playerTurn.setTextColor(Color.GREEN);
                                    enableButtons(true);
                                }
                            }
                        });
                        return;
                    }
                    if (reset) {
                        return;
                    }
                }
            }
        };
        thread.start();
    }

    public void player1Turn () {
        playerTurn.setText("Player 1 Turn");
        playerTurn.setTextColor(Color.BLUE);
        player1 = true;
    }

    public void player2Turn () {
        playerTurn.setText("Player 2 Turn");
        playerTurn.setTextColor(Color.MAGENTA);
        player1 = false;
    }
}
