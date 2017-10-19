package com.example.sst.animation;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {


    @Bind(R.id.imageView)
    ImageView imageView;
    @Bind(R.id.imageView2)
    ImageView imageView2;
    @Bind(R.id.imageView3)
    ImageView imageView3;
    @Bind(R.id.button)
    Button button;
    @Bind(R.id.tv2)
    TextView tv2;

    private int w1;
    private ArrayList<String> titleList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        ViewTreeObserver vto2 = imageView.getViewTreeObserver();
        vto2.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                imageView.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                /// textView.append("\n\n"+imageView.getHeight()+","+imageView.getWidth());
                w1 = imageView.getWidth();
            }
        });
        //   inDateText();
    }

    public void inDateText() {


    }


    public void inDate() {
        WindowManager windowManager = getWindowManager();
        imageView.setVisibility(View.VISIBLE);
        imageView2.setVisibility(View.VISIBLE);
        int width = windowManager.getDefaultDisplay().getWidth();
        int height = windowManager.getDefaultDisplay().getHeight();
        Animation translateAnimation = new TranslateAnimation(0, width / 2 - w1, 0, 0);
        translateAnimation.setDuration(1000);
        translateAnimation.setFillAfter(true);//设置动画结束后保持当前的位置（即不返回到动画开始前的位置）
        imageView.startAnimation(translateAnimation);
        Animation translateAnimation2 = new TranslateAnimation(0, -(width / 2 - w1), 0, 0);
        translateAnimation2.setDuration(1000);
        translateAnimation2.setFillAfter(true);//设置动画结束后保持当前的位置（即不返回到动画开始前的位置）
        imageView2.startAnimation(translateAnimation2);
        translateAnimation2.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                imageView.setVisibility(View.INVISIBLE);
                imageView2.setVisibility(View.INVISIBLE);
                imageView3.setVisibility(View.VISIBLE);
                AnimationSet animationSet = new AnimationSet(true);
                Animation scaleAnimation = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
                scaleAnimation.setFillBefore(true);//如果fillBefore的值为true，则动画执行后，控件将回到动画执行之前的状态
                scaleAnimation.setRepeatMode(Animation.REVERSE);
                scaleAnimation.setStartOffset(0);
                Animation alphaAnimation = new AlphaAnimation(0, 1);
                Animation rotateAnimation = new RotateAnimation(0, 360, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
                rotateAnimation.setFillAfter(true);
                alphaAnimation.setFillAfter(true);
                animationSet.addAnimation(scaleAnimation);
                animationSet.addAnimation(alphaAnimation);
                animationSet.addAnimation(rotateAnimation);
                animationSet.setDuration(2500);
                imageView3.startAnimation(animationSet);
                animationSet.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                startActivity(new Intent(MainActivity.this, TextActivity.class));
                            }
                        }, 1000);
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }

    @OnClick(R.id.button)
    public void onViewClicked() {
        inDate();
    }
}
