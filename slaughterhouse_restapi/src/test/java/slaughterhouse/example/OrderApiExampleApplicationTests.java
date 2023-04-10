package slaughterhouse.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import slaughterhouse.example.controller.AnimalController;
import slaughterhouse.example.model.Animal;
import slaughterhouse.example.repository.AnimalRepository0;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class OrderApiExampleApplicationTests {
    @Mock
    AnimalRepository0 repository;
    @Mock
    AnimalController controller;
    @Mock
    Animal animal;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        controller = new AnimalController(repository);
    }

    // http://localhost:8090/orders
    @Test
    public void httpPostRequest_CreateOneAnimal() {
        // Arrange
        var animal = new HashMap<String, String>() {{
            put("id","4");
            put("date", "2022-01-04");
            put("weight", "50.50");
            put("origin", "Farm4");

        }};

        var objectMapper = new ObjectMapper();
        String requestBody;
        try {
            requestBody = objectMapper.writeValueAsString(animal);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        System.out.println(requestBody);

        // Make an instance of HttpClient and create a new HttpRequest
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest requestToPost = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:8090/animals"))
                .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                .setHeader("Content-type", "application/json")
                .build();
        // Act
        HttpResponse<String> responseFromPost;
        try {
            responseFromPost = client.send(requestToPost,
                    HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // Assert
        assertEquals(200, responseFromPost.statusCode() );
    }


        @Test
        public void getAllAnimalsTest () {

            List<Animal> list = repository.findAll();
            assertEquals(list, list);
        }
        @Test
        public void GettingAllAnimalsByDateReturningManyTest () {
            String date = "2023-03-24";
            repository.findAllByDate(date);
            controller.getAnimalsByDate(date);
            assertEquals(repository.findAllByDate(date), controller.getAnimalsByDate(date));


        }

        @Test
        public void createAnimalTest () {
            repository.save(animal);
        }

    // HTTP Get - All animals
    public void httpGetRequest_GetAllAnimals() {
        // Arrange
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:8090/animals"))
                .build();

        // Act
        HttpResponse<String> response;
        try {
            response = client.send(request,
                    HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(response.body());

        // Assert
        assertEquals(200, response.statusCode());
    }


    // HTTP Get - Animal by ID
    @Test
    public void httpGetRequest_GetAnimalById_Equals1() {
        // Arrange
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:8090/animals/1"))
                .build();

        // Act
        HttpResponse<String> response;
        try {
            response = client.send(request,
                    HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(response.body());

        // Assert
        assertEquals(200, response.statusCode());
    }

    // HTTP Get - Animal by origin
    @Test
    public void httpGetRequest_GetAnimalByOrigin_EqualsCzechia() {
        // Arrange
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:8090/animals/by-origin/Farm2"))
                .build();

        // Act
        HttpResponse<String> response;
        try {
            response = client.send(request,
                    HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(response.body());

        // Assert
        assertEquals(200, response.statusCode());
    }

    // HTTP Get - Animal by date
    @Test
    public void httpGetRequest_GetAnimalByDate() {
        // Arrange
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:8090/animals/by-date/2022-01-04"))
                .build();

        // Act
        HttpResponse<String> response;
        try {
            response = client.send(request,
                    HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(response.body());

        // Assert
        assertEquals(200, response.statusCode());
    }

    // HTTP Put - Update animal with ID 1
    @Test
    public void httpPutRequest_UpdateAnimalWithId_Equals1() {
        // Arrange
        var animal = new HashMap<String, String>() {{
            put("id","1");
            put("date", "2022-01-04");
            put("weight", "120.20");
            put ("origin", "Farm4");

        }};

        var objectMapper = new ObjectMapper();
        String requestBody;
        try {
            requestBody = objectMapper
                    .writeValueAsString(animal);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        System.out.println(requestBody);

        // Make an instance of HttpClient and create a new HttpRequest
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest requestToPost = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:8090/animals/4"))
                .PUT(HttpRequest.BodyPublishers.ofString(requestBody))
                .setHeader("Content-type", "application/json")
                .build();

        // Act
        HttpResponse<String> responseFromPost;
        try {
            responseFromPost = client.send(requestToPost,
                    HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // Assert
        assertEquals(200, responseFromPost.statusCode());
    }

    // HTTP Delete - Animal by Id
    @Test
    public void httpDeleteRequest_DeleteAnimalById() {
        // Arrange
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:8090/animals/4"))
                .DELETE()
                .build();

        // Act
        HttpResponse<String> response;
        try {
            response = client.send(request,
                    HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(response.body());

        // Assert
        assertEquals(200, response.statusCode());
    }

    }


/*package com.example.slaughterhouse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;



*/
