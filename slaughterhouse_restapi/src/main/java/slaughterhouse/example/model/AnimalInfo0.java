package slaughterhouse.example.model;

import java.time.LocalDate;
import java.util.Date;

public class AnimalInfo0 {

    private Long id;
    private String origin;
    private LocalDate date;
    private double weight;

    public AnimalInfo0(){}


    public AnimalInfo0(Long id, String origin, LocalDate date, double weight) {
        this.id = id;
        this.origin = origin;
        this.date = date;
        this.weight = weight;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }
}
