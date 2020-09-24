package com.cutm.majorproject.cbct;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class FacultyLoginActivity extends AppCompatActivity {

    private Button mBtnGotoFacultyHomepage;
    private EditText mETFacultyUsername;
    private EditText mEtFacultyPassword;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faculty_login);

        mBtnGotoFacultyHomepage = findViewById(R.id.btn_goto_faculty_homepage);
        mETFacultyUsername = findViewById(R.id.et_faculty_username);
        mEtFacultyPassword = findViewById(R.id.et_faculty_password);

        mBtnGotoFacultyHomepage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                getFaculty();

            }
        });

    }

    private void getFaculty() {

        Retrofit retrofit = new Retrofit.Builder ().
                baseUrl("http://192.168.42.99:9091/")
                .addConverterFactory (GsonConverterFactory.create ())
                .build ();
        FacultyLoginApi facultyLoginApi = retrofit.create (FacultyLoginApi.class);

        String faculty = mETFacultyUsername.getText().toString();
        String password = mEtFacultyPassword.getText().toString();

        if(faculty.isEmpty())
        {
            mETFacultyUsername.setError("Field Cannot Be Empty ");
            mETFacultyUsername.requestFocus();
            Toast.makeText(getApplicationContext()," Pls Try Again",Toast.LENGTH_LONG).show();
            return;
        }
        else if (password.isEmpty())
        {
            mEtFacultyPassword.setError("Field Cannot Be Empty");
            mEtFacultyPassword.requestFocus();
            Toast.makeText(getApplicationContext(),"Pls Try Again",Toast.LENGTH_LONG).show();
            return;
        }
        long facultyId = Long.parseLong(faculty);
        Call<Facultylogin> call = facultyLoginApi.getFaculty(facultyId,password);
        call.enqueue(new Callback<Facultylogin>() {
            @Override
            public void onResponse(Call<Facultylogin> call, Response<Facultylogin> response) {

                if (!response.isSuccessful ()) {
                    Toast.makeText(getApplicationContext(), "LOGIN FAILURE...", Toast.LENGTH_LONG).show();
                    Toast.makeText(getApplicationContext(), "INVALID DETAIL!!! PLS Try Again", Toast.LENGTH_LONG).show();
                    return;
                }
                Intent intent = new Intent(FacultyLoginActivity.this,FacultyHomepageActivity.class);
                startActivity(intent);
                Toast.makeText(getApplicationContext(), "LOGIN SUCCESS...", Toast.LENGTH_LONG).show();

            }

            @Override
            public void onFailure(Call<Facultylogin> call, Throwable t) {

                // Toast.makeText (getApplicationContext (), t.getMessage (), Toast.LENGTH_LONG).show ();
                Toast.makeText(getApplicationContext(), "LOGIN FAILURE...", Toast.LENGTH_LONG).show();
                Toast.makeText(getApplicationContext(), "INVALID DETAIL!!! PLS Try Again", Toast.LENGTH_LONG).show();

            }
        });

    }

}
