import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class RockPaperScissorsGame extends JFrame implements ActionListener {

    private JTextField inputField;
    private JLabel resultLabel, userChoiceLabel, computerChoiceLabel;
    private String[] options = {"rock", "paper", "scissors"};
    private Random random = new Random();

    public RockPaperScissorsGame() {
        setTitle("Rock-Paper-Scissors Game");
        setSize(500, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 1));

        JLabel welcomeLabel = new JLabel("Please Enter rock, paper, or scissors and press", JLabel.CENTER);
        add(welcomeLabel);

        inputField = new JTextField();
        inputField.addActionListener(this);
        add(inputField);

        userChoiceLabel = new JLabel("Your Choice: ", JLabel.CENTER);
        add(userChoiceLabel);

        computerChoiceLabel = new JLabel("Computer's Choice: ", JLabel.CENTER);
        add(computerChoiceLabel);

        resultLabel = new JLabel("Result: ", JLabel.CENTER);
        add(resultLabel);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String userChoice = inputField.getText().toLowerCase().trim();
        if (!userChoice.equals("rock") && !userChoice.equals("paper") && !userChoice.equals("scissors")) {
            resultLabel.setText("Result: Invalid input. Try Again.");
            userChoiceLabel.setText("Your Choice: " + userChoice);
            computerChoiceLabel.setText("Computer's Choice:");
            return;
        }

        String computerChoice = options[random.nextInt(3)];
        userChoiceLabel.setText("Your Choice: " + userChoice);
        computerChoiceLabel.setText("Computer's Choice: " + computerChoice);
        resultLabel.setText("Result: " + getWinner(userChoice, computerChoice));
    }

    private String getWinner(String user, String computer) {
        if (user.equals(computer)) return "It's a tie!";
        if ((user.equals("rock") && computer.equals("scissors")) ||
                (user.equals("scissors") && computer.equals("paper")) ||
                (user.equals("paper") && computer.equals("rock"))) {
            return "You win!";
        } else {
            return "Computer wins!";
        }
    }

    public static void main(String[] args) {
        new RockPaperScissorsGame();
    }
}
