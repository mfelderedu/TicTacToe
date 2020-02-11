import javafx.beans.Observable;
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
import java.util.*;
import java.util.stream.Collectors;

public class Presenter implements Initializable {
    private final Game game;
    private final Main main;

    @FXML
    private Text active_playername;
    @FXML
    private Text sign_active_player;
    @FXML
    private Text sign_trophy; //Trophä
    @FXML
    private Text player1_points;
    @FXML
    private Text player2_points;

    @FXML
    private GridPane field;

    @FXML
    private Button button_newfield;
    @FXML
    private Button button_newgame;
    @FXML
    private Button button_settings;
    @FXML
    private Button button_exit;


    private EventHandler<ActionEvent> fieldClickHandler;
    private static final boolean IS_COMPUTER_PLAYER = true;

    public Presenter(Game game, Main main) {

        this.game = game;
        this.main = main;

        fieldClickHandler = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Button button = (Button) actionEvent.getSource();
                Field clickedField = game.getField(button.getId());
                setClickedField(button, clickedField);
                if (isComputerTurn()) {
                    makeComputerMove();
                }
            }
        };

        List<Player> players = game.getPlayers();
        players.forEach(player -> {
            player.getScoreProperty().addListener(this::scoreChangeListener);
        });


    }

    /**
     * Es wird ueberprueft ob der Computer Spieler an der Reihe ist
     * @return Ob der Computer Spieler spielen darf
     */
    private boolean isComputerTurn() {
        return IS_COMPUTER_PLAYER && !game.isGameWon(game.getActivePlayer().getSign()) && game.getActivePlayer().getSign().representationCharacter() == 'o';
    }

    /**
     * Der Computer wählt zu erst eine zufällige Spalte. Aus dieser wählt er zufällig ein noch nicht besetztes Feld aus.
     * Anschliessend spielt er dieses Feld
     */
    private void makeComputerMove() {

        List<Character> columns = new ArrayList<>(Arrays.asList('a', 'b', 'c'));
        String buttonId = null;
        Field fieldToBeClicked = null;
        while (fieldToBeClicked == null) {
            char column = getNextRandomColumn(columns);
            List<Field> fields = getAllUnOccupiedFieldsOfColumn(column);
            if (fields.size() > 0) {
                Random random = new Random();
                fieldToBeClicked = fields.get(random.nextInt(fields.size()));
                buttonId = column + "" + (game.getGameFields().get(column).indexOf(fieldToBeClicked));
            }
            columns.remove((Character) column);
        }
        Button button = (Button) field.lookup("#" + buttonId);
        setClickedField(button, fieldToBeClicked);
    }

    /**
     * Hole alle nicht besetzten der gewuenschten Spalte
     * @param column Spalte
     * @return Alle nicht bestzten Felder der Spalte
     */
    private List<Field> getAllUnOccupiedFieldsOfColumn( char column) {
        return game.getGameFields().get(column).stream().filter(field -> !field.isOccupied()).collect(Collectors.toList());
    }

    /**
     * Hole eine zufällige Spalte
     * @param columns die Spalten
     * @return eine zuföllig ausgewählte Spalte
     */
    private Character getNextRandomColumn(List<Character> columns) {
        Random random = new Random();
        return columns.get(random.nextInt(columns.size()));
    }

    private void setClickedField(Button button, Field clickedField) {
        if (!clickedField.isOccupied()) {

            Sign sign = game.getActivePlayer().getSign();
            clickedField.setSign(sign);
            button.setText(String.valueOf(sign.representationCharacter()));
            if (game.isGameWon(sign)) {
                showWinnerFields();
                game.addPointToActivePlayer(); //Punkten zählen

                setPlayersPoints();
            } else {
                game.toggleActivePlayer();
                String activeName = game.getActivePlayer().getName();
                active_playername.setText(activeName);
            }
        }
    }

    private void scoreChangeListener(Observable observable) {
        setPlayersPoints();
    }

    private void showWinnerFields() {
        Set<Node> allFieldButtons = getAllFieldButtons();
        allFieldButtons.forEach(node -> {
            if (!game.isWonField(node.getId())) {
                node.setDisable(true);
            }
        });
    }

    private void setPlayersPoints() {
        player1_points.setText("" + game.getPlayerPoints(0));
        player2_points.setText("" + game.getPlayerPoints(1));
    }

    private Set<Node> getAllFieldButtons() {
        return field.lookupAll(".ttt-field");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        String activeName = game.getActivePlayer().getName();
        active_playername.setText(activeName);

        final ObservableList<Node> columns = field.getChildren();
        for (Node node : columns) {
            GridPane column = (GridPane) node;
            ObservableList<Node> buttons = column.getChildren();

            for (Node buttonNode : buttons) {
                Button button = (Button) buttonNode;
                button.setOnAction(fieldClickHandler);
            }
        }

        button_exit.setOnAction(this::exitButtonHandler);
        button_newgame.setOnAction(this::newGameButtonHandler);
        button_newfield.setOnAction(this::newFieldButtonHandler);


    }

    private void newFieldButtonHandler(ActionEvent actionEvent) {
        resetFields();
    }

    private void exitButtonHandler(ActionEvent actionEvent) {
        main.exit();
    }

    private void newGameButtonHandler(ActionEvent actionEvent) {
        resetFields();

        game.resetScores();
    }

    private void resetFields() {
        game.resetFields(); // Logik New Field
        game.toggleActivePlayer();

        String activeName = game.getActivePlayer().getName();
        active_playername.setText(activeName);
        sign_trophy.setVisible(false);
        sign_active_player.setVisible(true);

        resetAllFieldButtons();
    }

    private void resetAllFieldButtons() {
        getAllTicTacToeButtons().forEach(button -> {
            button.setDisable(false);
            ((Button) button).setText("");
        });
    }

    private Set<Node> getAllTicTacToeButtons() {
        return field.lookupAll(".ttt-field");
    }


}