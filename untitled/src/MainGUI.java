import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainGUI extends JFrame{
    protected JButton btnCriaProjeto, btnAlterarProjeto, btnVerAtraso, btnVerConcluido, btnAddPessoa;
    private JLabel labelTeste;
    public Cisuc cisuc;
    public MainGUI (Cisuc cisuc){
        this.cisuc=cisuc;
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

        btnCriaProjeto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnCriaProjetoActionListener();
            }
        });

        btnVerAtraso.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){btnVerAtrasoActionListener();}
        });
        add(btnAlterarProjeto);
        add(btnCriaProjeto);
        add(btnVerAtraso);
        add(btnVerConcluido);
        add(btnAddPessoa);
    }


    private void btnCriaProjetoActionListener() {
        NovoProjetoGUI n = new NovoProjetoGUI(this);
        n.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        n.setSize(450,250);
        n.setVisible(true);
        this.setVisible(false);
    }

    private void btnVerAtrasoActionListener(){
        AtrasadosGUI atraso = new AtrasadosGUI(this);
        atraso.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        atraso.setSize(475,300);
        atraso.setVisible(true);
        this.setVisible(false);
    }
}
