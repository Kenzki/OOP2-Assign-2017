import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;

public class Menu extends JFrame implements ActionListener{


    JMenu playMenu,fileMenu,scoreMenu,infoMenu;

    //I looked through the class notes and example java code in the xdrive I also research on the internet on how to uses arraylist
    //http://www.homeandlearn.co.uk/java/array_lists.html + Class notes
    ArrayList<Player> score = new ArrayList<Player>();
    int total=0;


    //constructor
    public Menu() {
        setTitle("Snake Menu");
        //set the frames properties
        setSize(600,450);
        setLocation(600,200);
        setResizable(false);
        Container pane = getContentPane();
        //Collaborated wit Jack Teahan to insert image from Jframe.
        JLabel picture = new JLabel(new ImageIcon("snakemenu.JPG"));
        pane.add(picture);
        setDefaultCloseOperation(EXIT_ON_CLOSE);//registers exit upon closing as a default operation


        createPlayMenu();
        createFileMenu();
        createScoreMenu();
        createInfoMenu();

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        menuBar.add(playMenu);
        menuBar.add(fileMenu);
        menuBar.add(scoreMenu);
        menuBar.add(infoMenu);

    }
    public  void save() throws IOException {
        try{
            ObjectOutputStream os;
            os = new ObjectOutputStream(new FileOutputStream("score.dat"));
            os.writeObject(score);
            os.close();

        } catch (Exception e)
        {JOptionPane.showMessageDialog(null,"Error in saving file");
        }
    }

    public  void open() {
        try {
            ObjectInputStream is;
            is = new ObjectInputStream(new FileInputStream("score.dat"));
            score = (ArrayList<Player>) is.readObject();
            is.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Open didn't work");
            e.printStackTrace();
        }

    }

    public void addScore(){

        Player p1 = new Player();

        p1.setName(JOptionPane.showInputDialog("Enter Name:"));
        p1.setScore(Integer.parseInt(JOptionPane.showInputDialog("Enter Score:")));
        p1.setFruitsEaten(Integer.parseInt(JOptionPane.showInputDialog("Enter Fruits Eaten:")));
        score.add(p1);
    }

    public void displayScore(){
        JTextArea output = new JTextArea();

        total=score.size();
        if (total>0){
            for(int i=0; i <score.size();i++)
            {
                output.append(score.get(i).toString()+"\n\n");
            }

            showMessage(output);
        }
        else
            showMessage("No score added");

    }


    public void actionPerformed (ActionEvent e) {
        if (e.getActionCommand() . equals("Play Game")){
            new Snake();

        }

        else if (e.getActionCommand() .equals("How To Play")){
            JTextArea output = new JTextArea();
            String text = "Goal: Eat fruits to gain score and avoid hitting walls or snakes body\n\nControls: Use key A (Left), D (Right), S (Down), W (Up)" +
                           "\n or Arrow Keys - Up, Down, Right, Left";
            output.append(text);
            showMessage(output);

        }
        else if (e.getActionCommand() .equals ("Add Score")){
            addScore();
        }

        else if (e.getActionCommand() .equals ("Display Score")){
            displayScore();
        }
        else if (e.getActionCommand() .equals ("Save")){
            try{
                save();
                showMessage("Data saved successfully");
            }
            catch (IOException f){
                showMessage("Not able to save the file:\n"+
                        "Check the console printout for clues to why ");
                f.printStackTrace();
            }
        }
        else if (e.getActionCommand() .equals ("Open")){
           open();
        }

    }

    private void createPlayMenu() {
        playMenu = new JMenu("Play");

        JMenuItem item;
        item = new JMenuItem("Play Game");
        playMenu.add(item);
        item.addActionListener(this);

        playMenu.addSeparator();
        item = new JMenuItem("Quit");
        playMenu.add(item);
    }
    private void createFileMenu() {
        fileMenu = new JMenu("File");

        JMenuItem item;

        item = new JMenuItem("Save");
        fileMenu.add(item);
        item.addActionListener(this);

        item = new JMenuItem("Open");
        item.addActionListener(this);
        fileMenu.add(item);

        fileMenu.addSeparator();
        item = new JMenuItem("Exit");
        fileMenu.add(item);
    }


    private void createScoreMenu() {
        scoreMenu = new JMenu("Score");

        JMenuItem item;

        item = new JMenuItem("Add Score");
        scoreMenu.add(item);
        item.addActionListener(this);

        item = new JMenuItem("Display Score");
        item.addActionListener(this);
        scoreMenu.add(item);

        scoreMenu.addSeparator();
        item = new JMenuItem("Exit");
        scoreMenu.add(item);
    }

    private void createInfoMenu() {
        infoMenu = new JMenu("Information");

        JMenuItem item;
        item = new JMenuItem("How To Play");
        infoMenu.add(item);
        item.addActionListener(this);

        infoMenu.addSeparator();
        item = new JMenuItem("Exit");
        infoMenu.add(item);
    }



    public void showMessage (String s){
        JOptionPane.showMessageDialog(null,s);
    }

    public void showMessage (JTextArea s){
        JOptionPane.showMessageDialog(null,s);
    }


}
