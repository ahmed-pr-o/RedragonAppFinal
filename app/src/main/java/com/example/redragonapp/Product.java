package com.example.redragonapp;

public class Product {
    private String name;
    private int imageResource;
    private double price;

    public Product(String name, int imageResource, double price) {
        this.name = name;
        this.imageResource = imageResource;
        this.price = price;
    }

    public String getName() { return name; }
    public int getImageResource() { return imageResource; }
    public double getPrice() { return price; }
}



