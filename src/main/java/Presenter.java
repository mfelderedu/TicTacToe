import javafx.beans.Observable;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

import javax.swing.*;
import java.net.URL;
import java.util.ResourceBundle;

public class Presenter implements Initializable {
    private final Game game;

    @FXML private Button a1;
    @FXML private Button b1;
    @FXML private Button c1;

    EventHandler<ActionEvent> handler = new EventHandler<>() {
        @Override
        public void handle(ActionEvent actionEvent) {
            Button source = (Button) actionEvent.getSource();
            String id = source.getId();

        }
    };

    public Presenter(Game model) {
        this.game = model;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        a1.setOnAction(handler);
    }

    public void countWins() {

    }

    public void clickOnField() {

    }

    public void clickOnRestart() {

    }

    public void clickOnNewGame() {

    }

    public void clickOnSettings() {

    }

    public void clickOnExit() {

    }




}