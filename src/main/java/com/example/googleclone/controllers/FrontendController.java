/*Google Clone Application - Frontend Controller
 * a Controller that manage the routing of the UI (Two Static pages).
 * Built with Java & Spring Boot Library
 * Written by Itay Flaysher - Software engineer
 * 26/02/2022
 * */

package com.example.googleclone.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class FrontendController {

    //("/") - shows Google front page
    @RequestMapping()
    public String showHomePage() {
        return "index.html";
    }

    //("/result?q=") - Show results page
    @RequestMapping("/result")
    public String showResultPage(@RequestParam("query") String query) {
        return "result.html";
    }
}
