package slaughterhouse.example.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
@Getter
@Setter
@ToString
@EqualsAndHashCode
//@RequiredArgsConstructor
@Entity
@Table(name = "animals")
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    // You could also assign table column names
    @Column(name = "date")
    private LocalDate date;
    @Column(name = "weight")
    private double weight;
    @Column(name = "origin")
    private String origin;

    public Animal(int id, String origin, LocalDate date, double weight) {
        this.id = id;
        this.origin = origin;
        this.date = date;
        this.weight = weight;
    }

    public Animal(){}

        }