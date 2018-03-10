package com.example.mustafa.numberforkids;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Intent i ;

    public int correctAnswer;//holding correct answer
    public int progressStatus;//the number of question user has answered correct
    public int userStatus;//the question number user is currently at
    public Random rand;//random generator initialize onCreate
    public int rndInt;// n = the number of images, that start at idx 1 initialize onCreate
    public List<Integer> list;//this list will hold our numbers 1 to 8 representing the images

    public void answerGenerator(){
        Button btn1 = (Button) findViewById(R.id.btn1);
        Button btn2 = (Button) findViewById(R.id.btn2);
        Button btn3 = (Button) findViewById(R.id.btn3);
        int rndBtn, min, max, randomOne, randomTwo;
        String btnName;
        //setting the bounds of random answers
//        if(correctAnswer - 20 < 0)
//            min = 0;
//        else
//            min = correctAnswer - 20;
//        max = correctAnswer + 20;

        //making answers unique
        do {
            randomOne = rand.nextInt(11 ) ;//+1 to include the max value in our limits
        } while (randomOne == correctAnswer);

        do{
            randomTwo = rand.nextInt(11) ;//+1 to include the max value in our limits
        }while (randomOne == randomTwo || correctAnswer == randomTwo);

        //choosing random button for the right answer
        rndBtn  = rand.nextInt(3) + 1; // rndBtn={1,2,3},
        btnName = "btn" + rndBtn;

        //and setting the other two random numbers to the other two buttons
        if(btnName.equals("btn1")){
            btn1.setText(Integer.toString(correctAnswer));
            btn2.setText(Integer.toString(randomOne));
            btn3.setText(Integer.toString(randomTwo));
        }else if(btnName.equals("btn2")){
            btn1.setText(Integer.toString(randomOne));
            btn2.setText(Integer.toString(correctAnswer));
            btn3.setText(Integer.toString(randomTwo));
        }else{
            btn1.setText(Integer.toString(randomOne));
            btn2.setText(Integer.toString(randomTwo));
            btn3.setText(Integer.toString(correctAnswer));
        }
    }
    public void randomGenerator(){
        boolean gamefinished = false;
        ImageView mainImage = (ImageView) findViewById(R.id.mainView);
        Button btn1 = (Button) findViewById(R.id.btn1);
        Button btn2 = (Button) findViewById(R.id.btn2);
        Button btn3 = (Button) findViewById(R.id.btn3);
        //resetButtonText
        btn1.setText("");
        btn2.setText("");
        btn3.setText("");

        while (list.contains(rndInt)){//if the number already exists in our list we need a new one
            if(list.size() == 10){
                gamefinished = true;//if our list has 8 unique numbers then we must terminate the game
                break;
            }
            rndInt = rand.nextInt(10) + 1;//if list.size < 10 then rand.nextInt
        }

        if(!gamefinished){
            list.add(rndInt);
            String imgName = "i" + rndInt;
            int id = getResources().getIdentifier(imgName, "drawable", getPackageName());
            //getIdentifier gives you an identifier for the resourse name
            mainImage.setImageResource(id);
            switch (imgName){//initialize correctAnswer
                case "i1":
                    correctAnswer = 1;
                    break;
                case "i2":
                    correctAnswer = 2;
                    break;
                case "i3":
                    correctAnswer = 3;
                    break;
                case "i4":
                    correctAnswer = 4;
                    break;
                case "i5":
                    correctAnswer = 5;
                    break;
                case "i6":
                    correctAnswer = 6;
                    break;
                case "i7":
                    correctAnswer = 7;
                    break;
                case "i8":
                    correctAnswer = 8;
                    break;
                case "i9":
                    correctAnswer = 9;
                    break;
                case "i10":
                    correctAnswer = 10;
                    break;
            }
            answerGenerator();
        }else{
            gameTermination();
        }

    }
    public void userUpdateStatus(int userChoice){
        ProgressBar progressBar = (ProgressBar) findViewById(R.id.progressBar);
        TextView answersView = (TextView) findViewById(R.id.answersView);
        userStatus++;
        if(userChoice == correctAnswer){
            progressStatus++;
            Toast.makeText(getApplicationContext(),"Correct!", Toast.LENGTH_SHORT).show();
        }else
            Toast.makeText(getApplicationContext(),"Wrong!", Toast.LENGTH_SHORT).show();

        answersView.setText(progressStatus + "/" + userStatus);
        progressBar.setProgress(userStatus);
        //progressBar.setSecondaryProgress(progressStatus);
    }
    public void initiateGame(){
        final Button btn1 = (Button) findViewById(R.id.btn1);
        final Button btn2 = (Button) findViewById(R.id.btn2);
        final Button btn3 = (Button) findViewById(R.id.btn3);
        Button restart = (Button) findViewById(R.id.infoBtn);
        ImageView mainImage = (ImageView) findViewById(R.id.mainView);
        progressStatus = 0;
        userStatus = 0;

        randomGenerator();//Generate the first image

        AlphaAnimation animation1 = new AlphaAnimation(0.0f, 1.0f);//0.0 1.0
        animation1.setDuration(250);
        animation1.setStartOffset(250);
        mainImage.startAnimation(animation1);
        mainImage.animate().scaleX(1.3f).scaleY(1.3f).setDuration(500); //1.3  1.3

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int userChoice = Integer.parseInt(btn1.getText().toString());
                userUpdateStatus(userChoice);
                randomGenerator();
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int userChoice = Integer.parseInt(btn2.getText().toString());
                userUpdateStatus(userChoice);
                randomGenerator();
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int userChoice = Integer.parseInt(btn3.getText().toString());
                userUpdateStatus(userChoice);
                randomGenerator();
            }
        });
        restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                restartGame();
            }
        });

    }
    public void gameTermination(){
        final Button btn1 = (Button) findViewById(R.id.btn1);
        final Button btn2 = (Button) findViewById(R.id.btn2);
        final Button btn3 = (Button) findViewById(R.id.btn3);
        final Button restart = (Button) findViewById(R.id.infoBtn);
        final TextView finalText = (TextView) findViewById(R.id.answersView);
        final ImageView finalImage = (ImageView) findViewById(R.id.mainView);
        final ProgressBar progressBar = (ProgressBar) findViewById(R.id.progressBar);

        Animation fadeOut = new AlphaAnimation(1, 0);
        fadeOut.setInterpolator(new AccelerateInterpolator());
        fadeOut.setStartOffset(0);
        fadeOut.setDuration(100);

        final Animation fadeIn = new AlphaAnimation(0, 1);
        fadeIn.setInterpolator(new AccelerateInterpolator());
        fadeIn.setStartOffset(250);
        fadeIn.setDuration(500);

        //finalText.setText(progressStatus + "/" + userStatus);
        btn1.setAnimation(fadeOut);
        btn2.setAnimation(fadeOut);
        btn3.setAnimation(fadeOut);
        restart.setAnimation(fadeOut);
        finalImage.setAnimation(fadeOut);
        fadeOut.setAnimationListener(new Animation.AnimationListener(){

            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                btn1.setText("Restart");
                btn2.setText("Exit");
                finalImage.setImageResource(R.drawable.thanks);
                btn1.setAnimation(fadeIn);
                btn2.setAnimation(fadeIn);
                finalText.animate().translationX(-450).setDuration(1000); // -450
                finalText.animate().translationY(-150).setDuration(1000); // -200
                finalText.animate().scaleX(1.2f).setDuration(1000); // 1.9f
                finalText.animate().scaleY(1.2f).setDuration(1000); // 1.9f
                progressBar.animate().translationX(85).setStartDelay(150).setDuration(1000);
                btn3.setAlpha(0);
                restart.setAlpha(0);
                btn3.setClickable(false);
                restart.setClickable(false);

                //layout.removeView(finalImage);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn3.setAlpha(1);
                restart.setAlpha(1);
                finalText.animate().translationX(0).setDuration(150);
                finalText.animate().translationY(0).setDuration(200);
                finalText.animate().scaleX(1f).setDuration(150);
                finalText.animate().scaleY(1f).setDuration(150);
                progressBar.animate().translationX(0).setDuration(200);
                restartGame();
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                System.exit(0);
            }
        });
    }
    public void restartGame(){
        ProgressBar progressBar = (ProgressBar) findViewById(R.id.progressBar);
        TextView answersView = (TextView) findViewById(R.id.answersView);
        answersView.setText(0 + "/" + 0);
        progressBar.setProgress(0);
        list.clear();
        Toast.makeText(getApplicationContext(),"Game restarted!", Toast.LENGTH_SHORT).show();
        initiateGame();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = 8;



        final Button btn1 = (Button) findViewById(R.id.btn1);
        final Button btn2 = (Button) findViewById(R.id.btn2);
        final Button btn3 = (Button) findViewById(R.id.btn3);
        final Button restart = (Button) findViewById(R.id.infoBtn);
        final ProgressBar progressBar = (ProgressBar) findViewById(R.id.progressBar);
        final TextView answersView = (TextView) findViewById(R.id.answersView);
        final Drawable d = getResources().getDrawable(R.drawable.restartgame);
        final ImageView mainImage = (ImageView) findViewById(R.id.mainView);
        final Button youtube = (Button) findViewById(R.id.youtube1);


        rand = new Random();
        rndInt = rand.nextInt(10) + 1; //rndInt : 1 , 2 , 3 , .. , 10
        list = new ArrayList<>();
        //INITIATE GAME
        btn1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                AlphaAnimation animation1 = new AlphaAnimation(1.0f, 0.0f);
                mainImage.startAnimation(animation1);

                btn1.setText("");
                btn2.setText("");
                btn3.setText("");
                //btn1.animate().scaleX(0.4f).setDuration(500);
                //btn2.animate().scaleX(0.4f).setDuration(500);
                //btn3.animate().scaleX(0.4f).setDuration(500);
                restart.setBackgroundDrawable(d);
                restart.animate().translationY(-650).setDuration(500);
                progressBar.animate().alpha(1f).setStartDelay(250).setDuration(250);
                answersView.animate().alpha(1f).setStartDelay(250).setDuration(250);
                initiateGame();
            }
        });

        ((Button)findViewById(R.id.btn2)).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {


         startActivity(new Intent(MainActivity.this,Main2ActivityGallery.class));


            }
        });
        //EXIT GAME
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                System.exit(0);
            }
        });

        restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Eng. Mustafa Shahoud", Toast.LENGTH_LONG).show();
            }
        });

        youtube.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(MainActivity.this,LearnByYoutube.class);
                startActivity(i);

            }
        });


    }

}
