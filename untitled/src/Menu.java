import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.*;


public class Menu implements ActionListener, WindowListener{
    public ArrayList<Pessoa> listaPessoas;
    public ArrayList<Projeto> listaProjeto;
    public ArrayList<Tarefa> listaTarefa;

    public static void main(String [] args){
        Menu novo = new Menu();
        novo.Main();
    }

    public void Main(){
        Ficheiro projs = new Ficheiro();
        projs.ReadProjFromFile();
        try{
            listaProjeto=projs.ReadProjFromFile();
        }catch(Exception e){
            e.printStackTrace();
        }
        MainGUI menu = new MainGUI();
        menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menu.setSize(420,300);
        novoProjetoGUI novoGUI = new novoProjetoGUI();
        novoGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        novoGUI.setSize(450, 250);
        menu.setVisible(true);
        atrasadosGUI atraso = new atrasadosGUI(listaProjeto);
        atraso.setSize(300, 430);

        novoGUI.btnVoltar.addActionListener(e->{
            novoGUI.setVisible(false);
            menu.setVisible(true);

        });
        menu.btnCriaProjeto.addActionListener(e->{
            menu.setVisible(false);
            novoGUI.setVisible(true);
        });

        menu.btnVerAtraso.addActionListener(e->{
            menu.setVisible(false);
            atraso.setVisible(true);
        });


    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {

    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }
}
