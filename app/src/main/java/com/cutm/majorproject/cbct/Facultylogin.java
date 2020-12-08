package com.cutm.majorproject.cbct;

public class Facultylogin {


    private Long facultyID;
   // private String facultyName;
    private String password;


    public Facultylogin() {
    }

    public Facultylogin(Long facultyID,String password) {
        this.facultyID = facultyID;
      //  this.facultyName = facultyName;
        this.password = password;
    }

    public Long getFacultyID() {
        return facultyID;
    }

    public void setFacultyID(Long facultyID) {
        this.facultyID = facultyID;
    }

//    public String getFacultyName() {
//        return facultyName;
//    }
//
//    public void setFacultyName(String facultyName) {
//        this.facultyName = facultyName;
//    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
