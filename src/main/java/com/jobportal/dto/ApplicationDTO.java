package com.jobportal.dto;

public class ApplicationDTO {

    private String userName;
    private String jobTitle;

    public ApplicationDTO() {
    }

    public ApplicationDTO(String userName, String jobTitle) {
        this.userName = userName;
        this.jobTitle = jobTitle;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }
}