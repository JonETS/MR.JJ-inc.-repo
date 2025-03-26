package com.example;

import java.io.IOException;
import javafx.fxml.FXML;

public class HomeController {

    @FXML
    private void switchToSearch() throws IOException {
        App.setRoot("search");
    }
    @FXML
    private void switchToCart() throws IOException {
        App.setRoot("cart");
    }
    @FXML
    private void switchToAccount() throws IOException {
        App.setRoot("account");
    }
}
