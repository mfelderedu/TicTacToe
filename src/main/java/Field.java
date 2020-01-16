public class Field {
    private String id;
    private Sign sign;
    private boolean occupied;

    public Field(String id) {
        this.id = id;
        this.occupied = false;
    }

    public Sign getSign() {
        return sign;
    }

    public void setSign(Sign sign) {
        this.sign = sign;
        setOccupied(true);
    }

    public boolean isOccupied() {
        return occupied;
    }

    public void setOccupied(boolean occupied) {
        this.occupied = occupied;
    }

    public void reset() {

    }

}
