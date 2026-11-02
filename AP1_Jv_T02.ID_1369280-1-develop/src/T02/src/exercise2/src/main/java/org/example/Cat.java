package org.example;

public class Cat extends Animal {
    public Cat(String name, Integer age, Double weight) {
        super(name, age, weight);
    }

    public Double getFeedInfoKg() {
        return getWeight() * 0.1;
    }

    @Override
    public String toString() {
        return String.format("Cat name = %s, age = %d, mass = %.2f, feed %.2f",
                getName(), getAge(), getWeight(), getFeedInfoKg());
    }
}
