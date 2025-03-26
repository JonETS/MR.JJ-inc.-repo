package com.example;

import java.io.IOException;
import javafx.fxml.FXML;

public class AccountController {

    @FXML
    private void switchToHome() throws IOException {
        App.setRoot("home");
    }
    @FXML
    private void switchToCart() throws IOException {
        App.setRoot("cart");
    }
}