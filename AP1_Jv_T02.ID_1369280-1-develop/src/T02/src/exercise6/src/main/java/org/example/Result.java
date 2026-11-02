package org.example;

public class Result {

    private Integer quantity;
    private boolean isCorrect;
    private Double weight;
    private Integer age;


    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public boolean isCorrect() {
        return isCorrect;
    }

    public void setCorrect(boolean correct) {
        isCorrect = correct;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer counter) {
        this.age = counter;
    }

    @Override
    public String toString() {
        return "Result{" +
                "quantity=" + quantity +
                ", isCorrect=" + isCorrect +
                ", weight=" + weight +
                ", age=" + age +
                '}';
    }
}
