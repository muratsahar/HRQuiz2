package com.example.android.hrquiz;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static android.view.WindowManager.*;

public class MainActivity extends AppCompatActivity {

    //define variables
    EditText etName;
    private static String name;
    private static int score;
    Button btButton;
    TextView tvWelcome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Typeface tf=Typeface.createFromAsset(getAssets(),"alex.ttf");

        //change standart UI
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(LayoutParams.FLAG_FULLSCREEN, LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        //relation xml and java
        btButton =(Button)findViewById(R.id.btButton);
        tvWelcome=(TextView)findViewById(R.id.tvWelcome);




        //define text type
        Typeface tfAlex=Typeface.createFromAsset(getAssets(), "alex.ttf");
        tvWelcome.setTypeface(tfAlex);


    }

    public void startButtonListener(View v){
        //take users name put in var.
        etName=(EditText)findViewById(R.id.etName);
        name=etName.getText().toString();
        //if it empty?
        if(name.equals("")){
            Toast.makeText(this,"Please input name",Toast.LENGTH_SHORT).show();
        }else {
            Intent q1Intent=new Intent(this, q1Activity.class);
            startActivity(q1Intent);
        }
    }

        public static String getUserName(){

        return name;
        }

         public static int getScore(){

            return score;
         }

         public static void incScore(){

             score++;
         }


}











