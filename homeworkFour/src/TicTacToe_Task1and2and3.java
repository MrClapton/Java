import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class TicTacToe_Task1and2and3 {
    public static final char EmptyDot = '•';
    public static final char XDot = 'X';
    public static final char ODot = 'O';

    public static int Size = 5;
    public static int DotsToWin = 4;

    public static char[][] map = new char[Size][Size];
    public static Scanner scanner = new Scanner(System.in);
    public static Random generator = new Random();

    public static void main(String[] args) {
        prepareGame();
        playGame();
        System.out.println("Игра закончена!");
    }

    private static void playGame() {
        while (true) {
            humanTurn();
            printMap();
            if (checkWin(XDot)) {
                System.out.println("Победил человек!");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья!");
                break;
            }

            aiTurn();
            printMap();
            if (checkWin(ODot)) {
                System.out.println("Победил Искусственный Интеллект!");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья!");
                break;
            }
        }
    }

    private static void prepareGame() {
        initMap();
        printMap();
    }

    private static boolean isMapFull() {
        for (char[] row : map) {
            for (char cell : row) {
                if (cell == EmptyDot) {
                    return false;
                }
            }
        }
        return true;
    }


    //@SuppressWarnings("RedundantIfStatement")
    private static boolean checkWin(char symbol) {
        /*
        if (map[0][0] == symbol && map[0][1] == symbol && map[0][2] == symbol) return true;
        if (map[1][0] == symbol && map[1][1] == symbol && map[1][2] == symbol) return true;
        if (map[2][0] == symbol && map[2][1] == symbol && map[2][2] == symbol) return true;

        if (map[0][0] == symbol && map[1][0] == symbol && map[2][0] == symbol) return true;
        if (map[0][1] == symbol && map[1][1] == symbol && map[2][1] == symbol) return true;
        if (map[0][2] == symbol && map[1][2] == symbol && map[2][2] == symbol) return true;

        if (map[0][0] == symbol && map[1][1] == symbol && map[2][2] == symbol) return true;
        if (map[0][2] == symbol && map[1][1] == symbol && map[2][0] == symbol) return true;

        return false;
         */
        for (int i = 0; i < Size - DotsToWin + 1; i++) {
            for (int j = 0; j < Size - DotsToWin + 1; j++) {
                if (checkDiagonal(symbol, i, j) || checkLanes(symbol, i, j)) return true;
            }
        }
        return false;
    }

    private static boolean checkDiagonal(char symbol, int offsetX, int offsetY) {
        boolean toleft, toright;
        toleft = true;
        toright = true;
        for (int i = 0; i < DotsToWin; i++) {
            toleft &= (map[i + offsetX][i + offsetY] == symbol);
            toright &= (map[DotsToWin - i - 1 + offsetX][i + offsetY] == symbol);
        }

        if (toleft || toright) return true;

        return false;
    }

    private static boolean checkLanes(char symbol, int offsetX, int offsetY) {
        boolean cols, rows;
        for (int col = offsetX; col < DotsToWin + offsetX; col++) {
            cols = true;
            rows = true;
            for (int row = offsetY; row < DotsToWin + offsetY; row++) {
                cols &= (map[col][row] == symbol);
                rows &= (map[row][col] == symbol);
            }

            if (cols || rows) return true;
        }

        return false;
    }

    private static void aiTurn() {
        int rowIndex, colIndex;
        do {
            rowIndex = generator.nextInt(Size);
            colIndex = generator.nextInt(Size);
        } while (!isCellValid(rowIndex, colIndex));
        map[rowIndex][colIndex] = ODot;
    }

    private static void humanTurn() {
        int rowIndex = -1, colIndex = -1;
        do {
            System.out.println("Введите координаты в формате <номер строки> <номер колонки>");
            String[] stringData = scanner.nextLine().split(" ");
            if (stringData.length != 2) {
                System.out.println("Введены некорректные данные!");
                continue;
            }
            try {
                rowIndex = Integer.parseInt(stringData[0]) - 1;
                colIndex = Integer.parseInt(stringData[1]) - 1;
            } catch (NumberFormatException e) {
                System.out.println("Были введены некорректные данные!");
            }
        } while (!isCellValid(rowIndex, colIndex));
        map[rowIndex][colIndex] = XDot;
    }

    private static boolean isCellValid(int rowIndex, int colIndex) {
        if (rowIndex < 0 || rowIndex >= Size || colIndex < 0 || colIndex >= Size) {
            return false;
        }
        return map[rowIndex][colIndex] == EmptyDot;
    }

    private static void printMap() {
        printColumnNumbers();
        printRows();
        System.out.println();
    }

    private static void printRows() {
        for (int i = 0; i < map.length; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < map[i].length; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void printColumnNumbers() {
        for (int i = 0; i <= Size; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    private static void initMap() {
        for (char[] row : map) {
            Arrays.fill(row, EmptyDot);
        }
    }
}
