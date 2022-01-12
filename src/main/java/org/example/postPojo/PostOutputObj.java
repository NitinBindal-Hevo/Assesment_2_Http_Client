package org.example.postPojo;


public class PostOutputObj {

    private String name;
    private String job;
    private String id;
    public String createdAt;


    public PostOutputObj() {

    }

    public PostOutputObj(String name, String job, String id, String createdAt) {
        this.name = name;
        this.job = job;
        this.id = id;
        this.createdAt = createdAt;
    }

    public String getName() {
        return name;
    }

    public String getJob() {
        return job;
    }

    public String getId() {
        return id;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    @Override
    public String toString() {
        return "Name :  " + this.name + "\nJob :  " + this.job + "\nId :  " +
                this.id + "\nCreatedAt :  " + this.createdAt;
    }

}
