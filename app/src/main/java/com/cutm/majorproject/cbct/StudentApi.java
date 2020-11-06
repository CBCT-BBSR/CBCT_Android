package com.cutm.majorproject.cbct;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface StudentApi {

    @GET("/student/{student_id}")
    Call<Student> getStudent(@Path("student_id") int student_id);
}
