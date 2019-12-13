import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

public class ProjConcluidoGUI extends JFrame {
    public JLabel lblTitulo;
    public JList listProjeto;
    private JButton btnVoltar;
    MainGUI menu;
    private DefaultListModel<String> listModel = new DefaultListModel<>();
    public ProjConcluidoGUI(MainGUI menu){
        this.setLayout(null);
        this.menu=menu;
        btnVoltar = new JButton("Voltar");
        btnVoltar.setBounds(130, 400, 80, 20);
        lblTitulo = new JLabel("Projetos atrasados.");
        lblTitulo.setBounds(120,40,130,20);
        listProjeto = new JList();
        listProjeto.setBounds(70, 80, 200, 300);
        LocalDate dataTemp=java.time.LocalDate.now();
        Data dataAtual = new Data(dataTemp.getDayOfMonth(), dataTemp.getMonthValue(), dataTemp.getYear());
        int goal;
        for(Projeto proj : menu.cisuc.listaProjeto){
            goal=proj.getTarefas().size();
            for(Tarefa tarefa : proj.getTarefas()){
                if(tarefa.getTaxa()>=100){
                    goal-=1;
                }
            }
            if(goal==0){
                listModel.addElement(proj.getNome()+"   "+proj.getDataFim().toString());
            }
        }
        listProjeto.setModel(listModel);
        add(lblTitulo);
        add(listProjeto);
        add(btnVoltar);
        btnVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnVoltarActionListener();
            }
        });
    }

    private void btnVoltarActionListener(){
        MainGUI menu = new MainGUI(this.menu.cisuc);
        menu.setSize(420, 300);
        menu.setVisible(true);
        this.setVisible(false);
    }
}
