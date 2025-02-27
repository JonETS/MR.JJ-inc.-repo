package com.example;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Cart extends Application {

    private VBox cart;
    private int itemCount = 0;
    private Label cartItemLabel;
    private Label cartMoneyLabel;
    private float cartTotal;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Shopping Cart");

        // Create a list to represent the shopping cart
        cart = new VBox();
        cart.setSpacing(10);
        cart.setPadding(new Insets(10));

        cartItemLabel = new Label("Shopping Cart:");
        cartMoneyLabel = new Label("Total:");
        HBox itemContainer = new HBox(cartItemLabel, cart);
        HBox moneyContainer = new HBox(cartMoneyLabel, cart);

        // Create item buttons
        Button addItemButton1 = createAddItemButton("Item 1", 10.0);
        Button addItemButton2 = createAddItemButton("Item 2", 20.0);
        Button addItemButton3 = createAddItemButton("Item 3", 30.0);
        Button removeItemButton1 = createDeleteItemButton("Item 1", 10.0);
        Button removeItemButton2= createDeleteItemButton("Item 2", 20.0);
        Button removeItemButton3 = createDeleteItemButton("Item 3", 30.0);
        Button emptyCart = createClearItems();

        // Create the layout
        VBox root = new VBox(itemContainer,moneyContainer, addItemButton1, addItemButton2, addItemButton3,removeItemButton1,removeItemButton2,removeItemButton3,emptyCart);
        root.setSpacing(10);
        root.setPadding(new Insets(10));

        Scene scene = new Scene(root, 300, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private Button createAddItemButton(String itemName, double itemPrice) {
        Button button = new Button("Add " + itemName + " to Cart");
        button.setOnAction(event -> addItemToCart(itemName, itemPrice));
        return button;
    }

    private Button createDeleteItemButton(String itemName, double itemPrice) {
        Button button = new Button("Remove " + itemName + " from Cart");
        button.setOnAction(event -> removeItemFromCart(itemName, itemPrice));
        return button;
    }

    private Button createClearItems() {
        Button button = new Button("Remove all Items from Cart");
        button.setOnAction(event -> clearCart());
        return button;
    }

    private void addItemToCart(String itemName, double itemPrice) {
        Label itemLabel = new Label(itemName + " - $" + itemPrice);
        cart.getChildren().add(itemLabel);
        itemCount++;
        cartTotal += itemPrice;
        updateCartLabel();
    }

    private void removeItemFromCart(String itemName, double itemPrice) {
        Label itemLabel = new Label(itemName + " - $" + itemPrice);
        cart.getChildren().remove(itemLabel);
        itemCount--;
        cartTotal -= itemPrice;
        updateCartLabel();
    }

    private void clearCart() {
        cart.getChildren().removeAll();
        itemCount = 0;
        cartTotal = 0;
        updateCartLabel();
    }

    private void updateCartLabel() {
        cartItemLabel.setText("Shopping Cart (" + itemCount + " items):");
        cartMoneyLabel.setText("Total amount: $ "+cartTotal);
    }
}