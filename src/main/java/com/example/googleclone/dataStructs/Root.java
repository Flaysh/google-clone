/*Google Clone Application - Data Structures for Jackson Library, to create the POJO's
 * Built with Java & Spring Boot Library
 * Written by Itay Flaysher - Software engineer
 * 26/02/2022
 * */

package com.example.googleclone.dataStructs;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class Root{
    @JsonProperty("results") 
    public ArrayList<Result> getResults() { 
		 return this.results; }
    ArrayList<Result> results;
    @JsonProperty("image_results") 
    public ArrayList<Object> getImage_results() { 
		 return this.image_results; }
    ArrayList<Object> image_results;
    @JsonProperty("total")
    public long getTotal() {
		 return this.total; }
    long total;
    @JsonProperty("answers") 
    public ArrayList<String> getAnswers() { 
		 return this.answers; }
    ArrayList<String> answers;
    @JsonProperty("featured_snippet") 
    public FeaturedSnippet getFeatured_snippet() { 
		 return this.featured_snippet; }
    FeaturedSnippet featured_snippet;
    @JsonProperty("ts") 
    public long getTs() {
		 return this.ts; }
    long ts;
    @JsonProperty("device_region") 
    public String getDevice_region() { 
		 return this.device_region; }
    String device_region;
    @JsonProperty("device_type") 
    public String getDevice_type() { 
		 return this.device_type; }
    String device_type;
}
