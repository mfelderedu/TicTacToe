import java.util.*;

public class Game {
    private Map<Character, List<Field>> gameFields;
    private Player activePlayer;
    private Player player1;
    private Player player2;

    private Set<Field> wonGameFields; // Gewinner

    public Game() {
        player1 = new Player("Spieler 1", Sign.cross);
        player2 = new Player("Spieler 2", Sign.circle);

        gameFields = generateField();
        wonGameFields = new HashSet<>();

        initPlayerTurn();
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
        } else if(ifDiagonalSameSign(sign)) {
            return true;
        } else {
            return false;
        }
    }
    public boolean ifColumnSameSign(Sign sign) {
        int counterColumn = 0;
        for (char column = 'a'; column <= 'c'; column++) {
            for (int row = 0; row <= 2; row++) {
                Field gameField = gameFields.get(column).get(row); // sieger bestimmen
                if(gameField.getSign() == sign) {
                    counterColumn++;
                    wonGameFields.add(gameField);
                } else {
                    counterColumn--;
                }
            }
            if(counterColumn == 3) {
                return true;
            }else {
                counterColumn = 0;
                wonGameFields.clear();
            }

        }
        return false;
    }

    public boolean ifRowSameSign(Sign sign) {
        int counterRow = 0;
        for (int row = 0; row <= 2; row++) {
            for (char column = 'a'; column <= 'c'; column++) {
                Field gameField = gameFields.get(column).get(row);
                if(gameField.getSign() == sign) {
                    counterRow++;
                    wonGameFields.add(gameField);
                } else {
                    counterRow--;
                }
            }
            if(counterRow == 3) {
                return true;
            }else {
                counterRow = 0;
                wonGameFields.clear();
            }
        }
        return false;
    }

    public boolean ifDiagonalSameSign(Sign sign) {
        char column1 = 'a';
        int row1 = 0;
        int counterDia1 = 0;
        while (column1 <= 'c' && row1 < 3) {
            Field gameField = gameFields.get(column1).get(row1);
            if(gameField.getSign() == sign) {
                counterDia1++;
                wonGameFields.add(gameField);
            } else {
                if((row1 != 1) && (column1 != 'b')) {
                    counterDia1--;
                }
            }
            column1++;
            row1++;
            if(counterDia1 == 3) {
                return true;
            }else {
                counterDia1 = 0;
                wonGameFields.clear();
            }
        }
        /*
        char column2 = 'c';
        int row2 = 2;
        int counterDia2 = 0;
        while (column2 >= 'a' && row2 > 0) {
            Field gameField = gameFields.get(column2).get(row2);
            if(gameField.getSign() == sign) {
                counterDia2++;
                wonGameFields.add(gameField);
            } else if((row2 != 1) && (column2 != 'b')) {
                counterDia2--;
            }
            column2--;
            row2--;
            if(counterDia2 == 3) {
                return true;
            } else {
                counterDia2 = 0;
                wonGameFields.clear();
            }
        }
        */
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

    public String getActivePlayerName() {
        return activePlayer.getPlayerName();
    }

    public void addPointToActivePlayer() {
        activePlayer.addPointToScore();
    }

    public void newGame() {
        resetFields();
        resetScores();
        initPlayerTurn();
    }

    public void initPlayerTurn() {
        activePlayer = player1;
    }

    private void resetScores() {
        player1.resetScore();
        player2.resetScore();
    }

    public void resetFields() {
        for(char column = 'a'; column <='c'; column++ ){
            for (int row = 0; row <= 2; row++) {
                Field field = gameFields.get(column).get(row);
                field.reset();
            }
        }

        wonGameFields.clear();
    }

    public int getPlayerOnePoints() {
        return player1.getScore();
    }

    public int getPlayerTwoPoints() {
        return player2.getScore();
    }


    public boolean isWonField(String fieldId) {
        return wonGameFields.contains(getField(fieldId));
    }
}