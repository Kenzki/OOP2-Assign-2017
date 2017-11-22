import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import java.util.*;


public class Snake extends JFrame implements KeyListener {

    private static int windowWidth = 600;
    private static int windowHeight = 500;
    private int ax;
    private int ay;
    private LinkedList<Point> snake; //linked list with a point object
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
        this.addKeyListener(this);
        snake = new LinkedList<Point>(); //this creates the linked list object
        snake.addFirst(new Point(20,20)); //returns and positions the first element of the snake, which is the head onto the background
        ax = 0;
        ay= 0;


        while (true) {
            long time = System.currentTimeMillis();
            game();
            while (System.currentTimeMillis() - time <100){

            }
        }

    }

    public void game() {
        drawBackground();
        moveSnake(ax,ay);


    }

    public void drawBackground() {
        //this draws the background
        BufferStrategy buffer = this.getBufferStrategy(); //allows to draw everything before its displayed on the screen

        Graphics g= null;

        g = buffer.getDrawGraphics();

        g.setColor(Color.BLACK);
        g.fillRect(0,0,windowWidth,windowHeight); //fills the same height and width for the set window

        drawSnake(g);
        Scores(g);

        buffer.show();

    }

    /** snake is linkedlist with point objects
     *the for loop, loops around every element in the linkedlist and draws blue square to make up the snakes body
     */

    public void drawSnake (Graphics g) {
        for(int i=0; i < snake.size(); i++) {
            g.setColor(Color.BLUE);
            Point p = snake.get(i);
            g.fillRect(p.x*15,p.y*15,13,13);
        }
    }

    /**draws two strings to the background Totals Score and Fruits Eaten
     */
    public void Scores(Graphics g) {
        g.setColor(Color.white);
        g.drawString("Total Score: " + score, 12, 480);
        g.setColor(Color.white);
        g.drawString("Fruits Eaten: " + fruitsEaten, 120, 480);

    }

    public void moveSnake(int ax, int ay) {
        for (int i = snake.size()-1; i >= 1; i--) {
            snake.get(i).setLocation(snake.get(i-1));
        }
        snake.getFirst().x += ax;
        snake.getFirst().y += ay;
    }


    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        if(key == KeyEvent.VK_DOWN) {
            ay=1;
            ax=0;
        } else if(key == KeyEvent.VK_UP) {
            ay=-1;
            ax=0;
        } else if(key == KeyEvent.VK_RIGHT) {
            ay=0;
            ax=1;
        } else if(key == KeyEvent.VK_LEFT) {
            ay=0;
            ax=-1;
        }
    }

    public void keyReleased(KeyEvent e) {}

    public void keyTyped(KeyEvent e) {}







}
