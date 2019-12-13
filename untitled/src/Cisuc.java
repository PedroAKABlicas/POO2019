import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.*;


public class Cisuc{
    public ArrayList<Pessoa> listaPessoas;
    public ArrayList<Projeto> listaProjeto;

    public Cisuc(ArrayList<Pessoa> listaP, ArrayList<Projeto> lista){
        this.listaProjeto=lista;
        this.listaPessoas=listaP;
    }
}
