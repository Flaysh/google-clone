/*Google Clone Application - Backend Functions - Utilities
 * Built with Java & Spring Boot Library
 * Written by Itay Flaysher - Software engineer
 * 26/02/2022
 * */


package com.example.googleclone.utils;

import com.example.googleclone.dataStructs.PreviousSearch;
import com.example.googleclone.dataStructs.Root;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;

public class BackendFunctions {
    //main public PreviousSearch array - all searches that users had done.
    public ArrayList<PreviousSearch> previousSearchArrayList = new ArrayList<>();

    // fetch Data (Http Request) from RapidAPI Google Search API
    public String getDataFromAPI(String searchQuery) throws IOException, InterruptedException {
        String apiURL = "https://google-search3.p.rapidapi.com/api/v1/search/q=%s";
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(String.format(apiURL, searchQuery)))
                .header("x-user-agent", "desktop")
                .header("x-proxy-location", "EU")
                .header("x-rapidapi-host", "google-search3.p.rapidapi.com")
                .header("x-rapidapi-key", "YOUR_API_KEY_HERE")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        //print to see raw result
        System.out.println(response.body());
        return response.body();
    }

    //Takes the raw "JSON-String" result and make it a Plain Old Java Object
    public Root makeJSONtoPOJO(String data) {
        try {
            ObjectMapper om = new ObjectMapper();
            Root root = om.readValue(data, Root.class);
            return root;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // finds the current Session only SearchResults and return it to the active user.
    public ArrayList<PreviousSearch> currentSessionOnly(HttpSession session) {
        ArrayList<PreviousSearch> currentSearchArray = new ArrayList<>();
        for (int i = 0; i < previousSearchArrayList.size(); i++) {
            if (previousSearchArrayList.get(i).getUserID().equals(session.getId())) {
                currentSearchArray.add(previousSearchArrayList.get(i));
            }
        }
        return currentSearchArray;
    }
}
