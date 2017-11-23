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
    private Graphics gRef;

    Random spawn = new Random();


    public static void main(String args[])
    {
        Snake s = new Snake();
        s.setFocusable(true);
        //s.setVisible(true);

    }


    //Constructor

    public Snake(){

        setTitle("Snake");
        setSize(600,500);
        setLocation(600,200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
        //pack();
        this.createBufferStrategy(2);
        this.addKeyListener(this);
        snake = new LinkedList<Point>(); //this creates the linked list object
        snake.addFirst(new Point(20,20)); //returns and positions the first element of the snake, which is the head onto the background
        growSnake(3);
        ax = 0;
        ay= 0;



        while (true) {
            long time = System.currentTimeMillis();
            game();
            if (System.currentTimeMillis() - time <100){
                 //System.out.println("Called");
            }
        }

    }

    public void game() {
        gRef = getGraphics();
        //super.paint(gRef);
        drawBackground();
        moveSnake(ax,ay);

    }

    public void drawBackground() {
        BufferStrategy buffer = this.getBufferStrategy(); //allows to draw everything before its displayed on the screen

        Graphics g;

        g = buffer.getDrawGraphics();

        g.setColor(Color.BLACK);
        g.fillRect(0,0,windowWidth,windowHeight); //fills the same height and width for the set window

        drawSnake(g);
        drawScores(g);
        drawFruit(g);

        buffer.show();
        //pack();

    }

    /** snake is linked list with point objects
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
    public void drawScores(Graphics g) {
        g.setColor(Color.white);
        g.drawString("Total Score: " + score, 12, 480);
        g.setColor(Color.white);
        g.drawString("Fruits Eaten: " + fruitsEaten, 120, 480);

    }

    public void drawFruit(Graphics g) {
        g.setColor(Color.RED);
        g.fillOval(300,240,13,13);

    }


    public void moveSnake(int ax, int ay) {

        for (int i = snake.size()-1; i >= 1; i--) {
            snake.get(i).setLocation(snake.get(i-1));
        }
        snake.getFirst().x += ax;
        snake.getFirst().y += ay;

       // System.out.println( snake.get(0).getLocation());
    }

    public void growSnake (int t) {
        while(t > 0) {
            Point tail=snake.getLast();
            snake.add(new Point(tail));
            t--;
        }
    }


    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        if(key == KeyEvent.VK_DOWN) {
            ay=1;
            ax=0;
            //System.out.println("Called");
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
          else if(key == KeyEvent.VK_S) {
            ay=1;
            ax=0;
        } else if(key == KeyEvent.VK_W) {
            ay=-1;
            ax=0;
        } else if(key == KeyEvent.VK_D) {
            ay=0;
            ax=1;
        } else if(key == KeyEvent.VK_A) {
            ay=0;
            ax=-1;
        }

    }

    public void keyReleased(KeyEvent e) {}

    public void keyTyped(KeyEvent e) {}







}
