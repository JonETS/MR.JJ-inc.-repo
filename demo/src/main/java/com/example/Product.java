package com.example;
/**
 * Product.java
 * This class represents a product in the system. It contains attributes such as 
 * product ID, name, price, and stock status.
 * It also provides methods to get and set these attributes, 
 * as well as a method to print product information.
 * @author Ricky McCobb
 * @version 1.0
 */
public class Product {
    /** Represents the Product ID number of product. */
    private int productID;
    /** Represents the string name of product. */
    private String productName;
    /** Represents the price of product as a double. */
    private double productPrice;
    /** Represents availability of the product. */
    private boolean isInStock;
    /** Getters and setters for the attribues of the product. */
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
    /**
     * Sets the name of the product.
     * @param name the name of the product
     */
    public void setName(String name){
        productName = name;
    }
    /**
     * Sets the stock status of the product.
     * @param stock the stock status of the product to true or false
     */
    public void setStock(boolean stock){
        isInStock = stock;
    }
    /**
     * Sets the price of the product.
     * @param newPrice the price of the product
     */
    public void setPrice(double newPrice){
        productPrice = newPrice;
    }
    /**
     * Sets the product ID of the product.
     * @param newID the ID of the product
     */
    public void setProductID(int newID){
        productID = newID;
    }
    /** Method to display basic information about the object. */
    public void displayProduct() {
        System.out.println("Product ID: " + productID + ", Name: " + productName + 
        ", Price: $" + productPrice + ", In Stock: " + isInStock);
    }
}
