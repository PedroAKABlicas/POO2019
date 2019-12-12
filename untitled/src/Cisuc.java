import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.*;


public class Cisuc{
    public ArrayList<Pessoa> listaPessoas;
    public ArrayList<Projeto> listaProjeto;


    public Cisuc(){
        Ficheiro projs = new Ficheiro();
        //Ficheiro peepz = new Ficheiro();
        try{
            listaProjeto=projs.ReadProjFromFile();
            //listaPessoas=peepz.ReadPessoaFromFile();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
