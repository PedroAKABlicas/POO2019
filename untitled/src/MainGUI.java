import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.*;

public class MainGUI extends JFrame{
    protected JButton btnCriaProjeto, btnAlterarProjeto, btnVerAtraso, btnVerConcluido, btnAddPessoa;
    private JLabel labelTeste;
    public MainGUI (){
        setLayout(null);
        btnCriaProjeto = new JButton("Criar Projeto");
        btnCriaProjeto.setBounds(55, 40, 300, 25);
        btnAlterarProjeto = new JButton("Alterar Projeto");
        btnAlterarProjeto.setBounds(55, 80, 300, 25);
        btnVerAtraso = new JButton("Ver Projetos Atrasados");
        btnVerAtraso.setBounds(55, 120, 300, 25);
        btnVerConcluido = new JButton("Ver Projetos Concluidos");
        btnVerConcluido.setBounds(55, 160, 300, 25);
        btnAddPessoa = new JButton("Adicionar Pessoa");
        btnAddPessoa.setBounds(55, 200, 300, 25);
        add(btnAlterarProjeto);
        add(btnCriaProjeto);
        add(btnVerAtraso);
        add(btnVerConcluido);
        add(btnAddPessoa);
    }



}
