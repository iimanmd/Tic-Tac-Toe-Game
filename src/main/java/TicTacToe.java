import java.util.Scanner;

public class TicTacToe {

    private Player player1;
    private Player player2;
    private Player currentPlayer;
    public Board board;

    public TicTacToe() {
        player1 = new Player('X');
        player2 = new Player('O');
        currentPlayer = player1;
        board = new Board();
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        boolean playing = true;

        while (playing) {
            System.out.println("Current Player: " + currentPlayer.getMarker());
            board.print();

            int row = -1;
            int col = -1;

            // Eingabe validieren, bis gültig
            while (true) {
                System.out.print("row (0-2): ");
                row = Integer.parseInt(scanner.nextLine());
                System.out.print("column (0-2): ");
                col = Integer.parseInt(scanner.nextLine());

                if (row >= 0 && row <= 2 && col >= 0 && col <= 2 && board.isCellEmpty(row, col)) {
                    break;
                } else {
                    System.out.println("Invalid move. Try again.");
                }
            }

            board.place(row, col, currentPlayer.getMarker());

            // Spiel prüfen
            if (hasWinner()) {
                board.print();
                System.out.println("Player " + currentPlayer.getMarker() + " wins!");
                playing = askForNewGame(scanner);
            } else if (board.isFull()) {
                board.print();
                System.out.println("Draw!");
                playing = askForNewGame(scanner);
            } else {
                switchCurrentPlayer();
            }
        }

        System.out.println("Thanks for playing!");
        scanner.close();
    }

    public void switchCurrentPlayer() {
        currentPlayer = (currentPlayer == player1) ? player2 : player1;
    }

    public boolean hasWinner() {
        char marker = currentPlayer.getMarker();
        char[][] c = board.cells;  // Direkt zugriff, falls cells public oder Getter anpassen

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

    private boolean askForNewGame(Scanner scanner) {
        System.out.println("Do you want to play again? (y/n): ");
        String input = scanner.nextLine().trim().toLowerCase();
        if (input.equals("y")) {
            board.clear();
            currentPlayer = player1;
            return true;
        } else {
            return false;
        }
    }
}

