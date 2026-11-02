package org.example;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.spi.AbstractResourceBundleProvider;

public class AnimalCore {
    private List<Animal> animalList;
    private boolean unsupportedPetType = false;

    public AnimalCore() {
        animalList = new LinkedList<>();
    }


    public Result getQuantity(Scanner scanner) {
        Result result = new Result();
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

    private Animal returnAnimal(String type, String name, Integer age) {
        Animal animal = null;
        if (type.equals("cat")) {
            animal = new Cat(name, age);
        } else if (type.equals("dog")) {
            animal = new Dog(name, age);
        }
        return animal;
    }

    public String getString(Scanner scanner) {
        return scanner.next();
    }


    public void handlerAnimalCore(Result result, Scanner scanner) {
        for (int i = 0; i < result.getQuantity(); i++) {
            String type = getString(scanner);
            boolean isCorrect = isCorrectTypePet(type);
            if (isCorrect) {
                String name = getString(scanner);
                Result result1 = getQuantity(scanner);
                if (result1.getQuantity() > 0) {
                    animalList.add(returnAnimal(type, name, result1.getQuantity()));
                } else {
                    System.out.println("Incorrect input. Age <= 0");
                }

            } else {
                System.out.println("Incorrect input. Unsupported pet type");
            }
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
