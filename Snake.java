import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
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

    Random spawn = new Random();


    public static void main(String args[])
    {
        Snake s = new Snake();
        s.setVisible(true);


    }


    //Constructor

    public Snake(){

        super("Snake");
        setSize(600,500);
        setLocation(600,200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
        this.createBufferStrategy(2);
        game();

    }

    public void game() {
        drawBackgound();

    }

    public void drawBackgound() {
        //this draws the background
        BufferStrategy buffer = this.getBufferStrategy(); //allows to draw everything before its displayed on the screen

        Graphics g= null;

        g = buffer.getDrawGraphics();

        g.setColor(Color.BLACK);
        g.fillRect(0,0,windowWidth,windowHeight); //fills the same height and width for the set window


        buffer.show();

    }





}
