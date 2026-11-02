package org.example;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

public class AnimalService {
    private static final Instant PROGRAM_START = Instant.now();

    private final Instant programStart;
    private List<Animal> animalList;

    public AnimalService() {
        this.animalList = new LinkedList<>();
        programStart = Instant.now();
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
        }
        return animal;
    }


    private boolean isCorrectTypePet(String type) {
        return (type.equals("dog") || type.equals("cat"));
    }

    public void outputAnimals() {
        if (animalList.isEmpty()) return;
        List<CompletableFuture<Void>> futures = new ArrayList<>();

        for (Animal pet : animalList) {
            final Instant threadStart = Instant.now();
            CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
                try {
                    long initialDelay = Duration.between(PROGRAM_START, threadStart).toMillis();
//                    long randomDelay = (long) (Math.random() * 100);
//                    TimeUnit.MILLISECONDS.sleep(randomDelay);
                    long startMs = initialDelay ;
                    pet.goToWalk();
                    long endMs = Duration.between(PROGRAM_START, Instant.now()).toMillis();
                    System.out.printf("%s, start time = %.2f, end time = %.2f%n",
                            pet.toString(),
                            startMs / 1000.0,
                            endMs / 1000.0);

                } catch (Exception e) {
                    Thread.currentThread().interrupt();
                }
            });
            try {
                TimeUnit.MILLISECONDS.sleep(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            futures.add(future);
        }
        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();
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
        }
    }


}

