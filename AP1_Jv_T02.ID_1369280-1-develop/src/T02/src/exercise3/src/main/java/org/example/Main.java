package org.example;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AnimalService animalService = new AnimalService();
        Result result = new Result();
        animalService.getQuantity(scanner, result);
        animalService.handlerAnimalService(result,scanner);
        animalService.outputAnimals();
    }
}