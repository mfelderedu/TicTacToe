public class Player {
    private String name;
    private Sign sign;

    public Player() {
        sign = Sign.cross;
    }

    public String getName() {
        //return name;
        return "foo";
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
