package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int oldValue = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        changeTextViewValueOnButtonClick();
    }

    private void changeTextViewValueOnButtonClick() {
        final String helloWorld = "Hello World!";
        final String byeWorld = "Bye World!";
        final TextView changingText = (TextView) findViewById(R.id.textView);
        final Button changeTextButton = (Button) findViewById(R.id.button);

        changeTextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(oldValue == 0){
                    changingText.setText(helloWorld);
                    oldValue = 1;
                } else {
                    changingText.setText(byeWorld);
                    oldValue = 0;
                }

                Animation animation = new AlphaAnimation(1.0f, 0.0f);
                animation.setDuration(300);
                changeTextButton.startAnimation(animation);

                Log.d("DEBUG","Button clicked!");
            }
        });
    }

}
