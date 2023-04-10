package slaughterhouse.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import slaughterhouse.example.model.Animal;


@Repository
public interface AnimalRepository extends JpaRepository<Animal, Integer> {
}
