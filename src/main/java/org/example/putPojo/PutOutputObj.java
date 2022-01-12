package org.example.putPojo;

public class PutOutputObj {

    private String name;
    private String job;
    private String updatedAt;

    public PutOutputObj() {

    }

    public PutOutputObj(String name, String job, String updatedAt) {
        this.name = name;
        this.job = job;
        this.updatedAt = updatedAt;
    }

    public String getName() {
        return name;
    }

    public String getJob() {
        return job;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    @Override
    public String toString() {
        return "Name :  " + this.name + "\nJob :  " + this.job + "\nUpdatedAt :  " + this.updatedAt;
    }
}
