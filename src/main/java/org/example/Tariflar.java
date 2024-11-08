package org.example;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class Tariflar {

    private  Long id;
    private  String title;
    private  Integer price;
    private  String malumot;
    private String malumotRu;
    private String titleRu;
}
