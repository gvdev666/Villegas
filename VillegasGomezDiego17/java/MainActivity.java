package com.villegasgomezdiego17;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    Button b1  ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnConvert.setOnClickListener(new View.OnClickListener() {
 
            @Override
            public void onClick(View v) {
                int pos = 0;
spin.setOnItemSelectedListener(new OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(
                            AdapterView<?> parent, View view, int position, long id) {
                        pos = position;
                    }

 @Override
 public void onNothingSelected(AdapterView<?> arg0) {
 // TODO Auto-generated method stub
 
 }
                });
            }
            });
            void showToast(CharSequence msg) {
                Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
            }

            btnConvert.setOnClickListener(new View.OnClickListener() {
 
                @Override
                public void onClick(View v) {
              
                if (txtEntry.getText().toString().trim().length() > 0){
                String textValue = txtEntry.getText().toString();
                lastValue = Integer.parseInt(textValue);
                double km, m, cm;
                
                if(pos==0){
                km = lastValue / 1000;
                showToast(lastValue + " m = " +  km + " km(s)");
                }else if(pos==1){
                m = lastValue * 1000;
                showToast(lastValue + " km(s) = " +  m + " m");
                }else{
                cm = lastValue * 100;
                showToast(lastValue + " m = " +  cm + " cm(s)");
                } 
                }
                else{
                showToast("Please Enter Value");
                
                }
                
                }
                });
    }
}