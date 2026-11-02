package org.example;

import java.util.List;

public class AnimalIterator implements BaseIterator {

    private List<Animal> animalList;
    private Integer elementIndex;

    public AnimalIterator(List<Animal> animalList) {
        this.animalList = animalList;
        this.elementIndex = 0;
    }


    @Override
    public Animal next() {
        Animal animal = null;
        if (elementIndex < animalList.size()) {
            animal = animalList.get(elementIndex);
            elementIndex++;
        }
        return animal;
    }

    @Override
    public boolean hasNext() {
        return elementIndex < animalList.size();
    }

    @Override
    public void reset() {
        elementIndex = 0;
    }
}
