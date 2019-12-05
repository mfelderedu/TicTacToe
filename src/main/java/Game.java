public class Game {
    private Text text = new Text();

    public Game() {
        Player player1 = new Player("Spieler 1",Sign.cross);
        Player player2 = new Player("Spieler 2",Sign.circle);

        Rectangle border = new Rectangle(200, 200);
        border.setFill(null);
        border.setStroke(Color.BLACK);

        text.setFont(Font.font(72));

        setAlignment(Pos.CENTER);
        getChildren().addAll(border, text);

        setOnMouseClicked(event -> {
            if (!playable)
                return;

            if (event.getButton() == MouseButton.PRIMARY) {
                if (!turnX)
                    return;

                drawX();
                turnX = false;
                checkState();
            } else if (event.getButton() == MouseButton.SECONDARY) {
                if (turnX)
                    return;

}
