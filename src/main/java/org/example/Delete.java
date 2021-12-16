package org.example;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Delete {


    public void send(HttpClient client, HttpRequest request, String URL) throws IOException, InterruptedException {

        request = HttpRequest.newBuilder()
                .uri(URI.create(URL))
                .DELETE()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println("Status :  " + response.statusCode());
    }

}
