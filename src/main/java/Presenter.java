import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

import java.net.URL;
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

    private EventHandler<ActionEvent> fieldClickHandler;

    public Presenter(Game game, Main main) {
        this.game = game;
        this.main = main;

        fieldClickHandler = new EventHandler<>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Button button = (Button) actionEvent.getSource();
                Field clickedField = game.getField(button.getId());

                if(!clickedField.isOccupied()) {
                    // set icon to the field
                    Sign sign = game.getActivePlayerSign();
                    clickedField.setSign(sign);
                    button.setText(String.valueOf(sign.representationCharacter()));

                    game.toggleActivePlayer();
                    String activeName = game.toggleActivePlayerName();
                    active_playername.setText(activeName);
                }
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
                button.setOnAction(fieldClickHandler);
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