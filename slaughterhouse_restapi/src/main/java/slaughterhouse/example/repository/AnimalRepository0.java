package slaughterhouse.example.repository;

import org.springframework.stereotype.Repository;
import slaughterhouse.example.model.Animal;
import slaughterhouse.example.model.AnimalInfo0;


import java.time.Instant;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;


@Repository
public class AnimalRepository0 {
    private static final Map<Integer, Animal> orderMap = new HashMap<>();
    static {
        initDataSource();
    }

    private static void initDataSource() {
        Animal a1 = new Animal(1,"Farm1", LocalDate.of(2023,1,3), 56.7);
        Animal a2 = new Animal(2, "Farm2", LocalDate.of(2023,2,9), 103.5);
        Animal a3 = new Animal(3,"Farm1", LocalDate.of(2023,3,3), 116.09);

        orderMap.put(a1.getId(), a1);
        orderMap.put(a2.getId(), a2);
        orderMap.put(a3.getId(), a3);
    }

    // CRUD operations (later we inherit from interface ()CrudRepo or JpaRepo)

    // C - Create
    public Animal save(Animal o){
        orderMap.put(o.getId(), o);
        return o;
    }

    // R - GET
    public Animal findById(int id) {
        return orderMap.get(id);
    }

    public Animal findByRegistration(String registrationNumber){
        return orderMap.get(registrationNumber);
    }
    public Animal findByDate(LocalDate date){
        return orderMap.get(date);
    }
    public Animal findByOrigin(String origin){
        return orderMap.get(origin);
    }

    // U - Update
    public Animal update(Animal o){
        // simply saves the object
        orderMap.put(o.getId(), o);
        return o;
    }
    // D - Delete
    public void deleteById(int id) { // void just for test
        orderMap.remove(id);
    }

    // R - find all
    public List<Animal> findAll() {
        Collection<Animal> c = orderMap.values();
        List<Animal> orderList = new ArrayList<>();
        orderList.addAll(c);
        return orderList;
    }

    public List<Animal> findAllByDate(String date) {
        LocalDate localdate = LocalDate.parse(date);
        Collection<Animal> c =  orderMap.values().stream().
                filter(animal -> animal.getDate().equals(localdate) ).collect(Collectors.toList());
        List<Animal> orderList = new ArrayList<>();
        orderList.addAll(c);
        return orderList;
    }

    public List<Animal> findAllByOrigin(String origin) {
        Collection<Animal> c =  orderMap.values().stream().
                filter(animal -> animal.getOrigin().equalsIgnoreCase(origin) ).collect(Collectors.toList());
        List<Animal> orderList = new ArrayList<>();
        orderList.addAll(c);
        return orderList;
    }

}
