import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Player {
    private String name;
    private Sign sign;
    private IntegerProperty score = new SimpleIntegerProperty(0);

    public Player(String name, Sign sign) {
        this.name = name;
        this.sign = sign;
    }

    public String getName() {
        return name;
    }

    public void setPlayerName(String name) {
        this.name = name;
    }

    public Sign getSign() {
        return sign;
    }

    public void setPlayerSign(Sign sign) {
        this.sign = sign;
    }

    public int getScore() {
        return score.getValue();
    }

    public void incrementScore() {
        score.add(1);
    }

    public void resetScore() {
        score.set(0);
    }

    public IntegerProperty getScoreProperty() {
        return score;
    }
}
