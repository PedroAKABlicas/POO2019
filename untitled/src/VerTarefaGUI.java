import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.time.LocalDate;



public class VerTarefaGUI extends JFrame {
    private JButton btnAddTarefa, btnMudaTaxa, btnDelTarefa, btnTarefa100, btnTarefa0, btnTarefaAtraso, btnVoltar;
    private JComboBox comboTarefas;
    private DefaultComboBoxModel modelTarefas;
    protected VerProjetoGUI proj;
    protected int index;
    private String[] tarefas;
    public VerTarefaGUI(VerProjetoGUI proj, int index){
        this.proj=proj;
        this.index=index;
        this.setLayout(null);
        Projeto projeto = proj.menu.cisuc.listaProjeto.get(index);
        tarefas = new String[projeto.getTarefas().size()];
        for(int i =0; i<projeto.getTarefas().size();i++){
            tarefas[i]=projeto.getTarefas().get(i).getNome();
        }
        modelTarefas = new DefaultComboBoxModel(tarefas);
        btnAddTarefa = new JButton("Adicionar tarefa");
        btnAddTarefa.setBounds(30,30,100,20);
        btnDelTarefa = new JButton("Apagar tarefa");
        btnDelTarefa.setBounds(30,60, 100, 20);
        btnMudaTaxa = new JButton("Atualizar taxa");
        btnMudaTaxa.setBounds(330, 60, 150, 20);
        btnTarefa0 = new JButton("Tarefas a 0%");
        btnTarefa0.setBounds(270, 30, 150, 20);
        comboTarefas = new JComboBox(modelTarefas);
        comboTarefas.setBounds(140, 60, 120, 20);
        btnTarefa100 = new JButton("Tarefas acabadas");
        btnTarefa100.setBounds(130, 30, 150, 20);
        btnTarefaAtraso = new JButton("Tarefas Atrasadas");
        btnTarefaAtraso.setBounds(420, 30, 150, 20);
        btnVoltar = new JButton("Voltar");
        btnVoltar.setBounds(200, 100, 80, 20);
        add(btnAddTarefa);
        add(btnDelTarefa);
        add(btnTarefa0);
        add(btnMudaTaxa);
        add(btnTarefa100);
        add(comboTarefas);
        add(btnTarefaAtraso);
        add(btnVoltar);
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
        btnDelTarefa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnDelTarefaActionListener();
            }
        });

        btnTarefa0.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnTarefa0ActionListener();
            }
        });

        btnTarefa100.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnTarefa100ActionListener();
            }
        });
        btnTarefaAtraso.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnTarefaAtrasoActionListener();
            }
        });
        btnMudaTaxa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnMudaTaxaActionListener();
            }
        });
    }
    private void btnVoltarActionListener(){
        VerProjetoGUI proj = new VerProjetoGUI(this.proj.menu);
        proj.setSize(500, 300);
        proj.setVisible(true);
        this.setVisible(false);
    }

    private void btnAddTarefaActionListener(){
        AddTarefaGUI tarefa =new AddTarefaGUI(this);
        tarefa.setSize(600, 400);
        tarefa.setVisible(true);
        this.setVisible(false);
    }

    public void btnDelTarefaActionListener(){
        int i = comboTarefas.getSelectedIndex();
        int j=0;
        Tarefa tarefa = proj.menu.cisuc.listaProjeto.get(this.index).getTarefas().get(i);
        proj.menu.cisuc.listaProjeto.get(index).getTarefas().remove(tarefa);
        for(Pessoa pessoa:proj.menu.cisuc.listaProjeto.get(this.index).getEquipa()){
            if(pessoa.getTarefas().contains(tarefa)){
                proj.menu.cisuc.listaProjeto.get(this.index).getEquipa().get(j).getTarefas().remove(tarefa);
            }
            j++;
        }
        Ficheiro f = new Ficheiro();
        f.WriteToFile(proj.menu.cisuc);
    }

    private void btnTarefa0ActionListener(){
        ArrayList<Tarefa> tarefas = new ArrayList<>();
        for(Tarefa tarefa:proj.menu.cisuc.listaProjeto.get(this.index).getTarefas()){
            System.out.println(tarefa.getPeso());
            if(tarefa.getTaxa()==0){
                tarefas.add(tarefa);
            }
        }
        ConsTarefasGUI consulta =new ConsTarefasGUI(this, tarefas);
        consulta.setSize(400, 600);
        consulta.setVisible(true);
        this.setVisible(false);
    }
    private void btnTarefa100ActionListener(){
        ArrayList<Tarefa> tarefas = new ArrayList<>();
        for(Tarefa tarefa:proj.menu.cisuc.listaProjeto.get(this.index).getTarefas()){
            if(tarefa.getTaxa()==100){
                tarefas.add(tarefa);
            }
        }
        ConsTarefasGUI consulta =new ConsTarefasGUI(this, tarefas);
        consulta.setSize(400, 600);
        consulta.setVisible(true);
        this.setVisible(false);
    }
    private void btnTarefaAtrasoActionListener(){
        LocalDate dataTemp=java.time.LocalDate.now();
        Data dataAtual = new Data(dataTemp.getDayOfMonth(), dataTemp.getMonthValue(), dataTemp.getYear());
        ArrayList<Tarefa> tarefas = new ArrayList<>();
        for(Tarefa tarefa:proj.menu.cisuc.listaProjeto.get(this.index).getTarefas()){
            if(tarefa.getDataInicio().addData(tarefa.getDuaracao()).compare(dataAtual)){
                tarefas.add(tarefa);
            }
        }
        ConsTarefasGUI consulta =new ConsTarefasGUI(this, tarefas);
        consulta.setSize(400, 600);
        consulta.setVisible(true);
        this.setVisible(false);
    }
    private void btnMudaTaxaActionListener(){
        int i=comboTarefas.getSelectedIndex();
        int taxa=Integer.parseInt(JOptionPane.showInputDialog(this,"Em quanto aumentou a taxa?"));
        proj.menu.cisuc.listaProjeto.get(this.index).getTarefas().get(i).mudaTaxa(taxa);
    }
}
