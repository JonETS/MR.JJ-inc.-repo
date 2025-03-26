package com.example;

import java.io.IOException;
import javafx.fxml.FXML;

public class SecondaryController {

    @FXML
    private void switchToSearch() throws IOException {
        App.setRoot("search");
    }
}