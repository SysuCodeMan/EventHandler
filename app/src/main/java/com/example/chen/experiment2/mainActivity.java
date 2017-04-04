package com.example.chen.experiment2;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by Chen on 2016/10/3.
 */
public class mainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_page);
        Button basicButton = (Button)findViewById(R.id.basic);

        basicButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(mainActivity.this, basicActivity.class);
                startActivity(intent);
            }
        });

        Button extendButton = (Button)findViewById(R.id.extend);
        extendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(mainActivity.this, extendActivity.class);
                startActivity(intent);
            }
        });
    }
}
