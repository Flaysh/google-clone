/*Google Clone Application - Data Structures for Jackson Library, to create the POJO's
 * Built with Java & Spring Boot Library
 * Written by Itay Flaysher - Software engineer
 * 26/02/2022
 * */

package com.example.googleclone.dataStructs;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class Result{
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
    @JsonProperty("additional_links")
    public ArrayList<AdditionalLink> getAdditional_links() {
		 return this.additional_links; }
    ArrayList<AdditionalLink> additional_links;
    @JsonProperty("cite") 
    public Cite getCite() { 
		 return this.cite; }
    Cite cite;
    @JsonProperty("g_review_stars")
    public String getG_review_stars() {
        return this.g_review_stars; }
    String g_review_stars;
    @JsonProperty("additional_products")
    public String getAdditional_products() {
        return this.additional_products; }
    String additional_products;
}
