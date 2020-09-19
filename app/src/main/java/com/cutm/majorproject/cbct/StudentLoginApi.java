package com.cutm.majorproject.cbct;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface StudentLoginApi {

    @GET("/studentlogin/{studentId}/{password}")
    Call<Studentlogin> getStudent(@Path("studentId") Long studentId, @Path("password") String password);

}
