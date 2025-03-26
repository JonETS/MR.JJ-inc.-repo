package com.example;

public class Product {
    //attributes
    private static int productID;
    private static String productName;
    private static double productPrice;
    private static boolean isInStock;
    //methods
    public static double getPrice(){
        return productPrice;
    }
    public static int getProductID(){
        return productID;
    }
    private static void updateStock(boolean stock){

    }
    private static void setPrice(double newPrice){
        
    }
}
