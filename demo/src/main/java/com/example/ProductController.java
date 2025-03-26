package com.example;

import java.io.IOException;
import javafx.fxml.FXML;

public class ProductController {

    @FXML
    private void switchToSearch() throws IOException {
        App.setRoot("search");
    }
    @FXML
    private void switchToCart() throws IOException {
        App.setRoot("cart");
    }
    @FXML
    private void switchToHome() throws IOException {
        App.setRoot("home");
    }
}