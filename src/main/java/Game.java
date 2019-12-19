import java.util.*;

public class Game {
    private Map<Character, List> createdFields;
    Player activePlayer;
    Player player1;
    Player player2;

    public Game() {
        player1 = new Player("Spieler 1", Sign.cross);
        player2 = new Player("Spieler 2", Sign.circle);
        generateCols();
        createdFields = generateCols();

        activePlayer = player1;
    }

    // generate field-cols
    private final Map<Character, List> generateCols(){
        Map cols = new HashMap<>();
        for(char alphabet = 'a'; alphabet <='c'; alphabet++ ) {
            cols.put(alphabet, generateFieldRows(alphabet));
        }
        return cols;
    }

    // generate rows per col
    private final List<Field> generateFieldRows(char col){
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
        if(field.isOccupied() == false) {
            field.setOccupied(true);
        }
        return field.id;
    }

    public void toggleActivePlayer() {
        if (activePlayer == player1) {
            activePlayer = player2;
        } else {
            activePlayer = player1;
        }
    }

    // get the player-icon
    public Sign getActivePlayerSign() {
        Sign sign = activePlayer.getSign();
        return sign;
    }

    public void reset() {
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

// TODO: 19.12.19ö