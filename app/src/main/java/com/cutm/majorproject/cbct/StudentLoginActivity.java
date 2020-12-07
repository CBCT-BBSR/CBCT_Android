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

public class StudentLoginActivity extends AppCompatActivity {

    private Button mBtnGotoStudentHomepage;
    private EditText mETStudentUsername;
    private EditText mETStudentPassword;
    private TextView mTVForgetPassword;




    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_login);

        mBtnGotoStudentHomepage = findViewById(R.id.btn_goto_student_homepage);
        mETStudentUsername = findViewById(R.id.et_student_username);
        mETStudentPassword = findViewById(R.id.et_student_password);
        mTVForgetPassword = findViewById(R.id.tv_forget_password);


        mTVForgetPassword.setOnClickListener(
                new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StudentLoginActivity.this, StudentForgetPasswordActivity.class);
                startActivity(intent);
            }
        });

        mBtnGotoStudentHomepage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                getStudent();
            }
        });
    }


    private void getStudent() {

            Retrofit retrofit = new Retrofit.Builder ().
                    baseUrl("http://192.168.42.146:9090/")
                    .addConverterFactory (GsonConverterFactory.create ())
                    .build ();
            StudentLoginApi studentLoginApi = retrofit.create (StudentLoginApi.class);

        String student = mETStudentUsername.getText().toString();
        String password = mETStudentPassword.getText().toString();

        if(student.isEmpty())
        {
            mETStudentUsername.setError("Field Cannot Be Empty ");
            mETStudentUsername.requestFocus();
            Toast.makeText(getApplicationContext()," Pls Try Again",Toast.LENGTH_LONG).show();
            return;
        }
        else if (password.isEmpty())
        {
            mETStudentPassword.setError("Field Cannot Be Empty");
            mETStudentPassword.requestFocus();
            Toast.makeText(getApplicationContext(),"Pls Try Again",Toast.LENGTH_LONG).show();
            return;
        }
        long studentId = Long.parseLong(student);
        Call<Studentlogin> call = studentLoginApi.getStudent(studentId,password);
        call.enqueue(new Callback<Studentlogin>() {
            @Override
            public void onResponse(Call<Studentlogin> call, Response<Studentlogin> response) {

                if (!response.isSuccessful ()) {
                    Toast.makeText(getApplicationContext(), "LOGIN FAILURE...", Toast.LENGTH_LONG).show();
                    Toast.makeText(getApplicationContext(), "INVALID DETAIL!!! PLS Try Again", Toast.LENGTH_LONG).show();
                    return;
                }
                Intent intent = new Intent(StudentLoginActivity.this,StudentHomepageActivity.class);
                startActivity(intent);
                Toast.makeText(getApplicationContext(), "LOGIN SUCCESS...", Toast.LENGTH_LONG).show();

            }

            @Override
            public void onFailure(Call<Studentlogin> call, Throwable t) {

             // Toast.makeText (getApplicationContext (), t.getMessage (), Toast.LENGTH_LONG).show ();
                Toast.makeText(getApplicationContext(), "LOGIN FAILURE...", Toast.LENGTH_LONG).show();
                Toast.makeText(getApplicationContext(), "INVALID DETAIL!!! PLS Try Again", Toast.LENGTH_LONG).show();

            }
        });

    }
}
