import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenuWindow extends JFrame implements ActionListener {
    private final JLabel startLabel; // Стартовая надпись
    private final JButton startButton; //Кнопка начала игры
    private final Font Fonf4Label = new Font("Comic Sans MS", Font.BOLD, 16); //Шрифт для стартовой надписи

    MainMenuWindow() {
        startLabel = new JLabel("Press this Button to Start Game");
        startLabel.setBounds(20,40,315,50);
        startLabel.setFont(Fonf4Label);
        this.add(startLabel);

        startButton = new JButton("Start Game");
        startButton.setBounds(20,100,250,50);
        startButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
        startButton.addActionListener(event -> {
            new TicTacLogic();
            this.setVisible(false);
        });
        this.add(startButton);

        /*Настройка окна меню*/
        setTitle("TicTacToe Menu");
        setBounds(400,170,310,270);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        new TicTacLogic();
        this.setVisible(false);
    }

    public static void main(String[] args) {
        new MainMenuWindow();
    }
}
