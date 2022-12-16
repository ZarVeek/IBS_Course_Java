package org.example.boxWithCandy;

public abstract class Sweets {
    private String name;
    private double weight;
    private double price;
    private int id;


    public Sweets(String name, double weight, double price, int id) {
        this.name = name;
        this.weight = weight;
        this.price = price;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
