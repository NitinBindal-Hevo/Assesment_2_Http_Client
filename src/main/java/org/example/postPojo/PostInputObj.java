package org.example.postPojo;

public class PostInputObj {

    String name;
    String job;

    public PostInputObj() {

    }

    public PostInputObj(String name, String job) {
        this.name = name;
        this.job = job;
    }

    public String getName() {
        return name;
    }

    public String getJob() {
        return job;
    }
}
