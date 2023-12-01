package com.practice.bookpopulationservice.model;

import lombok.*;

import java.util.List;

@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class GoogleBooksApiVolumeInfo {
    private String title;
    private List<String> authors;
    private String publishedDate;

}
