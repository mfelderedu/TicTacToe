public enum Sign {
    cross('x'),circle('o');
    private final char sign;
    //test

    Sign(char sign) {
        this.sign = sign;
    }

    public char getSign() {
        return sign;
    }
}