package com.cutm.majorproject.cbct;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;



public class FacultyLoginActivity extends AppCompatActivity {

    private Button mBtnGotoFacultyHomepage;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faculty_login);

        mBtnGotoFacultyHomepage = findViewById(R.id.btn_goto_faculty_homepage);
        mBtnGotoFacultyHomepage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FacultyLoginActivity.this,FacultyHomepageActivity.class);
                startActivity(intent);
            }
        });
    }
}
