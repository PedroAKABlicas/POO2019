import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.*;

public class Criarpessoa extends JFrame{
    protected JButton btnAddPessoa;
    protected JLabel label1, label2,label3,label4,label5,label6;
    protected JRadioButton boud,boud2,boud3,boud4,boud5;
    protected JTextField nome;
    public Criarpessoa (){
        setLayout(null);
        boud = new JRadioButton();
        boud.setBounds(105,29,20,25);
        nome= new JTextField();
        nome.setBounds(125,150,200,25);
        label1 = new JLabel("Test");
        label1.setText("Docente");
        label1.setBounds(50,25, 200,30);
        label2 = new JLabel("Test");
        label2.setText("Bolseiro");
        label2.setBounds(200,25, 200,30);
        boud2 = new JRadioButton();
        boud2.setBounds(255,29,20,25);
        label3 = new JLabel("Test");
        label3.setText("Nome:");
        label3.setBounds(50,146, 200,30);
        label4 = new JLabel("Test");
        label4.setText("Licenciatura");
        label4.setBounds(50,90, 200,30);
        boud3 = new JRadioButton();
        boud3.setBounds(124,96,20,20);
        label5 = new JLabel("Test");
        label5.setText("Mestrado");
        label5.setBounds(150,90, 200,30);
        boud4= new JRadioButton();
        boud4.setBounds(210,96,20,20);
        label6 = new JLabel("Test");
        label6.setText("Doutoramento");
        label6.setBounds(235,90, 200,30);
        boud5= new JRadioButton();
        boud5.setBounds(320,96,20,20);
        btnAddPessoa = new JButton("Registar Pessoa");
        btnAddPessoa.setBounds(55, 200, 300, 25);
        add(btnAddPessoa);
        add(label1);
        add(boud);
        add(label2);
        add(label3);
        add(boud2);
        add(label4);
        add(boud3);
        add(label5);
        add(boud4);
        add(label6);
        add(boud5);
        add(nome);


    }



}