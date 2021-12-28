package org.example.getPojo;

public class getSupportObj {

    private String url;
    private String text;

    public getSupportObj() {

    }

    public getSupportObj(String url, String text) {
        this.url = url;
        this.text = text;
    }

    public String getUrl() {
        return url;
    }

    public String getText() {
        return text;
    }

    @Override
    public String toString() {
        return "Url :  " + this.url + "\nText :  " + this.text;
    }

}
