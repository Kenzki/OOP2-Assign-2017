import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Menu2 extends JFrame{


    private JFrame menu = new JFrame("Snake");

    public static void main(String[] args) {
        Menu2 m = new Menu2();
        m.setVisible(true);

    }

    public Menu2(){


        menu.setLocation(450,200);
        menu.setSize(600,500);
        menu.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


        JButton playGame = new JButton("Play");

        playGame.setSize(200,50);
        setLocation(300,300);
        setBackground(Color.BLACK);

        menu.setLayout(null);
        menu.setVisible(true);
        menu.add(playGame);




    }


}



