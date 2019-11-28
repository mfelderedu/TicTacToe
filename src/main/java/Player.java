public class Player {
    String name;
    Sign sign;

    public Player() {
        sign = Sign.cross;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Sign getSign() {
        return sign;
    }

    public void setSign(Sign sign) {
        this.sign = sign;
    }


}
