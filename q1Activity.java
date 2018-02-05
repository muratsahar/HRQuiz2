package com.example.android.hrquiz;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

public class q1Activity extends AppCompatActivity {

    //define variables
    RadioButton rb1, rb2, rb3, rb4;
    Button a_btn;
    int click = 0;
    boolean isrb1red, isrb2red, isrb3red, isrb4red;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //arrange UI
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_q1);

        //Transfer name
        Toast.makeText(this, "Good Luck " + MainActivity.getUserName() + "\nPassing score is 3", Toast.LENGTH_SHORT).show();
        //transfer components from XML to java. Only right answer is rb3
        rb1 = (RadioButton) findViewById(R.id.rb1);
        rb2 = (RadioButton) findViewById(R.id.rb2);
        rb3 = (RadioButton) findViewById(R.id.rb3);
        rb4 = (RadioButton) findViewById(R.id.rb4);
        a_btn = (Button) findViewById(R.id.a_btn);
    }

    @Override
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("click", click);
        bundle.putBoolean("isrb1Red", isrb1red);
        bundle.putBoolean("isrb2Red", isrb2red);
        bundle.putBoolean("isrb3Red", isrb3red);
        bundle.putBoolean("isrb4Red", isrb4red);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        click = savedInstanceState.getInt("click");
        isrb1red = savedInstanceState.getBoolean("isrb1red");
        isrb2red = savedInstanceState.getBoolean("isrb2red");
        isrb3red = savedInstanceState.getBoolean("isrb3red");
        isrb4red = savedInstanceState.getBoolean("isrb4red");
    }

    public void rb1Listener(View v) {
        rb2.setChecked(false);
        rb3.setChecked(false);
        rb4.setChecked(false);
    }

    public void rb2Listener(View v) {
        rb1.setChecked(false);
        rb3.setChecked(false);
        rb4.setChecked(false);
    }

    public void rb3Listener(View v) {
        rb1.setChecked(false);
        rb2.setChecked(false);
        rb4.setChecked(false);
    }

    public void rb4Listener(View v) {
        rb1.setChecked(false);
        rb2.setChecked(false);
        rb3.setChecked(false);
    }

    public void a_btnListener(View v) {
        if (click == 0) {
            if (!rb1.isChecked() && !rb2.isChecked() && !rb3.isChecked() && !rb4.isChecked()) {
                Toast.makeText(this, R.string.no_ans, Toast.LENGTH_SHORT).show();
            } else {
                if (rb2.isChecked()) {
                    MainActivity.incScore();
                    rb2.setBackgroundColor(Color.GREEN);
                    Toast.makeText(this, getString(R.string.right) + " " + MainActivity.getScore(), Toast.LENGTH_SHORT).show();
                } else {
                    rb2.setBackgroundColor(Color.GREEN);
                    if (rb1.isChecked()) {
                        rb1.setBackgroundColor(Color.RED);
                        isrb1red = true;
                    } else if (rb3.isChecked()) {
                        rb3.setBackgroundColor(Color.RED);
                        isrb3red = true;
                    } else if (rb4.isChecked()) {
                        rb4.setBackgroundColor(Color.RED);
                        isrb4red = true;
                    }
                    Toast.makeText(this, getString(R.string.wrong) + " " + MainActivity.getScore(), Toast.LENGTH_SHORT).show();
                }
                rb1.setClickable(false);
                rb2.setClickable(false);
                rb3.setClickable(false);
                rb4.setClickable(false);
                a_btn.setText(R.string.q_next);
                click = 1;
            }
        } else {
            Intent question2Intent = new Intent(q1Activity.this, q2Activity.class);
            startActivity(question2Intent);
        }
    }
}

