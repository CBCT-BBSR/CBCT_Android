package com.cutm.majorproject.cbct;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FacultySearchResult extends AppCompatActivity {

    TextView mTVFacultyStudentId;
    TextView mTVFacultyStudentName;
    TextView mTVFacultyStudentEmail;
    TextView mTVFacultyStudentAcadamicYear;
    TextView mTVFacultyStudentBranch;
    TextView mTVFacultyStudentSchool;
    Button mBTNFacultyLogout;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faculty_search_result);
         mTVFacultyStudentId = (TextView) findViewById(R.id.tv_Student_Id);
         mTVFacultyStudentName = (TextView) findViewById(R.id.tv_Student_Name);
         mTVFacultyStudentEmail = (TextView) findViewById(R.id.tv_Student_Email);
         mTVFacultyStudentAcadamicYear = (TextView) findViewById(R.id.tv_Student_Acadamic_year);
         mTVFacultyStudentBranch = (TextView) findViewById(R.id.tv_Student_Branch);
         mTVFacultyStudentSchool = (TextView) findViewById(R.id.tv_Student_School);
         mBTNFacultyLogout = (Button) findViewById(R.id.btn_faculty_logout);

         getResult();
    }

    private void getResult() {
        Retrofit retrofit = new Retrofit.Builder ().
                baseUrl("http://192.168.42.146:9090/")
                .addConverterFactory (GsonConverterFactory.create ())
                .build ();

        StudentApi studentApi = retrofit.create (StudentApi.class);
        Intent intent = getIntent();
        final String Student_Id = intent.getStringExtra("StudentId");
        int student_id = Integer.parseInt(Student_Id);
        Call<Student> call = studentApi.getStudent(student_id);
        call.enqueue(new Callback<Student>() {
            @Override
            public void onResponse(Call<Student> call, Response<Student> response) {
                if (!response.isSuccessful ()) {
                    Toast.makeText(getApplicationContext(), "STUDENT DOESN'T EXISTS...", Toast.LENGTH_LONG).show();
                    Toast.makeText(getApplicationContext(), "INVALID DETAIL!!! PLS Try Again", Toast.LENGTH_LONG).show();
                    return;
                }
              Student student = response.body();
                     mTVFacultyStudentId.setText(Student_Id);
                     mTVFacultyStudentName.setText(student.getStudent_name());
                     mTVFacultyStudentEmail.setText(student.getEmail());
                     mTVFacultyStudentAcadamicYear.setText(student.getAcademic_year());
                     mTVFacultyStudentBranch.setText(student.getBranch());
                     mTVFacultyStudentSchool.setText(student.getSchool());


            }

            @Override
            public void onFailure(Call<Student> call, Throwable t) {


                Toast.makeText(getApplicationContext(), "STUDENT DOESN'T EXISTS...", Toast.LENGTH_LONG).show();
                Toast.makeText(getApplicationContext(), "INVALID DETAIL!!! PLS Try Again", Toast.LENGTH_LONG).show();

            }
        });

        mBTNFacultyLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent intent= new Intent(FacultySearchResult.this, FacultyLoginActivity.class);
                startActivity(intent);
                finish();

            }
        });



    }

}
