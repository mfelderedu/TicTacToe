public class Player {
    private String name;
    private Sign sign;
    private int score;

    public Player(String name, Sign sign) {
        this.name = name;
        this.sign = sign;
    }

    public String getPlayerName() {
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
        return score;
    }

    public void addPointToScore() {
        score++;
    }

    public void resetScore() {
        score = 0;
    }
}
