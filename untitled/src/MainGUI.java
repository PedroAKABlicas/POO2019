import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainGUI extends JFrame {

    protected JButton btnCriaProjeto, btnVerProjeto, btnVerAtraso, btnVerConcluido, btnAddPessoa;
    public Cisuc cisuc;

    public MainGUI(Cisuc cisuc) {
        this.cisuc = cisuc;
        for(Projeto projeto : cisuc.listaProjeto){
            System.out.println(projeto.getEquipa()+ " "+projeto.getNome());
        }
        setLayout(null);
        btnCriaProjeto = new JButton("Criar Projeto");
        btnCriaProjeto.setBounds(55, 40, 300, 25);
        btnVerProjeto = new JButton("Ver Projetos");
        btnVerProjeto.setBounds(55, 80, 300, 25);
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

        btnAddPessoa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnAddPessoaActionListener();
            }
        });

        btnVerAtraso.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnVerAtrasoActionListener();
            }
        });
        btnVerProjeto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnVerProjetoActionListener();
            }
        });
        add(btnVerProjeto);
        add(btnCriaProjeto);
        add(btnVerAtraso);
        add(btnVerConcluido);
        add(btnAddPessoa);
    }


    private void btnCriaProjetoActionListener() {
        NovoProjetoGUI n = new NovoProjetoGUI(this);
        n.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        n.setSize(450,340);
        n.setVisible(true);
        this.setVisible(false);
    }
    private void btnAddPessoaActionListener() {
        Criarpessoa nova = new Criarpessoa(this);
        nova.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        nova.setSize(450,520);
        nova.setVisible(true);
        this.setVisible(false);
    }

    private void btnVerAtrasoActionListener(){
        AtrasadosGUI atraso = new AtrasadosGUI(this);
        atraso.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        atraso.setSize(400,600);
        atraso.setVisible(true);
        this.setVisible(false);
    }

    private void btnVerProjetoActionListener(){
        VerProjetoGUI projetos = new VerProjetoGUI(this);
        projetos.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        projetos.setSize(500,300);
        this.setVisible(false);
        projetos.setVisible(true);

    }
}

