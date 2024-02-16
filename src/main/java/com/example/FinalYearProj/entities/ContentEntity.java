package com.example.FinalYearProj.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "content")
public class ContentEntity {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long contentId;
    private String contentUrl;
    private String contentDescription;
}
