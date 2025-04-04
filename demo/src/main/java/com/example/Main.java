package com.example;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.IOException;
import java.io.BufferedReader;


public class Main {
    public static void main(String[] args) {
        //list of products
        ArrayList<Product> productList = new ArrayList<>();
        //create text file for products, if file already exists, move on
        try {
        File products = new File("productFile.txt");
        if (products.createNewFile()) {
            System.out.println("File created: " + products.getName());
        }
        //when adding products to text file, format should be:
        //ProductName price(double) instock(true or false)
        //NextProduct price instock (note each seperated by spaces)
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        
        //read data from file and create product objects from it
        String filePath = "productFile.txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            int counter = 0;
            String word;
            while ((line = reader.readLine()) != null) {
                Scanner scanner = new Scanner(line);
                productList.add(new Product());
                //set Product ID to match index in list
                productList.get(counter).setProductID(counter);
                //read file and set name, price, and stock of product in current index
                if(scanner.hasNext()) {
                    word = scanner.next();
                    productList.get(counter).setName(word);
                }
                if(scanner.hasNext()){
                    word = scanner.next();
                    productList.get(counter).setPrice(Double.parseDouble(word));
                }
                if(scanner.hasNext()) {
                    word = scanner.next();
                    //if "true" is on txt file, set stock to true, if else set to false
                    productList.get(counter).setStock(Boolean.parseBoolean(word));
                }                    
                counter++;
                scanner.close();
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
        for(int i = 0; i < productList.size(); i++){
            productList.get(i).displayProduct();
        }
        //Product p1 = new Product("test", 20.99, true);
       // p1.displayProduct();
        //System.out.println(p1.getProductName());


    }
}