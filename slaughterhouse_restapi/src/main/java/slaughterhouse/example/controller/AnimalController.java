package slaughterhouse.example.controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import slaughterhouse.example.model.Animal;
import slaughterhouse.example.repository.AnimalRepository0;
import slaughterhouse.example.service.AnimalServiceImpl;

import java.util.List;


@RestController
@RequestMapping("/")
public class AnimalController {
    private AnimalRepository0 orderRepo;
    private AnimalServiceImpl animalService;
    private Logger logger = LoggerFactory.getLogger(AnimalController.class);

    public AnimalController(AnimalRepository0 orderRepo){
        this.orderRepo=orderRepo;
    }

    /**
     * Gets all animals in the system
     * @return a list of all animals
     */
    @RequestMapping(value = "/animals", //
            method = RequestMethod.GET, //,
            produces = {MediaType.APPLICATION_JSON_VALUE} )
    @ResponseBody
    public List<Animal> getAllAnimals() {
        List<Animal> list = orderRepo.findAll();
        return list;
    }

    /**
     * Creates a new animal.
     *
     * @param animal the animal object to be added
     * @return the added animal object
     */

    @RequestMapping(value = "/animals",
            method = RequestMethod.POST)
    @ResponseBody
    public Animal createAnimal(@RequestBody Animal animal) {
        return orderRepo.save(animal);
    }


    /**
     * Gets animal by id
     * @param id the animal id searched by
     * @return
     */

    @RequestMapping(value = "/animals/{id}", //
            method = RequestMethod.GET, //
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE} )
    @ResponseBody
    public Animal getAnimalById(@PathVariable int id) {
        return orderRepo.findById(id);
    }


    /**
     * Retrieves animals by arrival date.
     *
     * @param localDate the arrival date in yyyy-MM-dd format
     * @return a list of animals that arrived on the given date
     */
    @RequestMapping(value = "/animals/by-date/{date}",
    method =RequestMethod.GET,
    produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @ResponseBody
    public List<Animal> getAnimalsByDate(@PathVariable("date") String localDate) {
        return orderRepo.findAllByDate(localDate);
    }

    /**
     * Retrieves animals by origin (i.e., farm).
     *
     * @param origin the origin (i.e., farm) of the animals
     * @return a list of animals from the given origin
     */
    @RequestMapping(value = "/animals/by-origin/{origin}",
            method =RequestMethod.GET,
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @ResponseBody
    public List<Animal> getAnimalsByOrigin(@PathVariable("origin") String origin) {
        return orderRepo.findAllByOrigin(origin);
    }


   /* @DeleteMapping(value="/animals/{id}")
    public ResponseEntity<HttpStatus> deleteOrder(@PathVariable("id") int id){
        try {
            animalService.deleteById(id);
            return new ResponseEntity<HttpStatus>(HttpStatus.OK);
        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
            return new ResponseEntity<HttpStatus>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/animals/{id}")
    public ResponseEntity<Object> updateOrder(@PathVariable("id") int id, @RequestBody Animal animal){
        try {
            animal.setId(id);
            Animal savedAnimal = animalService.update(animal);
            return new ResponseEntity<Object>(savedAnimal, HttpStatus.OK);
        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
            return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
        }
    }*/


}
