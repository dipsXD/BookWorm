package com.practice.bookpopulationservice.model;

import lombok.*;

@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class GoogleBooksApiItem {
    private GoogleBooksApiVolumeInfo volumeInfo;
}
