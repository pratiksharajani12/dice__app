package com.example.dice__app;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Vibrator;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Locale;
import java.util.Random;


public class dice_home_page extends AppCompatActivity {


        int[] img = {R.drawable.dice1, R.drawable.dice2, R.drawable.dice3, R.drawable.dice4, R.drawable.dice5, R.drawable.dice6};
        private Button roll_btn;
        private ImageView dicef_img, dices_img;
        private TextView dice1_txt,dice2_txt,sum_dicetxt;
        int i = 0;
        private TextToSpeech textToSpeech;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dice_home);
        binding();

        roll_btn.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                animation();
//              anim();
//              anim1();

                MediaPlayer ring = MediaPlayer.create(dice_home_page.this, R.raw.shake_diceaudio);
                ring.start();

                Random random = new Random();
                int n1 = random.nextInt(img.length);
                int n2 = random.nextInt(img.length);
                dicef_img.setImageResource(img[n1]);
                dices_img.setImageResource(img[n2]);

                dicef_img.setImageResource(img[n1]);
                dices_img.setImageResource(img[n2]);
//                double z = Math.toRadians(5);
//                i = (int)z;
//               setImg(i);
//                Toast.makeText(dice_home_page.this, "" + (n1 + 1) + "," + (n2 + 1), Toast.LENGTH_LONG).show();
                dice1_txt.setText("" + (n1 + 1));
                dice2_txt.setText("" + (n2 + 1));
                int z = Integer.parseInt(String.valueOf(n1));
                int s = Integer.parseInt(String.valueOf(n2));
                Vibrator vibe = (Vibrator) getSystemService(MainActivity.VIBRATOR_SERVICE);
                vibe.vibrate(100);
                int x = (z + 1) + (s + 1);
                sum_dicetxt.setText("" + x);

//                int resID=getResources().getIdentifier(String.valueOf(savedInstanceState), "raw", getPackageName());
//                MediaPlayer mediaPlayer=MediaPlayer.create(dice_home_page.this,resID);
//                dicef_img.setMaxWidth(mediaPlayer);

//                String mp3File = "raw/shake_dice.mp3";
//                AssetManager assetMan = getAssets();
//                MediaPlayer media = new MediaPlayer();
//                media.start();



                textToSpeech.speak(sum_dicetxt.getText().toString(),TextToSpeech.QUEUE_FLUSH,null); }
        });

        textToSpeech = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {
                if (i!=TextToSpeech.ERROR) {
                    textToSpeech.setLanguage(Locale.UK);
                } }});
    }

    private void binding() {
        roll_btn = (Button) findViewById(R.id.roll_btn);
        dicef_img = (ImageView) findViewById(R.id.dicef_img);
        dices_img = (ImageView) findViewById(R.id.dices_img);
        dice1_txt = (TextView) findViewById(R.id.dice1_txt);
        dice2_txt = (TextView) findViewById(R.id.dice2_txt);
        sum_dicetxt = (TextView) findViewById(R.id.sum_dicetxt);
    }
    private void anim(){

        RotateAnimation rotate = new RotateAnimation(10, 10);
        rotate.setDuration(100);

        dicef_img.startAnimation(rotate);
        dices_img.startAnimation(rotate);
    }
    private void anim1(){
        Animation animation = new AlphaAnimation(1,0);
        animation.setDuration(200);
        animation.setInterpolator(new LinearInterpolator());
        animation.setRepeatCount(Animation.RESTART);
        animation.setRepeatMode(Animation.REVERSE);
        dicef_img.startAnimation(animation);
    }

    private void animation() {
        final Animation anim1 = AnimationUtils.loadAnimation(dice_home_page.this, R.anim.shake);
        final Animation anim2 = AnimationUtils.loadAnimation(dice_home_page.this, R.anim.shake);

        dicef_img.startAnimation(anim1);
        dices_img.startAnimation(anim2); }

//    void setImage1(int z) {
//        Glide.with(dice_home_page.this)
//                .load(img[z])
//                .placeholder(R.drawable.ic_launcher_background)
//                .into(dicef_img);
//    }
//
//    void setImage2(int z) {
//        Glide.with(dice_home_page.this)
//                .load(img[z])
//                .placeholder(R.drawable.ic_launcher_background)
//                .into(dices_img);
//    }
}