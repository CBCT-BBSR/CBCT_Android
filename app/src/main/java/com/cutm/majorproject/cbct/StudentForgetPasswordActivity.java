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

public class StudentForgetPasswordActivity extends AppCompatActivity {

    private EditText mETStudentForgetId;
    private EditText mETStudentForgetPassword;
    private Button mBTNChangeStudentPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_forget_password);

        mETStudentForgetId = findViewById(R.id.et_student_forget_id);
        mETStudentForgetPassword = findViewById(R.id.et_student_forget_password);
        mBTNChangeStudentPassword = findViewById(R.id.btn_change_student_password);


        mBTNChangeStudentPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                changeStudentPassword();
            }
        });
    }

    private void changeStudentPassword()
    {
        Retrofit retrofit = new Retrofit.Builder ().
                baseUrl("http://192.168.42.146:9090/")
                .addConverterFactory (GsonConverterFactory.create ())
                .build ();

        StudentLoginApi studentLoginApi = retrofit.create (StudentLoginApi.class);

        String Id = mETStudentForgetId.getText().toString();
        String Password = mETStudentForgetPassword.getText().toString();

        if(Id.isEmpty())
        {
            mETStudentForgetId.setError("Field Cannot Be Empty ");
            mETStudentForgetId.requestFocus();
            Toast.makeText(getApplicationContext()," Pls Try Again",Toast.LENGTH_LONG).show();
            return;
        }
        else if (Password.isEmpty())
        {
            mETStudentForgetPassword.setError("Field Cannot Be Empty");
            mETStudentForgetPassword.requestFocus();
            Toast.makeText(getApplicationContext(),"Pls Try Again",Toast.LENGTH_LONG).show();
            return;
        }

        long studentId = Long.parseLong(Id);
        Call<Integer> call = studentLoginApi.StudentForgotPassword(studentId,Password);
        call.enqueue(new Callback<Integer>() {
            @Override
            public void onResponse(Call<Integer> call, Response<Integer> response)
            {
                Integer message = response.body ();
//                String Id = mETStudentForgetId.getText().toString();
//                String Password = mETStudentForgetPassword.getText().toString();
                if (message == 1){
                    Intent intent =new Intent(StudentForgetPasswordActivity.this, StudentLoginActivity.class);
                    Toast.makeText (getApplicationContext (), "New Password Is Ready", Toast.LENGTH_LONG).show ();
                    startActivity(intent);
                }
                else{
                    Toast.makeText (getApplicationContext (), "Invalid StudentId :" +response.code (), Toast.LENGTH_LONG).show ();
                }

            }

            @Override
            public void onFailure(Call<Integer> call, Throwable t) {

                Toast.makeText (getApplicationContext (), t.getMessage (), Toast.LENGTH_LONG).show ();

            }
        });
    }
}
