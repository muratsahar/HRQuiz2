package com.example.android.hrquiz;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;
public class q2Activity extends AppCompatActivity {
    //Define variables
    int click = 0;
    CheckBox cb1, cb2, cb3, cb4;
    Button a_Button;
    boolean iscb1Red, iscb2Red, iscb3Red, iscb4Red;

    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_q2);

        cb1 = (CheckBox) findViewById(R.id.cb1);
        cb2 = (CheckBox) findViewById(R.id.cb2);
        cb3 = (CheckBox) findViewById(R.id.cb3);
        cb4 = (CheckBox) findViewById(R.id.cb4);
        a_Button = (Button) findViewById(R.id.a_button);
    }

    @Override
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("click", click);
        bundle.putBoolean("iscb1Red", iscb1Red);
        bundle.putBoolean("iscb2Red", iscb2Red);
        bundle.putBoolean("iscb3Red", iscb3Red);
        bundle.putBoolean("iscb4Red", iscb4Red);
    }

    @Override
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        click = bundle.getInt("click");
        iscb1Red = bundle.getBoolean("iscb1Red");
        iscb2Red = bundle.getBoolean("iscb2Red");
        iscb3Red = bundle.getBoolean("iscb3Red");
        iscb4Red = bundle.getBoolean("iscb4Red");
        if (click == 1) {
            cb2.setBackgroundColor(Color.GREEN);
            cb3.setBackgroundColor(Color.GREEN);
            if (iscb1Red)
                cb1.setBackgroundColor(Color.RED);
            if (iscb4Red)
                cb4.setBackgroundColor(Color.RED);
            if (iscb3Red)
                cb1.setClickable(false);
            cb2.setClickable(false);
            cb3.setClickable(false);
            cb4.setClickable(false);
            a_Button.setText(R.string.q_next);
        }
    }

    public void answerListener(View v) {
        int numberOfCheckedBoxes = 0;
        if (click == 0) {

            if(!cb1.isChecked() && !cb2.isChecked() && !cb3.isChecked() && !cb4.isChecked()) {
                Toast.makeText(this, getString(R.string.no_ans), Toast.LENGTH_SHORT).show();
            }
            else if (cb1.isChecked() && cb2.isChecked() && cb3.isChecked() && !cb4.isChecked()) {
                MainActivity.incScore();
                cb1.setBackgroundColor(Color.GREEN);
                cb2.setBackgroundColor(Color.GREEN);
                cb3.setBackgroundColor(Color.GREEN);
                Toast.makeText(this, getString(R.string.right) + " " + MainActivity.getScore(), Toast.LENGTH_SHORT).show();
            } else {
                cb1.setBackgroundColor(Color.GREEN);
                cb2.setBackgroundColor(Color.GREEN);
                cb3.setBackgroundColor(Color.GREEN);
                cb4.setBackgroundColor(Color.RED);
                Toast.makeText(this, getString(R.string.wrong) + " " + MainActivity.getScore(), Toast.LENGTH_SHORT).show();
            }
            click = 1;
            a_Button.setText(R.string.q_next);

        } else {
            Intent q3Intent;
            q3Intent = new Intent(this, q3Activity.class);
            startActivity(q3Intent);
        }
    }
}