package ru.costa.tours.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "passport")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Passport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "series")
    private String series;
    @Column(name = "number")
    private String number;


    public Passport(long id, String series, String number) {
        this.id = id;
        this.series = series;
        this.number = number;
    }
}
