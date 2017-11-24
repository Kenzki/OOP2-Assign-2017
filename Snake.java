import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import java.util.*;


public class Snake extends JFrame implements KeyListener,Runnable {

    private static int windowWidth = 600;
    private static int windowHeight = 500;
    private int ax;
    private int ay;
    private LinkedList<Point> snake; //linked list with a point object
    private Point fruit;
    private int score;
    private int fruitsEaten;
    private Thread theThread; //this is for the extra thread we need to prevent runtime problems
    private boolean gameOn; //this will control the game loop, it will become false when the game ends

    Random spawn = new Random();


    public static void main(String args[])
    {
        Snake s = new Snake();
    }


    //Constructor

    public Snake(){

        setTitle("Snake");
        setSize(600,500);
        setLocation(500,200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
        createBufferStrategy(2);
        addKeyListener(this);
        snake = new LinkedList<Point>(); //this creates the linked list object
        snake.addFirst(new Point(20,20)); //returns and positions the first element of the snake, which is the head onto the background
        growSnake(3);
        ax = 0;
        ay= 0;



        /*
         Original game loop

        while (true) {
            long time = System.currentTimeMillis();
            game();
            while (System.currentTimeMillis() - time <90){
                 //System.out.println("Called");
            }
        }*/


        //Added by JB since the there was a an issue when trying to run the game from
        // the menu option on another JFrame, there were conflicts between the game loop executing
        //and the ability of the system to pick up key event.

        gameOn = true; //set the game loop variable to true
        start(); //now start the game loop thread

    }

    public void game() {
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

    }

    /** snake is linked list with point objects
     *the for loop, loops around every element in the linked list and draws blue square to make up the snakes body
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

    }

    public void growSnake (int t) {
        while(t > 0) {
            Point tail=snake.getLast();
            snake.add(new Point(tail));
            t--;
        }
    }

    public void spawnFruit (int x){

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


    //JB - called automatically by the start() method below. Because the game needs to draw information onto the screen
    //and listen for keyboard/other events at the same time, an extra thread of execution is needed. The run()
    //method basically ensures that the pane of the JFrame window gets painted/updated every 50 milliseconds
    //giving us 20 frames per second as such. The thread sleeps in between these updates meaning that the rest
    //of the time events can be listened for and handled without any conflict

    //Without this extra thread, it was not possible for the game JFrame to pick up any keyboard events or handle any
    //interactions with the main GUI JFrame window

    public void run()
    {

        while(gameOn)
        {
            try
            {
                game();

                Thread.sleep(90); //let the game loop stop for 50ms so keyboard events etc can be handled

            }
            catch (InterruptedException e)
            {
                break;
            }
        }
        System.out.println("Game now over!");

    }

    //JB - This method creates a brand new thread of execution in which the snake game loop will run. It basically creates a new Thread object,
    //links it with the game instance and sets the thread in motion with the call to start() on the thread reference
    //The call to start() then automatically calls the run() method above (this is defined in the Runnable interface and overridden by this class)

    public void start()
    {
        if (theThread == null)
        {
            System.out.println("Creating new thread");
            theThread = new Thread(this);
            theThread.start();
        }
    }




}