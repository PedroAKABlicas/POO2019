import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AddTarefaGUI extends JFrame {
    private JLabel lblDataI, lblEstimativa, lblResponsavel, lblTipo, lblNome;
    private JTextField txtDataI, txtEstimativa, txtNome;
    private JButton btnVoltar, btnAddTarefa;
    private String[] tipoStrings = { "Desenvolvimento","Design","Documentação"};
    private JComboBox comboPessoa, comboTipo;
    private DefaultComboBoxModel modelPessoa;
    private String[] pessoas;
    VerTarefaGUI trf;
    int index;
    public AddTarefaGUI(VerTarefaGUI trf){
        this.trf=trf;
        setLayout(null);
        pessoas = new String[trf.proj.menu.cisuc.listaProjeto.get(index).getEquipa().size()];
        for(int i=0; i<trf.proj.menu.cisuc.listaProjeto.get(index).getEquipa().size(); i++){
            pessoas[i]=trf.proj.menu.cisuc.listaProjeto.get(index).getEquipa().get(i).getUser();
        }
        modelPessoa= new DefaultComboBoxModel(pessoas);
        lblNome = new JLabel("Nome: ");
        lblNome.setBounds(25, 170, 100, 20);
        txtNome = new JTextField();
        txtNome.setBounds(110, 170, 100, 20);
        lblDataI = new JLabel("Data de Inicio:");
        lblDataI.setBounds(25,25, 100,30);
        txtDataI= new JTextField();
        txtDataI.setBounds(115,25,100,30);
        lblResponsavel = new JLabel("Responsavel:");
        lblResponsavel.setBounds(25,75, 100,30);
        comboPessoa = new JComboBox(modelPessoa);
        comboPessoa.setBounds(125,80,100,20);
        lblTipo= new JLabel("Tipo:");
        lblTipo.setBounds(25,125,100,30);
        comboTipo= new JComboBox(tipoStrings);
        comboTipo.setBounds(75,130,100,20);
        lblEstimativa = new JLabel("Estimativa em meses:");
        lblEstimativa.setBounds(25,200,150,30);
        txtEstimativa= new JTextField();
        txtEstimativa.setBounds(155,203,100,25);
        btnVoltar = new JButton("Voltar");
        btnVoltar.setBounds(55, 280, 300, 25);
        btnAddTarefa = new JButton("Criar tarefa");
        btnAddTarefa.setBounds(55, 250, 100, 25);
        add(btnAddTarefa);
        add(txtEstimativa);
        add(txtDataI);
        add(lblTipo);
        add(lblResponsavel);
        add(lblEstimativa);
        add(lblDataI);
        add(comboTipo);
        add(comboPessoa);
        add(btnVoltar);
        add(lblNome);
        add(txtNome);
        btnVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnVoltarActionListener();
            }
        });
        btnAddTarefa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnAddTarefaActionListener();
            }
        });
    }

    private void btnAddTarefaActionListener(){
        int aux = comboTipo.getSelectedIndex();
        Tarefa nova;
        String[] data;
        Data datai;
        switch(aux){
            case 0:
                data=txtDataI.getText().split("/");
                datai=new Data(Integer.parseInt(data[0]), Integer.parseInt(data[1]), Integer.parseInt(data[2]));
                nova = new Desenvolvimento(txtNome.getText(), datai, Integer.parseInt(txtEstimativa.getText()), this.trf.proj.menu.cisuc.listaProjeto.get(trf.index).getEquipa().get(comboPessoa.getSelectedIndex()));
                if(this.trf.proj.menu.cisuc.listaProjeto.get(index).getEquipa().get(comboPessoa.getSelectedIndex()).verTarefa(nova)){
                    this.trf.proj.menu.cisuc.listaProjeto.get(index).addTarefa(nova);
                    this.trf.proj.menu.cisuc.listaProjeto.get(index).getEquipa().get(comboPessoa.getSelectedIndex()).associaTarefa(nova);
                    JOptionPane.showMessageDialog(null, "Tarefa adicionada com sucesso");
                }else{
                    JOptionPane.showMessageDialog(null, "Utilizador nao pode realizar a tarefa");
                }
                break;

            case 1:
                data=txtDataI.getText().split("/");
                datai=new Data(Integer.parseInt(data[0]), Integer.parseInt(data[1]), Integer.parseInt(data[2]));
                nova = new Design(txtNome.getText(), datai, Integer.parseInt(txtEstimativa.getText()), this.trf.proj.menu.cisuc.listaProjeto.get(trf.index).getEquipa().get(comboPessoa.getSelectedIndex()));
                if(this.trf.proj.menu.cisuc.listaProjeto.get(index).getEquipa().get(comboPessoa.getSelectedIndex()).verTarefa(nova)){
                    this.trf.proj.menu.cisuc.listaProjeto.get(index).addTarefa(nova);
                    this.trf.proj.menu.cisuc.listaProjeto.get(index).getEquipa().get(comboPessoa.getSelectedIndex()).associaTarefa(nova);
                    JOptionPane.showMessageDialog(null, "Tarefa adicionada com sucesso");

                }else{
                    JOptionPane.showMessageDialog(null, "Utilizador nao pode realizar a tarefa");

                }
                break;
            case 3:
                data=txtDataI.getText().split("/");
                datai=new Data(Integer.parseInt(data[0]), Integer.parseInt(data[1]), Integer.parseInt(data[2]));
                nova = new Documentacao(txtNome.getText(), datai, Integer.parseInt(txtEstimativa.getText()), this.trf.proj.menu.cisuc.listaProjeto.get(trf.index).getEquipa().get(comboPessoa.getSelectedIndex()));
                if(this.trf.proj.menu.cisuc.listaProjeto.get(trf.index).getEquipa().get(comboPessoa.getSelectedIndex()).getTipo()==0){
                    if(this.trf.proj.menu.cisuc.listaProjeto.get(index).getEquipa().get(comboPessoa.getSelectedIndex()).verTarefa(nova)){
                        this.trf.proj.menu.cisuc.listaProjeto.get(index).addTarefa(nova);
                        this.trf.proj.menu.cisuc.listaProjeto.get(index).getEquipa().get(comboPessoa.getSelectedIndex()).associaTarefa(nova);
                        JOptionPane.showMessageDialog(null, "Tarefa adicionada com sucesso");
                    }else{
                        JOptionPane.showMessageDialog(null, "Utilizador nao pode realizar a tarefa");
                    }
                }
                break;
        }
        Ficheiro f = new Ficheiro();
        f.WriteToFile(trf.proj.menu.cisuc);
    }
    private void btnVoltarActionListener(){
        VerTarefaGUI proj = new VerTarefaGUI(this.trf.proj, trf.index);
        proj.setSize(500, 300);
        proj.setVisible(true);
        this.setVisible(false);
    }
}
