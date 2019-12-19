import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import javax.swing.*;
import java.net.URL;

public class Main extends Application {
    Stage primaryStage;

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) throws Exception{
        this.primaryStage = primaryStage;
        Game game = new Game();
        Presenter presenter = new Presenter(game, this);

        URL resource = getClass().getResource("view.fxml");
        FXMLLoader loader = new FXMLLoader(resource);

        loader.setController(presenter);

        GridPane root = loader.load();
        initScene(primaryStage, root);

        this.primaryStage.setTitle("Tic Tac Toe");
        this.primaryStage.show();
    }

    private void initScene(Stage primaryStage, GridPane root) {
        final int width = 700;
        final int height = 450;
        Scene scene = new Scene(root, width, height);
        scene.getStylesheets().add("style.css");

        // Icon
        String OS = System.getProperty("os.name").toLowerCase();
        /*
        if(OS.startsWith("mac")) {
            System.getProperties().list(System.out);
            try {
                URL iconURL = Main.class.getResource("icon.png");
                java.awt.Image image = new ImageIcon(iconURL).getImage();
                com.apple.eawt.Application.getApplication().setDockIconImage(image);
            } catch (Exception e) {
            }

        } else {
            primaryStage.getIcons().add(new Image("icon.png"));
        }
        */
        Image systemIcon = new Image("icon.png");
        primaryStage.getIcons().add(systemIcon);

        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
    }

    public void exit() {
        primaryStage.close();
    }
}
