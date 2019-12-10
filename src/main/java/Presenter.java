import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

import javax.swing.*;
import java.net.URL;
import java.util.HashMap;
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

    HashMap<String, Button> contentMap = new HashMap<String, Button>();
    int count = 0;

    EventHandler<ActionEvent> handler = new EventHandler<>() {

        @Override
        public void handle(ActionEvent actionEvent) {
            Button source = (Button) actionEvent.getSource();
            String id = source.getId();

            String field = game.checkField(id);
            Button pressedButton = contentMap.get(field);
            if(count == 0) {
                pressedButton.setText("x");
                count = 1;
            } else {
                pressedButton.setText("o");
                count = 0;
            }
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
        contentMap.put("a0", a0);
        contentMap.put("b0", b0);
        contentMap.put("c0", c0);
        contentMap.put("a1", a1);
        contentMap.put("b1", b1);
        contentMap.put("c1", c1);
        contentMap.put("a2", a2);
        contentMap.put("b2", b2);
        contentMap.put("c2", c2);
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