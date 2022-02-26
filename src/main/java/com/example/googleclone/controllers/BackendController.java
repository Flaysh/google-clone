/*Google Clone Application - Backend Controllers
 * This is the core of the REST API - Two main routes - search and previous.
 * Built with Java & Spring Boot Library
 * Written by Itay Flaysher - Software engineer
 * 26/02/2022
 * */

package com.example.googleclone.controllers;

import com.example.googleclone.dataStructs.PreviousSearch;
import com.example.googleclone.dataStructs.Root;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.googleclone.utils.BackendFunctions;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class BackendController {
    //use the Backend Functions
    BackendFunctions bf = new BackendFunctions();

    //route ../previous?query="" --> add the latest search query and get the active session user his previous results
    //creates new PreviousSearch Object, adding to current List and then filters and return the needed one.
    // to allow from specific domain
    @GetMapping("/previous")
    public ArrayList<PreviousSearch> addToPreviousSearches(@RequestParam(value = "query") String query,HttpSession session) {
        PreviousSearch ps = new PreviousSearch(query,session.getId());
        bf.previousSearchArrayList.add(ps);
        return bf.currentSessionOnly(session);
}


    //route ../search?query="" --> fetch data from API, make the JSON into a POJO and then return it to client.
    @GetMapping("/search")
    public Root getSearchResult(@RequestParam(value = "query") String query) throws IOException, InterruptedException {
        String dataFromApi = bf.getDataFromAPI(query);
        return bf.makeJSONtoPOJO(dataFromApi);
    }
}
