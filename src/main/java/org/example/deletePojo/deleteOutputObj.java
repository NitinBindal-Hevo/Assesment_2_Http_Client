package org.example.deletePojo;

public class deleteOutputObj {

    private int statusCode;

    deleteOutputObj() {

    }

    public deleteOutputObj(int status) {
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
