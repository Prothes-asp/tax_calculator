package com.aspprothesbarai.taxcalculation.SplashScreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;
import com.aspprothesbarai.taxcalculation.MainActivity;
import com.aspprothesbarai.taxcalculation.R;

public class SplashScreen extends AppCompatActivity {
    private int progress;
    private TextView tvId,desId;
    private ImageView imgId;
    private Animation animation1,animation2,animation3,animation4;
    private LottieAnimationView animationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.LAYOUT_IN_DISPLAY_CUTOUT_MODE_SHORT_EDGES,WindowManager.LayoutParams.LAYOUT_IN_DISPLAY_CUTOUT_MODE_SHORT_EDGES);
        this.getWindow().setStatusBarColor(getResources().getColor(R.color.orange));
        this.getWindow().setNavigationBarColor(getResources().getColor(R.color.orange));
        this.getSupportActionBar().hide();
        setContentView(R.layout.splash_screen);

        tvId = findViewById(R.id.tvId);
        desId = findViewById(R.id.desId);
        imgId = findViewById(R.id.imgId);

        animationView = findViewById(R.id.animationView2);

        animation1 = AnimationUtils.loadAnimation(this,R.anim.up_from_bottom_slow);
        animation2 = AnimationUtils.loadAnimation(this,R.anim.zoom_in);
        animation3 = AnimationUtils.loadAnimation(this,R.anim.fade_in);
        animation4 = AnimationUtils.loadAnimation(this,R.anim.move);
        tvId.setAnimation(animation1);
        desId.setAnimation(animation4);
        imgId.setAnimation(animation2);




        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                //ProgressBar
                startTheProgress();
                //Go Home Page
                goHomeActivity();
            }
        });
        thread.start();



    }

    // Start Progress....
    public void startTheProgress(){
        int lottieDuration = (int) animationView.getDuration();
        for (progress = lottieDuration; progress<=100; progress = progress + 50){
            try {
                Thread.sleep(1000);
                animationView.setProgress(progress);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    // Go Home Page
    public void goHomeActivity(){
        Intent intent = new Intent(SplashScreen.this, MainActivity.class);
        startActivity(intent);
        finish();
    }

}