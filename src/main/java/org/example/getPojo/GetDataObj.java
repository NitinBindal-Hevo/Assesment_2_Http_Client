package org.example.getPojo;

public class GetDataObj {

    private String id;
    private String email;
    private String first_name;
    private String last_name;
    private String avatar;

    public GetDataObj() {

    }

    public GetDataObj(String id, String email, String first_name, String last_name, String avatar) {
        this.id = id;
        this.email = email;
        this.first_name = first_name;
        this.last_name = last_name;
        this.avatar = avatar;
    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getAvatar() {
        return avatar;
    }

    @Override
    public String toString() {
        return "---------------------------------\n" + "Id :  " + this.id + "\nEmail :  " + this.email +
                "\nFirst Name :  " + this.first_name + "\nLast Name :  " + this.last_name +
                "\nAvatar :  " + this.avatar + "\n---------------------------------\n";
    }

}
