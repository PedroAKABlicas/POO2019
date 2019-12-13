import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ConsTarefasGUI extends JFrame {
    public JList listTarefa;
    private JButton btnVoltar;
    VerTarefaGUI trf;
    private DefaultListModel<String> listModel = new DefaultListModel<>();
    ArrayList<Tarefa> tarefas;
    public ConsTarefasGUI(VerTarefaGUI trf, ArrayList<Tarefa> tarefas){
        this.trf=trf;
        this.tarefas=tarefas;
        this.setLayout(null);
        btnVoltar = new JButton("Voltar");
        btnVoltar.setBounds(130, 400, 80, 20);

        for(Tarefa tarefa : tarefas){
            System.out.println(tarefa.getNome());
            listModel.addElement(tarefa.getNome());
        }
        listTarefa = new JList(listModel);
        listTarefa.setBounds(70, 80, 200, 300);
        btnVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnVoltarActionListener();
            }
        });
        add(btnVoltar);
        add(listTarefa);
    }
    private void btnVoltarActionListener(){
        VerTarefaGUI menu = new VerTarefaGUI(this.trf.proj, this.trf.index);
        menu.setSize(600, 400);
        menu.setVisible(true);
        this.setVisible(false);
    }
}
