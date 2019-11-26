import javafx.application.Application;
import javafx.fxml.FXMLLoader;

import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) throws Exception{
        Model model = new Model();
        Presenter presenter = new Presenter(model);

        FXMLLoader loader = new FXMLLoader(getClass().getResource("view.fxml"));
        loader.setController(presenter);

        GridPane root = loader.load();
        initScene(primaryStage, root);

        primaryStage.setTitle("TIc Tac Toe");
        primaryStage.show();
    }

    private void initScene(Stage primaryStage, GridPane root) {
        final int width = 700;
        final int height = 450;
        Scene scene = new Scene(root, width, height);
        primaryStage.setResizable(false);
        scene.getStylesheets().add("style.css");
        primaryStage.setScene(scene);
    }
}
