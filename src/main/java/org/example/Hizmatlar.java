package org.example;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Hizmatlar {

    private Long id;
    private String title;
    private Integer price;
    private String malumot;
    private Long tarifId;
}
