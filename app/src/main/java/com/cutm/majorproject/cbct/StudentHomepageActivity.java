package com.cutm.majorproject.cbct;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class StudentHomepageActivity extends AppCompatActivity {

    private ImageView mIVGotoCreditRecord;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_homepage);

        mIVGotoCreditRecord = findViewById(R.id.iv_credit_record);
        mIVGotoCreditRecord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StudentHomepageActivity.this, TaskViewActivity.class);
                startActivity(intent);
            }
        });
    }
}
