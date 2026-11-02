package org.example;

import java.util.concurrent.TimeUnit;

public class Cat extends Animal {
    public Cat(String name, Integer age) {
        super(name, age);
    }


    @Override
    public Long goToWalk(){
        Long walkTimeInSeconds = (long) (getAge() *  0.25);
        try {
            TimeUnit.SECONDS.sleep(walkTimeInSeconds);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return walkTimeInSeconds;
    }

    @Override
    public String toString() {
        return "Cat name = " + getName() + ", age = " + getAge();
    }
}
