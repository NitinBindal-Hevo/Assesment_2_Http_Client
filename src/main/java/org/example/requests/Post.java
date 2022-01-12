package org.example.requests;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.postPojo.PostInputObj;
import org.example.postPojo.PostOutputObj;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Post {

    ObjectMapper mapper;

    public Post() {
        mapper = new ObjectMapper();
    }

    public PostOutputObj send(HttpClient client, HttpRequest request, String URL, PostInputObj payload) throws IOException, InterruptedException {


        String body = mapper.writeValueAsString(payload);
        request = HttpRequest.newBuilder()
                .uri(URI.create(URL))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(body))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println("Status :  " + response.statusCode());
        PostOutputObj res_obj = mapper.readValue(response.body(), PostOutputObj.class);

        return res_obj;
    }

}