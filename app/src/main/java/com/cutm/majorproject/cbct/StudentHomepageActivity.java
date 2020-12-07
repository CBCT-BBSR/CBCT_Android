package com.cutm.majorproject.cbct;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class StudentHomepageActivity extends AppCompatActivity {

    private ImageView mIVGotoCreditRecord;
    private ImageView mIVGotoCgpaCalculator;
    Button mBTNStudentLogout;
    public int count = 0;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_homepage);

        mIVGotoCreditRecord = findViewById(R.id.iv_credit_record);
        mIVGotoCgpaCalculator = findViewById(R.id.iv_calculator);
        mBTNStudentLogout = findViewById(R.id.btn_student_logout);

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

        mBTNStudentLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(StudentHomepageActivity.this, StudentLoginActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }
    @Override
    public void onBackPressed()
    {
        if(count == 0)
        {
            Toast.makeText(StudentHomepageActivity.this,"Are Sure to Go Back",Toast.LENGTH_LONG).show();
            count++;
        }
        else
        {
            Intent intent= new Intent(StudentHomepageActivity.this, StudentLoginActivity.class);
            startActivity(intent);
            finish();
        }
       // Toast.makeText(StudentHomepageActivity.this,"Are Sure to Go Back",Toast.LENGTH_LONG).show();

    }
}
