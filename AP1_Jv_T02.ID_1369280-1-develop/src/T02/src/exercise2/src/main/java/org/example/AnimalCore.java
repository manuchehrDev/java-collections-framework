package org.example;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.spi.AbstractResourceBundleProvider;

public class AnimalCore {
    private List<Animal> animalList;

    public AnimalCore() {
        animalList = new LinkedList<>();
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


    public Result getWeight(Scanner scanner, Result result) {
        while (true) {
            if (scanner.hasNextDouble()) {
                result.setWeight(scanner.nextDouble());
                result.setCorrect(true);
                break;
            } else {
                System.out.println("Could not parse a number. Please, try again");
                scanner.next();
            }
        }
        return result;
    }

    private Animal returnAnimal(String type, String name, Integer age, Double weight) {
        Animal animal = null;
        if (type.equals("cat")) {
            animal = new Cat(name, age, weight);
        } else if (type.equals("dog")) {
            animal = new Dog(name, age, weight);
        }
        return animal;
    }

    public String getString(Scanner scanner) {
        return scanner.next();
    }


    public void handlerAnimalCore(Result result, Scanner scanner) {
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
            getWeight(scanner, result);
            if (result.getWeight() <= 0) {
                System.out.println("Incorrect input. Mass <= 0 ");
                continue;
            }
            animalList.add(returnAnimal(type, name, result.getQuantity(), result.getWeight()));
        }
    }


    private boolean isCorrectTypePet(String type) {
        return (type.equals("dog") || type.equals("cat"));
    }


    public void outputAnimals() {
        for (Animal a : animalList) {
            System.out.println(a);
        }
    }


}
