package com.example.android.hrquiz;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.android.hrquiz.MainActivity;
import com.example.android.hrquiz.R;

public class q3Activity extends AppCompatActivity {
     int click;
     EditText eText;
     Button a_button;
     boolean eTextStatus;
    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_q3);
        eText = (EditText) findViewById(R.id.eText);
        a_button = (Button) findViewById(R.id.a_button);
    }
    @Override
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("click", click);
        bundle.putBoolean("eTextStatus",eTextStatus);
    }
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        click = savedInstanceState.getInt("click");
        eTextStatus = savedInstanceState.getBoolean("eTextStatus");
    }
    public void answerListener(View v){
        if(click == 0) {
            if(eText.getText().toString().equals("")){
                Toast.makeText(this, R.string.no_ans, Toast.LENGTH_SHORT).show();
            }else{
                if(eText.getText().toString().toLowerCase().equals(getString(R.string.q3_answer))){
                    MainActivity.incScore();
                    eText.setBackgroundColor(Color.GREEN);
                    eTextStatus = true;

                    Toast.makeText(this, getString(R.string.right) + " " + MainActivity.getScore(), Toast.LENGTH_SHORT).show();
                }else{
                    eText.setBackgroundColor(Color.RED);
                    Toast.makeText(this, getString(R.string.wrong) + " " + MainActivity.getScore(), Toast.LENGTH_SHORT).show();
                }
                click = 1;
                a_button.setText(R.string.q_next);
            }
        }else{
            Intent q4Intent = new Intent(this, q4Activity.class);
            startActivity(q4Intent);
        }
    }
}