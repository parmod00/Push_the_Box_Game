package ui;

import Main.Main;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

/*Created By Parmod and Pooja During internship at solitaire infosys*/

public class Menu implements Initializable {

    @FXML private Button singleButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        singleButton.setOnAction(event -> {
            Main.startSingle();
        });
    }
}
