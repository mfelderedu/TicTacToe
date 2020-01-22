
public class Field {
    private Sign sign;
    private boolean occupied = false;

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
        sign= null;
        occupied = false;
    }
}
