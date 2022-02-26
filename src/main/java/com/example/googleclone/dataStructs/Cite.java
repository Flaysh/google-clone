/*Google Clone Application - Data Structures for Jackson Library, to create the POJO's
 * Built with Java & Spring Boot Library
 * Written by Itay Flaysher - Software engineer
 * 26/02/2022
 * */

package com.example.googleclone.dataStructs;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Cite{
    @JsonProperty("domain")
    public String getDomain() { 
		 return this.domain; }
    String domain;
    @JsonProperty("span") 
    public String getSpan() { 
		 return this.span; }
    String span;
}
