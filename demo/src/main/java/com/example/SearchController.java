package com.example;

import java.io.IOException;
import javafx.fxml.FXML;

public class SearchController {

    @FXML
    private void switchToHome() throws IOException {
        App.setRoot("home");
    }
    @FXML
    private void switchToCart() throws IOException {
        App.setRoot("cart");
    }
    @FXML
    private void switchToAccount() throws IOException {
        App.setRoot("account");
    }
    @FXML
    private void switchToProduct() throws IOException {
        App.setRoot("product");
    }
}
