package com.practice.bookpopulationservice.model;

import lombok.*;

import java.util.List;

@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class GoogleBooksApiResponse {
    private List<GoogleBooksApiItem> items;
}
