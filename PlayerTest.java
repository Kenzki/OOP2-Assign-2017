import javax.swing.*;

public class PlayerTest {
    public static void main(String[] args) {

        Player p = new Player();
        p.setName(JOptionPane.showInputDialog("Input Name: "));
        p.setScore(Integer.parseInt(JOptionPane.showInputDialog("Enter Score: ")));
        p.setFruitsEaten(Integer.parseInt(JOptionPane.showInputDialog("Enter Fruits Eaten: ")));

        JOptionPane.showMessageDialog(null, p.toString());

    }
}
