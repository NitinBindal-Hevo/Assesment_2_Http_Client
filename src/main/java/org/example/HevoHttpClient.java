package org.example;

import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;

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


    private Object getReqHandler() throws IOException, InterruptedException {
        Get obj = new Get();

        String res;
        if (this.page == -1) {

            res = obj.send(this.client, this.request, this.URL);
        }
        else
        {
            res = obj.send(this.client, this.request, this.URL, this.page);;
        }
        getObject res_obj = new getObject(res);
        return res_obj;

    }

    private Object postReqHandler() throws IOException, InterruptedException {
        Post obj = new Post();
        String res = obj.send(this.client, this.request, this.URL, this.body);

        ObjectMapper objectMapper = new ObjectMapper();
        postObject res_obj = objectMapper.readValue(res,postObject.class);
        return res_obj;

    }

    private Object putReqHandler() throws IOException, InterruptedException {
        Put obj = new Put();
        String res = obj.send(this.client, this.request, this.URL, this.body);

        ObjectMapper objectMapper = new ObjectMapper();
        putObject res_obj = objectMapper.readValue(res,putObject.class);
        return res_obj;

    }

    private Object deleteReqHandler() throws IOException, InterruptedException {
        Delete obj = new Delete();
        obj.send(this.client, this.request, this.URL);
//        return new Object();

        return null;
    }

    public int getPage() {
        return page;
    }


    public Object send() throws IOException, InterruptedException {
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
