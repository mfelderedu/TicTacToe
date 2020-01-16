import java.util.*;

public class Game {
    private Map<Character, List<Field>> gameFields;
    private Player activePlayer;
    private Player player1;
    private Player player2;

    public Game() {
        player1 = new Player("Spieler 1", Sign.cross);
        player2 = new Player("Spieler 2", Sign.circle);

        gameFields = generateField();

        activePlayer = player1;
    }

    // generate field-cols
    private Map<Character, List<Field>> generateField(){
        Map<Character, List<Field>> columns = new HashMap<>();
        for(char alphabet = 'a'; alphabet <='c'; alphabet++ ) {
            columns.put(alphabet, generateFieldRows(alphabet));
        }
        return columns;
    }

    // generate rows per col
    private List<Field> generateFieldRows(char col){
        List<Field> rows = new ArrayList<>();
        for (int j = 0; j <= 2; j++) {
            //String fieldName = String.valueOf(col) + j;
            Field field = new Field();
            rows.add(field);
        }
        return rows;
    }

    // set Field as Occupied
    public final Field getField(String id) {
        List<Field> fields = gameFields.get(id.charAt(0));
        Field field = fields.get(Character.getNumericValue(id.charAt(1)));
        return field;
    }

    public boolean isGameWon(Sign sign) {
        if(ifColumnSameSign(sign)) {
            return true;
        } else if(ifRowSameSign(sign)) {
            return true;
        //} else if(ifDiagonalSameSign(sign)) {
       //     return true;
        } else {
            return false;
        }
    }
    public boolean ifColumnSameSign(Sign sign) {
        int counter = 0;
        for (char column = 'a'; column <= 'c'; column++) {
            for (int row = 0; row <= 2; row++) {
                if(gameFields.get(column).get(row).getSign() == sign) {
                    counter++;
                }
            }
            if(counter == 3) {
                return true;
            }
        }
        return false;
    }

    public boolean ifDiagonalSameSign(Sign sign) {
        int counter = 0;
        return false;
    }

    public boolean ifRowSameSign(Sign sign) {
        int counter = 0;
        for (int row = 0; row <= 2; row++) {
             for (char column = 'a'; column <= 'c'; column++) {
                if(gameFields.get(column).get(row).getSign() == sign) {
                    counter++;
                }
            }
            if(counter == 3) {
                return true;
            }
        }
        return false;
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
        for(char column = 'a'; column <='c'; column++ ){
            for (int row = 0; row <= 2; row++) {
                Field field = gameFields.get(column).get(row);
                field.reset();
            }
        }
    }
}