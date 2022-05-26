package com.app.villegasgomezdiego16;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class RusiaActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        View v = findViewById(R.id.button4);
        v.setOnClickListener(this);

    }

    @Override
    public void onClick(View arg0) {
        if (arg0.getId() == R.id.button4) {
            Intent intent = new Intent(this, MainActivity.class);

            this.startActivity(intent);
        }
    }
}