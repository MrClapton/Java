import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class TicTacLogic extends JFrame implements ActionListener {
    private JLabel ScoreTable;
    private JPanel content = new JPanel();
    private int ScoreX = 0, ScoreO = 0;
    private JButton buttonsXO[];
    private final static int BUTTON_WIDTH = 80;
    private final static int BUTTON_HEIGHT = 80;

    private static Random generator = new Random();
    private boolean printRandom = true;

    public static final char EmptyDot = '•';
    public static int SIZE = 3;
    public static int DotsToWin = 4;

    private int arrayRows[] = new int[8]; // This Table is add : ( 1 For X ) And ( -1 For O )
    private boolean mCenterFirst = false;
    private boolean mCornerFirst = false;
    private boolean mHvFirst = false;
    private boolean mHvAfterCorner = false;
    private boolean mCornerAfterHv = false;
    private boolean mCornerAfterCenter = false;
    private boolean mHvAfterHv = false;
    private int mCounter = 0;
    private boolean mCorner = false;
    private boolean mHvAfterCenter = false;

    private final static int POSITION_XO_H[] = {30, BUTTON_WIDTH * 1 + 30, BUTTON_WIDTH * 2 + 30, BUTTON_WIDTH * 3 + 30}; // Dimension Of Button Horizontal
    private final static int POSITION_XO_V[] = {120, BUTTON_WIDTH * 1 + 120, BUTTON_WIDTH * 2 + 120, BUTTON_WIDTH * 3 + 120 + 20}; // Dimontion Of Button Vertical & The Value 20 For Margin-Top

    public TicTacLogic() {

        setTitle("TicTacToe GAME");

        ScoreTable = new JLabel("");
        printScore(ScoreX, ScoreO);
        ScoreTable.setSize(/*170,10,*/200, JFrame.HEIGHT);
        ScoreTable.setFont(new Font("Comic Sans MS", Font.ITALIC, 16));
        this.add(ScoreTable, BorderLayout.NORTH);
        setVisible(true);

        buttonsXO = new JButton[SIZE * SIZE];

        for (int i = 0; i < buttonsXO.length; i++) {
            buttonsXO[i] = new JButton();
            content.add(buttonsXO[i], BorderLayout.CENTER);
            if (i < 3) {
                buttonsXO[i].setBounds(POSITION_XO_H[i], POSITION_XO_V[0], BUTTON_WIDTH, BUTTON_HEIGHT);
            } else if (i < 6) {
                buttonsXO[i].setBounds(POSITION_XO_H[i - 3], POSITION_XO_V[1], BUTTON_WIDTH, BUTTON_HEIGHT);
            } else if (i < 9) {
                buttonsXO[i].setBounds(POSITION_XO_H[i - 6], POSITION_XO_V[2], BUTTON_WIDTH, BUTTON_HEIGHT);
            }
            buttonsXO[i].setFont(new Font("Comic Sans MS", Font.PLAIN, 26));
            buttonsXO[i].setBackground(Color.WHITE); // Change The Color of The Button
            this.add(buttonsXO[i]);
        }
        for (int i = 0; i < SIZE * SIZE; i++) {
            buttonsXO[i].addActionListener(this);
        }

        this.setBounds(400, 170, buttonsXO[0].getWidth() * 3 + 75, ScoreTable.getHeight() + buttonsXO[0].getHeight() * 3 + 120);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 9; i++) {
            if (e.getSource() == buttonsXO[i]) {
                if (buttonsXO[i].getText().equals("")) {
                    printXO4Me(i);

                    if (checkEnd(true)) {
                        printXO4AI();
                        checkEnd(false);
                    }
                }
            }
        }
    }

    private void printScore(int x, int o) {
        x = 0;
        o = 0;
        String xFormat = setColor(String.valueOf(x), "green");
        String oFormat = setColor(String.valueOf(o), "green");

        if (x > o) {
            xFormat = setColorOnly(String.valueOf(x), "green");
            oFormat = setColorOnly(String.valueOf(o), "red");
        } else if (x < o) {
            xFormat = setColorOnly(String.valueOf(x), "red");
            oFormat = setColorOnly(String.valueOf(o), "green");
        }
        String p1 = "You";
        String p2 = "AI";

        ScoreTable.setText("<html><table border='1'><tr><th colspan='2'>Score :&nbsp;&nbsp;&nbsp;</th></tr>"
                + "<tr><td><b>" + p1 + "</b></td><td>" + xFormat + "</td></tr>"
                + "<tr><td><b>" + p2 + "</b></td><td>" + oFormat + "</td></tr></html>");
    }

    private static String setColorOnly(String before, String color) {
        return "<font color='" + color + "'>" + before + "</font>";
    }

    protected static String setColor(String before, String color) { // Change Color Of String
        return "<html><font color='" + color + "'>" + before + "</font></html>";
    }


    private boolean checkEnd(boolean isHuman) {
        if (((buttonsXO[0].getText().equals(buttonsXO[3].getText())) && (buttonsXO[0].getText().equals(buttonsXO[6].getText())) && (!buttonsXO[0].getText().equals("")))
                || ((buttonsXO[1].getText().equals(buttonsXO[4].getText())) && (buttonsXO[1].getText().equals(buttonsXO[7].getText())) && (!buttonsXO[1].getText().equals("")))
                || ((buttonsXO[2].getText().equals(buttonsXO[5].getText())) && (buttonsXO[2].getText().equals(buttonsXO[8].getText())) && (!buttonsXO[2].getText().equals("")))
                || ((buttonsXO[0].getText().equals(buttonsXO[1].getText())) && (buttonsXO[0].getText().equals(buttonsXO[2].getText())) && (!buttonsXO[0].getText().equals("")))
                || ((buttonsXO[3].getText().equals(buttonsXO[4].getText())) && (buttonsXO[3].getText().equals(buttonsXO[5].getText())) && (!buttonsXO[3].getText().equals("")))
                || ((buttonsXO[6].getText().equals(buttonsXO[7].getText())) && (buttonsXO[6].getText().equals(buttonsXO[8].getText())) && (!buttonsXO[6].getText().equals("")))
                || ((buttonsXO[0].getText().equals(buttonsXO[4].getText())) && (buttonsXO[0].getText().equals(buttonsXO[8].getText())) && (!buttonsXO[0].getText().equals("")))
                || ((buttonsXO[2].getText().equals(buttonsXO[4].getText())) && (buttonsXO[2].getText().equals(buttonsXO[6].getText())) && (!buttonsXO[2].getText().equals("")))) {
            if (isHuman) {
                ScoreX++;
                JOptionPane.showMessageDialog(null, setColor("You Win  ^_^ !", "green"));
            } else {
                ScoreO++;
                JOptionPane.showMessageDialog(null, "<html>" + setColorOnly("You Lose : (", "red") + "<br>AI " + setColorOnly("Win !", "green") + "</html>");
            }
            printScore(ScoreX, ScoreO);
            clear();
            return false;
        } else {
            if (!buttonsXO[0].getText().equals("")
                    && !buttonsXO[1].getText().equals("")
                    && !buttonsXO[2].getText().equals("")
                    && !buttonsXO[3].getText().equals("")
                    && !buttonsXO[4].getText().equals("")
                    && !buttonsXO[5].getText().equals("")
                    && !buttonsXO[6].getText().equals("")
                    && !buttonsXO[7].getText().equals("")
                    && !buttonsXO[8].getText().equals("")) {
                JOptionPane.showMessageDialog(null, " Draw !");
                clear();
                return false;
            } else {
                printRandom = true;
            }
        }
        return true;
    }

    private void clear() { // This Function For Clean The Screen & Initialize All Variables
        for (int i = 0; i < 9; i++) {
            buttonsXO[i].setText(""); // Remove The Contain Of ButtonXO

            for (int j = 0; j < 8; j++) {
                arrayRows[j] = 0;
                mCenterFirst = false;
                mCornerFirst = false;
                mHvFirst = false;
                mHvAfterCorner = false;
                mCornerAfterHv = false;
                mCornerAfterCenter = false;
                mHvAfterHv = false;
                mCorner = false;
                mHvAfterCenter = false;
                mCounter = 0;
            }
        }
    }

    private void printXO4Me(int index) {
        buttonsXO[index].setText(setColor("X", "green"));
        if (index == 4) {
            if (mCounter == 0) { // Check If The First Checked Is The Center
                mCenterFirst = true;
            }
        } else if (index == 0 || index == 2 || index == 6 || index == 8) { // Corner
            if (mCounter == 0) { // Check If The First Checked Is The Corner
                mCornerFirst = true;
            } else {
                if (mCenterFirst) {
                    mCornerAfterCenter = true;
                    mCenterFirst = false;
                }
                mCorner = true;
                mCornerFirst = false;
                if (mHvFirst) {
                    mCornerAfterHv = true;
                }
                mHvFirst = false;
            }
        } else {
            if (mCounter == 0) {
                mHvFirst = true;
            } else {
                if (mCornerFirst) {
                    mHvAfterCorner = true;
                    mCornerFirst = false;
                } else if (mHvFirst) {
                    mHvAfterHv = true;
                    mHvFirst = false;
                } else if (mCenterFirst) {
                    mHvAfterCenter = true;
                    mCornerAfterCenter = false;
                    mCenterFirst = false;
                } else {
                    mCorner = false;
                }
            }
        }
        fillArray(index, 1);
        mCounter++;
    }

    private void printXO4AI() {
        if (mCenterFirst) {
            //TODO play in corner
            if (buttonsXO[0].getText().equals("")) {
                fillCaseAI(0);
            } else if (buttonsXO[2].getText().equals("")) {
                fillCaseAI(2);
            } else if (buttonsXO[6].getText().equals("")) {
                fillCaseAI(6);
            } else if (buttonsXO[8].getText().equals("")) {
                fillCaseAI(8);
            }
        } else if (mCornerFirst) {
            //TODO play in center
            fillCaseAI(4);
        } else if (mHvFirst) {
            fillCaseAI(4);
            //TODO play4);
        } else if (mHvAfterHv) {
            int indexOfTheBestCorner = getBestCorner();
            fillCaseAI(indexOfTheBestCorner);
            mCorner = false;
            mHvAfterHv = false;
            //TODO play in best Corner
        } else if (mCornerAfterCenter) {
            if (buttonsXO[0].getText().equals("")) {
                fillCaseAI(0);
            } else if (buttonsXO[2].getText().equals("")) {
                fillCaseAI(2);
            } else if (buttonsXO[6].getText().equals("")) {
                fillCaseAI(6);
            } else if (buttonsXO[8].getText().equals("")) {
                fillCaseAI(8);
            }
            mCornerAfterCenter = false;
            //todo play in corner
        } else if (meWantWin() != -1) {
            //TODO go and win
            int indexOfTheRow = meWantWin();
            int[] theTargetRow = getTargetRow(indexOfTheRow);
            int indexOfTheTargetCase = getIndexOfTheEmptyCase(theTargetRow);
            fillCaseAI(indexOfTheTargetCase);
            mCorner = false;
            mCornerAfterCenter = false;
            mHvAfterHv = false;
            mHvAfterCorner = false;
            mCornerAfterHv = false;
        } else if (adverserWantWin() != -1) {
            //TODO stop him
            int indexOfTheRow = adverserWantWin();
            int[] theTargetRow = getTargetRow(indexOfTheRow);
            int indexOfTheTargetCase = getIndexOfTheEmptyCase(theTargetRow);
            fillCaseAI(indexOfTheTargetCase);
            mCorner = false;
            mCornerAfterCenter = false;
            mHvAfterHv = false;
            mHvAfterCorner = false;
            mCornerAfterHv = false;
        } else if (mCornerAfterHv) {
            int indexOfBestHV = getBestHV();
            fillCaseAI(indexOfBestHV);
            mCorner = false;
            mCornerAfterHv = false;
            //TODO play in best Corner en face
        } else if (mHvAfterCorner) {
            int indexOfBestHV = getBestHV();
            fillCaseAI(indexOfBestHV);
            mCorner = false;
            mHvAfterCorner = false;
        } else if (mCorner) {
            //TODO play in hv
            if (buttonsXO[1].getText().equals("")) {
                fillCaseAI(1);
            } else if (buttonsXO[3].getText().equals("")) {
                fillCaseAI(3);
            } else if (buttonsXO[5].getText().equals("")) {
                fillCaseAI(5);
            } else if (buttonsXO[7].getText().equals("")) {
                fillCaseAI(7);
            }
        } else {
            if (mCounter <= 4) {
                int indexOfTheBestCorner = getBestCorner();
                fillCaseAI(indexOfTheBestCorner);
                mCorner = false;
                //TODO play in best corner

            } else {
                if (buttonsXO[0].getText().equals("")) {
                    fillCaseAI(0);
                } else if (buttonsXO[2].getText().equals("")) {
                    fillCaseAI(2);
                } else if (buttonsXO[6].getText().equals("")) {
                    fillCaseAI(6);
                } else if (buttonsXO[8].getText().equals("")) {
                    fillCaseAI(8);
                }
            }
        }
    }

    private void fillArray(int cases, int current) {
        switch (cases) {
            case 0:
                arrayRows[0] += current;
                arrayRows[3] += current;
                arrayRows[7] += current;
                break;
            case 1:
                arrayRows[0] += current;
                arrayRows[4] += current;
                break;
            case 2:
                arrayRows[0] += current;
                arrayRows[5] += current;
                arrayRows[6] += current;
                break;
            case 3:
                arrayRows[1] += current;
                arrayRows[3] += current;
                break;
            case 4:
                arrayRows[1] += current;
                arrayRows[4] += current;
                arrayRows[6] += current;
                arrayRows[7] += current;
                break;
            case 5:
                arrayRows[1] += current;
                arrayRows[5] += current;
                break;
            case 6:
                arrayRows[2] += current;
                arrayRows[3] += current;
                arrayRows[6] += current;
                break;
            case 7:
                arrayRows[2] += current;
                arrayRows[4] += current;
                break;
            case 8:
                arrayRows[2] += current;
                arrayRows[5] += current;
                arrayRows[7] += current;
                break;
        }
    }

    private void fillCaseAI(int index){
        try{
            Thread.sleep(100);
        }catch(InterruptedException e){}

        buttonsXO[index].setText(setColor("O", "blue"));
        fillArray(index, -1);
        mCounter++;
        mCorner = false;
    }

    private int adverserWantWin() {
        int index = -1;
        for (int i = 0; i < arrayRows.length; i++)
            index = (arrayRows[i] == 2)? i: index;
        return index;
    }

    private int meWantWin() {
        int index = -1;
        for (int i = 0; i < arrayRows.length; i++)
            index = (arrayRows[i] == -2)? i : index;
        return index;
    }

    private static int[] getTargetRow(int index) {
        switch (index) {
            case 0:
                return new int[]{0, 1, 2};
            case 1:
                return new int[]{3, 4, 5};
            case 2:
                return new int[]{6, 7, 8};
            case 3:
                return new int[]{0, 3, 6};
            case 4:
                return new int[]{1, 4, 7};
            case 5:
                return new int[]{2, 5, 8};
            case 6:
                return new int[]{2, 4, 6};
            case 7:
                return new int[]{0, 4, 8};
            default:
                return new int[]{};
        }
    }

    private int getIndexOfTheEmptyCase(int[] array) {
        int index = -1;
        for (int i = 0; i < 3; i++)
            if (buttonsXO[array[i]].getText().equals(""))
                index = array[i];

        return index;
    }

    private int getBestHV() {
        int ZeroFour = arrayRows[0] + arrayRows[4];
        int TwoFour = arrayRows[2] + arrayRows[4];
        int OneThree = arrayRows[1] + arrayRows[3];
        int OneFive = arrayRows[1] + arrayRows[5];

        if ((ZeroFour <= OneFive) && (ZeroFour <= TwoFour) && (ZeroFour <= OneThree)) {
            return 1;
        } else if ((TwoFour <= OneThree) && (TwoFour <= ZeroFour) && (TwoFour <= OneFive)) {
            return 7;
        } else if ((OneThree <= TwoFour) && (OneThree <= ZeroFour) && (OneThree <= OneFive)) {
            return 3;
        } else {
            return 5;
        }
    }

    private int getBestCorner() {
        int ZeroThree = arrayRows[0] + arrayRows[3];
        int TwoThree = arrayRows[2] + arrayRows[3];
        int ZeroFive = arrayRows[0] + arrayRows[5];
        int TwoFive = arrayRows[2] + arrayRows[5];

        if ((ZeroThree >= TwoThree) && (ZeroThree >= ZeroFive) && (ZeroThree >= TwoFive)) {
            return 0;
        } else if ((TwoThree >= ZeroThree) && (TwoThree >= ZeroFive) && (TwoThree >= TwoFive)) {
            return 6;
        } else if ((ZeroFive >= ZeroThree) && (ZeroFive >= TwoThree) && (ZeroFive >= TwoFive)) {
            return 2;
        } else {
            return 8;
        }
    }
}

