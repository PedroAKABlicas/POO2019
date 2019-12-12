import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.*;

public class Criarpessoa extends JFrame{
    protected JButton btnAddPessoa, btnVoltar;
    protected JLabel label1,label2,label3,label4;
    String[] cargoStrings = { "Docente", "Licenciatura", "Mestrado", "Doutoramento" };
    protected JComboBox cargo,orientador;
    protected JTextField nome,mail;
    public Criarpessoa (){
        setLayout(null);
        label1 = new JLabel("Test");
        label1.setText("Cargo:");
        label1.setBounds(50,25, 200,30);
        cargo = new JComboBox(cargoStrings);
        cargo.setBounds(125,30,200,20);
        label2 = new JLabel("Test");
        label2.setText("Orientador:");
        label2.setBounds(50,67, 200,30);
        orientador = new JComboBox();
        orientador.setBounds(125,71,200,20);
        mail= new JTextField();
        mail.setBounds(125,110,200,25);
        label3 = new JLabel("Test");
        label3.setText("Mail:");
        label3.setBounds(50,108, 200,30);
        nome= new JTextField();
        nome.setBounds(125,150,200,25);
        label4 = new JLabel("Test");
        label4.setText("Nome:");
        label4.setBounds(50,146, 200,30);
        btnAddPessoa = new JButton("Registar Pessoa");
        btnAddPessoa.setBounds(55, 200, 300, 25);
        btnVoltar = new JButton("Back");
        btnVoltar.setBounds(55, 240, 300, 25);
        add(btnAddPessoa);
        add(label1);
        add(nome);
        add(label2);
        add(label3);
        add(orientador);
        add(cargo);
        add(label4);
        add(mail);
        add(btnVoltar);


    }



}