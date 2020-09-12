import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.Scanner;

public class TicTacToeWindow {

    private static final char DOT_EMPTY = '•';
    private static final char DOT_X = 'X';
    private static final char DOT_O = 'O';

    private static final int SIZE = 3;
    private static final int DOTS_TO_WIN = 4;

    private static final char[][] map = new char[SIZE][SIZE];
    private static final Scanner scanner = new Scanner(System.in);
    private static final Random random = new Random();
    public static final String PLAYER_WIN_MESSAGE = "Пользователь победил!";
    public static final String AI_WIN_MESSAGE = "Победил Искуственный Интеллект!";

    public static final JButton[] cells = new JButton[9];
    public static int i;


    public static class InitializeWindow extends JFrame {
        public InitializeWindow(JButton[] cells) {
            setTitle("TicTacToe Game");
            setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            setBounds(920, 540, 400, 400);
            setLayout(new GridLayout(SIZE, SIZE));
            for (int i = 0; i < cells.length; i++) {
                cells[i] = new JButton(String.valueOf(DOT_EMPTY));
                int finalI = i;
                cells[i].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (cells[finalI].getText().charAt(0) == DOT_EMPTY) {
                            cells[finalI].setText("X");
                        } else {
                            System.out.println("Эта клетка уже занята! Выберите пустую клетку для хода!");
                        }
                    }
                });
                add(cells[i]);
            }
            ;
            setVisible(true);
        }

    }


    public static void main(String[] args) {
        prepareGame(cells);
        playGame(cells);
        System.out.println("Игра закончена!");
    }

    private static void playGame(JButton[] cells) {
        //humanTurn(cells);
        //printMap();
        //if (checkEnd(DOT_X, PLAYER_WIN_MESSAGE))
        //break;

        //aiTurn();
        //printMap();
        //if (checkEnd(DOT_O, AI_WIN_MESSAGE))
        //break;
    }

    private static void prepareGame(JButton[] cells) {
        //initMap();
        //printMap();
        InitializeWindow GameWindow = new InitializeWindow(cells);
        /*EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                InitializeWindow GameWindow = new InitializeWindow(cells);//стартовая отрисовка поля игры
            }
        });*/

    }

    private static boolean isMapFull() {
        for (char[] row : map) {
            for (char cell : row) {
                if (cell == DOT_EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean checkEnd(char symbol, String winMessage) {
        if (checkWin(symbol)) {
            System.out.println(winMessage);
            return true;
        }
        if (isMapFull()) {
            System.out.println("Ничья!");
            return true;
        }
        return false;
    }

    private static boolean checkWin(char symbol) {
        if (checkRowsAndCols(symbol)) return true;
        return checkDiagonals(symbol);
    }

    private static boolean checkDiagonals(char symbol) {
        int mainDiagCounter = 0;
        int sideDiagCounter = 0;
        for (int i = 0; i < SIZE; i++) {
            mainDiagCounter = (map[i][i] == symbol) ? mainDiagCounter + 1 : 0;
            sideDiagCounter = (map[i][map.length - 1 - i] == symbol) ? sideDiagCounter + 1 : 0;
            if (mainDiagCounter == DOTS_TO_WIN || sideDiagCounter == DOTS_TO_WIN) {
                return true;
            }
        }
        return false;
    }

    private static boolean checkRowsAndCols(char symbol) {
        for (int i = 0; i < SIZE; i++) {
            int rowCounter = 0;
            int colCounter = 0;
            for (int j = 0; j < SIZE; j++) {
                rowCounter = (map[i][j] == symbol) ? rowCounter + 1 : 0;
                colCounter = (map[j][i] == symbol) ? colCounter + 1 : 0;
                if (rowCounter == DOTS_TO_WIN || colCounter == DOTS_TO_WIN) {
                    return true;
                }
            }
        }
        return false;
    }

    /*private static void aiTurn() {
        int[] cell = getCellToBlockOpponent(DOT_X);
        if (cell == null) {
            cell = getRandomEmptyCell();
        }
        int rowIndex = cell[0];
        int colIndex = cell[1];
        setCell(rowIndex, colIndex, DOT_O);
    }*/ //aiTurn

    /*private static int[] getRandomEmptyCell() {
        int rowIndex, colIndex;
        do {
            rowIndex = random.nextInt(SIZE);
            colIndex = random.nextInt(SIZE);
        } while (!isCellValid(rowIndex, colIndex));
        return new int[] {rowIndex, colIndex};
    }*/ //getRandomEmptyCell

    @SuppressWarnings("SameParameterValue")
    private static int[] getCellToBlockOpponent(char opponentSymbol) {
        for (int rowIndex = 0; rowIndex < map.length; rowIndex++) {
            for (int colIndex = 0; colIndex < map[rowIndex].length; colIndex++) {
                if (map[rowIndex][colIndex] == DOT_EMPTY && isGameMoveWinning(rowIndex, colIndex, opponentSymbol)) {
                    return new int[]{rowIndex, colIndex};
                }
            }
        }

        return null;
    }

    private static boolean isGameMoveWinning(int rowIndex, int colIndex, char opponentSymbol) {
        setCell(rowIndex, colIndex, opponentSymbol);
        boolean result = checkWin(opponentSymbol);
        setCell(rowIndex, colIndex, DOT_EMPTY);
        return result;
    }

    private static void setCell(int rowIndex, int colIndex, char symbol) {
        map[rowIndex][colIndex] = symbol;
    }

   /*private static void humanTurn(JButton[] cells) {
        //int rowIndex = -1, colIndex = -1;
        do {
            System.out.println("Введите координаты в формате '<номер строки> <номер колонки>'");

            String[] stringData = scanner.nextLine().split(" ");
            if (stringData.length != 2) {
                System.out.println("Были введены некорректные данные!");
                continue;
            }
            try {
                rowIndex = Integer.parseInt(stringData[0]) - 1;
                colIndex = Integer.parseInt(stringData[1]) - 1;
            } catch (NumberFormatException e) {
                System.out.println("Были введены некорректные данные!");
            }
        } while (!isCellValid(rowIndex, colIndex));

        setCell(rowIndex, colIndex, DOT_X);

        System.out.println("Делайте Ваш ход кликом мыши по свободному полю");

        //for (JButton cell : cells) {
            //cell.addActionListener(new ActionListener() {
                //@Override
                //public void actionPerformed(ActionEvent e) {
                    //if (cell.getText().charAt(0) == DOT_EMPTY) {
                        //cell = new JButton(String.valueOf(DOT_X));
                    //}
                //}
            //});
        //}
        for (i = 0; i < cells.length - 1; i++) {
            cells[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (cells[i].getText().charAt(0) == DOT_EMPTY) {
                        cells[i].setText("X");
                    } else {
                        System.out.println("Эта клетка уже занята! Выберите пустую клетку для хода!");
                    }
                }
            });
        }
    }*/

    //@SuppressWarnings("BooleanMethodIsAlwaysInverted")
    /*private static boolean isCellValid(int rowIndex, int colIndex) {
        if (rowIndex < 0 || rowIndex >= SIZE || colIndex < 0 || colIndex >= SIZE) {
            return false;
        }

        return map[rowIndex][colIndex] == DOT_EMPTY;
    }*/

    /*private static void printMap() {
        printColumnNumbers();
        printRows();
        System.out.println();
    }*/ //printMap

    /*private static void printRows() {
        for (int i = 0; i < map.length; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < map[i].length; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }*/ //printRows

    /*private static void printColumnNumbers() {
        for (int i = 0; i <= SIZE; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
    }*/ //printColumnNumbers

    /*private static void initMap() {
        for (char[] row : map) {
            Arrays.fill(row, DOT_EMPTY);
        }
    }*/ //initMap


}

