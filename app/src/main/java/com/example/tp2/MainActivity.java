package com.example.tp2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    String number1 = "";
    String number2 = "";
    String sign="";
    Boolean eqPressed=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    void RefreshNumber(TextView t){
        t.setText(number1 + sign + number2);
    }

    public void OnEqualPress(View v){
        if (sign.length() != 0){
            float n1 = Float.parseFloat(number1);
            float n2 = Float.parseFloat(number2);
            float res = 0;
            if (sign.equals("+")){
                res = n1+n2;
            }
            if (sign.equals("-")){
                res = n1-n2;
            }
            if (sign.equals("*")){
                res = n1*n2;
            }
            if (sign.equals("/")){
                res = n1/n2;
            }
            number1 = "";
            number2 = String.valueOf(res);
            sign = "";
        }
        RefreshNumber(findViewById(R.id.textView));
        eqPressed=true;
    }
    
    public void OnNumberPress(View v){
        if (eqPressed){
            OnCPress(v);
        }
        eqPressed=false;
        Button b = (Button)v;
        number2 += b.getText().toString().replace(".",",");
        RefreshNumber(findViewById(R.id.textView));
    }

    public void OnSignPress(View v){
        if (sign.length() == 0){
            OnEqualPress(v);
        }
        eqPressed=false;
        Button b = (Button)v;
        sign = b.getText().toString();
        number1 = number2;
        number2 = "";
        RefreshNumber(findViewById(R.id.textView));

    }

    public void OnCPress(View v){
        number1 = "";
        number2 = "";
        sign= "";
        eqPressed=false;
        RefreshNumber(findViewById(R.id.textView));
    }
}
