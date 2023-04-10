package slaughterhouse.example.model;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@ToString
@EqualsAndHashCode
@RequiredArgsConstructor
@Entity
public class Tray {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Double maxWeightCapacity;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "tray_id")
    private List<Part> animalParts = new ArrayList<>();

    public void addAnimalPart(Part animalPart) {
        animalParts.add(animalPart);
    }

    public void removeAnimalPart(Part animalPart) {
        animalParts.remove(animalPart);
    }

    public Double getCurrentWeight() {
        return animalParts.stream()
                .mapToDouble(animalPart -> animalPart.getHeads() * 1.0
                        + animalPart.getChests() * 1.0
                        + animalPart.getBacks() * 1.0
                        + animalPart.getLegs() * 1.0)
                .sum();
    }
}
