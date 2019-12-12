public enum Sign {
    cross('x'),circle('o');
    private final char sign;

    Sign(char sign) {
        this.sign = sign;
    }

    public char representationCharacter() {
        return sign;
    }
}