import javax.swing.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args){
        ArrayList<Pessoa> pessoas = new ArrayList<>();
        ArrayList<Projeto> projetos = new ArrayList<>();
        Cisuc cisuc = new Cisuc(pessoas, projetos);
        MainGUI menu = new MainGUI(cisuc);
        menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menu.setSize(420,300);
        menu.setVisible(true);
    }
}
