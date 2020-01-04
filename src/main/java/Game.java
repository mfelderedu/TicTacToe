import java.util.*;

public class Game {
    private Map<Character, List> createdFields;
    private Player activePlayer;
    private Player player1;
    private Player player2;

    public Game() {
        player1 = new Player("Spieler 1", Sign.cross);
        player2 = new Player("Spieler 2", Sign.circle);

        createdFields = generateField();

        activePlayer = player1;
    }

    // generate field-cols
    private Map<Character, List> generateField(){
        Map<Character, List> columns = new HashMap<>();
        for(char alphabet = 'a'; alphabet <='c'; alphabet++ ) {
            columns.put(alphabet, generateFieldRows(alphabet));
        }
        return columns;
    }

    // generate rows per col
    private List<Field> generateFieldRows(char col){
        List<Field> rows = new ArrayList<>();
        for (int j = 0; j <= 2; j++) {
            String fieldName = String.valueOf(col) + j;
            Field field = new Field(fieldName);
            rows.add(field);
        }
        return rows;
    }

    // set Field as Occupied
    public final String checkField(String id) {
        List<Field> fields = createdFields.get(id.charAt(0));
        Field field = fields.get(Character.getNumericValue(id.charAt(1)));
        if (field.isOccupied() == false) {
            field.setOccupied(true);
        }
        return field.id;
    }

    public void setFieldAsOccupied() {
        //field.setOccupied();
    }
    public boolean checkIfFieldIsOccupied(Field field) {
        return field.isOccupied();
    }

    public void toggleActivePlayer() {
        if (activePlayer == player1) {
            activePlayer = player2;
        } else {
            activePlayer = player1;
        }
    }

    public String toggleActivePlayerName() {
        String name = activePlayer.getPlayerName();
        return name;
    }

    // get the player-icon
    public Sign getActivePlayerSign() {
        Sign sign = activePlayer.getSign();
        return sign;
    }


    public void newGame() {
        resetfields();
        resetScores();
    }

    private void resetScores() {

    }

    private void resetfields() {
        for(char alphabet = 'a'; alphabet <='c'; alphabet++ ){
            for (int j = 0; j <= 2; j++) {
                createdFields.get(alphabet).get(j);
            }
            }
    }
}