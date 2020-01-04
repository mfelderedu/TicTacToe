import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.net.URL;
import java.util.*;
import java.util.HashMap;
import java.util.ResourceBundle;

public class Presenter implements Initializable {
    private final Game game;
    private final Main main;

    @FXML private Text active_playername;

    @FXML private GridPane field;

    @FXML private Button button_newfield;
    @FXML private Button button_newgame;
    @FXML private Button button_settings;
    @FXML private Button button_exit;

    private EventHandler<ActionEvent> handler;

    public Presenter(Game game, Main main) {
        this.game = game;
        this.main = main;

        handler = new EventHandler<>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Button button = (Button) actionEvent.getSource();
                game.checkField(button.getId());

                // set icon to the field
                Sign sign = game.getActivePlayerSign();
                button.setText(String.valueOf(sign.representationCharacter()));

                game.toggleActivePlayer();
            }
        };
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        String activeName = game.toggleActivePlayerName();
        active_playername.setText(activeName);

        final ObservableList<Node> columns = field.getChildren();
        for(Node node : columns) {
            GridPane column = (GridPane) node;
            ObservableList<Node> buttons = column.getChildren();

            for(Node buttonNode : buttons) {
                Button button = (Button) buttonNode;
                button.setOnAction(handler);
            }
        }

        button_exit.setOnAction(this::exitButtonHandler);
        button_newgame.setOnAction(this::newGameButtonHandler);

    }

    public void countWins() {

    }

    public void clickOnField() {

    }

    public void clickOnRestart() {

    }


    public void settingButtonHandler(ActionEvent actionEvent) {

    }

    private void exitButtonHandler(ActionEvent actionEvent) {
        main.exit();

    }
    private void newGameButtonHandler(ActionEvent actionEvent){
       game.newGame();
    }
}