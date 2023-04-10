package slaughterhouse.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import slaughterhouse.example.controller.AnimalController;
import slaughterhouse.example.model.Animal;
import slaughterhouse.example.repository.AnimalRepository0;

import java.time.LocalDate;
import java.util.Scanner;

@SpringBootApplication
public class AnimalApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(AnimalApiApplication.class, args);
        AnimalRepository0 repository0=new AnimalRepository0();
        AnimalController controller=new AnimalController(repository0);
        Animal animal=new Animal();

        Scanner scanner=new Scanner(System.in);
        System.out.println("Welcome to the animal registration system");
        String another;
        do {
            System.out.println("Please input the number of the animal: ");
            int l = scanner.nextInt();
        if(repository0.findById(l).equals(true)){
            System.out.println("Animal with this id exists, please put a valid id");
        }

            System.out.println("number inputed is " + l);
            scanner.nextLine();
            System.out.println("Please input the origin of the animal (i.e the farm ): ");
            String origin = scanner.nextLine();
            System.out.println("origin inputed is " + origin);
            System.out.println("Please input the date of arrival of the animal at the slaughterhouse (in the format yyyy-mm-dd):");
            String date = scanner.nextLine();
            System.out.println("date inputed " + date);
            System.out.println("Please weight the animal and input the result: ");
            Double weight = scanner.nextDouble();
            System.out.println("Weight inputed is " + weight);
            scanner.nextLine();
            System.out.println("The information inputed about the animal is: ");
            System.out.println("Number: " + l);
            System.out.println("Origin: " + origin);
            System.out.println("Date: " + date);
            System.out.println("Weight:s " + weight);
            System.out.println("Input yes if you want to save the information about the animal: ");
            String response = scanner.nextLine();
            if (response.equalsIgnoreCase("yes")) {
                Animal a1 = new Animal(l, origin, LocalDate.parse(date), weight);
                controller.createAnimal(a1);
                repository0.save(a1);
                System.out.println("The animal has been saved, refresh page to see it in the system");
            }
            else{
                System.out.println("Animal not registered:((");
            }
            System.out.println("Do you want to register another animal?");
            System.out.println("If yes, type yes if no type exit");
            another=scanner.nextLine();
            if(another.equalsIgnoreCase("exit")){
                System.exit(0);
            }
        }while (!another.equalsIgnoreCase("exit"));


    }

}
