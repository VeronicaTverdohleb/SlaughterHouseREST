package slaughterhouse.example.model;


import lombok.*;
import javax.persistence.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@RequiredArgsConstructor
@Entity
public class Part {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int heads;
    private int chests;
    private int backs;
    private int legs;


}
