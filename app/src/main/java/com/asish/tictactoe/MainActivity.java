package com.asish.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    boolean game_active = true;

    // state meanings
    // 0 - x
    // 1 - O
    // 2 - Null

    int active_player = 0;
    int[] game_state = {2, 2, 2, 2, 2, 2, 2, 2, 2};

    int[][] win_pos = {{0,1,2}, {3,4,5}, {6,7,8},
                        {0,3,6}, {1,4,7}, {2,5,8},
                        {0,4,8}, {2,4,6}};

    public void taptap(View view){

        ImageView img = (ImageView) view;
        int tap_img = Integer.parseInt(img.getTag().toString());
        if(!game_active)
        {
            gm_reset(view);
        }
        if(game_state[tap_img] == 2 ) {
            game_state[tap_img] = active_player;
            img.setTranslationY(-1000f);
            if (active_player == 0) {
                img.setImageResource(R.drawable.cross);
                active_player = 1;
                TextView status = findViewById(R.id.status);
                status.setText("O's Turn - Tap To Play ");
            } else {
                img.setImageResource(R.drawable.ooo);
                active_player = 0;
                TextView status = findViewById(R.id.status);
                status.setText("X's Turn - Tap To Play");
            }
            img.animate().translationYBy(1000f).setDuration(300);
        }
        //check if player has won
        for(int[] win: win_pos)
        {
            if(game_state[win[0]] == game_state[win[1]] &&
                    game_state[win[1]] == game_state[win[2]] &&
                        game_state[win[0]] != 2){
                //somebody has won
                String winStr;
                game_active = false;

                if(game_state[win[0]] == 0 ){
                    winStr = " X is the Winner" ;
            }
                else{
                    winStr="O is the winner";
                }
                TextView status = findViewById(R.id.status);
                status.setText(winStr);
            }
        }

    }
    public void gm_reset(View view){
        game_active = true;
        active_player=0;
        for(int i =0; i<game_state.length; i++){
            game_state[i] = 2;
        }
        ((ImageView)findViewById(R.id.imageView1)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView2)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView3)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView4)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView5)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView6)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView7)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView8)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView0)).setImageResource(0);

        TextView status = findViewById(R.id.status);
        status.setText("X's Turn - Tap To Play");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}