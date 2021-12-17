package org.example;

import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.util.List;

public class HevoHttpClient {

    private String REQ_TYPE;
    private String URL;
    private String body;
    private HttpClient client;
    private HttpRequest request;
    private int page;


    HevoHttpClient(String REQ_TYPE, String URL) {

        /**
         *Hevo Client constructor to set some default or initial values of parameters.
         * Used for GET and POST request.
         **/
        client = HttpClient.newHttpClient();
        this.REQ_TYPE = REQ_TYPE;
        this.URL = URL;
        this.page = -1;
    }

    HevoHttpClient(String REQ_TYPE, String URL, int page) {

        /**
         *Hevo Client constructor to set some default or initial values of parameters.
         * Used for GET request
         **/
        client = HttpClient.newHttpClient();
        this.REQ_TYPE = REQ_TYPE;
        this.URL = URL;
        this.page = page;
    }


    HevoHttpClient(String REQ_TYPE, String URL, String body) {

        /**
         *Hevo Client constructor to set some default or initial values of parameters.
         * Used for POST & PUT request
         **/
        client = HttpClient.newHttpClient();
        this.REQ_TYPE = REQ_TYPE;
        this.URL = URL;
        this.body = body;
    }


    private String getReqHandler() throws IOException, InterruptedException {
        Get obj = new Get();

        if (this.page == -1) {
            return obj.send(this.client, this.request, this.URL);
        }

        return obj.send(this.client, this.request, this.URL, this.page);

    }

    private String postReqHandler() throws IOException, InterruptedException {
        Post obj = new Post();
        return obj.send(this.client, this.request, this.URL, this.body);
    }

    private String putReqHandler() throws IOException, InterruptedException {
        Put obj = new Put();
        return obj.send(this.client, this.request, this.URL, this.body);
    }

    private String deleteReqHandler() throws IOException, InterruptedException {
        Delete obj = new Delete();
        obj.send(this.client, this.request, this.URL);
        return null;
    }

    public int getPage() {
        return page;
    }


    public String send() throws IOException, InterruptedException {
        /**
         * Send function to be called only when all the parameters need to build a request is set.
         * This function primarily reponses to 4 types of request namely GET,POST,PUT,DELETE
         */
        switch (this.REQ_TYPE) {
            case "GET":
                return getReqHandler();
            case "POST":
                return postReqHandler();
            case "PUT":
                return putReqHandler();
            case "DELETE":
                return deleteReqHandler();
            default:
                System.out.println("Please Enter correct REQ_TYPE !");
        }

        return null;
    }


}
