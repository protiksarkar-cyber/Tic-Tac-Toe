package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    // for 1 = X and 2 = O and 0 = null
    int active = 1;
    int[] game = {0,0,0,0,0,0,0,0,0};

    // for winner state
    int[][] winner = {{0,1,2},{3,4,5},{6,7,8},
                      {0,3,6},{1,4,7},{2,5,8},
                      {0,4,8},{2,4,6}};
    boolean gameactive  = true;
    public void playerrun(View view)
    {
        ImageView img = (ImageView) view;
        int tapimg = Integer.parseInt(img.getTag().toString());
        String ans;

        if(!gameactive)
        {
            reset(view);
        }
        if(game[tapimg]==0)
        {
            game[tapimg]=active;
            img.setTranslationY(-1000f);
            if(active==1)
            {
                img.setImageResource(R.drawable.x);
                active=2;
                TextView status =findViewById(R.id.status);
                status.setText("O's Turn - Tap To Play");
            }
            else
            {
                img.setImageResource(R.drawable.o);
                active=1;
                TextView status =findViewById(R.id.status);
                status.setText("X's Turn - Tap To Play");
            }
            img.animate().translationYBy(1000f);
        }


        // check which player has won
        for(int[] win : winner)
        {

            if(game[win[0]]==game[win[1]] && game[win[1]]==game[win[2]] && game[win[0]]!=0 )
            {
                // check whether x or o has won
                if(game[win[0]]==1)
                {
                    ans = "X has won";
                }
                else
                {
                    ans = "O has won";
                }

                //update status bar who is the winner
                TextView status =findViewById(R.id.status);
                status.setText(ans);
            }

        }
    }

    public void reset(View view)
    {
        active = 1;
        gameactive = true;
        for(int i=0;i<game.length;i++)
        {
            game[i]=0;
        }
        ((ImageView) findViewById(R.id.imageView0)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView1)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView2)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView3)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView4)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView5)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView6)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView7)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView8)).setImageResource(0);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}