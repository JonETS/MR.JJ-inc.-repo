package com.example;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
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
        //ProductName, price(double), instock(true or false) (each var seperated by comma)
        //example: "Yellow Shirt, 10.99, true"
        //new line for each additional product
            
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        
        //read data from file and create product objects from it
        String filePath = "productFile.txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            int counter = 0;
            //read each line in the file
            while ((line = reader.readLine()) != null) {
                line = line.trim(); // Remove leading and trailing whitespace
                if (line.isEmpty()) {
                    continue; // Skip empty lines
                }
                String[] parts = line.split(","); // Split the line by commas
                productList.add(new Product());
                // Set Product ID to match index in list
                productList.get(counter).setProductID(counter);
                // Read file and set name, price, and stock of product in current index
                if (parts.length > 0) {
                    productList.get(counter).setName(parts[0].trim());
                }
                if (parts.length > 1) {
                    productList.get(counter).setPrice(Double.parseDouble(parts[1].trim()));
                }
                if (parts.length > 2) {
                    productList.get(counter).setStock(Boolean.parseBoolean(parts[2].trim()));
                }
                counter++;
            }
        //close reader and display error message if necessary
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Error parsing number: " + e.getMessage());
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Error with array index: " + e.getMessage());
        }
        //print all products created in list:
        for(int i = 0; i < productList.size(); i++){
            productList.get(i).displayProduct();
        }
    }
}
