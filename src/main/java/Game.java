import java.util.*;

public class Game {
    HashMap<String, Field> createdFields = new HashMap<String, Field>();

    public Game() {
        Player player1 = new Player("Spieler 1", Sign.cross);
        Player player2 = new Player("Spieler 2", Sign.circle);

        generateCols();
    }

    // generate field-cols
    public final Map<Character, List> generateCols(){
        Map cols = new HashMap<Character, List>();
        for(char alphabet = 'a'; alphabet <='c'; alphabet++ ) {
            cols.put(alphabet, generateFieldRows(alphabet));
        }
        return cols;
    }

    // generate rows per col
    public final List<Field> generateFieldRows(char col){
        List rows = new ArrayList<Field>();
        for (int j = 0; j <= 2; j++) {
            String fieldName = String.valueOf(col) + j;
            Field field = new Field(fieldName);
            rows.add(field);
            createdFields.put(field.id, field);
        }
        return rows;
    }

    // set Field as Occupied
    public final String checkField(String id) {
        Field field = this.createdFields.get(id);
        field.setOccupied(true);
        return field.id;
    }

    // get the player-icon
    // dont' work
    public final String getSign(String id) {
        Field field = this.createdFields.get(id);
        String sign = "x";
        field.setSign(sign);
        //Sign sign =  Sign.cross;
        return sign;
    }


    public void reset() {
        resetfields();
        resetScores();
    }

    private void resetScores() {

    }

    private void resetfields() {
        field.reset();
    }
}