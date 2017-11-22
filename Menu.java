import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JFrame implements ActionListener{


    JMenu playMenu,userMenu,fileMenu,infoMenu;

    public static void main(String[] args) {
        Menu frame = new Menu();
        frame.setVisible(true);
    }

    public Menu() {
        setTitle("Snake Menu");
        setSize(600,500);
        setLocation(600,200);
        setResizable(false);
        Container pane = getContentPane();
        pane.setBackground(new Color(50, 150, 92));
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        createPlayMenu();
        createUserMenu();
        createFileMenu();
        createInfoMenu();

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        menuBar.add(playMenu);
        menuBar.add(userMenu);
        menuBar.add(fileMenu);
        menuBar.add(infoMenu);

    }

    public void actionPerformed (ActionEvent e) {
        if (e.getActionCommand() . equals("Play Game")){
            dispose();
            new Snake();

        }

        else if (e.getActionCommand() .equals("How To Play")){
            showMessage("Controls: A (Left), D (Right), S (Down), W (Up)" +
                           "\nArrow Keys - Up, Down, Right, Left");
        }

        else
            showMessage("No button Clicked");

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

    private void createUserMenu() {
        userMenu = new JMenu("Users");

        JMenuItem item;
        item = new JMenuItem("Register New User");
        userMenu.add(item);

        item = new JMenuItem("Load User Details");
        userMenu.add(item);
    }

    private void createFileMenu() {
        fileMenu = new JMenu("File");

        JMenuItem item;
        item = new JMenuItem("Save User Details");
        fileMenu.add(item);

        item = new JMenuItem("Display User Details");
        fileMenu.add(item);

        fileMenu.addSeparator();
        item = new JMenuItem("Exit");
        fileMenu.add(item);
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
