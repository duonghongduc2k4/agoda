package com.codegym.agoda.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Image")
@Data
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nameImage;

}
