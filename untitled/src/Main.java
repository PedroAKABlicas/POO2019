import javax.swing.*;

public class Main {
    public static void main(String[] args){
        Cisuc cisuc = new Cisuc();
        MainGUI menu = new MainGUI(cisuc);
        menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menu.setSize(420,300);
        menu.setVisible(true);
    }
}
