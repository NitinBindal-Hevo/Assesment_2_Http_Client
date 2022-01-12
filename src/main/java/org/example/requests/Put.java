package org.example.requests;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.putPojo.PutInputObj;
import org.example.putPojo.putOutputObj;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Put {


    ObjectMapper mapper;

    public Put() {
        mapper = new ObjectMapper();
    }

    public putOutputObj send(HttpClient client, HttpRequest request, String URL, PutInputObj payload) throws IOException, InterruptedException {

        String body = mapper.writeValueAsString(payload);
        request = HttpRequest.newBuilder()
                .uri(URI.create(URL))
                .header("Content-Type", "application/json")
                .PUT(HttpRequest.BodyPublishers.ofString(body))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println("Status :  " + response.statusCode());
        putOutputObj res_obj = mapper.readValue(response.body(), putOutputObj.class);

        return res_obj;
    }


}
