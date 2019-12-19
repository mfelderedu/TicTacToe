import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.net.URL;
import java.util.*;
import java.util.HashMap;
import java.util.ResourceBundle;

public class Presenter implements Initializable {
    private final Game game;
    public String activeName;


    Map buttons = new HashMap<Character, List<Button>>();

    @FXML private Text active_playername;
    @FXML private Button a0;
    @FXML private Button b0;
    @FXML private Button c0;
    @FXML private Button a1;
    @FXML private Button b1;
    @FXML private Button c1;
    @FXML private Button a2;
    @FXML private Button b2;
    @FXML private Button c2;
    @FXML private Button button_restart;
    @FXML private Button button_newgame;
    @FXML private Button button_settings;
    @FXML private Button button_exit;


    HashMap<String, Button> contentMap = new HashMap<String, Button>();

    EventHandler<ActionEvent> handler = new EventHandler<>() {

        @Override
        public void handle(ActionEvent actionEvent) {
            // get button-id
            Button source = (Button) actionEvent.getSource();
            String id = source.getId();

            // check the clicked field
            String field = game.checkField(id);
            Button pressedButton = contentMap.get(field);

            //Sign p1 = Sign.cross;
            //pressedButton.setText(String.valueOf(p1));
                // set icon to the field
                //String sign = Sign.cross;
                Sign sign = game.getActivePlayerSign();
                //String sign = "x";

                pressedButton.setText(String.valueOf(sign.representationCharacter()));
                //game.setFieldAsOccupied(id);
                game.toggleActivePlayer();

                String activeName = game.toggleActivePlayerName();
                active_playername.setText(activeName);
        }

    };

    public Presenter(Game game) {
        //buttons.put("a",0);
        this.game = game;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        String activeName = game.toggleActivePlayerName();
        active_playername.setText(activeName);

        //Player activePlayer = game.getActivePlayer();
        /*
        for(Map.Entry<String, Button> field : contentMap.entrySet()){
            field.getValue().setOnAction(handler);
            contentMap.put(field.getKey(), field.getValue());
        }
        */

        // set actions on click on field
        a0.setOnAction(handler);
        b0.setOnAction(handler);
        c0.setOnAction(handler);
        a1.setOnAction(handler);
        b1.setOnAction(handler);
        c1.setOnAction(handler);
        a2.setOnAction(handler);
        b2.setOnAction(handler);
        c2.setOnAction(handler);

        // returns sign to field
        contentMap.put("a0", a0);
        contentMap.put("b0", b0);
        contentMap.put("c0", c0);
        contentMap.put("a1", a1);
        contentMap.put("b1", b1);
        contentMap.put("c1", c1);
        contentMap.put("a2", a2);
        contentMap.put("b2", b2);
        contentMap.put("c2", c2);

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
             Stage stage = (Stage) button_exit.getScene().getWindow();
            stage.close();
    }
    private void newGameButtonHandler(ActionEvent actionEvent){
        contentMap.put(" ", a0);
        contentMap.put(" ", b0);
        contentMap.put(" ", c0);
        contentMap.put(" ", a1);
        contentMap.put(" ", b1);
        contentMap.put(" ", c1);
        contentMap.put(" ", a2);
        contentMap.put(" ", b2);
        contentMap.put(" ", c2);
    }
}