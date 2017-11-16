import javax.swing.*;
import java.awt.*;
import java.util.*;


public class Snake extends JFrame {

    private static int windowWidth = 600;
    private static int windowHeight = 500;
    private int x;
    private int y;
    private LinkedList<Point> snake;
    private Point fruit;
    private int score;
    private int fruitsEaten;

    Random position = new Random();


    public static void main(String args[])
    {
        Snake game = new Snake();
        game.setVisible(true);


    }



    //Constructor

    public Snake(){

        super("Snake");
        setSize(600,500);
        setLocation(600,200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);

    }




}
