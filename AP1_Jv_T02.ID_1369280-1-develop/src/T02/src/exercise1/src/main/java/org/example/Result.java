package org.example;

public class Result {

    private Integer quantity;
    private boolean isCorrect;


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


    @Override
    public String toString() {
        return "Result{" +
                "quantity=" + quantity +
                ", isCorrect=" + isCorrect +
                '}';
    }
}
