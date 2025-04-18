package com.example;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.io.IOException;
import java.io.BufferedReader;

/**
 * This class initializes the product list, reads product data from a file,
 * and creates Product objects based on the data.
 * It also handles file creation and reading errors.
 * @author Ricky McCobb
 * @version 1.0
 */
public class Main {
    public static void main(String[] args) {
        /**
         * The main method initializes the product list, creates a file for products,
         * reads product data from the file, and creates Product objects based on the data.
         */
        ArrayList<Product> productList = new ArrayList<>();
        try {
        /**
         * Creates a new file named "productFile.txt" in the current directory.
         * If the file already exists, it will not be created again.
         */
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
        
        /**
         * Reads product data from the "productFile.txt" file.
         * Each line of the file should contain product information in the format:
         * "ProductName, price(double), instock(true or false)".
         * The data is split by commas and used to create Product objects.
         * The product ID is set to match the index in the list.
         * If the file cannot be read or if there are parsing errors, an error message is displayed.
         */
        String filePath = "productFile.txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            int counter = 0;
            //read each line of the file
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

        /**
         * Displays the product information for each product in the list.
         */
        for(Product product : productList) {
            product.displayProduct();
        }
    }
}
