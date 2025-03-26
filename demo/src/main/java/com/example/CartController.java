package com.example;

import java.io.IOException;
import javafx.fxml.FXML;

public class CartController {

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
}
