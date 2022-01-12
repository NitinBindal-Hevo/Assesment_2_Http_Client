package org.example.requests;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.example.deletePojo.DeleteOutputObj;


public class Delete {


    public DeleteOutputObj send(HttpClient client, HttpRequest request, String URL) throws IOException, InterruptedException {

        request = HttpRequest.newBuilder()
                .uri(URI.create(URL))
                .DELETE()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println("Status :  " + response.statusCode());
        return new DeleteOutputObj(response.statusCode());
    }

}
