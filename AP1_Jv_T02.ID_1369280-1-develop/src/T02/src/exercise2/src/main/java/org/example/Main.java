package org.example;

import java.util.Locale;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.US);
        AnimalCore animalCore = new AnimalCore();
        Result result = new Result();
        animalCore.getQuantity(scanner,result);
        animalCore.handlerAnimalCore(result,scanner);
        animalCore.outputAnimals();
    }
}