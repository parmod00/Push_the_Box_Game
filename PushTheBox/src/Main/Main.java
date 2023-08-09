package Main;

/*Created By Parmod and Pooja During internship at solitaire infosys*/

import business.Game;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;
import ui.GameMenu;

import java.net.URL;



public class Main extends Application{

    public static Game game;

    @Override
    public void start(Stage primaryStage) throws Exception {
        System.setProperty("prism.lcdtext", "false");
        Parent parent = FXMLLoader.load(new URL("file:src/ui/Menu.fxml"));
        Scene scene = new Scene(parent);
        Stage window = new Stage();
        window.setScene(scene);
        window.setTitle("Sokoban");
        window.initModality(Modality.APPLICATION_MODAL);
        window.setResizable(false);
        window.getIcons().add(new Image("file:resources/PushBox.jpg"));
        window.show();
        window.setOnCloseRequest(event -> System.exit(0));
    }

    public static void startSingle(){
        String filename = "resources/maps.txt";
        game = new Game(filename, false);
        new GameMenu(false);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
