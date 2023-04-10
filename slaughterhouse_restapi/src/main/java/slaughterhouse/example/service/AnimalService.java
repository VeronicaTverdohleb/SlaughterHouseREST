package slaughterhouse.example.service;

import org.springframework.stereotype.Service;
import slaughterhouse.example.model.Animal;

import java.util.List;
import java.util.Optional;

@Service
public interface AnimalService {
    Animal create(Animal order);
    List<Animal> findAll();  //  use List or Iterable
    Iterable<Animal> findAllItr(); // use List or Iterable
    Optional<Animal> findById(int id);
    Animal update(Animal order);
    void deleteById(int id);
}
