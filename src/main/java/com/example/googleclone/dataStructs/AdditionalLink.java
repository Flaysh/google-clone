/*Google Clone Application - Data Structures for Jackson Library, to create the POJO's
 * Built with Java & Spring Boot Library
 * Written by Itay Flaysher - Software engineer
 * 26/02/2022
 * */


package com.example.googleclone.dataStructs;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AdditionalLink{
    @JsonProperty("text")
    public String getText() { 
		 return this.text; }
    String text;
    @JsonProperty("href") 
    public String getHref() { 
		 return this.href; }
    String href;
}
