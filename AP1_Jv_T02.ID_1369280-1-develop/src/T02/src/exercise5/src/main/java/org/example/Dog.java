package org.example;

import java.util.concurrent.TimeUnit;

public class Dog extends Animal {
    public Dog(String name, Integer age) {
        super(name, age);
    }

    @Override
    public Long goToWalk(){
        Long walkTimeInSeconds = (long)(getAge() * 0.5);
        try {
            TimeUnit.SECONDS.sleep(walkTimeInSeconds);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return walkTimeInSeconds;
    }

    @Override
    public String toString() {
        return "Dog name = " + getName() + ", age = " + getAge();
    }
}
