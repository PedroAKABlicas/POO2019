import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class VerProjetoGUI extends JFrame {
    private JLabel lblAddPessoa, lblProj;
    private JComboBox comboPessoa, comboProj;
    private String[] pessoas, projetos;
    private JButton btnConsTarefa, btnVoltar, btnAddPessoa, btnVerProjeto;
    private DefaultComboBoxModel modelPessoa, modelProj;
    private ArrayList<Pessoa> peepz = new ArrayList<>();
    MainGUI menu;
    int index;
    public VerProjetoGUI(MainGUI menu){
        this.menu=menu;
        lblProj = new JLabel("Selecionar projeto: ");
        lblProj.setBounds(40,40,150,20);
        projetos = new String[menu.cisuc.listaProjeto.size()];
        int i=0;
        for(Projeto proj:menu.cisuc.listaProjeto){
            projetos[i]=proj.getNome();
            i++;
        }
        modelProj = new DefaultComboBoxModel(projetos);
        comboProj = new JComboBox(modelProj);
        comboProj.setBounds(170,40,80,20);
        comboProj.setSelectedIndex(0);
        btnVerProjeto = new JButton("Consultar");
        btnVerProjeto.setBounds(260,40,80,20);
        lblAddPessoa = new JLabel("Associar uma pessoa:");
        lblAddPessoa.setBounds(40,70,150,20);
        index=comboProj.getSelectedIndex();
        comboPessoa = new JComboBox(AtualizaPeepz(index));
        comboPessoa.setBounds(170,70,80,20);
        btnAddPessoa = new JButton("Associar");
        btnAddPessoa.setBounds(260, 70, 80, 20);
        btnConsTarefa=new JButton("Consultar Tarefas");
        btnConsTarefa.setBounds(80, 100, 180, 20);
        btnVoltar = new JButton("Voltar");
        btnVoltar.setBounds(210, 100, 80, 20);
        btnVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnVoltarActionListener();
            }
        });
        btnAddPessoa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnAddPessoaActionListener(comboProj.getSelectedIndex(), peepz.get(comboPessoa.getSelectedIndex()));
            }
        });
        comboProj.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                comboProjActionListener(e);
            }
        });
        btnConsTarefa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnConsTarefaActionListener();
            }
        });
        add(lblAddPessoa);
        add(lblProj);
        add(comboPessoa);
        add(comboProj);
        add(btnAddPessoa);
        add(btnConsTarefa);
        add(btnVerProjeto);
        add(btnVoltar);
    }

    private DefaultComboBoxModel AtualizaPeepz(int index){
        peepz.clear();
        ArrayList<Pessoa> equipa= menu.cisuc.listaProjeto.get(index).getEquipa();
        System.out.println(equipa);
        for(Pessoa pessoa:menu.cisuc.listaPessoas){
            System.out.println(pessoa);
                if(!(equipa.contains(pessoa))){
                    System.out.println(pessoa.getUser());
                    peepz.add(pessoa);
                }
        }
        pessoas = new String[peepz.size()];
        for(int i=0; i<peepz.size();i++){
            pessoas[i]=peepz.get(i).getUser();
        }
        modelPessoa = new DefaultComboBoxModel<>(pessoas);
        comboPessoa = new JComboBox(modelPessoa);
        return modelPessoa;
    }

    private void btnVoltarActionListener(){
        MainGUI menu = new MainGUI(this.menu.cisuc);
        menu.setSize(420, 300);
        menu.setVisible(true);
        this.setVisible(false);
    }
    private void btnAddPessoaActionListener(int index, Pessoa pessoa){
        menu.cisuc.listaProjeto.get(index).associaPessoa(pessoa);
        Ficheiro ficheiro = new Ficheiro();
        ficheiro.WriteToFile(menu.cisuc);
        AtualizaPeepz(index);
    }

    private void btnConsTarefaActionListener(){
        AddTarefaGUI tarefa = new AddTarefaGUI(this, comboProj.getSelectedIndex());
        tarefa.setSize(600, 400);
        tarefa.setVisible(true);
        this.setVisible(false);
    }

    private void comboProjActionListener(ActionEvent e){
        JComboBox cb=(JComboBox)e.getSource();
        int index=cb.getSelectedIndex();
        AtualizaPeepz(index);
    }
}
