package com.cutm.majorproject.cbct;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class StudentLoginActivity extends AppCompatActivity {

    private Button mBtnGotoStudentHomepage;


    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_login);

        mBtnGotoStudentHomepage = findViewById(R.id.btn_goto_student_homepage);

        mBtnGotoStudentHomepage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StudentLoginActivity.this,StudentHomepageActivity.class);
                startActivity(intent);
            }
        });
    }
}
