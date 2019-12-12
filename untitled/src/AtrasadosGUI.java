import javax.swing.*;
import java.time.LocalDate;
import java.util.ArrayList;


public class AtrasadosGUI extends JFrame {
    public JLabel lblTitulo;
    public JList listProjeto;
    private DefaultListModel<String> listModel = new DefaultListModel<>();
    public AtrasadosGUI(MainGUI menu){
        lblTitulo = new JLabel("Projetos atrasados.");
        lblTitulo.setBounds(150,40,130,20);
        listProjeto = new JList();
        listProjeto.setBounds(70, 80, 200, 300);
        LocalDate dataTemp=java.time.LocalDate.now();
        Data dataAtual = new Data(dataTemp.getDayOfMonth(), dataTemp.getMonthValue(), dataTemp.getYear());
        for(Projeto proj : menu.cisuc.listaProjeto){
            System.out.println(proj.getNome() + proj.getDataFim());
            if(proj.getDataFim().compare(dataAtual)){
                listModel.addElement(proj.getNome()+"   "+proj.getDataFim().toString());
            }
        }
        listProjeto.setModel(listModel);
        add(lblTitulo);
        add(listProjeto);
    }
}
