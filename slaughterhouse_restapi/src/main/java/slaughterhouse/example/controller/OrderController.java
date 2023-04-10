package slaughterhouse.example.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import slaughterhouse.example.model.Animal;
import slaughterhouse.example.service.AnimalServiceImpl;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class OrderController {
    private Logger logger = LoggerFactory.getLogger(OrderController.class);
    private AnimalServiceImpl orderService;
    public OrderController(AnimalServiceImpl orderService) {
        this.orderService = orderService;
    }

    // CRUD endpoint follows

    // http://localhost:8090/api/orders
    @PostMapping("/animals")
    public ResponseEntity<Object> createOrder(@RequestBody Animal order){
        try {
            Animal createdOrder = orderService.create(order);
            return new ResponseEntity<Object>(createdOrder, HttpStatus.OK);
        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
            return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/animals")
    public ResponseEntity<Object> getAllOrders(){
        try {
            Iterable<Animal> orders = orderService.findAllItr();
            return new ResponseEntity<Object>(orders, HttpStatus.OK);
        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
            return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
        }
    }

    //@GetMapping("/orders/{id}")  // can include MediaType as well
    @GetMapping(value="/animals/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getOrderById(@PathVariable("id") int id){
        try {
            Optional<Animal> order = orderService.findById(id);
            if (order.isPresent()) {
                return new ResponseEntity<Object>(order.get(), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
            return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/animals/{id}")
    public ResponseEntity<Object> updateOrder(@PathVariable("id") int id, @RequestBody Animal order){
        try {
            order.setId(id);
            Animal savedOrder = orderService.update(order);
            return new ResponseEntity<Object>(savedOrder, HttpStatus.OK);
        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
            return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/animals/{id}")
    public ResponseEntity<HttpStatus> deleteOrder(@PathVariable("id") int id){
        try {
            orderService.deleteById(id);
            return new ResponseEntity<HttpStatus>(HttpStatus.OK);
        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
            return new ResponseEntity<HttpStatus>(HttpStatus.BAD_REQUEST);
        }
    }
}