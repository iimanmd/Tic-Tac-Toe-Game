import java.util.Scanner;

public class TicTacToe {
    private Player player1;
    private Player player2;
    private Player currentPlayer;
    private Board board;

    public void start() {
        Scanner scanner = new Scanner(System.in);
        board = new Board();
        player1 = new Player('X');
        player2 = new Player('O');
        currentPlayer = player1;

        while (true) {
            board.print();
            System.out.println("Current Player: " + currentPlayer.getMarker());

            System.out.print("row (0-2): ");
            int row = scanner.nextInt();

            System.out.print("column (0-2): ");
            int col = scanner.nextInt();

            if (row < 0 || row > 2 || col < 0 || col > 2) {
                System.out.println("Invalid input. Try again.");
                continue;
            }

            if (!board.isCellEmpty(row, col)) {
                System.out.println("Cell is already occupied. Try again.");
                continue;
            }

            board.place(row, col, currentPlayer.getMarker());

            // (Später prüfen wir hier auf Sieg oder Unentschieden)

            switchCurrentPlayer();
        }
    }

    public void switchCurrentPlayer() {
        currentPlayer = (currentPlayer == player1) ? player2 : player1;
    }

    public boolean hasWinner() {
        return false; // wird später umgesetzt
    }
}
