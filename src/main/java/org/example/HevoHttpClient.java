package org.example;

import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.deletePojo.deleteOutputObj;
import org.example.getPojo.getInputObj;
import org.example.getPojo.getOutputObj;
import org.example.postPojo.postInputObj;
import org.example.postPojo.postOutputObj;
import org.example.putPojo.putInputObj;
import org.example.putPojo.putOutputObj;
import org.example.requests.Delete;
import org.example.requests.Get;
import org.example.requests.Post;
import org.example.requests.Put;

public class HevoHttpClient<T> {

    private String REQ_TYPE;
    private String URL;
    private T payload;
    private HttpClient client;
    private HttpRequest request;
    private ObjectMapper mapper;

    public HevoHttpClient(String REQ_TYPE, String URL) {
        /**
         *Hevo Client constructor to set some default or initial values of parameters.
         * Used for DELETE request
         **/

        this.client = HttpClient.newHttpClient();
        this.REQ_TYPE = REQ_TYPE;
        this.URL = URL;
    }

    public HevoHttpClient(String REQ_TYPE, String URL, T payload) {

        /**
         *Hevo Client constructor to set some default or initial values of parameters.
         * Used for GET, POST & PUT request
         **/
        this.client = HttpClient.newHttpClient();
        this.REQ_TYPE = REQ_TYPE;
        this.URL = URL;
        this.payload = payload;
        this.mapper = new ObjectMapper();
    }


    private getOutputObj getReqHandler() throws IOException, InterruptedException {
        Get obj = new Get();
        int page = ((getInputObj) payload).getPage();
        if (page == -1) {

            return obj.send(this.client, this.request, this.URL);
        }

        return obj.send(this.client, this.request, this.URL, page);


    }

    private postOutputObj postReqHandler() throws IOException, InterruptedException {
        Post obj = new Post();
        return obj.send(this.client, this.request, this.URL, (postInputObj) this.payload);
    }

    private putOutputObj putReqHandler() throws IOException, InterruptedException {
        Put obj = new Put();
        return obj.send(this.client, this.request, this.URL, (putInputObj) this.payload);

    }

    private deleteOutputObj deleteReqHandler() throws IOException, InterruptedException {
        Delete obj = new Delete();
        return obj.send(this.client, this.request, this.URL);
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
