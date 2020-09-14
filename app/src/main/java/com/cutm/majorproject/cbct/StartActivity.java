package com.cutm.majorproject.cbct;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StartActivity extends AppCompatActivity {

    private Button mBtnGotoStudentLogin;
    private Button mBtnGotoFacultyLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

       // mBtnSubmit = findViewById(R.id.btn_submit);
        mBtnGotoStudentLogin = findViewById(R.id.btn_goto_student_login);
        mBtnGotoFacultyLogin = findViewById(R.id.btn_goto_faculty_login);

        mBtnGotoStudentLogin.setOnClickListener(new View.OnClickListener() {
         @Override
      public void onClick(View v) {
             Intent intent = new Intent(StartActivity.this,StudentLoginActivity.class);
                startActivity(intent);
         }
        });

        mBtnGotoFacultyLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StartActivity.this,FacultyLoginActivity.class);
                startActivity(intent);
            }
        });
       }
    }