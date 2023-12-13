package com.practice.bookpopulationservice.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.*;

import java.util.List;

@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class GoogleBooksApiVolumeInfo {
    private String title;
    private String subtitle;
    private List<String> authors;
    private String publisher;
    private String publishedDate;
    private String description;
    @JsonProperty("imageLinks")
    private JsonNode imageLinks;
    private String thumbnail;
    private String language;
    private List<String> categories;




    // Convenience methods to get specific properties
//    public String getSmallThumbnail() {
//        return imageLinksNode != null ? imageLinksNode.path("smallThumbnail").asText() : null;
//    }

//    public String getThumbnail() {
//        return imageLinks != null ? imageLinks.path("thumbnail").asText() : null;
//    }

}
