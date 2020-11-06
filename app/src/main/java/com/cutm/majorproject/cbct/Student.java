package com.cutm.majorproject.cbct;

public class Student {

    private int student_no;
    private int student_id;
    private String student_name;
    private String password;
    private String academic_year;
    private String batch_id;
    private String email;
    private String school;
    private String branch;
    private String department;

    public Student() {
    }

    public Student(int student_no, int student_id, String student_name, String password, String academic_year, String batch_id, String email, String school, String branch, String department) {
        this.student_no = student_no;
        this.student_id = student_id;
        this.student_name = student_name;
        this.password = password;
        this.academic_year = academic_year;
        this.batch_id = batch_id;
        this.email = email;
        this.school = school;
        this.branch = branch;
        this.department = department;
    }

    public int getStudent_no() {
        return student_no;
    }

    public void setStudent_no(int student_no) {
        this.student_no = student_no;
    }

    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public String getStudent_name() {
        return student_name;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAcademic_year() {
        return academic_year;
    }

    public void setAcademic_year(String academic_year) {
        this.academic_year = academic_year;
    }

    public String getBatch_id() {
        return batch_id;
    }

    public void setBatch_id(String batch_id) {
        this.batch_id = batch_id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
