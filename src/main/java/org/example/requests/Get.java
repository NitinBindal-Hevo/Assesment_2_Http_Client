package org.example.requests;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.getPojo.getOutputObj;

import java.io.IOException;
import java.lang.reflect.Array;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Get {

    private ObjectMapper mapper;

    public Get() {
        mapper = new ObjectMapper();
    }

    public getOutputObj send(HttpClient client, HttpRequest request, String URL) throws IOException, InterruptedException {
        System.out.println("Now entered!");
        int page = 1;

        Scanner key = new Scanner(System.in);
        System.out.println("Press return for next page or q to exit ");
        String input = "";

        String temp = URL + "?page=" + page;
        System.out.println("URL :  " + temp);
        char[] new_url = temp.toCharArray();

        List<String> responses = new ArrayList<>();
        int size = new_url.length - 1;
        while (!input.equalsIgnoreCase("q")) {
            request = HttpRequest.newBuilder().GET().header("accept", "application/json").uri(URI.create(String.valueOf(new_url))).build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println("Status :  " + response.statusCode());
            System.out.println(response.body());
            responses.add(response.body());
            page += 1;
            Array.setChar(new_url, size, (char) (page + '0'));
            input = key.nextLine();

        }

        return mapper.readValue(responses.get(responses.size() - 1), getOutputObj.class);

    }

    public getOutputObj send(HttpClient client, HttpRequest request, String URL, int page) throws IOException, InterruptedException {


        String temp = URL + "?page=" + page;
        char[] new_url = temp.toCharArray();

        request = HttpRequest.newBuilder().GET().header("accept", "application/json").uri(URI.create(String.valueOf(new_url))).build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println("Status :  " + response.statusCode());
        System.out.println(response.body());

        return mapper.readValue(response.body().toString(), getOutputObj.class);


    }


}
