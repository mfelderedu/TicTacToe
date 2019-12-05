import javafx.beans.Observable;

import java.util.*;

public class Game {
    public Game() {
        Player player1 = new Player("Spieler 1", Sign.cross);
        Player player2 = new Player("Spieler 2", Sign.circle);

        generateFields();
    }

    public final Map<Character, List> generateFields(){
        Map cols = new HashMap<Character, List>();
        for(char alphabet = 'a'; alphabet <='c'; alphabet++ ) {
            cols.put(alphabet,generateRows(alphabet));
        }
        return cols;
    }

    public final List<Field> generateRows(char col){
        List rows = new ArrayList<Field>();
        for (int j = 0; j <= 2; j++) {
            String fieldName = String.valueOf(col) + j;
            Field field = new Field(fieldName);
            rows.add(field);
        }
        return rows;
    }
}