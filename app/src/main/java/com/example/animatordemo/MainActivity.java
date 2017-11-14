package com.example.animatordemo;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private AnimatorSet set1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView text = (TextView) findViewById(R.id.text);
        //text.animate().alpha(0f).translationX(0f).setDuration(3000);
        final ImageView image_view = (ImageView) findViewById(R.id.image_view);
        final ObjectAnimator anim2 = ObjectAnimator.ofFloat(image_view,"alpha",1f,0f,1f);
        ObjectAnimator anim = ObjectAnimator.ofFloat(text,"translationX",-500f,0f);
        ObjectAnimator animator = ObjectAnimator.ofFloat(text,"alpha",1f,0f,1f);
        ObjectAnimator animator2 = ObjectAnimator.ofFloat(text,"rotation",0f,360f);
        AnimatorSet set = new AnimatorSet();
        set.play(animator).with(animator2).after(anim);
        set.setDuration(5000);
        set.start();
        animator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                set1 = new AnimatorSet();
                image_view.setVisibility(View.VISIBLE);
                set1.play(anim2);
                set1.setDuration(3000);
                set1.start();
            }
        });
        anim2.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                set1.start();
            }
        });
    }
}
