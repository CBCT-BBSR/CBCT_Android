package com.cutm.majorproject.cbct;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class StudentCgpaActivity extends AppCompatActivity {

    private Button cgpaCalc;
    private Button directCgpaCalc;
    private AlertDialog.Builder aleartDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_cgpa);

        cgpaCalc = findViewById(R.id.cgpaId);
        directCgpaCalc = findViewById(R.id.directcgpaId);

        cgpaCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(com.cutm.majorproject.cbct.StudentCgpaActivity.this, CGPACalc.class);
                startActivity(intent);
            }
        });

        directCgpaCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(com.cutm.majorproject.cbct.StudentCgpaActivity.this , directCgpaCalc.class);
                startActivity(intent);
            }
        });

    }

    /*@Override
      public void onBackPressed() {
        aleartDialog = new AlertDialog.Builder(com.cutm.majorproject.cbct.StudentCgpaActivity.this);
        aleartDialog.setTitle("Do you want to exit?");
        aleartDialog.setCancelable(false);
        aleartDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });

        aleartDialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        aleartDialog.show();
    }*/
}
