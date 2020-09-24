package com.cutm.majorproject.cbct;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface FacultyLoginApi {

    @GET("/facultylogin/{facultyId}/{password}")
    Call<Facultylogin> getFaculty(@Path("facultyId") Long facultyId, @Path("password") String password);

}
