import javax.swing.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args){
        Ficheiro ficheiro = new Ficheiro();
        ArrayList<Pessoa> pessoas = new ArrayList<>();
        pessoas.add(new Pessoa("ha","ha"));
        ArrayList<Projeto> projetos = new ArrayList<>();
        try{
            pessoas=ficheiro.ReadPessoaFromFile();
            projetos=ficheiro.ReadProjFromFile();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        Cisuc cisuc = new Cisuc(pessoas, projetos);
        MainGUI menu = new MainGUI(cisuc);
        menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menu.setSize(420,300);
        menu.setVisible(true);
    }
}
