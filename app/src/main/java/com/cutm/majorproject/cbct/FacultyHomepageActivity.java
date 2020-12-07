package com.cutm.majorproject.cbct;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FacultyHomepageActivity extends AppCompatActivity {


    Button mBtnGotoFacultyFetchDetails;
    EditText mETFacultySearchStudentid;
    public int count = 0;


    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faculty_homepage);

        mBtnGotoFacultyFetchDetails = (Button) findViewById(R.id.btn_goto_faculty_fetch_details);
        mETFacultySearchStudentid =(EditText) findViewById(R.id.et_faculty_search_studentid);

        mBtnGotoFacultyFetchDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 String Id = mETFacultySearchStudentid.getText().toString();

                if(Id.isEmpty())
                {
                    mETFacultySearchStudentid.setError("Field Cannot Be Empty ");
                    mETFacultySearchStudentid.requestFocus();
                    Toast.makeText(getApplicationContext()," Pls Try Again",Toast.LENGTH_LONG).show();
                    return;
                }
                Intent intent = new Intent(FacultyHomepageActivity.this,FacultySearchResult.class);
                intent.putExtra("StudentId",Id);
                startActivity(intent);

            }
        });


    }

    private void getDetails() {


        Retrofit retrofit = new Retrofit.Builder ().
                baseUrl("http://192.168.43.57:9090/")
                .addConverterFactory (GsonConverterFactory.create ())
                .build ();

        StudentApi studentApi = retrofit.create (StudentApi.class);
        final String Id = mETFacultySearchStudentid.getText().toString();
        if(Id.isEmpty())
        {
            mETFacultySearchStudentid.setError("Field Cannot Be Empty ");
            mETFacultySearchStudentid.requestFocus();
            Toast.makeText(getApplicationContext()," Pls Try Again",Toast.LENGTH_LONG).show();
            return;
        }
        int student_id = Integer.parseInt(Id);
        Call<Student> call = studentApi.getStudent(student_id);
        call.enqueue(new Callback<Student>() {
            @Override
            public void onResponse(Call<Student> call, Response<Student> response) {
                if (!response.isSuccessful ()) {
                    Toast.makeText(getApplicationContext(), "STUDENT DOESN'T EXISTS...", Toast.LENGTH_LONG).show();
                    Toast.makeText(getApplicationContext(), "INVALID DETAIL!!! PLS Try Again", Toast.LENGTH_LONG).show();
                    return;
                }
                Intent intent = new Intent(FacultyHomepageActivity.this,FacultySearchResult.class);
                intent.putExtra("StudentId",Id);
                startActivity(intent);

            }

            @Override
            public void onFailure(Call<Student> call, Throwable t) {

                Toast.makeText(getApplicationContext(), "STUDENT DOESN'T EXISTS...", Toast.LENGTH_LONG).show();
                Toast.makeText(getApplicationContext(), "INVALID DETAIL!!! PLS Try Again", Toast.LENGTH_LONG).show();

            }
        });
    }
    @Override
    public void onBackPressed()
    {
        if(count == 0)
        {
            Toast.makeText(FacultyHomepageActivity.this,"Are Sure to Go Back",Toast.LENGTH_LONG).show();
            count++;
        }
        else
        {
            Intent intent= new Intent(FacultyHomepageActivity.this, FacultyLoginActivity.class);
            startActivity(intent);
            finish();
        }
        // Toast.makeText(StudentHomepageActivity.this,"Are Sure to Go Back",Toast.LENGTH_LONG).show();

    }
}
