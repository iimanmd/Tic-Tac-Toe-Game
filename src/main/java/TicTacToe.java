import java.util.Scanner;

public class TicTacToe {
    private Player player1;
    private Player player2;
    private Player currentPlayer;
    private Board board;

    public TicTacToe() {
        board = new Board();
        player1 = new Player('X');
        player2 = new Player('O');
        currentPlayer = player1;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            board.print();
            System.out.println("Current Player: " + currentPlayer.getMarker());

            System.out.print("row (0-2): ");
            int row = scanner.nextInt();

            System.out.print("column (0-2): ");
            int col = scanner.nextInt();

            if (!makeMove(row, col)) {
                System.out.println("Invalid move. Try again.");
                continue;
            }

            if (hasWinner()) {
                board.print();
                System.out.println("Player " + currentPlayer.getMarker() + " wins!");
                break;
            } else if (board.isFull()) {
                board.print();
                System.out.println("Draw!");
                break;
            }

            switchCurrentPlayer();
        }

        scanner.close();
    }

    public boolean makeMove(int row, int col) {
        if (row < 0 || row > 2 || col < 0 || col > 2) return false;
        if (!board.isCellEmpty(row, col)) return false;

        board.place(row, col, currentPlayer.getMarker());
        return true;
    }

    public void switchCurrentPlayer() {
        currentPlayer = (currentPlayer == player1) ? player2 : player1;
    }

    public boolean hasWinner() {
        char marker = currentPlayer.getMarker();
        char[][] c = board.getCells();

        // Zeilen
        for (int i = 0; i < 3; i++) {
            if (c[i][0] == marker && c[i][1] == marker && c[i][2] == marker) return true;
        }

        // Spalten
        for (int j = 0; j < 3; j++) {
            if (c[0][j] == marker && c[1][j] == marker && c[2][j] == marker) return true;
        }

        // Diagonalen
        if (c[0][0] == marker && c[1][1] == marker && c[2][2] == marker) return true;
        if (c[0][2] == marker && c[1][1] == marker && c[2][0] == marker) return true;

        return false;
    }

    public Board getBoard() {
        return board;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(Player player) {
        this.currentPlayer = player;
    }
}
