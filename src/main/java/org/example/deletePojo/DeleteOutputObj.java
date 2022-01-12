package org.example.deletePojo;

public class DeleteOutputObj {

    private int statusCode;

    DeleteOutputObj() {

    }

    public DeleteOutputObj(int status) {
        this.statusCode = status;
    }

    public int getStatusCode() {
        return statusCode;
    }

    @Override
    public String toString() {
        return "StatusCode :  " + this.statusCode;
    }

}
