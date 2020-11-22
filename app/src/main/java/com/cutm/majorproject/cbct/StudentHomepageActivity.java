package com.cutm.majorproject.cbct;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class StudentHomepageActivity extends AppCompatActivity {

    private ImageView mIVGotoCreditRecord;
    private ImageView mIVGotoCgpaCalculator;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_homepage);

        mIVGotoCreditRecord = findViewById(R.id.iv_credit_record);
        mIVGotoCgpaCalculator = findViewById(R.id.iv_calculator);

        //Go to credit record page----
        mIVGotoCreditRecord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StudentHomepageActivity.this, TaskViewActivity.class);
                startActivity(intent);
            }
        });

        // Go to cgpa calculator-------

        mIVGotoCgpaCalculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(StudentHomepageActivity.this,StudentCgpaActivity.class);
                startActivity(intent);
            }
        });


    }
}
