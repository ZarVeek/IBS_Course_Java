package org.example.box;

public abstract class Sweets{
    private String name;
    private float weight;
    private float price;
    private int id;


    protected Sweets(String name, float weight, float price, int id) {
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

    public float getWeight(){
        return weight;
    }
    public void setWeight(float weight) {
        this.weight = weight;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
