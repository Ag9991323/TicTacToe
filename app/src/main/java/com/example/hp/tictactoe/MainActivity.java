package com.example.hp.tictactoe;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int activePlayer=0;
    int[] gameState={2,2,2,2,2,2,2,2,2};
    boolean  GameActive=true;
    int[][] winningState={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
    int count=0;
    public void dropping(View view){

        ImageView Counter= (ImageView) view;

        int tag=Integer.parseInt(Counter.getTag().toString());

        if(gameState[tag]==2 && GameActive){

            gameState[tag]=activePlayer;
            Counter.setTranslationY(-1000);
        if(activePlayer==0) {
            activePlayer=1;
            Counter.setImageResource(R.drawable.tic);
            }
        else{
            activePlayer=0;
            Counter.setImageResource(R.drawable.toe);
            }
        Counter.animate().translationYBy(1000).setDuration(300);
            for(int i:gameState){
                if( i!=2){
                    count+=1;
                }
            }
            if(count!=gameState.length){
                count=0;
            }

            Log.i("info",Integer.toString(count));
            Log.i("info",Integer.toString(gameState.length));
        for(int[] winnerPosition: winningState){
            if(gameState[winnerPosition[0]]==gameState[winnerPosition[1]]&& gameState[winnerPosition[1]]==gameState[winnerPosition[2]]&& gameState[winnerPosition[0]]!=2){
                GameActive=false;
                String Winner="";
                if(activePlayer==0){
                    Winner=" circle";
                }
                if(activePlayer==1){
                    Winner="cross";
                }
                //Toast.makeText(this,Winner+" is the winner",Toast.LENGTH_SHORT).show();

            Button playAgain =(Button)findViewById(R.id.playAgain);
            TextView winners=(TextView)findViewById(R.id.winners);
            winners.setText(Winner+ " is winner");
            playAgain.setVisibility(View.VISIBLE);
            winners.setVisibility(View.VISIBLE);
        }

       else if(count==gameState.length) {

           GameActive = false;
           Button playAgain = (Button) findViewById(R.id.playAgain);
           TextView winners = (TextView) findViewById(R.id.winners);
           winners.setText(" Tie ");
           playAgain.setVisibility(View.VISIBLE);
           winners.setVisibility(View.VISIBLE);
       }
        }
        }
        }

    public void PlayAgain(View view){
        Log.i("info","1");
        Button playagain =(Button)findViewById(R.id.playAgain);
        Log.i("info","2");
      TextView wins=(TextView)findViewById(R.id.winners);
        Log.i("info","3");
       playagain.setVisibility(View.INVISIBLE);
        Log.i("info","4");
       wins.setVisibility(View.INVISIBLE);
        Log.i("info","5");
//         GridLayout gridLayout = (GridLayout)findViewById(R.id.gridLayout);
//        Log.i("info","6");
//        for(int i=0; i<gridLayout.getChildCount(); i++) {
//           ImageView counter = (ImageView)gridLayout.getChildAt(i);
//           counter.setImageDrawable(null);
//        }

        for(int i=1;i<10;i++){
            ImageView counter=(ImageView)findViewById(getResources().getIdentifier("imageView"+i,"id",getPackageName()));
            counter.setImageDrawable(null);
        }

//        ImageView counter=(ImageView)findViewById(R.id.imageView1);
//        counter.setImageDrawable(null);
//
//
//        ImageView counter1=(ImageView)findViewById(R.id.imageView2);
//        counter1.setImageDrawable(null);
//
//        ImageView counter2=(ImageView)findViewById(R.id.imageView3);
//        counter2.setImageDrawable(null);
//
//        ImageView counter3=(ImageView)findViewById(R.id.imageView4);
//        counter3.setImageDrawable(null);
//
//        ImageView counter4=(ImageView)findViewById(R.id.imageView5);
//        counter4.setImageDrawable(null);
//
//        ImageView counter5=(ImageView)findViewById(R.id.imageView6);
//        counter5.setImageDrawable(null);
//
//        ImageView counter6=(ImageView)findViewById(R.id.imageView7);
//        counter6.setImageDrawable(null);
//
//        ImageView counter7=(ImageView)findViewById(R.id.imageView8);
//        counter7.setImageDrawable(null);
//
//        ImageView counter8=(ImageView)findViewById(R.id.imageView9);
//        counter8.setImageDrawable(null);

        Log.i("info","7");

         for(int i=0;i<gameState.length;i++){
          gameState[i]=2;
        }
        Log.i("info","8");
       GameActive=true;
        Log.i("info","9");
        activePlayer=0;
        Log.i("info","10");


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
