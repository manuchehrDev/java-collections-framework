package org.example;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class AnimalService {

    private List<Animal> animalList;
    private List<Animal> herbivores;
    private List<Animal> omnivores;

    public AnimalService() {
        this.animalList = new LinkedList<>();
        this.herbivores = new LinkedList<>();
        this.omnivores = new LinkedList<>();
    }


    public Result getQuantity(Scanner scanner, Result result) {
        while (true) {
            if (scanner.hasNextInt()) {
                result.setQuantity(scanner.nextInt());
                result.setCorrect(true);
                break;
            } else {
                System.out.println("Could not parse a number. Please, try again");
                scanner.next();
            }
        }
        return result;
    }


    public Result getAge(Scanner scanner, Result result) {
        while (true) {
            if (scanner.hasNextInt()) {
                result.setAge(scanner.nextInt());
                result.setCorrect(true);
                break;
            } else {
                System.out.println("Could not parse a number. Please, try again");
                scanner.next();
            }
        }
        return result;
    }

    public String getString(Scanner scanner) {
        return scanner.next();
    }

    private Animal returnAnimal(String type, String name, Integer age) {
        Animal animal = null;
        if (type.equals("cat")) {
            animal = new Cat(name, age);
        } else if (type.equals("dog")) {
            animal = new Dog(name, age);
        } else if (type.equals("guinea")) {
            animal = new GuineaPig(name, age);
        } else if (type.equals("hamster")) {
            animal = new Hamster(name, age);
        }
        return animal;
    }


    private boolean isCorrectTypePet(String type) {
        return (type.equals("dog") || type.equals("cat") || type.equals("hamster") || type.equals("guinea"));
    }


    public void outputAnimals() {
        for (Animal herbivore : herbivores) {
            System.out.println(herbivore);
        }
        for (Animal omnivore : omnivores) {
            System.out.println(omnivore);
        }
    }


    public void handlerAnimalService(Result result, Scanner scanner) {
        for (int i = 0; i < result.getQuantity(); i++) {
            String type = getString(scanner);
            if (!isCorrectTypePet(type)) {
                System.out.println("Incorrect input. Unsupported pet type");
                continue;
            }
            String name = getString(scanner);
            getAge(scanner, result);

            if (result.getAge() <= 0) {
                System.out.println("Incorrect input. Age <= 0");
                continue;
            }
            Animal animal = returnAnimal(type, name, result.getAge());
            animalList.add(animal);

            if (animal instanceof Omnivore) {
                omnivores.add(animal);
            } else if (animal instanceof Herbivore) {
                herbivores.add(animal);
            }
        }
    }


}
