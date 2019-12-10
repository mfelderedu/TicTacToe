public class Field {
    String id;
    String sign;
    boolean occupied;

    public Field(String id) {
        this.id = id;
        this.occupied = false;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public void setOccupied(boolean occupied) {
        this.occupied = occupied;
    }

}
