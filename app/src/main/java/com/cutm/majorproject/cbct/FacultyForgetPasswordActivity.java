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

public class FacultyForgetPasswordActivity extends AppCompatActivity {

    private EditText mETFacultyForgetId;
    private EditText mETFacultyForgetPassword;
    private Button mBTNChangeFacultyPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faculty_forget_password);

        mETFacultyForgetId = findViewById(R.id.et_faculty_forget_id);
        mETFacultyForgetPassword = findViewById(R.id.et_faculty_forget_password);
        mBTNChangeFacultyPassword = findViewById(R.id.btn_change_faculty_password);

        mBTNChangeFacultyPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                changeFacultyPassword();
            }
        });
    }
    private void changeFacultyPassword()
    {
        Retrofit retrofit = new Retrofit.Builder ().
                baseUrl("http://192.168.42.146:9090/")
                .addConverterFactory (GsonConverterFactory.create ())
                .build ();

        FacultyLoginApi facultyLoginApi = retrofit.create (FacultyLoginApi.class);

        String Id = mETFacultyForgetId.getText().toString();
        String Password = mETFacultyForgetPassword.getText().toString();

        if(Id.isEmpty())
        {
            mETFacultyForgetId.setError("Field Cannot Be Empty ");
            mETFacultyForgetId.requestFocus();
            Toast.makeText(getApplicationContext()," Pls Try Again",Toast.LENGTH_LONG).show();
            return;
        }
        else if (Password.isEmpty())
        {
            mETFacultyForgetPassword.setError("Field Cannot Be Empty");
            mETFacultyForgetPassword.requestFocus();
            Toast.makeText(getApplicationContext(),"Pls Try Again",Toast.LENGTH_LONG).show();
            return;
        }

        long studentId = Long.parseLong(Id);
        Call<Integer> call = facultyLoginApi.FacultyForgotPassword(studentId,Password);
        call.enqueue(new Callback<Integer>() {
            @Override
            public void onResponse(Call<Integer> call, Response<Integer> response)
            {
                Integer message = response.body ();
//                String Id = mETFacultyForgetId.getText().toString();
//                String Password = mETFacultyForgetPassword.getText().toString();
                if (message == 1){
                    Intent intent =new Intent(FacultyForgetPasswordActivity.this, FacultyLoginActivity.class);
                    Toast.makeText (getApplicationContext (), "New Password Is Ready" , Toast.LENGTH_LONG).show ();
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
