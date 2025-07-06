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

            if (hasWinner()) {
                board.print();
                System.out.println("Player " + currentPlayer.getMarker() + " wins!");
                break; // Spiel beenden
            } else if (board.isFull()) {
                board.print();
                System.out.println("Draw!");
                break; // Spiel beenden
            } else {
                switchCurrentPlayer();
            }
        }

        scanner.close();
    }

    public void switchCurrentPlayer() {
        currentPlayer = (currentPlayer == player1) ? player2 : player1;
    }

    public boolean hasWinner() {
        char marker = currentPlayer.getMarker();
        char[][] c = board.getCells();

        // Reihen prüfen
        for (int i = 0; i < 3; i++) {
            if (c[i][0] == marker && c[i][1] == marker && c[i][2] == marker) return true;
        }

        // Spalten prüfen
        for (int j = 0; j < 3; j++) {
            if (c[0][j] == marker && c[1][j] == marker && c[2][j] == marker) return true;
        }

        // Diagonalen prüfen
        if (c[0][0] == marker && c[1][1] == marker && c[2][2] == marker) return true;
        if (c[0][2] == marker && c[1][1] == marker && c[2][0] == marker) return true;

        return false;
    }

    public static void main(String[] args) {
        new TicTacToe().start();
    }
}
