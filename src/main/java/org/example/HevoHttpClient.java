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


    HevoHttpClient() {

        /**
         *Hevo Client constructor to set some default or initial values of parameters.
         **/
        page = -1;
        client = HttpClient.newHttpClient();
        REQ_TYPE = "";
    }

    private String getReqHandler() throws IOException, InterruptedException {
        Get obj = new Get();

        if (this.page == -1) {
            return obj.send(this.client, this.request, URL);
        }

        return obj.send(this.client, this.request, URL, page);

    }

    private String postReqHandler() throws IOException, InterruptedException {
        Post obj = new Post();
        return obj.send(this.client, this.request, URL, body);
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

    public void setPage(int page) {
        /**
         * Must be setted if user wants to search for a particular page of results.
         * It's only used in case of GET request.
         */
        this.page = page;
    }

    public void setRequestType(String req) {
        /**
         * Set's the type of request user want's to create.
         * It's a must for all types of request.
         */
        this.REQ_TYPE = req;
    }

    public void setUrl(String URL) {
        /**
         * Set the URL to send the request to.
         * It's a must in all types of request.
         */
        this.URL = URL;
    }

    public void setBody(String body) {
        /**
         * Set the body of the request in case of POST Or PUT request.
         */
        this.body = body;
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
