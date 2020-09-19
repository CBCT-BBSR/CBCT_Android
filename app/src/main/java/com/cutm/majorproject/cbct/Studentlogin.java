package com.cutm.majorproject.cbct;

public class Studentlogin {


    private Long studentID;
    private String studentName;
    private String password;

    public Studentlogin() {
    }

    public Studentlogin(Long studentID, String studentName, String password) {
        this.studentID = studentID;
        this.studentName = studentName;
        this.password = password;
    }

    public Long getStudentID() {
        return studentID;
    }

    public void setStudentID(Long studentID) {
        this.studentID = studentID;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
