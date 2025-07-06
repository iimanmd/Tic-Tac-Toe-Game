public class Board {
    private char[][] cells;

    public Board() {
        cells = new char[3][3];
        clear();
    }

    public boolean isCellEmpty(int x, int y) {
        return cells[x][y] == ' ';
    }

    public void place(int x, int y, char marker) {
        cells[x][y] = marker;
    }

    public boolean isFull() {
        // vorerst false zurückgeben
        return false;
    }

    public void clear() {
        for (int i=0; i<3; i++) {
            for (int j=0; j<3; j++) {
                cells[i][j] = ' ';
            }
        }
    }

    public void print() {
        System.out.println("Current Board:");
        for (int i=0; i<3; i++) {
            System.out.print("|");
            for (int j=0; j<3; j++) {
                System.out.print(cells[i][j] + "|");
            }
            System.out.println();
        }
    }
}