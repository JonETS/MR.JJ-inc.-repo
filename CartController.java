package com.example;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

/**
 * This Controller class handles the Cart Class and all the backend functionality for its buttons
 * Currently contains tester buttons to test label creation and label deletion
 * @author Jason Tran
 * @version 1.5
 */
public class CartController {
    /* 
    @FXML
    private void switchToSearch() throws IOException {
        App.setRoot("search");
    }
    @FXML
    private void switchToHome() throws IOException {
        App.setRoot("home");
    }
    @FXML
    private void switchToAccount() throws IOException {
        App.setRoot("account");
    }
    */

    private int itemCount = 0;

    private float cartTotal;

    @FXML
    private Button addItemButton1;

    @FXML
    private Button addItemButton2;

    @FXML
    private Button addItemButton3;

    @FXML
    private VBox cart;

    @FXML
    private Label cartItemLabel;

    @FXML
    private Label cartMoneyLabel;

    @FXML
    private Button emptyCart;

    @FXML
    private Button removeItemButton1;

    @FXML
    private Button removeItemButton2;

    @FXML
    private Button removeItemButton3;

    /**
     * Creates the item to be placed into cart
     * Tester Button
     * @param event
     */
    @FXML
    void addItemAction1(ActionEvent event) 
    {
        String itemName = "Product 1";
        float itemPrice = 10;
        Label itemLabel = new Label(itemName + " - $" + itemPrice);
        cart.getChildren().add(itemLabel);
        itemCount++;
        cartTotal += itemPrice;
        updateCartLabel();
    }

    @FXML
    void addItemAction2(ActionEvent event) 
    {

    }

    @FXML
    void addItemAction3(ActionEvent event) 
    {

    }

    /**
     * Clears the item placed into cart
     * Tester Button
     * @param event
     */
    @FXML
    void clearItemAction1(ActionEvent event) 
    {
        String itemName = "Product 1";
        float itemPrice = 10;
        Label itemLabel = new Label(itemName + " - $" + itemPrice);
        cart.getChildren().remove(itemLabel);
        itemCount--;
        cartTotal -= itemPrice;
        updateCartLabel();
    }

    @FXML
    void clearItemAction2(ActionEvent event) 
    {

    }

    @FXML
    void clearItemAction3(ActionEvent event)
    {

    }

    /**
     * Clears all products from the cart and set the totals to 0
     * @param event
     */
    @FXML
    void emptyCartAction(ActionEvent event) 
    {
        cart.getChildren().removeAll();
        itemCount = 0;
        cartTotal = 0;
        updateCartLabel();
    }

    /**
     * This method handles the updating of cart total price and total amount
     */
    private void updateCartLabel() 
    {
        cartItemLabel.setText("Shopping Cart (" + itemCount + " items):");
        cartMoneyLabel.setText("Total amount: $ "+cartTotal);
    }
}
