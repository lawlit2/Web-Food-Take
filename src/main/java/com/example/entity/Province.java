package com.example.entity;

import lombok.Data;

import java.util.List;
@Data
public class Province {
    int id;
    String name;
    List<City> child;
}
