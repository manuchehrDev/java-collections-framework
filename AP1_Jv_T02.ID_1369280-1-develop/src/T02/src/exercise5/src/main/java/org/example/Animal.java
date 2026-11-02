package org.example;

public abstract class Animal {
    private String name;
    private Integer age;

    public Animal(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public Long goToWalk(){
        return null;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

}
