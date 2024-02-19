package com.example.FinalYearProj.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "homeWork")
public class HomeWorkEntity {
  @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long homeWorkId;
    private String homeWorkHeading;
    private LocalDate date;

}
