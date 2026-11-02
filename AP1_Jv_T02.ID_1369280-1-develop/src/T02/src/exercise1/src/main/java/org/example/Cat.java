package org.example;

public class Cat extends Animal {
    public Cat(String name, Integer age) {
        super(name, age);
    }

    @Override
    public String toString() {
        return "Dog name = " + getName() + ", age = " + getAge();
    }

}
