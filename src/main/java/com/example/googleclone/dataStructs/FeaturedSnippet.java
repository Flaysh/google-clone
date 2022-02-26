/*Google Clone Application - Data Structures for Jackson Library, to create the POJO's
 * Built with Java & Spring Boot Library
 * Written by Itay Flaysher - Software engineer
 * 26/02/2022
 * */

package com.example.googleclone.dataStructs;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class FeaturedSnippet{
    @JsonProperty("title")
    public String getTitle() { 
		 return this.title; }
    String title;
    @JsonProperty("link") 
    public String getLink() { 
		 return this.link; }
    String link;
    @JsonProperty("description") 
    public String getDescription() { 
		 return this.description; }
    String description;
    @JsonProperty("featured_snippet") 
    public String getFeatured_snippet() { 
		 return this.featured_snippet; }
    String featured_snippet;
    @JsonProperty("additional_links") 
    public ArrayList<AdditionalLink> getAdditional_links() {
		 return this.additional_links; }
    ArrayList<AdditionalLink> additional_links;
    @JsonProperty("cite") 
    public Cite getCite() { 
		 return this.cite; }
    Cite cite;
}
