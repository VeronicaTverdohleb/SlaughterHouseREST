package slaughterhouse.example.service;

import org.springframework.stereotype.Service;
import slaughterhouse.example.model.Animal;
import slaughterhouse.example.repository.AnimalRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AnimalServiceImpl implements AnimalService {
    AnimalRepository orderRepository;
    // inject the repo
    public AnimalServiceImpl(AnimalRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Animal create(Animal order) {
        return orderRepository.save(order);
    }

    @Override
    public List<Animal> findAll() {
        return (List<Animal>) orderRepository.findAll();
    }

    @Override
    public Iterable<Animal> findAllItr() {
        return orderRepository.findAll();
    }

    @Override
    public Optional<Animal> findById(int id) {
        return orderRepository.findById(id);
    }

    @Override
    public Animal update(Animal order) {
        return orderRepository.save(order);
    }

    @Override
    public void deleteById(int id) {
        orderRepository.deleteById(id);
    }
}
