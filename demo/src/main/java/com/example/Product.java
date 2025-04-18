package com.example;

public class Product {
    //attributes
    private int productID;
    private String productName;
    private double productPrice;
    private boolean isInStock;
    //getters/setters
    public String getProductName(){
        return productName;
    }
    public double getPrice(){
        return productPrice;
    }
    public int getProductID(){
        return productID;
    }
    public boolean getStock(){
        return isInStock;
    }
    public void setName(String name){
        productName = name;
    }
    public void setStock(boolean stock){
        isInStock = stock;
    }
    public void setPrice(double newPrice){
        productPrice = newPrice;
    }
    public void setProductID(int newID){
        productID = newID;
    }
    //method to print info about product
    public void displayProduct() {
        System.out.println("Product ID: " + productID + ", Name: " + productName + 
        ", Price: $" + productPrice + ", In Stock: " + isInStock);
    }
}
