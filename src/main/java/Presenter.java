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

    @FXML private Button a0;
    @FXML private Button b0;
    @FXML private Button c0;
    @FXML private Button a1;
    @FXML private Button b1;
    @FXML private Button c1;
    @FXML private Button a2;
    @FXML private Button b2;
    @FXML private Button c2;


    EventHandler<ActionEvent> handler = new EventHandler<>() {
        @Override
        public void handle(ActionEvent actionEvent) {
            Button source = (Button) actionEvent.getSource();
            String id = source.getId();

            game.checkField(id);
            //game.getPlayerSign().addListener(this::signStringListener);
            game.setSign('x');

        }
    };

    public Presenter(Game game) {
        this.game = game;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        a0.setOnAction(handler);
        b0.setOnAction(handler);
        c0.setOnAction(handler);
        a1.setOnAction(handler);
        b1.setOnAction(handler);
        c1.setOnAction(handler);
        a2.setOnAction(handler);
        b2.setOnAction(handler);
        c2.setOnAction(handler);
    }

    public void setSignToField(String id) {

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